package de.haug_dev.swagger_compare.swagger_compare_core.request_bodies;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_core.media.MediaTypeCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.media.MediaTypesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.parameters.RequestBody;

import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.CRITICAL;
import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.INFO;
import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.NONE;

public class RequestBodyCompareHolder extends AbstractCompareHolder<RequestBody> {
    private CompareHolderFactory compareHolderFactory;

    public RequestBodyCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(RequestBody left, RequestBody right, CompareCriticalType created, CompareCriticalType deleted) {
        RequestBody leftValue = left == null ? new RequestBody() : left;
        RequestBody rightValue = right == null ? new RequestBody() : right;
        NodeCompareResult result = new NodeCompareResult(created, deleted);

        MediaTypesCompareHolder mediaTypesCompareHolder = compareHolderFactory.getMediaTypesCompareHolder();

        this.leafCompare(leftValue.get$ref(), rightValue.get$ref(), "Ref", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO, CompareCriticalType.INFO, result);
        this.leafCompare(leftValue.getDescription(), rightValue.getDescription(), "Description", CompareCriticalType.NONE, CompareCriticalType.INFO, CompareCriticalType.INFO, CompareCriticalType.INFO, result);
        this.nodeCompare(leftValue.getContent(), rightValue.getContent(), "content", mediaTypesCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

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

        return result;
    }
}
