package de.haug_dev.swagger_compare_rest_cdt;

import de.haug_dev.swagger_compare.swagger_compare_core.Normalizer;
import de.haug_dev.swagger_compare.swagger_compare_core.SwaggerCompareCore;
import de.haug_dev.swagger_compare.swagger_compare_core.processors.ChangedPathFinder;
import de.haug_dev.swagger_compare.swagger_compare_core.processors.CreatedPathFinder;
import de.haug_dev.swagger_compare.swagger_compare_core.processors.DeletedPathFinder;
import de.haug_dev.swagger_compare.swagger_compare_core.processors.UnchangedPathFinder;
import de.haug_dev.swagger_compare.swagger_compare_facade.SwaggerCompareFacade;
import de.haug_dev.swagger_compare.swagger_compare_reader.OpenAPIV3ParserFactory;
import de.haug_dev.swagger_compare.swagger_compare_reader.SwaggerCompareReader;
import de.haug_dev.swagger_compare_rest.CompareController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.swagger.v3.parser.OpenAPIV3Parser;
import org.junit.Before;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class MvcTest {

    @Before
    public void setup() throws URISyntaxException, MalformedURLException {

        OpenAPIV3ParserFactory openAPIV3ParserFactory = mock(OpenAPIV3ParserFactory.class);
        String test1_yaml = fixUri(this.getClass().getResource("/yaml/test2.yaml").toString());
        System.err.println(test1_yaml);
        OpenAPIV3Parser openAPIV3Parser = new OpenAPIV3Parser();
        OpenAPIV3Parser openApiv3ParserMock= mock(OpenAPIV3Parser.class);
        when(openAPIV3ParserFactory.getParser()).thenReturn(openApiv3ParserMock);
        when(openApiv3ParserMock.read("https://mocked.mock/test1.yaml"))
                .thenReturn(
                        openAPIV3Parser.read(
                                fixUri(this.getClass().getResource("/yaml/test1.yaml").toString())
                        )
                );
        when(openApiv3ParserMock.read("https://mocked.mock/test2.yaml"))
                .thenReturn(
                        openAPIV3Parser.read(
                                fixUri(this.getClass().getResource("/yaml/test2.yaml").toString())
                        )
                );
        RestAssuredMockMvc.standaloneSetup(
                new CompareController(
                        new SwaggerCompareFacade(
                                new SwaggerCompareReader(openAPIV3ParserFactory),
                                new SwaggerCompareCore(
                                        new UnchangedPathFinder(),
                                        new ChangedPathFinder(),
                                        new DeletedPathFinder(),
                                        new CreatedPathFinder(),
                                        new Normalizer()
                                )
                        )
                )
        );
    }

    private String fixUri(String s) {
        return (s != null && s.startsWith("file:/"))? s.replace("file:/", "file:///") : s;
    }
}
