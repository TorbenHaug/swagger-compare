package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.PathItemCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.PathsCompareResult;
import io.swagger.v3.oas.models.Paths;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathsCompareHolder extends LinkedHashMap<String,PathItemCompareHolder>{

    private final Paths paths;
    private final BidiMap<String,String> normailzedMap = new DualHashBidiMap<>();

    public PathsCompareHolder(Paths paths) {
        this.paths = paths;
        this.paths.forEach((k,v) -> {
            String normalizePath = normalizePath(k);
            this.normailzedMap.put(normalizePath, k);
            this.put(normalizePath, new PathItemCompareHolder(v));
        });
        if(normailzedMap.size() != paths.size()){
            throw new RuntimeException("Invalid OpenAPI specification");
        }
    }

    private String normalizePath(String path) {
        String repString = "{var}";
        String rx = "(\\{[^}]+\\})";

        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile(rx);
        Matcher m = p.matcher(path);

        while (m.find()){
            if (repString != null) {
                m.appendReplacement(sb, repString);
            }
        }
        m.appendTail(sb);

        return sb.toString();
    }

    public PathsCompareResult compare(PathsCompareHolder other) {
        PathsCompareResult result = new PathsCompareResult();

        Set<String> deleted = new HashSet<>(this.keySet());
        deleted.removeAll(other.keySet());
        deleted.forEach((k) -> {
            result.putDeleted(this.normailzedMap.get(k), this.paths.get(this.normailzedMap.get(k)));
        });

        Set<String> created = new HashSet<>(other.keySet());
        created.removeAll(this.keySet());
        created.forEach((k) -> {
            result.putCreated(other.normailzedMap.get(k), other.paths.get(other.normailzedMap.get(k)));
        });

        Set<String> pathesToCompare = new HashSet<>(this.keySet());
        pathesToCompare.removeAll(deleted);

        pathesToCompare.forEach((k) -> {
            PathItemCompareResult pathItemCompareResult = this.get(k).compare(other.get(k));
            if(pathItemCompareResult.getCompareResultType() == CompareResultType.UNCHANGED){
                result.putUnchanged(this.normailzedMap.get(k), this.paths.get(this.normailzedMap.get(k)));
            }else{
                result.putChanged(other.normailzedMap.get(k), pathItemCompareResult);
            }

        });

        return result;
    }
}
