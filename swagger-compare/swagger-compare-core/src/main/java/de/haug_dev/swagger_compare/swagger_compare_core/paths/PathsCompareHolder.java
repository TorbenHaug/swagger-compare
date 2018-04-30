package de.haug_dev.swagger_compare.swagger_compare_core.paths;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.ICompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PathsCompareHolder extends AbstractCompareHolder<Paths> {


    private PathItemCompareHolder pathItemCompareHolder;

    @Autowired
    public PathsCompareHolder(PathItemCompareHolder pathItemCompareHolder){
        this.pathItemCompareHolder = pathItemCompareHolder;
    }

    @Override
    public ICompareResult compare(Paths left, Paths right) {
        BidiMap<String,String> normalizedMapLeft = new DualHashBidiMap<>();
        BidiMap<String,String> normalizedMapRight = new DualHashBidiMap<>();
        Paths pathsLeft = left == null ? new Paths() : left;
        Paths pathsLeftNormalized = new Paths();
        pathsLeft.forEach((k,v) -> {
            String normalizePath = normalizePath(k);
            normalizedMapLeft.put(normalizePath, k);
            pathsLeftNormalized.put(normalizePath, v);
        });

        Paths pathsRight = right == null ? new Paths() : right;
        Paths pathsRightNormalized = new Paths();
        pathsRight.forEach((k,v) -> {
            String normalizePath = normalizePath(k);
            normalizedMapRight.put(normalizePath, k);
            pathsRightNormalized.put(normalizePath, v);
        });

        NodeCompareResult normalizedResult = this.compare(pathsLeftNormalized, pathsRightNormalized, pathItemCompareHolder, normalizedMapLeft, normalizedMapRight);
        BidiMap<String,String> normailzedMap = new DualHashBidiMap<>(normalizedMapLeft);
        normailzedMap.putAll(normalizedMapRight);
        NodeCompareResult result = new NodeCompareResult();
        normalizedResult.getValues().forEach((k,v) -> {
            result.put(normailzedMap.get(k), v);
        });
        return result;
    }

    protected NodeCompareResult compare(Map<String, PathItem> left, Map<String, PathItem> right, ICompareHolder<PathItem> compareHolder, BidiMap<String,String> normailzedMapLeft, BidiMap<String,String> normailzedMapRight){
        NodeCompareResult result = new NodeCompareResult();
        Set<String> keys = new HashSet<>(left.keySet());
        keys.addAll(right.keySet());
        keys.forEach((k) -> {
            pathItemCompareHolder.setNormalizedParameterNames(normalizeParameterNames(normailzedMapLeft.get(k)), normalizeParameterNames(normailzedMapRight.get(k)));
            PathItem leftValue = left.get(k);
            PathItem rightValue = right.get(k);
            if(!(leftValue == null && rightValue == null)) {
                result.put(k, compareHolder.compare(leftValue, rightValue));
            }
        });
        return result;
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

    private BidiMap<String, String> normalizeParameterNames(String path) {
        BidiMap<String, String> result = new DualHashBidiMap<>();
        String rx = "(\\{[^}]+\\})";
        int count = 0;

        if(path != null) {
            Pattern p1 = Pattern.compile(rx);
            Matcher m1 = p1.matcher(path);

            while (m1.find()) {
                String value = m1.group();
                result.put(value, "var" + count++);
            }
        }

        return result;
    }
}