package de.haug_dev.swagger_compare.swagger_compare_core.parameters;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.Map;

public class ParametersCompareHolder extends AbstractCompareHolder<Map<String, Parameter>> {

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
            if (normalizedParameterNamesLeft.get(k) != null) {
                name = normalizedParameterNamesLeft.get(k);
            }
            if (normalizedParameterNamesRight.get(k) != null) {
                name = normalizedParameterNamesRight.get(k);
            }
            result.put(name, v);
        });
        return result;
    }

    public void setNormalizedParameterNames(BidiMap<String, String> normalizedParameterNamesLeft, BidiMap<String, String> normalizedParameterNamesRight) {
        this.normalizedParameterNamesLeft = normalizedParameterNamesLeft == null ? new DualHashBidiMap<>() : normalizedParameterNamesLeft;
        this.normalizedParameterNamesRight = normalizedParameterNamesRight == null ? new DualHashBidiMap<>() : normalizedParameterNamesRight;
    }
}
