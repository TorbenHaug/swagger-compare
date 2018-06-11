package de.haug_dev.swagger_compare.swagger_compare_core.responses;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_core.headers.HeadersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.links.LinksCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.media.MediaTypesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.responses.ApiResponse;

import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.CRITICAL;
import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.INFO;
import static de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType.NONE;

public class ResponseCompareHolder extends AbstractCompareHolder<ApiResponse> {
    private CompareHolderFactory compareHolderFactory;

    public ResponseCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(ApiResponse left, ApiResponse right, CompareCriticalType created, CompareCriticalType deleted) {
        ApiResponse leftValue = left == null ? new ApiResponse() : left;
        ApiResponse rightValue = right == null ? new ApiResponse() : right;
        NodeCompareResult result = new NodeCompareResult(created,deleted);

        HeadersCompareHolder headersCompareHolder = compareHolderFactory.getHeadersCompareHolder();
        MediaTypesCompareHolder mediaTypesCompareHolder = compareHolderFactory.getMediaTypesCompareHolder();
        LinksCompareHolder linksCompareHolder = compareHolderFactory.getLinksCompareHolder();

        this.leafCompare(leftValue.get$ref(), rightValue.get$ref(), "Ref", NONE, CRITICAL,CRITICAL, CRITICAL, result);
        this.leafCompare(leftValue.getDescription(), rightValue.getDescription(), "Description", NONE, INFO,INFO, INFO, result);
        this.nodeCompare(leftValue.getHeaders(),rightValue.getHeaders(), "Headers", headersCompareHolder, result, INFO, CRITICAL);
        this.nodeCompare(leftValue.getContent(),rightValue.getContent(), "Content", mediaTypesCompareHolder, result, INFO, CRITICAL);
        this.nodeCompare(leftValue.getLinks(),rightValue.getLinks(), "Links", linksCompareHolder, result, CRITICAL, INFO);

        return result;
    }
}
