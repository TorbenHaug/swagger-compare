package de.haug_dev.swagger_compare.swagger_compare_core.links;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.links.Link;

import java.util.HashMap;
import java.util.Map;

public class LinksCompareHolder extends AbstractCompareHolder<Map<String, Link>> {
    private CompareHolderFactory compareHolderFactory;

    public LinksCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Map<String, Link> left, Map<String, Link> right, CompareCriticalType created, CompareCriticalType deleted) {
        Map<String, Link> leftValue = left == null ? new HashMap<>() : left;
        Map<String, Link> rightValue = right == null ? new HashMap<>() : right;
        LinkCompareHolder linkCompareHolder = compareHolderFactory.getLinkCompareHolder();
        return referableCompare(leftValue, rightValue, linkCompareHolder, created, deleted);
    }
}
