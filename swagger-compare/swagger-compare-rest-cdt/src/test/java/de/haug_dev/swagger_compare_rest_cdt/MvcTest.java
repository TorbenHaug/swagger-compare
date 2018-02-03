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
import org.mockito.Mockito;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class MvcTest {

    @Before
    public void setup() throws URISyntaxException, MalformedURLException {

        OpenAPIV3ParserFactory openAPIV3ParserFactory = mock(OpenAPIV3ParserFactory.class);
        OpenAPIV3Parser openAPIV3Parser = new OpenAPIV3Parser();
        OpenAPIV3Parser openApiv3ParserMock = spy(OpenAPIV3Parser.class);
        when(openAPIV3ParserFactory.getParser()).thenReturn(openApiv3ParserMock);
        mockUrlResult("https://mocked.mock/basicPathLeft.yaml", "/yaml/basicPathLeft.yaml", openApiv3ParserMock, openAPIV3Parser);
        mockUrlResult("https://mocked.mock/basicPathRight.yaml", "/yaml/basicPathRight.yaml", openApiv3ParserMock, openAPIV3Parser);

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

    private void mockUrlResult(String url, String filePath, OpenAPIV3Parser spiedParser, OpenAPIV3Parser realParser){
        doReturn(
                realParser.read(
                        fixUri(this.getClass().getResource(filePath).toString())
                )
        ).when(spiedParser).read(url);
    }
}
