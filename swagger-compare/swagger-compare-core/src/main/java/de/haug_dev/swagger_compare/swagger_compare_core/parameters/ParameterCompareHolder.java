package de.haug_dev.swagger_compare.swagger_compare_core.parameters;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_core.examples.ExamplesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.media.MediaTypesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.schemas.SchemaCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;

import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.*;

public class ParameterCompareHolder extends AbstractCompareHolder<Parameter> {
    private static final Logger LOG = LoggerFactory.getLogger(ParameterCompareHolder.class);
    private CompareHolderFactory compareHolderFactory;

    public ParameterCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Parameter left, Parameter right, CompareCriticalType created, CompareCriticalType deleted) {
        Parameter leftValue = left == null ? new Parameter() : left;
        Parameter rightValue = right == null ? new Parameter() : right;
        LOG.debug("Comparing: " + leftValue.getName() + ", " + rightValue.getName());
        NodeCompareResult result = new NodeCompareResult(created, deleted);

        if(Objects.equals(rightValue.getIn(), "path")){
            this.leafCompare(leftValue.getName(), rightValue.getName(), "Name", NONE, CRITICAL, CRITICAL, INFO, result);
        } else {
            this.leafCompare(leftValue.getName(), rightValue.getName(), "Name", NONE, CRITICAL, CRITICAL, CRITICAL, result);
        }
        this.leafCompare(leftValue.getIn(), rightValue.getIn(), "In", NONE, CRITICAL, CRITICAL, CRITICAL, result);
        this.leafCompare(leftValue.getDescription(), rightValue.getDescription(), "Description", NONE, INFO, INFO, INFO, result);

        this.booleanCompare(
                leftValue.getRequired(),
                rightValue.getRequired(),
                "Required",
                NONE,
                NONE,
                CRITICAL,
                NONE,
                INFO,
                INFO,
                CRITICAL,
                result
        );

        this.booleanCompare(
                leftValue.getDeprecated(),
                rightValue.getDeprecated(),
                "Deprecated",
                NONE,
                NONE,
                WARNING,
                NONE,
                INFO,
                INFO,
                WARNING,
                result);

        this.booleanCompare(
                leftValue.getAllowEmptyValue(),
                rightValue.getAllowEmptyValue(),
                "AllowEmptyValue",
                NONE,
                INFO,
                INFO,
                INFO,
                CRITICAL,
                CRITICAL,
                INFO,
                result
        );

        if(leftValue.getStyle() == null && rightValue.getStyle() != null && isDefaultStyle(rightValue.getIn(), rightValue.getStyle())){
            result.put("Style", new LeafCompareResult(leftValue.getStyle(), rightValue.getStyle(), CompareResultType.CREATED, INFO));
        } else if (leftValue.getStyle() != null && rightValue.getStyle() == null && isDefaultStyle(leftValue.getIn(), leftValue.getStyle())){
            result.put("Style", new LeafCompareResult(leftValue.getStyle(), rightValue.getStyle(), CompareResultType.DELETED, INFO));
        } else {
            this.leafCompare(leftValue.getStyle(), rightValue.getStyle(), "Style", NONE, CRITICAL, CRITICAL, CRITICAL, result);
        }

        this.booleanCompare(
            leftValue.getExplode(),
            rightValue.getExplode(),
            "Explode",
            NONE,
            INFO,
            INFO,
            INFO,
            INFO,
            INFO,
            INFO,
            result
        );
        this.booleanCompare(
                leftValue.getAllowReserved(),
                rightValue.getAllowReserved(),
                "AllowReserved",
                NONE,
                INFO,
                CRITICAL,
                INFO,
                CRITICAL,
                CRITICAL,
                CRITICAL,
                result
        );

        SchemaCompareHolder schemaCompareHolder = compareHolderFactory.getSchemaCompareHolder();
        this.nodeCompare(leftValue.getSchema(), rightValue.getSchema(), "Schema", schemaCompareHolder, result, CRITICAL,CRITICAL);
        this.leafCompare(leftValue.getExample(), rightValue.getExample(), "Example", NONE,INFO, INFO, INFO, result);
        ExamplesCompareHolder examplesCompareHolder = compareHolderFactory.getExamplesCompareHolder();
        this.nodeCompare(leftValue.getExamples(), rightValue.getExamples(), "Examples", examplesCompareHolder, result, INFO, INFO);
        MediaTypesCompareHolder mediaTypesCompareHolder = compareHolderFactory.getMediaTypesCompareHolder();
        this.nodeCompare(leftValue.getContent(), rightValue.getContent(), "Content", mediaTypesCompareHolder, result, CRITICAL, CRITICAL);
        return result;
    }

    private boolean isDefaultStyle(String in, Parameter.StyleEnum style) {
        return (Objects.equals(in,"query") && Objects.equals(style, Parameter.StyleEnum.FORM)) ||
                (Objects.equals(in,"path") && Objects.equals(style, Parameter.StyleEnum.SIMPLE)) ||
                (Objects.equals(in,"header") && Objects.equals(style, Parameter.StyleEnum.SIMPLE)) ||
                (Objects.equals(in,"cookie") && Objects.equals(style, Parameter.StyleEnum.FORM));
    }


}
