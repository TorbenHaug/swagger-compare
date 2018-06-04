package de.haug_dev.swagger_compare.swagger_compare_core.parameters;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ParametersCompareHolder extends AbstractCompareHolder<Map<String, Parameter>> {

    private static Logger LOG = LoggerFactory.getLogger(ParametersCompareHolder.class);

    private BidiMap<String, String> normalizedParameterNamesLeft = new DualHashBidiMap<>();
    private BidiMap<String, String> normalizedParameterNamesRight = new DualHashBidiMap<>();
    private CompareHolderFactory compareHolderFactory;

    public ParametersCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Map<String, Parameter> left, Map<String, Parameter> right, CompareCriticalType created, CompareCriticalType deleted) {
        NodeCompareResult result = new NodeCompareResult(created, deleted);

        ParameterCompareHolder parameterCompareHolder = compareHolderFactory.getParameterCompareHolder();

        NodeCompareResult compareResult = referableCompare(left, right, parameterCompareHolder, created, deleted);
        compareResult.getValues().forEach((k, v) -> {
            String name = k;
            LOG.debug("Rebuild: " + name);
            String[] splitName = k.split(":",2);
            if(splitName.length == 2 && Objects.equals("path", splitName[0])) {
                LOG.debug("Looking for: " + splitName[1]);
                if (normalizedParameterNamesLeft.getKey(splitName[1]) != null) {
                    name = splitName[0] + ":" + normalizedParameterNamesLeft.getKey(splitName[1]);
                }
                if (normalizedParameterNamesRight.getKey(splitName[1]) != null) {
                    name = splitName[0] + ":" + normalizedParameterNamesRight.getKey(splitName[1]);
                }
            }
            result.put(name, v);
        });
        return result;
    }

    public Map<String,Parameter> listToMapLeft(List<Parameter> parameters) {
        return listToMap(parameters, normalizedParameterNamesLeft);
    }

    public Map<String,Parameter> listToMapRight(List<Parameter> parameters) {
        return listToMap(parameters, normalizedParameterNamesRight);
    }

    private Map<String,Parameter> listToMap(List<Parameter> parameters, BidiMap<String,String> normalizedParameterNames) {
        Map<String, Parameter> result = new HashMap<>();
        if (parameters != null) {
            parameters.forEach((v) -> {
                String normalizedName = normalizedParameterNames.get(v.getName());
                String name = (normalizedName == null) ? v.getName() : ("path".equals(v.getIn()) ? normalizedName : v.getName());
                result.put(v.getIn() + ":" + name, v);
            });
        }
        return result;
    }

    public void setNormalizedParameterNames(BidiMap<String, String> normalizedParameterNamesLeft, BidiMap<String, String> normalizedParameterNamesRight) {
        this.normalizedParameterNamesLeft = normalizedParameterNamesLeft == null ? new DualHashBidiMap<>() : normalizedParameterNamesLeft;
        this.normalizedParameterNamesRight = normalizedParameterNamesRight == null ? new DualHashBidiMap<>() : normalizedParameterNamesRight;
        LOG.debug("Set parameterNames:");
        LOG.debug("Left: " + normalizedParameterNamesLeft.toString());
        LOG.debug("Right: " + normalizedParameterNamesRight.toString());
    }


}
