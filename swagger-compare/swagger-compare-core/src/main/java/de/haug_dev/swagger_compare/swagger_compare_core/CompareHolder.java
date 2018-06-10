package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_core.misc.ExternalDocumentationObjectCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.paths.PathsCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.servers.ServersCompareHolder;
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
        ServersCompareHolder serversCompareHolder = compareHolderFactory.getServersCompareHolder();
        ExternalDocumentationObjectCompareHolder externalDocumentationObjectCompareHolder = compareHolderFactory.getExternalDocumentationObjectCompareHolder();

        NodeCompareResult result = new NodeCompareResult(created, deleted);
        this.nodeCompare(leftToCompare.getPaths(), rightToCompare.getPaths(), "Paths", pathsCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftToCompare.getComponents(), rightToCompare.getComponents(), "Components", componentsCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftToCompare.getServers(), rightToCompare.getServers(), "Servers", serversCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        this.nodeCompare(leftToCompare.getExternalDocs(), rightToCompare.getExternalDocs(), "ExternalDocs", externalDocumentationObjectCompareHolder, result, CompareCriticalType.INFO, CompareCriticalType.INFO);


        return result;
    }
}
