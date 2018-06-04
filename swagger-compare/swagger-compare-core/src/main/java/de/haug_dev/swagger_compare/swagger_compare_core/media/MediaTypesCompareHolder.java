package de.haug_dev.swagger_compare.swagger_compare_core.media;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.media.MediaType;

import java.util.HashMap;
import java.util.Map;

public class MediaTypesCompareHolder extends AbstractCompareHolder<Map<String, MediaType>> {
    private CompareHolderFactory compareHolderFactory;

    public MediaTypesCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Map<String, MediaType> left, Map<String, MediaType> right, CompareCriticalType created, CompareCriticalType deleted) {
        Map<String, MediaType> leftValue = left == null ? new HashMap<>() : left;
        Map<String, MediaType> rightValue = right == null ? new HashMap<>() : right;
        MediaTypeCompareHolder mediaTypeCompareHolder = compareHolderFactory.getMediaTypeCompareHolder();
        return this.referableCompare(leftValue, rightValue,mediaTypeCompareHolder, created, deleted);
    }
}
