package de.haug_dev.swagger_compare.swagger_compare_core.paths;

import de.haug_dev.swagger_compare.swagger_compare_core.*;
import de.haug_dev.swagger_compare.swagger_compare_core.parameters.ParametersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.paths.PathItemCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PathItemCompareHolderTest {

    @Test
    public void compareWithAllValues() {
        String refLeft = "refLeft";
        String refRight = "refRight";
        ICompareResult refResult = new LeafCompareResult(refLeft, refRight, CompareResultType.CHANGED, CompareCriticalType.CRITICAL);

        String summaryLeft = "summaryLeft";
        String summaryRight = "summaryRight";
        ICompareResult summaryResult = new LeafCompareResult(summaryLeft, summaryRight, CompareResultType.CHANGED, CompareCriticalType.INFO);

        String descriptionLeft = "descriptionLeft";
        String descriptionRight = "descriptionRight";
        ICompareResult descriptionResult = new LeafCompareResult(descriptionLeft, descriptionRight, CompareResultType.CHANGED, CompareCriticalType.INFO);

        Operation operationLeft = new Operation();
        Operation operationRight = new Operation();
        ICompareResult operationResult = new LeafCompareResult(operationLeft, operationRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        OperationCompareHolder operationCompareHolder = Mockito.mock(OperationCompareHolder.class);
        Mockito.when(operationCompareHolder.compare(operationLeft, operationRight)).thenReturn(operationResult);

        Server serverLeft = new Server();
        serverLeft.setUrl("test");
        List<Server> serversLeft = new ArrayList<>();
        serversLeft.add(serverLeft);
        Map<String, Server> serverMapLeft = new HashMap<>();
        serverMapLeft.put("test", serverLeft);
        Server serverRight = new Server();
        serverRight.setUrl("test");
        List<Server> serversRight = new ArrayList<>();
        serversRight.add(serverRight);
        Map<String, Server> serverMapRight = new HashMap<>();
        serverMapRight.put("test", serverRight);
        ICompareResult serversResult = new LeafCompareResult(serverMapLeft, serverMapRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ServersCompareHolder serversCompareHolder = Mockito.mock(ServersCompareHolder.class);
        Mockito.when(serversCompareHolder.compare(serverMapLeft, serverMapRight)).thenReturn(serversResult);

        Parameter parameterLeft = new Parameter();
        parameterLeft.setName("test");
        List<Parameter> parametersLeft = new ArrayList<>();
        parametersLeft.add(parameterLeft);
        Map<String, Parameter> parameterMapLeft = new HashMap<>();
        parameterMapLeft.put("test", parameterLeft);
        Parameter parameterRight = new Parameter();
        parameterRight.setName("test");
        List<Parameter> parametersRight = new ArrayList<>();
        parametersRight.add(parameterRight);
        Map<String, Parameter> parameterMapRight = new HashMap<>();
        parameterMapRight.put("test", parameterRight);
        ICompareResult parametersResult = new LeafCompareResult(parameterMapLeft, parameterMapRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ParametersCompareHolder parametersCompareHolder = Mockito.mock(ParametersCompareHolder.class);
        Mockito.when(parametersCompareHolder.compare(parameterMapLeft, parameterMapRight)).thenReturn(parametersResult);

        PathItem pathItemLeft = new PathItem();
        pathItemLeft.set$ref(refLeft);
        pathItemLeft.setSummary(summaryLeft);
        pathItemLeft.setDescription(descriptionLeft);
        pathItemLeft.setGet(operationLeft);
        pathItemLeft.setPut(operationLeft);
        pathItemLeft.setPost(operationLeft);
        pathItemLeft.setDelete(operationLeft);
        pathItemLeft.setOptions(operationLeft);
        pathItemLeft.setHead(operationLeft);
        pathItemLeft.setPatch(operationLeft);
        pathItemLeft.setTrace(operationLeft);
        pathItemLeft.setServers(serversLeft);
        pathItemLeft.setParameters(parametersLeft);

        PathItem pathItemRight = new PathItem();
        pathItemRight.set$ref(refRight);
        pathItemRight.setSummary(summaryRight);
        pathItemRight.setDescription(descriptionRight);
        pathItemRight.setGet(operationRight);
        pathItemRight.setPut(operationRight);
        pathItemRight.setPost(operationRight);
        pathItemRight.setDelete(operationRight);
        pathItemRight.setOptions(operationRight);
        pathItemRight.setHead(operationRight);
        pathItemRight.setPatch(operationRight);
        pathItemRight.setTrace(operationRight);
        pathItemRight.setServers(serversRight);
        pathItemRight.setParameters(parametersRight);

        PathItemCompareHolder pathItemCompareHolder = new PathItemCompareHolder(
                operationCompareHolder,
                serversCompareHolder,
                parametersCompareHolder);

        NodeCompareResult actual = (NodeCompareResult) pathItemCompareHolder.compare(pathItemLeft,pathItemRight);

        NodeCompareResult expected = new NodeCompareResult();

        expected.put("Ref", refResult);
        expected.put("Summary", summaryResult);
        expected.put("Description", descriptionResult);
        expected.put("Get", operationResult);
        expected.put("Put", operationResult);
        expected.put("Post", operationResult);
        expected.put("Delete", operationResult);
        expected.put("Options", operationResult);
        expected.put("Head", operationResult);
        expected.put("Patch", operationResult);
        expected.put("Trace", operationResult);
        expected.put("Servers", serversResult);
        expected.put("Parameters", parametersResult);

        assertEquals(expected, actual);

    }

    @Test
    public void compareWithLeftValues() {
        String refLeft = "refLeft";
        String refRight = null;
        ICompareResult refResult = new LeafCompareResult(refLeft, refRight, CompareResultType.DELETED, CompareCriticalType.CRITICAL);

        String summaryLeft = "summaryLeft";
        String summaryRight = null;
        ICompareResult summaryResult = new LeafCompareResult(summaryLeft, summaryRight, CompareResultType.DELETED, CompareCriticalType.INFO);

        String descriptionLeft = "descriptionLeft";
        String descriptionRight = null;
        ICompareResult descriptionResult = new LeafCompareResult(descriptionLeft, descriptionRight, CompareResultType.DELETED, CompareCriticalType.INFO);

        Operation operationLeft = new Operation();
        Operation operationRight = null;
        ICompareResult operationResult = new LeafCompareResult(operationLeft, operationRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        OperationCompareHolder operationCompareHolder = Mockito.mock(OperationCompareHolder.class);
        Mockito.when(operationCompareHolder.compare(operationLeft, operationRight)).thenReturn(operationResult);

        Server serverLeft = new Server();
        serverLeft.setUrl("test");
        List<Server> serversLeft = new ArrayList<>();
        serversLeft.add(serverLeft);
        Map<String, Server> serverMapLeft = new HashMap<>();
        serverMapLeft.put("test", serverLeft);
        Server serverRight = new Server();
        serverRight.setUrl("test");
        List<Server> serversRight = null;
        Map<String, Server> serverMapRight = new HashMap<>();
        ICompareResult serversResult = new LeafCompareResult(serverMapLeft, serverMapRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ServersCompareHolder serversCompareHolder = Mockito.mock(ServersCompareHolder.class);
        Mockito.when(serversCompareHolder.compare(serverMapLeft, serverMapRight)).thenReturn(serversResult);

        Parameter parameterLeft = new Parameter();
        parameterLeft.setName("test");
        List<Parameter> parametersLeft = new ArrayList<>();
        parametersLeft.add(parameterLeft);
        Map<String, Parameter> parameterMapLeft = new HashMap<>();
        parameterMapLeft.put("test", parameterLeft);
        Parameter parameterRight = new Parameter();
        parameterRight.setName("test");
        List<Parameter> parametersRight = null;
        Map<String, Parameter> parameterMapRight = new HashMap<>();
        ICompareResult parametersResult = new LeafCompareResult(parameterMapLeft, parameterMapRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ParametersCompareHolder parametersCompareHolder = Mockito.mock(ParametersCompareHolder.class);
        Mockito.when(parametersCompareHolder.compare(parameterMapLeft, parameterMapRight)).thenReturn(parametersResult);

        PathItem pathItemLeft = new PathItem();
        pathItemLeft.set$ref(refLeft);
        pathItemLeft.setSummary(summaryLeft);
        pathItemLeft.setDescription(descriptionLeft);
        pathItemLeft.setGet(operationLeft);
        pathItemLeft.setPut(operationLeft);
        pathItemLeft.setPost(operationLeft);
        pathItemLeft.setDelete(operationLeft);
        pathItemLeft.setOptions(operationLeft);
        pathItemLeft.setHead(operationLeft);
        pathItemLeft.setPatch(operationLeft);
        pathItemLeft.setTrace(operationLeft);
        pathItemLeft.setServers(serversLeft);
        pathItemLeft.setParameters(parametersLeft);

        PathItem pathItemRight = new PathItem();
        pathItemRight.set$ref(refRight);
        pathItemRight.setSummary(summaryRight);
        pathItemRight.setDescription(descriptionRight);
        pathItemRight.setGet(operationRight);
        pathItemRight.setPut(operationRight);
        pathItemRight.setPost(operationRight);
        pathItemRight.setDelete(operationRight);
        pathItemRight.setOptions(operationRight);
        pathItemRight.setHead(operationRight);
        pathItemRight.setPatch(operationRight);
        pathItemRight.setTrace(operationRight);
        pathItemRight.setServers(serversRight);
        pathItemRight.setParameters(parametersRight);

        PathItemCompareHolder pathItemCompareHolder = new PathItemCompareHolder(
                operationCompareHolder,
                serversCompareHolder,
                parametersCompareHolder);

        NodeCompareResult actual = (NodeCompareResult) pathItemCompareHolder.compare(pathItemLeft,pathItemRight);

        NodeCompareResult expected = new NodeCompareResult();

        expected.put("Ref", refResult);
        expected.put("Summary", summaryResult);
        expected.put("Description", descriptionResult);
        expected.put("Get", operationResult);
        expected.put("Put", operationResult);
        expected.put("Post", operationResult);
        expected.put("Delete", operationResult);
        expected.put("Options", operationResult);
        expected.put("Head", operationResult);
        expected.put("Patch", operationResult);
        expected.put("Trace", operationResult);
        expected.put("Servers", serversResult);
        expected.put("Parameters", parametersResult);

        assertEquals(expected, actual);

    }


    @Test
    public void compareWithRightValues() {
        String refLeft = null;
        String refRight = "refRight";
        ICompareResult refResult = new LeafCompareResult(refLeft, refRight, CompareResultType.CREATED, CompareCriticalType.CRITICAL);

        String summaryLeft = null;
        String summaryRight = "summaryRight";
        ICompareResult summaryResult = new LeafCompareResult(summaryLeft, summaryRight, CompareResultType.CREATED, CompareCriticalType.INFO);

        String descriptionLeft = null;
        String descriptionRight = "descriptionRight";
        ICompareResult descriptionResult = new LeafCompareResult(descriptionLeft, descriptionRight, CompareResultType.CREATED, CompareCriticalType.INFO);

        Operation operationLeft = null;
        Operation operationRight = new Operation();
        ICompareResult operationResult = new LeafCompareResult(operationLeft, operationRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        OperationCompareHolder operationCompareHolder = Mockito.mock(OperationCompareHolder.class);
        Mockito.when(operationCompareHolder.compare(operationLeft, operationRight)).thenReturn(operationResult);

        List<Server> serversLeft = null;
        Map<String, Server> serverMapLeft = new HashMap<>();
        Server serverRight = new Server();
        serverRight.setUrl("test");
        List<Server> serversRight = new ArrayList<>();
        serversRight.add(serverRight);
        Map<String, Server> serverMapRight = new HashMap<>();
        serverMapRight.put("test", serverRight);
        ICompareResult serversResult = new LeafCompareResult(serverMapLeft, serverMapRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ServersCompareHolder serversCompareHolder = Mockito.mock(ServersCompareHolder.class);
        Mockito.when(serversCompareHolder.compare(serverMapLeft, serverMapRight)).thenReturn(serversResult);

        List<Parameter> parametersLeft = null;
        Map<String, Parameter> parameterMapLeft = new HashMap<>();
        Parameter parameterRight = new Parameter();
        parameterRight.setName("test");
        List<Parameter> parametersRight = new ArrayList<>();
        parametersRight.add(parameterRight);
        Map<String, Parameter> parameterMapRight = new HashMap<>();
        parameterMapRight.put("test", parameterRight);
        ICompareResult parametersResult = new LeafCompareResult(parameterMapLeft, parameterMapRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ParametersCompareHolder parametersCompareHolder = Mockito.mock(ParametersCompareHolder.class);
        Mockito.when(parametersCompareHolder.compare(parameterMapLeft, parameterMapRight)).thenReturn(parametersResult);

        PathItem pathItemLeft = new PathItem();
        pathItemLeft.set$ref(refLeft);
        pathItemLeft.setSummary(summaryLeft);
        pathItemLeft.setDescription(descriptionLeft);
        pathItemLeft.setGet(operationLeft);
        pathItemLeft.setPut(operationLeft);
        pathItemLeft.setPost(operationLeft);
        pathItemLeft.setDelete(operationLeft);
        pathItemLeft.setOptions(operationLeft);
        pathItemLeft.setHead(operationLeft);
        pathItemLeft.setPatch(operationLeft);
        pathItemLeft.setTrace(operationLeft);
        pathItemLeft.setServers(serversLeft);
        pathItemLeft.setParameters(parametersLeft);

        PathItem pathItemRight = new PathItem();
        pathItemRight.set$ref(refRight);
        pathItemRight.setSummary(summaryRight);
        pathItemRight.setDescription(descriptionRight);
        pathItemRight.setGet(operationRight);
        pathItemRight.setPut(operationRight);
        pathItemRight.setPost(operationRight);
        pathItemRight.setDelete(operationRight);
        pathItemRight.setOptions(operationRight);
        pathItemRight.setHead(operationRight);
        pathItemRight.setPatch(operationRight);
        pathItemRight.setTrace(operationRight);
        pathItemRight.setServers(serversRight);
        pathItemRight.setParameters(parametersRight);

        PathItemCompareHolder pathItemCompareHolder = new PathItemCompareHolder(
                operationCompareHolder,
                serversCompareHolder,
                parametersCompareHolder);

        NodeCompareResult actual = (NodeCompareResult) pathItemCompareHolder.compare(pathItemLeft,pathItemRight);

        NodeCompareResult expected = new NodeCompareResult();

        expected.put("Ref", refResult);
        expected.put("Summary", summaryResult);
        expected.put("Description", descriptionResult);
        expected.put("Get", operationResult);
        expected.put("Put", operationResult);
        expected.put("Post", operationResult);
        expected.put("Delete", operationResult);
        expected.put("Options", operationResult);
        expected.put("Head", operationResult);
        expected.put("Patch", operationResult);
        expected.put("Trace", operationResult);
        expected.put("Servers", serversResult);
        expected.put("Parameters", parametersResult);

        assertEquals(expected, actual);

    }

    @Test
    public void compareWithNoValues() {
        OperationCompareHolder operationCompareHolder = Mockito.mock(OperationCompareHolder.class);
        ServersCompareHolder serversCompareHolder = Mockito.mock(ServersCompareHolder.class);
        ParametersCompareHolder parametersCompareHolder = Mockito.mock(ParametersCompareHolder.class);

        PathItem pathItemLeft = new PathItem();

        PathItem pathItemRight = new PathItem();

        PathItemCompareHolder pathItemCompareHolder = new PathItemCompareHolder(
                operationCompareHolder,
                serversCompareHolder,
                parametersCompareHolder);

        NodeCompareResult actual = (NodeCompareResult) pathItemCompareHolder.compare(pathItemLeft,pathItemRight);

        NodeCompareResult expected = new NodeCompareResult();

        assertEquals(expected, actual);

    }

}