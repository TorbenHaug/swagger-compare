package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_core.paths.PathsCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.OpenAPI;

public class CompareHolder extends AbstractCompareHolder<OpenAPI> {

    private CompareHolderFactory compareHolderFactory;

    public CompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(OpenAPI left, OpenAPI right, CompareCriticalType created, CompareCriticalType deleted) {
        OpenAPI leftToCompare = left == null ? new OpenAPI() : left;
        OpenAPI rightToCompare = right == null ? new OpenAPI() : right;

        PathsCompareHolder pathsCompareHolder = compareHolderFactory.getPathsCompareHolder();
        ComponentsCompareHolder componentsCompareHolder = compareHolderFactory.getComponentsCompareHolder();

        NodeCompareResult result = new NodeCompareResult(created, deleted);
        if (!(leftToCompare.getPaths() == null && rightToCompare.getPaths() == null)) {
            ICompareResult compareResult = pathsCompareHolder.compare(leftToCompare.getPaths(), rightToCompare.getPaths(), CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
            result.put("Paths", compareResult);
        }
        if (!(leftToCompare.getPaths() == null && rightToCompare.getPaths() == null)) {
            ICompareResult compareResult = componentsCompareHolder.compare(leftToCompare.getComponents(), rightToCompare.getComponents(), CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
            result.put("Components", compareResult);
        }

        return result;
    }
}
