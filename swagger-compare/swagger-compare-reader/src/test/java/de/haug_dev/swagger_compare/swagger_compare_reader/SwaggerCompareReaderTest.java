package de.haug_dev.swagger_compare.swagger_compare_reader;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class SwaggerCompareReaderTest {

    @Test(expected = InvalidOpenAPIFileException.class)
    public void readInavlidURLLeft() throws MalformedURLException, InvalidOpenAPIFileException {
        URL urlLeft = new URL("http://left/left");
        URL urlRight = new URL("http://right/right");
        OpenAPI openAPIRight = mock(OpenAPI.class);
        OpenAPIV3Parser parser = mock(OpenAPIV3Parser.class);
        when(parser.read(urlLeft.toString())).thenReturn(null);
        when(parser.read(urlRight.toString())).thenReturn(openAPIRight);
        SwaggerCompareReader reader = new SwaggerCompareReader(parser);
        reader.read(urlLeft, urlRight);
    }

    @Test(expected = InvalidOpenAPIFileException.class)
    public void readInavlidURLRight() throws MalformedURLException, InvalidOpenAPIFileException {
        URL urlLeft = new URL("http://left/left");
        URL urlRight = new URL("http://right/right");
        OpenAPI openAPILeft = mock(OpenAPI.class);
        OpenAPIV3Parser parser = mock(OpenAPIV3Parser.class);
        when(parser.read(urlLeft.toString())).thenReturn(openAPILeft);
        when(parser.read(urlRight.toString())).thenReturn(null);
        SwaggerCompareReader reader = new SwaggerCompareReader(parser);
        reader.read(urlLeft, urlRight);
    }

    @Test
    public void read() throws MalformedURLException, InvalidOpenAPIFileException {
        URL urlLeft = new URL("http://left/left");
        URL urlRight = new URL("http://right/right");
        OpenAPI openAPILeft = mock(OpenAPI.class);
        OpenAPI openAPIRight = mock(OpenAPI.class);
        OpenAPI[] expected = new OpenAPI[2];
        expected[0] = openAPILeft;
        expected[1] = openAPIRight;
        OpenAPIV3Parser parser = mock(OpenAPIV3Parser.class);
        when(parser.read(urlLeft.toString())).thenReturn(openAPILeft);
        when(parser.read(urlRight.toString())).thenReturn(openAPIRight);
        SwaggerCompareReader reader = new SwaggerCompareReader(parser);
        OpenAPI[] actual = reader.read(urlLeft, urlRight);
        verify(parser,times(2)).read(anyString());
        assertEquals(Arrays.asList(expected), Arrays.asList(actual));
    }
}