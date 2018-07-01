package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_core.callbacks.CallbacksCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.examples.ExamplesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.headers.HeadersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.links.LinksCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.parameters.ParametersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.request_bodies.RequestBodiesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.responses.ResponsesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.schemas.SchemasCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.security_schemes.SecuritySchemesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.callbacks.Callback;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.links.Link;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

;

public class ComponentsOpenAPICompareHolderTest {

    @Test
    public void compareAllValuesSet() {
        Map<String, Schema> schemasLeft = new HashMap<>();
        Schema schemaLeft = new Schema();
        schemasLeft.put("schemaLeft", schemaLeft);

        Map<String, ApiResponse> responsesLeft = new HashMap<>();
        ApiResponse responseLeft = new ApiResponse();
        responsesLeft.put("responseLeft", responseLeft);

        Map<String, Parameter> parametersLeft = new HashMap<>();
        Parameter parameterLeft = new Parameter();
        parametersLeft.put("parameterLeft", parameterLeft);

        Map<String, Example> examplesLeft = new HashMap<>();
        Example exampleLeft = new Example();
        examplesLeft.put("exampleLeft", exampleLeft);

        Map<String, RequestBody> requestBodiesLeft = new HashMap<>();
        RequestBody requestBodyLeft = new RequestBody();
        requestBodiesLeft.put("requestBodyLeft", requestBodyLeft);

        Map<String, Header> headersLeft = new HashMap<>();
        Header headerLeft = new Header();
        headersLeft.put("headerLeft", headerLeft);

        Map<String, SecurityScheme> securitySchemesLeft = new HashMap<>();
        SecurityScheme securitySchemeLeft = new SecurityScheme();
        securitySchemesLeft.put("securitySchemeLeft", securitySchemeLeft);

        Map<String, Link> linksLeft = new HashMap<>();
        Link linkSchemeLeft = new Link();
        linksLeft.put("linkSchemeLeft", linkSchemeLeft);

        Map<String, Callback> callbacksLeft = new HashMap<>();
        Callback callbackLeft = new Callback();
        callbacksLeft.put("callbackLeft", callbackLeft);

        Components componentsLeft = new Components();
        componentsLeft.setSchemas(schemasLeft);
        componentsLeft.setResponses(responsesLeft);
        componentsLeft.setParameters(parametersLeft);
        componentsLeft.setExamples(examplesLeft);
        componentsLeft.setRequestBodies(requestBodiesLeft);
        componentsLeft.setHeaders(headersLeft);
        componentsLeft.setSecuritySchemes(securitySchemesLeft);
        componentsLeft.setLinks(linksLeft);
        componentsLeft.setCallbacks(callbacksLeft);

        Map<String, Schema> schemasRight = new HashMap<>();
        Schema schemaRight = new Schema();
        schemasRight.put("schemaRight", schemaRight);

        Map<String, ApiResponse> responsesRight = new HashMap<>();
        ApiResponse responseRight = new ApiResponse();
        responsesRight.put("responseRight", responseRight);

        Map<String, Parameter> parametersRight = new HashMap<>();
        Parameter parameterRight = new Parameter();
        parametersRight.put("parameterRight", parameterRight);

        Map<String, Example> examplesRight = new HashMap<>();
        Example exampleRight = new Example();
        examplesRight.put("exampleRight", exampleRight);

        Map<String, RequestBody> requestBodiesRight = new HashMap<>();
        RequestBody requestBodyRight = new RequestBody();
        requestBodiesRight.put("requestBodyRight", requestBodyRight);

        Map<String, Header> headersRight = new HashMap<>();
        Header headerRight = new Header();
        headersRight.put("headerRight", headerRight);

        Map<String, SecurityScheme> securitySchemesRight = new HashMap<>();
        SecurityScheme securitySchemeRight = new SecurityScheme();
        securitySchemesRight.put("securitySchemeRight", securitySchemeRight);

        Map<String, Link> linksRight = new HashMap<>();
        Link linkSchemeRight = new Link();
        linksRight.put("linkSchemeRight", linkSchemeRight);

        Map<String, Callback> callbacksRight = new HashMap<>();
        Callback callbackRight = new Callback();
        callbacksRight.put("callbackRight", callbackRight);

        Components componentsRight = new Components();
        componentsRight.setSchemas(schemasRight);
        componentsRight.setResponses(responsesRight);
        componentsRight.setParameters(parametersRight);
        componentsRight.setExamples(examplesRight);
        componentsRight.setRequestBodies(requestBodiesRight);
        componentsRight.setHeaders(headersRight);
        componentsRight.setSecuritySchemes(securitySchemesRight);
        componentsRight.setLinks(linksRight);
        componentsRight.setCallbacks(callbacksRight);

        ICompareResult schemasCompareResult = new LeafCompareResult(schemasLeft, schemasRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult responsesCompareResult = new LeafCompareResult(responsesLeft, responsesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult parametersCompareResult = new LeafCompareResult(parametersLeft, parametersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult examplesCompareResult = new LeafCompareResult(examplesLeft, examplesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult requestBodiesCompareResult = new LeafCompareResult(requestBodiesLeft, requestBodiesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult headersCompareResult = new LeafCompareResult(headersLeft, headersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult securitySchemesCompareResult = new LeafCompareResult(securitySchemesLeft, securitySchemesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult linksCompareResult = new LeafCompareResult(linksLeft, linksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult callbacksCompareResult = new LeafCompareResult(callbacksLeft, callbacksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);


        SchemasCompareHolder schemasCompareHolder = Mockito.mock(SchemasCompareHolder.class);
        Mockito.when(schemasCompareHolder.compare(eq(schemasLeft), eq(schemasRight), any(), any())).thenReturn(schemasCompareResult);
        ResponsesCompareHolder responsesCompareHolder = Mockito.mock(ResponsesCompareHolder.class);
        Mockito.when(responsesCompareHolder.compare(eq(responsesLeft), eq(responsesRight), any(), any())).thenReturn(responsesCompareResult);
        ParametersCompareHolder parametersCompareHolder = Mockito.mock(ParametersCompareHolder.class);
        Mockito.when(parametersCompareHolder.compare(eq(parametersLeft), eq(parametersRight), any(), any())).thenReturn(parametersCompareResult);
        ExamplesCompareHolder examplesCompareHolder = Mockito.mock(ExamplesCompareHolder.class);
        Mockito.when(examplesCompareHolder.compare(eq(examplesLeft), eq(examplesRight), any(), any())).thenReturn(examplesCompareResult);
        RequestBodiesCompareHolder requestBodiesCompareHolder = Mockito.mock(RequestBodiesCompareHolder.class);
        Mockito.when(requestBodiesCompareHolder.compare(eq(requestBodiesLeft), eq(requestBodiesRight), any(), any())).thenReturn(requestBodiesCompareResult);
        HeadersCompareHolder headersCompareHolder = Mockito.mock(HeadersCompareHolder.class);
        Mockito.when(headersCompareHolder.compare(eq(headersLeft), eq(headersRight), any(), any())).thenReturn(headersCompareResult);
        SecuritySchemesCompareHolder securitySchemesCompareHolder = Mockito.mock(SecuritySchemesCompareHolder.class);
        Mockito.when(securitySchemesCompareHolder.compare(eq(securitySchemesLeft), eq(securitySchemesRight), any(), any())).thenReturn(securitySchemesCompareResult);
        LinksCompareHolder linksCompareHolder = Mockito.mock(LinksCompareHolder.class);
        Mockito.when(linksCompareHolder.compare(eq(linksLeft), eq(linksRight), any(), any())).thenReturn(linksCompareResult);
        CallbacksCompareHolder callbacksCompareHolder = Mockito.mock(CallbacksCompareHolder.class);
        Mockito.when(callbacksCompareHolder.compare(eq(callbacksLeft), eq(callbacksRight), any(), any())).thenReturn(callbacksCompareResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("Schemas", schemasCompareResult);
        expected.put("Responses", responsesCompareResult);
        expected.put("Parameters", parametersCompareResult);
        expected.put("Examples", examplesCompareResult);
        expected.put("RequestBodies", requestBodiesCompareResult);
        expected.put("Headers", headersCompareResult);
        expected.put("SecuritySchemes", securitySchemesCompareResult);
        expected.put("Links", linksCompareResult);
        expected.put("Callbacks", callbacksCompareResult);

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getSchemasCompareHolder()).thenReturn(schemasCompareHolder);
        when(compareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        when(compareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        when(compareHolderFactory.getExamplesCompareHolder()).thenReturn(examplesCompareHolder);
        when(compareHolderFactory.getRequestBodiesCompareHolder()).thenReturn(requestBodiesCompareHolder);
        when(compareHolderFactory.getHeadersCompareHolder()).thenReturn(headersCompareHolder);
        when(compareHolderFactory.getSecuritySchemesCompareHolder()).thenReturn(securitySchemesCompareHolder);
        when(compareHolderFactory.getLinksCompareHolder()).thenReturn(linksCompareHolder);
        when(compareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);

        ComponentsCompareHolder componentsCompareHolder = new ComponentsCompareHolder(compareHolderFactory);

        ICompareResult actual = componentsCompareHolder.compare(componentsLeft, componentsRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);

    }

    @Test
    public void compareLeftValuesSet1() {
        Map<String, Schema> schemasLeft = new HashMap<>();
        Schema schemaLeft = new Schema();
        schemasLeft.put("schemaLeft", schemaLeft);

        Map<String, ApiResponse> responsesLeft = new HashMap<>();
        ApiResponse responseLeft = new ApiResponse();
        responsesLeft.put("responseLeft", responseLeft);

        Map<String, Parameter> parametersLeft = new HashMap<>();
        Parameter parameterLeft = new Parameter();
        parametersLeft.put("parameterLeft", parameterLeft);

        Map<String, Example> examplesLeft = new HashMap<>();
        Example exampleLeft = new Example();
        examplesLeft.put("exampleLeft", exampleLeft);

        Map<String, RequestBody> requestBodiesLeft = new HashMap<>();
        RequestBody requestBodyLeft = new RequestBody();
        requestBodiesLeft.put("requestBodyLeft", requestBodyLeft);

        Map<String, Header> headersLeft = new HashMap<>();
        Header headerLeft = new Header();
        headersLeft.put("headerLeft", headerLeft);

        Map<String, SecurityScheme> securitySchemesLeft = new HashMap<>();
        SecurityScheme securitySchemeLeft = new SecurityScheme();
        securitySchemesLeft.put("securitySchemeLeft", securitySchemeLeft);

        Map<String, Link> linksLeft = new HashMap<>();
        Link linkSchemeLeft = new Link();
        linksLeft.put("linkSchemeLeft", linkSchemeLeft);

        Map<String, Callback> callbacksLeft = new HashMap<>();
        Callback callbackLeft = new Callback();
        callbacksLeft.put("callbackLeft", callbackLeft);

        Components componentsLeft = new Components();
        componentsLeft.setSchemas(schemasLeft);
        componentsLeft.setResponses(responsesLeft);
        componentsLeft.setParameters(parametersLeft);
        componentsLeft.setExamples(examplesLeft);
        componentsLeft.setRequestBodies(requestBodiesLeft);
        componentsLeft.setHeaders(headersLeft);
        componentsLeft.setSecuritySchemes(securitySchemesLeft);
        componentsLeft.setLinks(linksLeft);
        componentsLeft.setCallbacks(callbacksLeft);

        Map<String, Schema> schemasRight = new HashMap<>();

        Map<String, ApiResponse> responsesRight = new HashMap<>();

        Map<String, Parameter> parametersRight = new HashMap<>();

        Map<String, Example> examplesRight = new HashMap<>();

        Map<String, RequestBody> requestBodiesRight = new HashMap<>();

        Map<String, Header> headersRight = new HashMap<>();

        Map<String, SecurityScheme> securitySchemesRight = new HashMap<>();

        Map<String, Link> linksRight = new HashMap<>();

        Map<String, Callback> callbacksRight = new HashMap<>();

        Components componentsRight = new Components();
        componentsRight.setSchemas(schemasRight);
        componentsRight.setResponses(responsesRight);
        componentsRight.setParameters(parametersRight);
        componentsRight.setExamples(examplesRight);
        componentsRight.setRequestBodies(requestBodiesRight);
        componentsRight.setHeaders(headersRight);
        componentsRight.setSecuritySchemes(securitySchemesRight);
        componentsRight.setLinks(linksRight);
        componentsRight.setCallbacks(callbacksRight);

        ICompareResult schemasCompareResult = new LeafCompareResult(schemasLeft, schemasRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult responsesCompareResult = new LeafCompareResult(responsesLeft, responsesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult parametersCompareResult = new LeafCompareResult(parametersLeft, parametersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult examplesCompareResult = new LeafCompareResult(examplesLeft, examplesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult requestBodiesCompareResult = new LeafCompareResult(requestBodiesLeft, requestBodiesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult headersCompareResult = new LeafCompareResult(headersLeft, headersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult securitySchemesCompareResult = new LeafCompareResult(securitySchemesLeft, securitySchemesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult linksCompareResult = new LeafCompareResult(linksLeft, linksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult callbacksCompareResult = new LeafCompareResult(callbacksLeft, callbacksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);


        SchemasCompareHolder schemasCompareHolder = Mockito.mock(SchemasCompareHolder.class);
        Mockito.when(schemasCompareHolder.compare(eq(schemasLeft), eq(schemasRight), any(), any())).thenReturn(schemasCompareResult);
        ResponsesCompareHolder responsesCompareHolder = Mockito.mock(ResponsesCompareHolder.class);
        Mockito.when(responsesCompareHolder.compare(eq(responsesLeft), eq(responsesRight), any(), any())).thenReturn(responsesCompareResult);
        ParametersCompareHolder parametersCompareHolder = Mockito.mock(ParametersCompareHolder.class);
        Mockito.when(parametersCompareHolder.compare(eq(parametersLeft), eq(parametersRight), any(), any())).thenReturn(parametersCompareResult);
        ExamplesCompareHolder examplesCompareHolder = Mockito.mock(ExamplesCompareHolder.class);
        Mockito.when(examplesCompareHolder.compare(eq(examplesLeft), eq(examplesRight), any(), any())).thenReturn(examplesCompareResult);
        RequestBodiesCompareHolder requestBodiesCompareHolder = Mockito.mock(RequestBodiesCompareHolder.class);
        Mockito.when(requestBodiesCompareHolder.compare(eq(requestBodiesLeft), eq(requestBodiesRight), any(), any())).thenReturn(requestBodiesCompareResult);
        HeadersCompareHolder headersCompareHolder = Mockito.mock(HeadersCompareHolder.class);
        Mockito.when(headersCompareHolder.compare(eq(headersLeft), eq(headersRight), any(), any())).thenReturn(headersCompareResult);
        SecuritySchemesCompareHolder securitySchemesCompareHolder = Mockito.mock(SecuritySchemesCompareHolder.class);
        Mockito.when(securitySchemesCompareHolder.compare(eq(securitySchemesLeft), eq(securitySchemesRight), any(), any())).thenReturn(securitySchemesCompareResult);
        LinksCompareHolder linksCompareHolder = Mockito.mock(LinksCompareHolder.class);
        Mockito.when(linksCompareHolder.compare(eq(linksLeft), eq(linksRight), any(), any())).thenReturn(linksCompareResult);
        CallbacksCompareHolder callbacksCompareHolder = Mockito.mock(CallbacksCompareHolder.class);
        Mockito.when(callbacksCompareHolder.compare(eq(callbacksLeft), eq(callbacksRight), any(), any())).thenReturn(callbacksCompareResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("Schemas", schemasCompareResult);
        expected.put("Responses", responsesCompareResult);
        expected.put("Parameters", parametersCompareResult);
        expected.put("Examples", examplesCompareResult);
        expected.put("RequestBodies", requestBodiesCompareResult);
        expected.put("Headers", headersCompareResult);
        expected.put("SecuritySchemes", securitySchemesCompareResult);
        expected.put("Links", linksCompareResult);
        expected.put("Callbacks", callbacksCompareResult);

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getSchemasCompareHolder()).thenReturn(schemasCompareHolder);
        when(compareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        when(compareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        when(compareHolderFactory.getExamplesCompareHolder()).thenReturn(examplesCompareHolder);
        when(compareHolderFactory.getRequestBodiesCompareHolder()).thenReturn(requestBodiesCompareHolder);
        when(compareHolderFactory.getHeadersCompareHolder()).thenReturn(headersCompareHolder);
        when(compareHolderFactory.getSecuritySchemesCompareHolder()).thenReturn(securitySchemesCompareHolder);
        when(compareHolderFactory.getLinksCompareHolder()).thenReturn(linksCompareHolder);
        when(compareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);

        ComponentsCompareHolder componentsCompareHolder = new ComponentsCompareHolder(compareHolderFactory);

        ICompareResult actual = componentsCompareHolder.compare(componentsLeft, componentsRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);

    }

    @Test
    public void compareLeftValuesSet2() {
        Map<String, Schema> schemasLeft = new HashMap<>();
        Schema schemaLeft = new Schema();
        schemasLeft.put("schemaLeft", schemaLeft);

        Map<String, ApiResponse> responsesLeft = new HashMap<>();
        ApiResponse responseLeft = new ApiResponse();
        responsesLeft.put("responseLeft", responseLeft);

        Map<String, Parameter> parametersLeft = new HashMap<>();
        Parameter parameterLeft = new Parameter();
        parametersLeft.put("parameterLeft", parameterLeft);

        Map<String, Example> examplesLeft = new HashMap<>();
        Example exampleLeft = new Example();
        examplesLeft.put("exampleLeft", exampleLeft);

        Map<String, RequestBody> requestBodiesLeft = new HashMap<>();
        RequestBody requestBodyLeft = new RequestBody();
        requestBodiesLeft.put("requestBodyLeft", requestBodyLeft);

        Map<String, Header> headersLeft = new HashMap<>();
        Header headerLeft = new Header();
        headersLeft.put("headerLeft", headerLeft);

        Map<String, SecurityScheme> securitySchemesLeft = new HashMap<>();
        SecurityScheme securitySchemeLeft = new SecurityScheme();
        securitySchemesLeft.put("securitySchemeLeft", securitySchemeLeft);

        Map<String, Link> linksLeft = new HashMap<>();
        Link linkSchemeLeft = new Link();
        linksLeft.put("linkSchemeLeft", linkSchemeLeft);

        Map<String, Callback> callbacksLeft = new HashMap<>();
        Callback callbackLeft = new Callback();
        callbacksLeft.put("callbackLeft", callbackLeft);

        Components componentsLeft = new Components();
        componentsLeft.setSchemas(schemasLeft);
        componentsLeft.setResponses(responsesLeft);
        componentsLeft.setParameters(parametersLeft);
        componentsLeft.setExamples(examplesLeft);
        componentsLeft.setRequestBodies(requestBodiesLeft);
        componentsLeft.setHeaders(headersLeft);
        componentsLeft.setSecuritySchemes(securitySchemesLeft);
        componentsLeft.setLinks(linksLeft);
        componentsLeft.setCallbacks(callbacksLeft);

        Map<String, Schema> schemasRight = null;

        Map<String, ApiResponse> responsesRight = null;

        Map<String, Parameter> parametersRight = null;

        Map<String, Example> examplesRight = null;

        Map<String, RequestBody> requestBodiesRight = null;

        Map<String, Header> headersRight = null;

        Map<String, SecurityScheme> securitySchemesRight = null;

        Map<String, Link> linksRight = null;

        Map<String, Callback> callbacksRight = null;

        Components componentsRight = new Components();
        componentsRight.setSchemas(schemasRight);
        componentsRight.setResponses(responsesRight);
        componentsRight.setParameters(parametersRight);
        componentsRight.setExamples(examplesRight);
        componentsRight.setRequestBodies(requestBodiesRight);
        componentsRight.setHeaders(headersRight);
        componentsRight.setSecuritySchemes(securitySchemesRight);
        componentsRight.setLinks(linksRight);
        componentsRight.setCallbacks(callbacksRight);

        ICompareResult schemasCompareResult = new LeafCompareResult(schemasLeft, schemasRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult responsesCompareResult = new LeafCompareResult(responsesLeft, responsesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult parametersCompareResult = new LeafCompareResult(parametersLeft, parametersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult examplesCompareResult = new LeafCompareResult(examplesLeft, examplesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult requestBodiesCompareResult = new LeafCompareResult(requestBodiesLeft, requestBodiesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult headersCompareResult = new LeafCompareResult(headersLeft, headersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult securitySchemesCompareResult = new LeafCompareResult(securitySchemesLeft, securitySchemesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult linksCompareResult = new LeafCompareResult(linksLeft, linksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult callbacksCompareResult = new LeafCompareResult(callbacksLeft, callbacksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);


        SchemasCompareHolder schemasCompareHolder = Mockito.mock(SchemasCompareHolder.class);
        Mockito.when(schemasCompareHolder.compare(eq(schemasLeft), eq(schemasRight), any(), any())).thenReturn(schemasCompareResult);
        ResponsesCompareHolder responsesCompareHolder = Mockito.mock(ResponsesCompareHolder.class);
        Mockito.when(responsesCompareHolder.compare(eq(responsesLeft), eq(responsesRight), any(), any())).thenReturn(responsesCompareResult);
        ParametersCompareHolder parametersCompareHolder = Mockito.mock(ParametersCompareHolder.class);
        Mockito.when(parametersCompareHolder.compare(eq(parametersLeft), eq(parametersRight), any(), any())).thenReturn(parametersCompareResult);
        ExamplesCompareHolder examplesCompareHolder = Mockito.mock(ExamplesCompareHolder.class);
        Mockito.when(examplesCompareHolder.compare(eq(examplesLeft), eq(examplesRight), any(), any())).thenReturn(examplesCompareResult);
        RequestBodiesCompareHolder requestBodiesCompareHolder = Mockito.mock(RequestBodiesCompareHolder.class);
        Mockito.when(requestBodiesCompareHolder.compare(eq(requestBodiesLeft), eq(requestBodiesRight), any(), any())).thenReturn(requestBodiesCompareResult);
        HeadersCompareHolder headersCompareHolder = Mockito.mock(HeadersCompareHolder.class);
        Mockito.when(headersCompareHolder.compare(eq(headersLeft), eq(headersRight), any(), any())).thenReturn(headersCompareResult);
        SecuritySchemesCompareHolder securitySchemesCompareHolder = Mockito.mock(SecuritySchemesCompareHolder.class);
        Mockito.when(securitySchemesCompareHolder.compare(eq(securitySchemesLeft), eq(securitySchemesRight), any(), any())).thenReturn(securitySchemesCompareResult);
        LinksCompareHolder linksCompareHolder = Mockito.mock(LinksCompareHolder.class);
        Mockito.when(linksCompareHolder.compare(eq(linksLeft), eq(linksRight), any(), any())).thenReturn(linksCompareResult);
        CallbacksCompareHolder callbacksCompareHolder = Mockito.mock(CallbacksCompareHolder.class);
        Mockito.when(callbacksCompareHolder.compare(eq(callbacksLeft), eq(callbacksRight), any(), any())).thenReturn(callbacksCompareResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("Schemas", schemasCompareResult);
        expected.put("Responses", responsesCompareResult);
        expected.put("Parameters", parametersCompareResult);
        expected.put("Examples", examplesCompareResult);
        expected.put("RequestBodies", requestBodiesCompareResult);
        expected.put("Headers", headersCompareResult);
        expected.put("SecuritySchemes", securitySchemesCompareResult);
        expected.put("Links", linksCompareResult);
        expected.put("Callbacks", callbacksCompareResult);

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getSchemasCompareHolder()).thenReturn(schemasCompareHolder);
        when(compareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        when(compareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        when(compareHolderFactory.getExamplesCompareHolder()).thenReturn(examplesCompareHolder);
        when(compareHolderFactory.getRequestBodiesCompareHolder()).thenReturn(requestBodiesCompareHolder);
        when(compareHolderFactory.getHeadersCompareHolder()).thenReturn(headersCompareHolder);
        when(compareHolderFactory.getSecuritySchemesCompareHolder()).thenReturn(securitySchemesCompareHolder);
        when(compareHolderFactory.getLinksCompareHolder()).thenReturn(linksCompareHolder);
        when(compareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);

        ComponentsCompareHolder componentsCompareHolder = new ComponentsCompareHolder(compareHolderFactory);

        ICompareResult actual = componentsCompareHolder.compare(componentsLeft, componentsRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);

    }

    @Test
    public void compareRightValuesSet1() {
        Map<String, Schema> schemasLeft = new HashMap<>();

        Map<String, ApiResponse> responsesLeft = new HashMap<>();

        Map<String, Parameter> parametersLeft = new HashMap<>();

        Map<String, Example> examplesLeft = new HashMap<>();

        Map<String, RequestBody> requestBodiesLeft = new HashMap<>();

        Map<String, Header> headersLeft = new HashMap<>();

        Map<String, SecurityScheme> securitySchemesLeft = new HashMap<>();

        Map<String, Link> linksLeft = new HashMap<>();

        Map<String, Callback> callbacksLeft = new HashMap<>();

        Components componentsLeft = new Components();
        componentsLeft.setSchemas(schemasLeft);
        componentsLeft.setResponses(responsesLeft);
        componentsLeft.setParameters(parametersLeft);
        componentsLeft.setExamples(examplesLeft);
        componentsLeft.setRequestBodies(requestBodiesLeft);
        componentsLeft.setHeaders(headersLeft);
        componentsLeft.setSecuritySchemes(securitySchemesLeft);
        componentsLeft.setLinks(linksLeft);
        componentsLeft.setCallbacks(callbacksLeft);

        Map<String, Schema> schemasRight = new HashMap<>();
        Schema schemaRight = new Schema();
        schemasRight.put("schemaRight", schemaRight);

        Map<String, ApiResponse> responsesRight = new HashMap<>();
        ApiResponse responseRight = new ApiResponse();
        responsesRight.put("responseRight", responseRight);

        Map<String, Parameter> parametersRight = new HashMap<>();
        Parameter parameterRight = new Parameter();
        parametersRight.put("parameterRight", parameterRight);

        Map<String, Example> examplesRight = new HashMap<>();
        Example exampleRight = new Example();
        examplesRight.put("exampleRight", exampleRight);

        Map<String, RequestBody> requestBodiesRight = new HashMap<>();
        RequestBody requestBodyRight = new RequestBody();
        requestBodiesRight.put("requestBodyRight", requestBodyRight);

        Map<String, Header> headersRight = new HashMap<>();
        Header headerRight = new Header();
        headersRight.put("headerRight", headerRight);

        Map<String, SecurityScheme> securitySchemesRight = new HashMap<>();
        SecurityScheme securitySchemeRight = new SecurityScheme();
        securitySchemesRight.put("securitySchemeRight", securitySchemeRight);

        Map<String, Link> linksRight = new HashMap<>();
        Link linkSchemeRight = new Link();
        linksRight.put("linkSchemeRight", linkSchemeRight);

        Map<String, Callback> callbacksRight = new HashMap<>();
        Callback callbackRight = new Callback();
        callbacksRight.put("callbackRight", callbackRight);

        Components componentsRight = new Components();
        componentsRight.setSchemas(schemasRight);
        componentsRight.setResponses(responsesRight);
        componentsRight.setParameters(parametersRight);
        componentsRight.setExamples(examplesRight);
        componentsRight.setRequestBodies(requestBodiesRight);
        componentsRight.setHeaders(headersRight);
        componentsRight.setSecuritySchemes(securitySchemesRight);
        componentsRight.setLinks(linksRight);
        componentsRight.setCallbacks(callbacksRight);

        ICompareResult schemasCompareResult = new LeafCompareResult(schemasLeft, schemasRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult responsesCompareResult = new LeafCompareResult(responsesLeft, responsesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult parametersCompareResult = new LeafCompareResult(parametersLeft, parametersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult examplesCompareResult = new LeafCompareResult(examplesLeft, examplesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult requestBodiesCompareResult = new LeafCompareResult(requestBodiesLeft, requestBodiesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult headersCompareResult = new LeafCompareResult(headersLeft, headersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult securitySchemesCompareResult = new LeafCompareResult(securitySchemesLeft, securitySchemesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult linksCompareResult = new LeafCompareResult(linksLeft, linksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult callbacksCompareResult = new LeafCompareResult(callbacksLeft, callbacksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);


        SchemasCompareHolder schemasCompareHolder = Mockito.mock(SchemasCompareHolder.class);
        Mockito.when(schemasCompareHolder.compare(eq(schemasLeft), eq(schemasRight), any(), any())).thenReturn(schemasCompareResult);
        ResponsesCompareHolder responsesCompareHolder = Mockito.mock(ResponsesCompareHolder.class);
        Mockito.when(responsesCompareHolder.compare(eq(responsesLeft), eq(responsesRight), any(), any())).thenReturn(responsesCompareResult);
        ParametersCompareHolder parametersCompareHolder = Mockito.mock(ParametersCompareHolder.class);
        Mockito.when(parametersCompareHolder.compare(eq(parametersLeft), eq(parametersRight), any(), any())).thenReturn(parametersCompareResult);
        ExamplesCompareHolder examplesCompareHolder = Mockito.mock(ExamplesCompareHolder.class);
        Mockito.when(examplesCompareHolder.compare(eq(examplesLeft), eq(examplesRight), any(), any())).thenReturn(examplesCompareResult);
        RequestBodiesCompareHolder requestBodiesCompareHolder = Mockito.mock(RequestBodiesCompareHolder.class);
        Mockito.when(requestBodiesCompareHolder.compare(eq(requestBodiesLeft), eq(requestBodiesRight), any(), any())).thenReturn(requestBodiesCompareResult);
        HeadersCompareHolder headersCompareHolder = Mockito.mock(HeadersCompareHolder.class);
        Mockito.when(headersCompareHolder.compare(eq(headersLeft), eq(headersRight), any(), any())).thenReturn(headersCompareResult);
        SecuritySchemesCompareHolder securitySchemesCompareHolder = Mockito.mock(SecuritySchemesCompareHolder.class);
        Mockito.when(securitySchemesCompareHolder.compare(eq(securitySchemesLeft), eq(securitySchemesRight), any(), any())).thenReturn(securitySchemesCompareResult);
        LinksCompareHolder linksCompareHolder = Mockito.mock(LinksCompareHolder.class);
        Mockito.when(linksCompareHolder.compare(eq(linksLeft), eq(linksRight), any(), any())).thenReturn(linksCompareResult);
        CallbacksCompareHolder callbacksCompareHolder = Mockito.mock(CallbacksCompareHolder.class);
        Mockito.when(callbacksCompareHolder.compare(eq(callbacksLeft), eq(callbacksRight), any(), any())).thenReturn(callbacksCompareResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("Schemas", schemasCompareResult);
        expected.put("Responses", responsesCompareResult);
        expected.put("Parameters", parametersCompareResult);
        expected.put("Examples", examplesCompareResult);
        expected.put("RequestBodies", requestBodiesCompareResult);
        expected.put("Headers", headersCompareResult);
        expected.put("SecuritySchemes", securitySchemesCompareResult);
        expected.put("Links", linksCompareResult);
        expected.put("Callbacks", callbacksCompareResult);

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getSchemasCompareHolder()).thenReturn(schemasCompareHolder);
        when(compareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        when(compareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        when(compareHolderFactory.getExamplesCompareHolder()).thenReturn(examplesCompareHolder);
        when(compareHolderFactory.getRequestBodiesCompareHolder()).thenReturn(requestBodiesCompareHolder);
        when(compareHolderFactory.getHeadersCompareHolder()).thenReturn(headersCompareHolder);
        when(compareHolderFactory.getSecuritySchemesCompareHolder()).thenReturn(securitySchemesCompareHolder);
        when(compareHolderFactory.getLinksCompareHolder()).thenReturn(linksCompareHolder);
        when(compareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);

        ComponentsCompareHolder componentsCompareHolder = new ComponentsCompareHolder(compareHolderFactory);

        ICompareResult actual = componentsCompareHolder.compare(componentsLeft, componentsRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);

    }

    @Test
    public void compareRightValuesSet2() {
        Map<String, Schema> schemasLeft = null;

        Map<String, ApiResponse> responsesLeft = null;

        Map<String, Parameter> parametersLeft = null;

        Map<String, Example> examplesLeft = null;

        Map<String, RequestBody> requestBodiesLeft = null;

        Map<String, Header> headersLeft = null;

        Map<String, SecurityScheme> securitySchemesLeft = null;

        Map<String, Link> linksLeft = null;

        Map<String, Callback> callbacksLeft = null;

        Components componentsLeft = new Components();
        componentsLeft.setSchemas(schemasLeft);
        componentsLeft.setResponses(responsesLeft);
        componentsLeft.setParameters(parametersLeft);
        componentsLeft.setExamples(examplesLeft);
        componentsLeft.setRequestBodies(requestBodiesLeft);
        componentsLeft.setHeaders(headersLeft);
        componentsLeft.setSecuritySchemes(securitySchemesLeft);
        componentsLeft.setLinks(linksLeft);
        componentsLeft.setCallbacks(callbacksLeft);

        Map<String, Schema> schemasRight = new HashMap<>();
        Schema schemaRight = new Schema();
        schemasRight.put("schemaRight", schemaRight);

        Map<String, ApiResponse> responsesRight = new HashMap<>();
        ApiResponse responseRight = new ApiResponse();
        responsesRight.put("responseRight", responseRight);

        Map<String, Parameter> parametersRight = new HashMap<>();
        Parameter parameterRight = new Parameter();
        parametersRight.put("parameterRight", parameterRight);

        Map<String, Example> examplesRight = new HashMap<>();
        Example exampleRight = new Example();
        examplesRight.put("exampleRight", exampleRight);

        Map<String, RequestBody> requestBodiesRight = new HashMap<>();
        RequestBody requestBodyRight = new RequestBody();
        requestBodiesRight.put("requestBodyRight", requestBodyRight);

        Map<String, Header> headersRight = new HashMap<>();
        Header headerRight = new Header();
        headersRight.put("headerRight", headerRight);

        Map<String, SecurityScheme> securitySchemesRight = new HashMap<>();
        SecurityScheme securitySchemeRight = new SecurityScheme();
        securitySchemesRight.put("securitySchemeRight", securitySchemeRight);

        Map<String, Link> linksRight = new HashMap<>();
        Link linkSchemeRight = new Link();
        linksRight.put("linkSchemeRight", linkSchemeRight);

        Map<String, Callback> callbacksRight = new HashMap<>();
        Callback callbackRight = new Callback();
        callbacksRight.put("callbackRight", callbackRight);

        Components componentsRight = new Components();
        componentsRight.setSchemas(schemasRight);
        componentsRight.setResponses(responsesRight);
        componentsRight.setParameters(parametersRight);
        componentsRight.setExamples(examplesRight);
        componentsRight.setRequestBodies(requestBodiesRight);
        componentsRight.setHeaders(headersRight);
        componentsRight.setSecuritySchemes(securitySchemesRight);
        componentsRight.setLinks(linksRight);
        componentsRight.setCallbacks(callbacksRight);

        ICompareResult schemasCompareResult = new LeafCompareResult(schemasLeft, schemasRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult responsesCompareResult = new LeafCompareResult(responsesLeft, responsesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult parametersCompareResult = new LeafCompareResult(parametersLeft, parametersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult examplesCompareResult = new LeafCompareResult(examplesLeft, examplesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult requestBodiesCompareResult = new LeafCompareResult(requestBodiesLeft, requestBodiesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult headersCompareResult = new LeafCompareResult(headersLeft, headersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult securitySchemesCompareResult = new LeafCompareResult(securitySchemesLeft, securitySchemesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult linksCompareResult = new LeafCompareResult(linksLeft, linksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult callbacksCompareResult = new LeafCompareResult(callbacksLeft, callbacksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);


        SchemasCompareHolder schemasCompareHolder = Mockito.mock(SchemasCompareHolder.class);
        Mockito.when(schemasCompareHolder.compare(eq(schemasLeft), eq(schemasRight), any(), any())).thenReturn(schemasCompareResult);
        ResponsesCompareHolder responsesCompareHolder = Mockito.mock(ResponsesCompareHolder.class);
        Mockito.when(responsesCompareHolder.compare(eq(responsesLeft), eq(responsesRight), any(), any())).thenReturn(responsesCompareResult);
        ParametersCompareHolder parametersCompareHolder = Mockito.mock(ParametersCompareHolder.class);
        Mockito.when(parametersCompareHolder.compare(eq(parametersLeft), eq(parametersRight), any(), any())).thenReturn(parametersCompareResult);
        ExamplesCompareHolder examplesCompareHolder = Mockito.mock(ExamplesCompareHolder.class);
        Mockito.when(examplesCompareHolder.compare(eq(examplesLeft), eq(examplesRight), any(), any())).thenReturn(examplesCompareResult);
        RequestBodiesCompareHolder requestBodiesCompareHolder = Mockito.mock(RequestBodiesCompareHolder.class);
        Mockito.when(requestBodiesCompareHolder.compare(eq(requestBodiesLeft), eq(requestBodiesRight), any(), any())).thenReturn(requestBodiesCompareResult);
        HeadersCompareHolder headersCompareHolder = Mockito.mock(HeadersCompareHolder.class);
        Mockito.when(headersCompareHolder.compare(eq(headersLeft), eq(headersRight), any(), any())).thenReturn(headersCompareResult);
        SecuritySchemesCompareHolder securitySchemesCompareHolder = Mockito.mock(SecuritySchemesCompareHolder.class);
        Mockito.when(securitySchemesCompareHolder.compare(eq(securitySchemesLeft), eq(securitySchemesRight), any(), any())).thenReturn(securitySchemesCompareResult);
        LinksCompareHolder linksCompareHolder = Mockito.mock(LinksCompareHolder.class);
        Mockito.when(linksCompareHolder.compare(eq(linksLeft), eq(linksRight), any(), any())).thenReturn(linksCompareResult);
        CallbacksCompareHolder callbacksCompareHolder = Mockito.mock(CallbacksCompareHolder.class);
        Mockito.when(callbacksCompareHolder.compare(eq(callbacksLeft), eq(callbacksRight), any(), any())).thenReturn(callbacksCompareResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);
        expected.put("Schemas", schemasCompareResult);
        expected.put("Responses", responsesCompareResult);
        expected.put("Parameters", parametersCompareResult);
        expected.put("Examples", examplesCompareResult);
        expected.put("RequestBodies", requestBodiesCompareResult);
        expected.put("Headers", headersCompareResult);
        expected.put("SecuritySchemes", securitySchemesCompareResult);
        expected.put("Links", linksCompareResult);
        expected.put("Callbacks", callbacksCompareResult);

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getSchemasCompareHolder()).thenReturn(schemasCompareHolder);
        when(compareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        when(compareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        when(compareHolderFactory.getExamplesCompareHolder()).thenReturn(examplesCompareHolder);
        when(compareHolderFactory.getRequestBodiesCompareHolder()).thenReturn(requestBodiesCompareHolder);
        when(compareHolderFactory.getHeadersCompareHolder()).thenReturn(headersCompareHolder);
        when(compareHolderFactory.getSecuritySchemesCompareHolder()).thenReturn(securitySchemesCompareHolder);
        when(compareHolderFactory.getLinksCompareHolder()).thenReturn(linksCompareHolder);
        when(compareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);

        ComponentsCompareHolder componentsCompareHolder = new ComponentsCompareHolder(compareHolderFactory);

        ICompareResult actual = componentsCompareHolder.compare(componentsLeft, componentsRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);

    }

    @Test
    public void compareNoValuesSet1() {
        Map<String, Schema> schemasLeft = new HashMap<>();

        Map<String, ApiResponse> responsesLeft = new HashMap<>();

        Map<String, Parameter> parametersLeft = new HashMap<>();

        Map<String, Example> examplesLeft = new HashMap<>();

        Map<String, RequestBody> requestBodiesLeft = new HashMap<>();

        Map<String, Header> headersLeft = new HashMap<>();

        Map<String, SecurityScheme> securitySchemesLeft = new HashMap<>();

        Map<String, Link> linksLeft = new HashMap<>();

        Map<String, Callback> callbacksLeft = new HashMap<>();

        Components componentsLeft = new Components();
        componentsLeft.setSchemas(schemasLeft);
        componentsLeft.setResponses(responsesLeft);
        componentsLeft.setParameters(parametersLeft);
        componentsLeft.setExamples(examplesLeft);
        componentsLeft.setRequestBodies(requestBodiesLeft);
        componentsLeft.setHeaders(headersLeft);
        componentsLeft.setSecuritySchemes(securitySchemesLeft);
        componentsLeft.setLinks(linksLeft);
        componentsLeft.setCallbacks(callbacksLeft);

        Map<String, Schema> schemasRight = new HashMap<>();

        Map<String, ApiResponse> responsesRight = new HashMap<>();

        Map<String, Parameter> parametersRight = new HashMap<>();

        Map<String, Example> examplesRight = new HashMap<>();

        Map<String, RequestBody> requestBodiesRight = new HashMap<>();

        Map<String, Header> headersRight = new HashMap<>();

        Map<String, SecurityScheme> securitySchemesRight = new HashMap<>();

        Map<String, Link> linksRight = new HashMap<>();

        Map<String, Callback> callbacksRight = new HashMap<>();

        Components componentsRight = new Components();
        componentsRight.setSchemas(schemasRight);
        componentsRight.setResponses(responsesRight);
        componentsRight.setParameters(parametersRight);
        componentsRight.setExamples(examplesRight);
        componentsRight.setRequestBodies(requestBodiesRight);
        componentsRight.setHeaders(headersRight);
        componentsRight.setSecuritySchemes(securitySchemesRight);
        componentsRight.setLinks(linksRight);
        componentsRight.setCallbacks(callbacksRight);

        ICompareResult schemasCompareResult = new LeafCompareResult(schemasLeft, schemasRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult responsesCompareResult = new LeafCompareResult(responsesLeft, responsesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult parametersCompareResult = new LeafCompareResult(parametersLeft, parametersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult examplesCompareResult = new LeafCompareResult(examplesLeft, examplesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult requestBodiesCompareResult = new LeafCompareResult(requestBodiesLeft, requestBodiesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult headersCompareResult = new LeafCompareResult(headersLeft, headersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult securitySchemesCompareResult = new LeafCompareResult(securitySchemesLeft, securitySchemesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult linksCompareResult = new LeafCompareResult(linksLeft, linksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult callbacksCompareResult = new LeafCompareResult(callbacksLeft, callbacksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);


        SchemasCompareHolder schemasCompareHolder = Mockito.mock(SchemasCompareHolder.class);
        Mockito.when(schemasCompareHolder.compare(eq(schemasLeft), eq(schemasRight), any(), any())).thenReturn(schemasCompareResult);
        ResponsesCompareHolder responsesCompareHolder = Mockito.mock(ResponsesCompareHolder.class);
        Mockito.when(responsesCompareHolder.compare(eq(responsesLeft), eq(responsesRight), any(), any())).thenReturn(responsesCompareResult);
        ParametersCompareHolder parametersCompareHolder = Mockito.mock(ParametersCompareHolder.class);
        Mockito.when(parametersCompareHolder.compare(eq(parametersLeft), eq(parametersRight), any(), any())).thenReturn(parametersCompareResult);
        ExamplesCompareHolder examplesCompareHolder = Mockito.mock(ExamplesCompareHolder.class);
        Mockito.when(examplesCompareHolder.compare(eq(examplesLeft), eq(examplesRight), any(), any())).thenReturn(examplesCompareResult);
        RequestBodiesCompareHolder requestBodiesCompareHolder = Mockito.mock(RequestBodiesCompareHolder.class);
        Mockito.when(requestBodiesCompareHolder.compare(eq(requestBodiesLeft), eq(requestBodiesRight), any(), any())).thenReturn(requestBodiesCompareResult);
        HeadersCompareHolder headersCompareHolder = Mockito.mock(HeadersCompareHolder.class);
        Mockito.when(headersCompareHolder.compare(eq(headersLeft), eq(headersRight), any(), any())).thenReturn(headersCompareResult);
        SecuritySchemesCompareHolder securitySchemesCompareHolder = Mockito.mock(SecuritySchemesCompareHolder.class);
        Mockito.when(securitySchemesCompareHolder.compare(eq(securitySchemesLeft), eq(securitySchemesRight), any(), any())).thenReturn(securitySchemesCompareResult);
        LinksCompareHolder linksCompareHolder = Mockito.mock(LinksCompareHolder.class);
        Mockito.when(linksCompareHolder.compare(eq(linksLeft), eq(linksRight), any(), any())).thenReturn(linksCompareResult);
        CallbacksCompareHolder callbacksCompareHolder = Mockito.mock(CallbacksCompareHolder.class);
        Mockito.when(callbacksCompareHolder.compare(eq(callbacksLeft), eq(callbacksRight), any(), any())).thenReturn(callbacksCompareResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getSchemasCompareHolder()).thenReturn(schemasCompareHolder);
        when(compareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        when(compareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        when(compareHolderFactory.getExamplesCompareHolder()).thenReturn(examplesCompareHolder);
        when(compareHolderFactory.getRequestBodiesCompareHolder()).thenReturn(requestBodiesCompareHolder);
        when(compareHolderFactory.getHeadersCompareHolder()).thenReturn(headersCompareHolder);
        when(compareHolderFactory.getSecuritySchemesCompareHolder()).thenReturn(securitySchemesCompareHolder);
        when(compareHolderFactory.getLinksCompareHolder()).thenReturn(linksCompareHolder);
        when(compareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);

        ComponentsCompareHolder componentsCompareHolder = new ComponentsCompareHolder(compareHolderFactory);

        ICompareResult actual = componentsCompareHolder.compare(componentsLeft, componentsRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);

    }

    @Test
    public void compareNoValuesSet2() {
        Map<String, Schema> schemasLeft = null;

        Map<String, ApiResponse> responsesLeft = null;

        Map<String, Parameter> parametersLeft = null;

        Map<String, Example> examplesLeft = null;

        Map<String, RequestBody> requestBodiesLeft = null;

        Map<String, Header> headersLeft = null;

        Map<String, SecurityScheme> securitySchemesLeft = null;

        Map<String, Link> linksLeft = null;

        Map<String, Callback> callbacksLeft = null;

        Components componentsLeft = new Components();
        componentsLeft.setSchemas(schemasLeft);
        componentsLeft.setResponses(responsesLeft);
        componentsLeft.setParameters(parametersLeft);
        componentsLeft.setExamples(examplesLeft);
        componentsLeft.setRequestBodies(requestBodiesLeft);
        componentsLeft.setHeaders(headersLeft);
        componentsLeft.setSecuritySchemes(securitySchemesLeft);
        componentsLeft.setLinks(linksLeft);
        componentsLeft.setCallbacks(callbacksLeft);

        Map<String, Schema> schemasRight = null;

        Map<String, ApiResponse> responsesRight = null;

        Map<String, Parameter> parametersRight = null;

        Map<String, Example> examplesRight = null;

        Map<String, RequestBody> requestBodiesRight = null;

        Map<String, Header> headersRight = null;

        Map<String, SecurityScheme> securitySchemesRight = null;

        Map<String, Link> linksRight = null;

        Map<String, Callback> callbacksRight = null;

        Components componentsRight = new Components();
        componentsRight.setSchemas(schemasRight);
        componentsRight.setResponses(responsesRight);
        componentsRight.setParameters(parametersRight);
        componentsRight.setExamples(examplesRight);
        componentsRight.setRequestBodies(requestBodiesRight);
        componentsRight.setHeaders(headersRight);
        componentsRight.setSecuritySchemes(securitySchemesRight);
        componentsRight.setLinks(linksRight);
        componentsRight.setCallbacks(callbacksRight);

        ICompareResult schemasCompareResult = new LeafCompareResult(schemasLeft, schemasRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult responsesCompareResult = new LeafCompareResult(responsesLeft, responsesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult parametersCompareResult = new LeafCompareResult(parametersLeft, parametersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult examplesCompareResult = new LeafCompareResult(examplesLeft, examplesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult requestBodiesCompareResult = new LeafCompareResult(requestBodiesLeft, requestBodiesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult headersCompareResult = new LeafCompareResult(headersLeft, headersRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult securitySchemesCompareResult = new LeafCompareResult(securitySchemesLeft, securitySchemesRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult linksCompareResult = new LeafCompareResult(linksLeft, linksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult callbacksCompareResult = new LeafCompareResult(callbacksLeft, callbacksRight, CompareResultType.UNCHANGED, CompareCriticalType.NONE);


        SchemasCompareHolder schemasCompareHolder = Mockito.mock(SchemasCompareHolder.class);
        Mockito.when(schemasCompareHolder.compare(eq(schemasLeft), eq(schemasRight), any(), any())).thenReturn(schemasCompareResult);
        ResponsesCompareHolder responsesCompareHolder = Mockito.mock(ResponsesCompareHolder.class);
        Mockito.when(responsesCompareHolder.compare(eq(responsesLeft), eq(responsesRight), any(), any())).thenReturn(responsesCompareResult);
        ParametersCompareHolder parametersCompareHolder = Mockito.mock(ParametersCompareHolder.class);
        Mockito.when(parametersCompareHolder.compare(eq(parametersLeft), eq(parametersRight), any(), any())).thenReturn(parametersCompareResult);
        ExamplesCompareHolder examplesCompareHolder = Mockito.mock(ExamplesCompareHolder.class);
        Mockito.when(examplesCompareHolder.compare(eq(examplesLeft), eq(examplesRight), any(), any())).thenReturn(examplesCompareResult);
        RequestBodiesCompareHolder requestBodiesCompareHolder = Mockito.mock(RequestBodiesCompareHolder.class);
        Mockito.when(requestBodiesCompareHolder.compare(eq(requestBodiesLeft), eq(requestBodiesRight), any(), any())).thenReturn(requestBodiesCompareResult);
        HeadersCompareHolder headersCompareHolder = Mockito.mock(HeadersCompareHolder.class);
        Mockito.when(headersCompareHolder.compare(eq(headersLeft), eq(headersRight), any(), any())).thenReturn(headersCompareResult);
        SecuritySchemesCompareHolder securitySchemesCompareHolder = Mockito.mock(SecuritySchemesCompareHolder.class);
        Mockito.when(securitySchemesCompareHolder.compare(eq(securitySchemesLeft), eq(securitySchemesRight), any(), any())).thenReturn(securitySchemesCompareResult);
        LinksCompareHolder linksCompareHolder = Mockito.mock(LinksCompareHolder.class);
        Mockito.when(linksCompareHolder.compare(eq(linksLeft), eq(linksRight), any(), any())).thenReturn(linksCompareResult);
        CallbacksCompareHolder callbacksCompareHolder = Mockito.mock(CallbacksCompareHolder.class);
        Mockito.when(callbacksCompareHolder.compare(eq(callbacksLeft), eq(callbacksRight), any(), any())).thenReturn(callbacksCompareResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        CompareHolderFactory compareHolderFactory = mock(CompareHolderFactory.class);
        when(compareHolderFactory.getSchemasCompareHolder()).thenReturn(schemasCompareHolder);
        when(compareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        when(compareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        when(compareHolderFactory.getExamplesCompareHolder()).thenReturn(examplesCompareHolder);
        when(compareHolderFactory.getRequestBodiesCompareHolder()).thenReturn(requestBodiesCompareHolder);
        when(compareHolderFactory.getHeadersCompareHolder()).thenReturn(headersCompareHolder);
        when(compareHolderFactory.getSecuritySchemesCompareHolder()).thenReturn(securitySchemesCompareHolder);
        when(compareHolderFactory.getLinksCompareHolder()).thenReturn(linksCompareHolder);
        when(compareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);

        ComponentsCompareHolder componentsCompareHolder = new ComponentsCompareHolder(compareHolderFactory);

        ICompareResult actual = componentsCompareHolder.compare(componentsLeft, componentsRight, CompareCriticalType.INFO, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);

    }


}