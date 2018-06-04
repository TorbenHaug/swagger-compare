package de.haug_dev.swagger_compare.swagger_compare_core.headers;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_core.ICompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.headers.Header;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class HeadersCompareHolder extends AbstractCompareHolder<Map<String, Header>> {

    private CompareHolderFactory compareHolderFactory;

    public HeadersCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(Map<String, Header> left, Map<String, Header> right, CompareCriticalType created, CompareCriticalType deleted) {
        Map<String, Header> leftValue = left == null ? new HashMap<>() : left;
        Map<String, Header> rightValue = right == null ? new HashMap<>() : right;
        HeaderCompareHolder headerCompareHolder = compareHolderFactory.getHeaderCompareHolder();
        return referableCompare(leftValue, rightValue, headerCompareHolder, created, deleted);
    }
}
