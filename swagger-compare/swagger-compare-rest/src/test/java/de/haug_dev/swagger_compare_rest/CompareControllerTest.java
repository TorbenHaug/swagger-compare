package de.haug_dev.swagger_compare_rest;

import de.haug_dev.swagger_compare.swagger_compare_dto.OpenAPICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_facade.SwaggerCompareFacade;

import de.haug_dev.swagger_compare.swagger_compare_reader.InvalidOpenAPIFileException;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CompareControllerTest {



    @Test
    public void compare() throws MalformedURLException, InvalidOpenAPIFileException {
        SwaggerCompareFacade facade = mock(SwaggerCompareFacade.class);
        OpenAPICompareResult expected = mock(OpenAPICompareResult.class);
        when(facade.compare("test1", "test2")).thenReturn(expected);
        CompareController controller = new CompareController(facade);

        CompareRequest compareRequest = new CompareRequest();
        compareRequest.setUrlLeft("test1");
        compareRequest.setUrlRight("test2");

        OpenAPICompareResult actual = controller.compare(compareRequest);
        verify(facade.compare("test1", "test2"), times(1));
        assertEquals(expected, actual);
    }
}