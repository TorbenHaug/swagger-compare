package de.haug_dev.swagger_compare.swagger_compare_core.servers;

import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.servers.ServerVariable;
import io.swagger.v3.oas.models.servers.ServerVariables;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class ServerCompareHolderTest {

    @Test
    public void compareNullNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        ServerVariablesCompareHolder serverVariablesCompareHolder = mock(ServerVariablesCompareHolder.class);
        when(spiedCompareHolderFactory.getServerVariablesCompareHolder()).thenReturn(serverVariablesCompareHolder);

        Server leftValue = null;
        Server rightValue = null;

        NodeCompareResult serverVariablesResult = new NodeCompareResult(CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        when(serverVariablesCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(serverVariablesResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getServerCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareNullEmptyValue() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        ServerVariablesCompareHolder serverVariablesCompareHolder = mock(ServerVariablesCompareHolder.class);
        when(spiedCompareHolderFactory.getServerVariablesCompareHolder()).thenReturn(serverVariablesCompareHolder);

        Server leftValue = null;
        Server rightValue = new Server();

        NodeCompareResult serverVariablesResult = new NodeCompareResult(CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        when(serverVariablesCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(serverVariablesResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getServerCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareEmptyValueNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        ServerVariablesCompareHolder serverVariablesCompareHolder = mock(ServerVariablesCompareHolder.class);
        when(spiedCompareHolderFactory.getServerVariablesCompareHolder()).thenReturn(serverVariablesCompareHolder);

        Server leftValue = new Server();
        Server rightValue = null;

        NodeCompareResult serverVariablesResult = new NodeCompareResult(CompareCriticalType.CRITICAL, CompareCriticalType.CRITICAL);
        when(serverVariablesCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(serverVariablesResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getServerCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareDeleted() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        ServerVariablesCompareHolder serverVariablesCompareHolder = mock(ServerVariablesCompareHolder.class);
        when(spiedCompareHolderFactory.getServerVariablesCompareHolder()).thenReturn(serverVariablesCompareHolder);

        Server leftValue = new Server();
        leftValue.setUrl("Test");
        leftValue.setDescription("Test");
        ServerVariables serverVariablesLeft = mock(ServerVariables.class);
        serverVariablesLeft.put("Test", new ServerVariable());
        leftValue.setVariables(serverVariablesLeft);

        Server rightValue = null;

        ICompareResult serverVariablesResult = new LeafCompareResult("TestVariable", null, CompareResultType.DELETED, CompareCriticalType.CRITICAL);
        when(serverVariablesCompareHolder.compare(eq(serverVariablesLeft), eq(null), any(), any())).thenReturn(serverVariablesResult);


        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("Url", new LeafCompareResult(leftValue.getUrl(), null, CompareResultType.DELETED, CompareCriticalType.CRITICAL));
        expected.put("Description", new LeafCompareResult(leftValue.getDescription(), null, CompareResultType.DELETED, CompareCriticalType.INFO));
        expected.put("Variables", serverVariablesResult);

        ICompareResult actual = spiedCompareHolderFactory.getServerCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareCreated() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        ServerVariablesCompareHolder serverVariablesCompareHolder = mock(ServerVariablesCompareHolder.class);
        when(spiedCompareHolderFactory.getServerVariablesCompareHolder()).thenReturn(serverVariablesCompareHolder);

        Server leftValue = null;
        Server rightValue = new Server();
        rightValue.setUrl("Test");
        rightValue.setDescription("Test");
        ServerVariables serverVariablesRight = mock(ServerVariables.class);
        rightValue.setVariables(serverVariablesRight);

        ICompareResult serverVariablesResult = new LeafCompareResult(null, "TestVariable", CompareResultType.CREATED, CompareCriticalType.CRITICAL);
        when(serverVariablesCompareHolder.compare(eq(null), eq(serverVariablesRight), any(), any())).thenReturn(serverVariablesResult);


        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("Url", new LeafCompareResult(null, rightValue.getUrl(), CompareResultType.CREATED, CompareCriticalType.CRITICAL));
        expected.put("Description", new LeafCompareResult(null,rightValue.getDescription(), CompareResultType.CREATED, CompareCriticalType.INFO));
        expected.put("Variables", serverVariablesResult);
        ICompareResult actual = spiedCompareHolderFactory.getServerCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareUnchanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        ServerVariablesCompareHolder serverVariablesCompareHolder = mock(ServerVariablesCompareHolder.class);
        when(spiedCompareHolderFactory.getServerVariablesCompareHolder()).thenReturn(serverVariablesCompareHolder);;

        Server leftValue = new Server();
        leftValue.setUrl("Test");
        leftValue.setDescription("Test");
        ServerVariables serverVariablesLeft = mock(ServerVariables.class);
        leftValue.setVariables(serverVariablesLeft);
        Server rightValue = new Server();
        rightValue.setUrl("Test");
        rightValue.setDescription("Test");
        ServerVariables serverVariablesRight = mock(ServerVariables.class);
        rightValue.setVariables(serverVariablesRight);

        ICompareResult serverVariablesResult = new LeafCompareResult("TestVariable", "TestVariable", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        when(serverVariablesCompareHolder.compare(eq(serverVariablesLeft), eq(serverVariablesRight), any(), any())).thenReturn(serverVariablesResult);


        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("Url", new LeafCompareResult(leftValue.getUrl(), rightValue.getUrl(), CompareResultType.UNCHANGED, CompareCriticalType.NONE));
        expected.put("Description", new LeafCompareResult(leftValue.getDescription(), rightValue.getDescription(), CompareResultType.UNCHANGED, CompareCriticalType.NONE));
        expected.put("Variables", serverVariablesResult);

        ICompareResult actual = spiedCompareHolderFactory.getServerCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareChanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        ServerVariablesCompareHolder serverVariablesCompareHolder = mock(ServerVariablesCompareHolder.class);
        when(spiedCompareHolderFactory.getServerVariablesCompareHolder()).thenReturn(serverVariablesCompareHolder);

        Server leftValue = new Server();
        leftValue.setUrl("Test");
        leftValue.setDescription("Test");
        ServerVariables serverVariablesLeft = mock(ServerVariables.class);
        leftValue.setVariables(serverVariablesLeft);
        Server rightValue = new Server();
        rightValue.setUrl("Test1");
        rightValue.setDescription("Test1");
        ServerVariables serverVariablesRight = mock(ServerVariables.class);
        rightValue.setVariables(serverVariablesRight);

        ICompareResult serverVariablesResult = new LeafCompareResult("TestVariable", "TestVariable", CompareResultType.CHANGED, CompareCriticalType.INFO);
        when(serverVariablesCompareHolder.compare(eq(serverVariablesLeft), eq(serverVariablesRight), any(), any())).thenReturn(serverVariablesResult);


        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("Url", new LeafCompareResult(leftValue.getUrl(), rightValue.getUrl(), CompareResultType.CHANGED, CompareCriticalType.CRITICAL));
        expected.put("Description", new LeafCompareResult(leftValue.getDescription(), rightValue.getDescription(), CompareResultType.CHANGED, CompareCriticalType.INFO));
        expected.put("Variables", serverVariablesResult);
        ICompareResult actual = spiedCompareHolderFactory.getServerCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }
}