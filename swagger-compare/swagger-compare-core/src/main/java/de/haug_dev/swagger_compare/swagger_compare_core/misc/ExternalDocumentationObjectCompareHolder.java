package de.haug_dev.swagger_compare.swagger_compare_core.misc;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.ExternalDocumentation;

import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.CRITICAL;
import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.INFO;
import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.NONE;

public class ExternalDocumentationObjectCompareHolder extends AbstractCompareHolder<ExternalDocumentation> {

    @Override
    public ICompareResult compare(ExternalDocumentation left, ExternalDocumentation right, CompareCriticalType created, CompareCriticalType deleted) {
        ExternalDocumentation leftValue = left == null ? new ExternalDocumentation() : left;
        ExternalDocumentation rightValue = right == null ? new ExternalDocumentation() : right;
        NodeCompareResult result = new NodeCompareResult(created, deleted);

        this.leafCompare(leftValue.getDescription(), rightValue.getDescription(), "Description", NONE, INFO, INFO, INFO, result);
        this.leafCompare(leftValue.getUrl(), rightValue.getUrl(), "Url", NONE, CRITICAL, CRITICAL, INFO, result);

        return result;
    }
}
