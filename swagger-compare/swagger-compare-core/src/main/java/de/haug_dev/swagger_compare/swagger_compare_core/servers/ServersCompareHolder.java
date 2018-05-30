package de.haug_dev.swagger_compare.swagger_compare_core.servers;

import de.haug_dev.swagger_compare.swagger_compare_core.AbstractCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import io.swagger.v3.oas.models.servers.Server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServersCompareHolder extends AbstractCompareHolder<List<Server>> {

    private CompareHolderFactory compareHolderFactory;

    public ServersCompareHolder(CompareHolderFactory compareHolderFactory) {
        this.compareHolderFactory = compareHolderFactory;
    }

    @Override
    public ICompareResult compare(List<Server> left, List<Server> right, CompareCriticalType created, CompareCriticalType deleted) {

        ServerCompareHolder serverCompareHolder = compareHolderFactory.getServerCompareHolder();

        Map<String, Server> serversLeft = new HashMap<>();
        if (left != null) {
            left.forEach((v) -> {
                serversLeft.put(v.getUrl(), v);
            });
        }
        Map<String, Server> serversRight = new HashMap<>();
        if (right != null) {
            right.forEach((v) -> {
                serversRight.put(v.getUrl(), v);
            });
        }
        return this.referableCompare(serversLeft, serversRight, serverCompareHolder, created, deleted);
    }
}
