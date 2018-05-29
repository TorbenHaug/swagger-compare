package de.haug_dev.swagger_compare_rest_cdt;

import de.haug_dev.swagger_compare.swagger_compare_core.SwaggerCompareCore;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareCriticalType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.LeafCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_facade.SwaggerCompareFacade;
import de.haug_dev.swagger_compare.swagger_compare_reader.OpenAPIV3ParserFactory;
import de.haug_dev.swagger_compare.swagger_compare_reader.SwaggerCompareReader;
import de.haug_dev.swagger_compare_rest.CompareController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import org.junit.Before;
import org.mockito.Mockito;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class MvcTest {

    @Before
    public void setup() {

        NodeCompareResult goodValue0_0 = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        NodeCompareResult goodValue1_0 = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        LeafCompareResult goodValue1_1 = new LeafCompareResult("goodValue1_1_left", "goodValue1_1_right", CompareResultType.CHANGED, CompareCriticalType.INFO);
        LeafCompareResult goodValue2_0 = new LeafCompareResult("goodValue2_0_left", "goodValue2_0_right", CompareResultType.CHANGED, CompareCriticalType.INFO);
        goodValue0_0.put("goodValue1_0", goodValue1_0);
        goodValue0_0.put("goodValue1_1", goodValue1_1);
        goodValue1_0.put("goodValue2_0", goodValue2_0);
        OpenAPI goodValueLeft = Mockito.mock(OpenAPI.class);
        OpenAPI goodValueRight = Mockito.mock(OpenAPI.class);

        OpenAPIV3Parser openAPIV3Parser = Mockito.mock(OpenAPIV3Parser.class);
        Mockito.when(openAPIV3Parser.read("http://goodValue/left.yaml")).thenReturn(goodValueLeft);
        Mockito.when(openAPIV3Parser.read("http://goodValue/right.yaml")).thenReturn(goodValueRight);

        OpenAPIV3ParserFactory openAPIV3ParserFactory = mock(OpenAPIV3ParserFactory.class);
        Mockito.when(openAPIV3ParserFactory.getParser()).thenReturn(openAPIV3Parser);

        SwaggerCompareCore swaggerCompareCore = Mockito.mock(SwaggerCompareCore.class);
        Mockito.when(swaggerCompareCore.compare(goodValueLeft, goodValueRight)).thenReturn(goodValue0_0);
        RestAssuredMockMvc.standaloneSetup(
                new CompareController(
                        new SwaggerCompareFacade(
                                new SwaggerCompareReader(openAPIV3ParserFactory),
                                swaggerCompareCore
                        )
                )
        );
    }

}
