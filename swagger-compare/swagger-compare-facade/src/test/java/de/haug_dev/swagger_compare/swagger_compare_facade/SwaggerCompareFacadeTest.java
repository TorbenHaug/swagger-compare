package de.haug_dev.swagger_compare.swagger_compare_facade;

import de.haug_dev.swagger_compare.swagger_compare_core.SwaggerCompareCore;
import de.haug_dev.swagger_compare.swagger_compare_reader.InvalidOpenAPIFileException;
import de.haug_dev.swagger_compare.swagger_compare_reader.SwaggerCompareReader;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class SwaggerCompareFacadeTest {


    @Test(expected = MalformedURLException.class)
    public void compareWithWrongFormatedUrlLeft() throws MalformedURLException, InvalidOpenAPIFileException {
        SwaggerCompareReader reader = mock(SwaggerCompareReader.class);
        SwaggerCompareCore core = mock(SwaggerCompareCore.class);
        SwaggerCompareFacade facade = new SwaggerCompareFacade(reader, core);
        facade.compare("aaaa","aaaa");
    }

    @Test(expected = MalformedURLException.class)
    public void compareWithWrongFormatedUrlRight() throws MalformedURLException, InvalidOpenAPIFileException {
        SwaggerCompareReader reader = mock(SwaggerCompareReader.class);
        SwaggerCompareCore core = mock(SwaggerCompareCore.class);
        SwaggerCompareFacade facade = new SwaggerCompareFacade(reader, core);
        facade.compare("http://test.test/test","aaaa");
    }

    @Test()
    public void compareWithCorrectFormatedUrlRight() throws MalformedURLException, InvalidOpenAPIFileException {
        SwaggerCompareReader reader = mock(SwaggerCompareReader.class);
        OpenAPI[] openAPIS = new OpenAPI[2];
        openAPIS[0] = mock(OpenAPI.class);
        openAPIS[1] = mock(OpenAPI.class);
        when(reader.read(any(URL.class),any(URL.class))).thenReturn(openAPIS);
        SwaggerCompareCore core = mock(SwaggerCompareCore.class);
        SwaggerCompareFacade facade = new SwaggerCompareFacade(reader, core);
        facade.compare("http://test.test/test","http://test.test/test2");
        verify(reader, times(1)).read(new URL("http://test.test/test"),new URL("http://test.test/test2"));
        verify(core, times(1)).compare(openAPIS[0],openAPIS[1]);
    }

}