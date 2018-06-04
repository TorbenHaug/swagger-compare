package de.haug_dev.swagger_compare.swagger_compare_core.paths;

import de.haug_dev.swagger_compare.swagger_compare_core.CompareHolderFactory;
import de.haug_dev.swagger_compare.swagger_compare_core.callbacks.CallbacksCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.misc.ExternalDocumentationObjectCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.misc.TagsCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.parameters.ParametersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.request_bodies.RequestBodyCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.responses.ResponsesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.security_schemes.SecuritiesRequirementObjectCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.servers.ServersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.*;
import io.swagger.v3.oas.models.callbacks.Callback;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class OperationCompareHolderTest {

    @Test
    public void compareNullNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        TagsCompareHolder tagsCompareHolder = mock(TagsCompareHolder.class);
        when(spiedCompareHolderFactory.getTagsCompareHolder()).thenReturn(tagsCompareHolder);
        ExternalDocumentationObjectCompareHolder externalDocumentationObjectCompareHolder = mock(ExternalDocumentationObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getExternalDocumentationObjectCompareHolder()).thenReturn(externalDocumentationObjectCompareHolder);
        ParametersCompareHolder parametersCompareHolder = mock(ParametersCompareHolder.class);
        when(spiedCompareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        RequestBodyCompareHolder requestBodyCompareHolder = mock(RequestBodyCompareHolder.class);
        when(spiedCompareHolderFactory.getRequestBodyCompareHolder()).thenReturn(requestBodyCompareHolder);
        ResponsesCompareHolder responsesCompareHolder = mock(ResponsesCompareHolder.class);
        when(spiedCompareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        CallbacksCompareHolder callbacksCompareHolder = mock(CallbacksCompareHolder.class);
        when(spiedCompareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);
        ServersCompareHolder serversCompareHolder = mock(ServersCompareHolder.class);
        when(spiedCompareHolderFactory.getServersCompareHolder()).thenReturn(serversCompareHolder);
        SecuritiesRequirementObjectCompareHolder securitiesRequirementObjectCompareHolder = mock(SecuritiesRequirementObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getSecuritiesRequirementObjectCompareHolder()).thenReturn(securitiesRequirementObjectCompareHolder);

        Operation leftValue = null;
        Operation rightValue= null;

        ICompareResult tagsResult = new LeafCompareResult("tags", "tags", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult externalDocumentationObjectResult = new LeafCompareResult("externalDocumentationObject", "externalDocumentationObject", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult parametersResult = new LeafCompareResult("parameters", "parameters", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult requestBodyResult = new LeafCompareResult("requestBody", "requestBody", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult responsesResult = new LeafCompareResult("responses", "responses", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult callbacksResult = new LeafCompareResult("callbacks", "callbacks", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult serversResult = new LeafCompareResult("servers", "servers", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult securitiesRequirementObjectResult = new LeafCompareResult("securitiesRequirementObject", "securitiesRequirementObject", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        when(tagsCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(tagsResult);
        when(externalDocumentationObjectCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(externalDocumentationObjectResult);
        when(parametersCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(parametersResult);
        when(requestBodyCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(requestBodyResult);
        when(responsesCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(responsesResult);
        when(callbacksCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(callbacksResult);
        when(serversCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(serversResult);
        when(securitiesRequirementObjectCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(securitiesRequirementObjectResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getOperationCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareNullEmptyValue() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        TagsCompareHolder tagsCompareHolder = mock(TagsCompareHolder.class);
        when(spiedCompareHolderFactory.getTagsCompareHolder()).thenReturn(tagsCompareHolder);
        ExternalDocumentationObjectCompareHolder externalDocumentationObjectCompareHolder = mock(ExternalDocumentationObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getExternalDocumentationObjectCompareHolder()).thenReturn(externalDocumentationObjectCompareHolder);
        ParametersCompareHolder parametersCompareHolder = mock(ParametersCompareHolder.class);
        when(spiedCompareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        RequestBodyCompareHolder requestBodyCompareHolder = mock(RequestBodyCompareHolder.class);
        when(spiedCompareHolderFactory.getRequestBodyCompareHolder()).thenReturn(requestBodyCompareHolder);
        ResponsesCompareHolder responsesCompareHolder = mock(ResponsesCompareHolder.class);
        when(spiedCompareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        CallbacksCompareHolder callbacksCompareHolder = mock(CallbacksCompareHolder.class);
        when(spiedCompareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);
        ServersCompareHolder serversCompareHolder = mock(ServersCompareHolder.class);
        when(spiedCompareHolderFactory.getServersCompareHolder()).thenReturn(serversCompareHolder);
        SecuritiesRequirementObjectCompareHolder securitiesRequirementObjectCompareHolder = mock(SecuritiesRequirementObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getSecuritiesRequirementObjectCompareHolder()).thenReturn(securitiesRequirementObjectCompareHolder);

        Operation leftValue= null;
        Operation rightValue= new Operation();
        
        ICompareResult tagsResult = new LeafCompareResult("tags", "tags", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult externalDocumentationObjectResult = new LeafCompareResult("externalDocumentationObject", "externalDocumentationObject", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult parametersResult = new LeafCompareResult("parameters", "parameters", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult requestBodyResult = new LeafCompareResult("requestBody", "requestBody", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult responsesResult = new LeafCompareResult("responses", "responses", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult callbacksResult = new LeafCompareResult("callbacks", "callbacks", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult serversResult = new LeafCompareResult("servers", "servers", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult securitiesRequirementObjectResult = new LeafCompareResult("securitiesRequirementObject", "securitiesRequirementObject", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        when(tagsCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(tagsResult);
        when(externalDocumentationObjectCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(externalDocumentationObjectResult);
        when(parametersCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(parametersResult);
        when(requestBodyCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(requestBodyResult);
        when(responsesCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(responsesResult);
        when(callbacksCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(callbacksResult);
        when(serversCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(serversResult);
        when(securitiesRequirementObjectCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(securitiesRequirementObjectResult);

        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getOperationCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareEmptyValueNull() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        TagsCompareHolder tagsCompareHolder = mock(TagsCompareHolder.class);
        when(spiedCompareHolderFactory.getTagsCompareHolder()).thenReturn(tagsCompareHolder);
        ExternalDocumentationObjectCompareHolder externalDocumentationObjectCompareHolder = mock(ExternalDocumentationObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getExternalDocumentationObjectCompareHolder()).thenReturn(externalDocumentationObjectCompareHolder);
        ParametersCompareHolder parametersCompareHolder = mock(ParametersCompareHolder.class);
        when(spiedCompareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        RequestBodyCompareHolder requestBodyCompareHolder = mock(RequestBodyCompareHolder.class);
        when(spiedCompareHolderFactory.getRequestBodyCompareHolder()).thenReturn(requestBodyCompareHolder);
        ResponsesCompareHolder responsesCompareHolder = mock(ResponsesCompareHolder.class);
        when(spiedCompareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        CallbacksCompareHolder callbacksCompareHolder = mock(CallbacksCompareHolder.class);
        when(spiedCompareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);
        ServersCompareHolder serversCompareHolder = mock(ServersCompareHolder.class);
        when(spiedCompareHolderFactory.getServersCompareHolder()).thenReturn(serversCompareHolder);
        SecuritiesRequirementObjectCompareHolder securitiesRequirementObjectCompareHolder = mock(SecuritiesRequirementObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getSecuritiesRequirementObjectCompareHolder()).thenReturn(securitiesRequirementObjectCompareHolder);

        Operation leftValue= new Operation();
        Operation rightValue= null;

        ICompareResult tagsResult = new LeafCompareResult("tags", "tags", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult externalDocumentationObjectResult = new LeafCompareResult("externalDocumentationObject", "externalDocumentationObject", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult parametersResult = new LeafCompareResult("parameters", "parameters", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult requestBodyResult = new LeafCompareResult("requestBody", "requestBody", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult responsesResult = new LeafCompareResult("responses", "responses", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult callbacksResult = new LeafCompareResult("callbacks", "callbacks", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult serversResult = new LeafCompareResult("servers", "servers", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult securitiesRequirementObjectResult = new LeafCompareResult("securitiesRequirementObject", "securitiesRequirementObject", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        when(tagsCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(tagsResult);
        when(externalDocumentationObjectCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(externalDocumentationObjectResult);
        when(parametersCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(parametersResult);
        when(requestBodyCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(requestBodyResult);
        when(responsesCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(responsesResult);
        when(callbacksCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(callbacksResult);
        when(serversCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(serversResult);
        when(securitiesRequirementObjectCompareHolder.compare(eq(null), eq(null), any(), any())).thenReturn(securitiesRequirementObjectResult);


        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        ICompareResult actual = spiedCompareHolderFactory.getOperationCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareDeleted() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        TagsCompareHolder tagsCompareHolder = mock(TagsCompareHolder.class);
        when(spiedCompareHolderFactory.getTagsCompareHolder()).thenReturn(tagsCompareHolder);
        ExternalDocumentationObjectCompareHolder externalDocumentationObjectCompareHolder = mock(ExternalDocumentationObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getExternalDocumentationObjectCompareHolder()).thenReturn(externalDocumentationObjectCompareHolder);
        ParametersCompareHolder parametersCompareHolder = mock(ParametersCompareHolder.class);
        when(spiedCompareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        RequestBodyCompareHolder requestBodyCompareHolder = mock(RequestBodyCompareHolder.class);
        when(spiedCompareHolderFactory.getRequestBodyCompareHolder()).thenReturn(requestBodyCompareHolder);
        ResponsesCompareHolder responsesCompareHolder = mock(ResponsesCompareHolder.class);
        when(spiedCompareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        CallbacksCompareHolder callbacksCompareHolder = mock(CallbacksCompareHolder.class);
        when(spiedCompareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);
        ServersCompareHolder serversCompareHolder = mock(ServersCompareHolder.class);
        when(spiedCompareHolderFactory.getServersCompareHolder()).thenReturn(serversCompareHolder);
        SecuritiesRequirementObjectCompareHolder securitiesRequirementObjectCompareHolder = mock(SecuritiesRequirementObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getSecuritiesRequirementObjectCompareHolder()).thenReturn(securitiesRequirementObjectCompareHolder);

        Operation leftValue = new Operation();
        List<String> leftTags = mock(List.class);
        leftValue.setTags(leftTags);
        String leftSummary = "test";
        leftValue.setSummary(leftSummary);
        String leftDescription = "test";
        leftValue.setDescription(leftDescription);
        ExternalDocumentation leftExternalDocs = mock(ExternalDocumentation.class);
        leftValue.setExternalDocs(leftExternalDocs);
        String leftOperationId = "test";
        leftValue.setOperationId(leftOperationId);
        Map<String, Parameter> leftParameterMap = mock(Map.class);
        List<Parameter> leftParameters = mock(List.class);
        leftValue.setParameters(leftParameters);
        RequestBody leftRequestBody = mock(RequestBody.class);
        leftValue.setRequestBody(leftRequestBody);
        ApiResponses leftResponses = mock(ApiResponses.class);
        leftValue.setResponses(leftResponses);
        Map<String, Callback> leftCallbacks = mock(Map.class);
        leftValue.setCallbacks(leftCallbacks);
        Boolean leftDeprecated = false;
        leftValue.setDeprecated(leftDeprecated);
        List<SecurityRequirement> leftSecurity = mock(List.class);
        leftValue.setSecurity(leftSecurity);
        List<Server> leftServers = mock(List.class);
        leftValue.setServers(leftServers);

        Operation rightValue= null;
        Map<String, Parameter> rightParameterMap = mock(Map.class);

        ICompareResult tagsResult = new LeafCompareResult("tags", "tags", CompareResultType.DELETED, CompareCriticalType.CRITICAL);
        ICompareResult externalDocumentationObjectResult = new LeafCompareResult("externalDocumentationObject", "externalDocumentationObject", CompareResultType.DELETED, CompareCriticalType.CRITICAL);
        ICompareResult parametersResult = new LeafCompareResult("parameters", "parameters", CompareResultType.DELETED, CompareCriticalType.CRITICAL);
        ICompareResult requestBodyResult = new LeafCompareResult("requestBody", "requestBody", CompareResultType.DELETED, CompareCriticalType.CRITICAL);
        ICompareResult responsesResult = new LeafCompareResult("responses", "responses", CompareResultType.DELETED, CompareCriticalType.CRITICAL);
        ICompareResult callbacksResult = new LeafCompareResult("callbacks", "callbacks", CompareResultType.DELETED, CompareCriticalType.CRITICAL);
        ICompareResult serversResult = new LeafCompareResult("servers", "servers", CompareResultType.DELETED, CompareCriticalType.CRITICAL);
        ICompareResult securitiesRequirementObjectResult = new LeafCompareResult("securitiesRequirementObject", "securitiesRequirementObject", CompareResultType.DELETED, CompareCriticalType.CRITICAL);
        when(tagsCompareHolder.compare(eq(leftTags), eq(null), any(), any())).thenReturn(tagsResult);
        when(externalDocumentationObjectCompareHolder.compare(eq(leftExternalDocs), eq(null), any(), any())).thenReturn(externalDocumentationObjectResult);
        when(parametersCompareHolder.listToMapLeft(any())).thenReturn(leftParameterMap);
        when(parametersCompareHolder.listToMapRight(any())).thenReturn(rightParameterMap);
        when(parametersCompareHolder.compare(eq(leftParameterMap), eq(rightParameterMap), any(), any())).thenReturn(parametersResult);
        when(requestBodyCompareHolder.compare(eq(leftRequestBody), eq(null), any(), any())).thenReturn(requestBodyResult);
        when(responsesCompareHolder.compare(eq(leftResponses), eq(null), any(), any())).thenReturn(responsesResult);
        when(callbacksCompareHolder.compare(eq(leftCallbacks), eq(null), any(), any())).thenReturn(callbacksResult);
        when(serversCompareHolder.compare(eq(leftServers), eq(null), any(), any())).thenReturn(serversResult);
        when(securitiesRequirementObjectCompareHolder.compare(eq(leftSecurity), eq(null), any(), any())).thenReturn(securitiesRequirementObjectResult);

        ICompareResult summaryResult = new LeafCompareResult(leftSummary, null, CompareResultType.DELETED, CompareCriticalType.INFO);
        ICompareResult descriptionResult = new LeafCompareResult(leftDescription, null, CompareResultType.DELETED, CompareCriticalType.INFO);
        ICompareResult operationIdResult = new LeafCompareResult(leftOperationId, null, CompareResultType.DELETED, CompareCriticalType.CRITICAL);
        ICompareResult deprecatedResult = new LeafCompareResult(leftDeprecated, null, CompareResultType.DELETED, CompareCriticalType.NONE);
        


        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("Tags", tagsResult);
        expected.put("Summary", summaryResult);
        expected.put("Description", descriptionResult);
        expected.put("ExternalDocs", externalDocumentationObjectResult);
        expected.put("OperationId", operationIdResult);
        expected.put("Parameters", parametersResult);
        expected.put("RequestBody", requestBodyResult);
        expected.put("Responses", responsesResult);
        expected.put("Callbacks", callbacksResult);
        expected.put("Deprecated", deprecatedResult);
        expected.put("Security", securitiesRequirementObjectResult);
        expected.put("Servers", serversResult);


        ICompareResult actual = spiedCompareHolderFactory.getOperationCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareCreated() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        TagsCompareHolder tagsCompareHolder = mock(TagsCompareHolder.class);
        when(spiedCompareHolderFactory.getTagsCompareHolder()).thenReturn(tagsCompareHolder);
        ExternalDocumentationObjectCompareHolder externalDocumentationObjectCompareHolder = mock(ExternalDocumentationObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getExternalDocumentationObjectCompareHolder()).thenReturn(externalDocumentationObjectCompareHolder);
        ParametersCompareHolder parametersCompareHolder = mock(ParametersCompareHolder.class);
        when(spiedCompareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        RequestBodyCompareHolder requestBodyCompareHolder = mock(RequestBodyCompareHolder.class);
        when(spiedCompareHolderFactory.getRequestBodyCompareHolder()).thenReturn(requestBodyCompareHolder);
        ResponsesCompareHolder responsesCompareHolder = mock(ResponsesCompareHolder.class);
        when(spiedCompareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        CallbacksCompareHolder callbacksCompareHolder = mock(CallbacksCompareHolder.class);
        when(spiedCompareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);
        ServersCompareHolder serversCompareHolder = mock(ServersCompareHolder.class);
        when(spiedCompareHolderFactory.getServersCompareHolder()).thenReturn(serversCompareHolder);
        SecuritiesRequirementObjectCompareHolder securitiesRequirementObjectCompareHolder = mock(SecuritiesRequirementObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getSecuritiesRequirementObjectCompareHolder()).thenReturn(securitiesRequirementObjectCompareHolder);

        Operation leftValue = new Operation();
        Map<String, Parameter> leftParameterMap = mock(Map.class);
        
        Operation rightValue = new Operation();
        List<String> rightTags = mock(List.class);
        rightValue.setTags(rightTags);
        String rightSummary = "test";
        rightValue.setSummary(rightSummary);
        String rightDescription = "test";
        rightValue.setDescription(rightDescription);
        ExternalDocumentation rightExternalDocs = mock(ExternalDocumentation.class);
        rightValue.setExternalDocs(rightExternalDocs);
        String rightOperationId = "test";
        rightValue.setOperationId(rightOperationId);
        Map<String, Parameter> rightParameterMap = mock(Map.class);
        List<Parameter> rightParameters = mock(List.class);
        rightValue.setParameters(rightParameters);
        RequestBody rightRequestBody = mock(RequestBody.class);
        rightValue.setRequestBody(rightRequestBody);
        ApiResponses rightResponses = mock(ApiResponses.class);
        rightValue.setResponses(rightResponses);
        Map<String, Callback> rightCallbacks = mock(Map.class);
        rightValue.setCallbacks(rightCallbacks);
        Boolean rightDeprecated = false;
        rightValue.setDeprecated(rightDeprecated);
        List<SecurityRequirement> rightSecurity = mock(List.class);
        rightValue.setSecurity(rightSecurity);
        List<Server> rightServers = mock(List.class);
        rightValue.setServers(rightServers);

        ICompareResult tagsResult = new LeafCompareResult("tags", "tags", CompareResultType.CREATED, CompareCriticalType.CRITICAL);
        ICompareResult externalDocumentationObjectResult = new LeafCompareResult("externalDocumentationObject", "externalDocumentationObject", CompareResultType.CREATED, CompareCriticalType.CRITICAL);
        ICompareResult parametersResult = new LeafCompareResult("parameters", "parameters", CompareResultType.CREATED, CompareCriticalType.CRITICAL);
        ICompareResult requestBodyResult = new LeafCompareResult("requestBody", "requestBody", CompareResultType.CREATED, CompareCriticalType.CRITICAL);
        ICompareResult responsesResult = new LeafCompareResult("responses", "responses", CompareResultType.CREATED, CompareCriticalType.CRITICAL);
        ICompareResult callbacksResult = new LeafCompareResult("callbacks", "callbacks", CompareResultType.CREATED, CompareCriticalType.CRITICAL);
        ICompareResult serversResult = new LeafCompareResult("servers", "servers", CompareResultType.CREATED, CompareCriticalType.CRITICAL);
        ICompareResult securitiesRequirementObjectResult = new LeafCompareResult("securitiesRequirementObject", "securitiesRequirementObject", CompareResultType.CREATED, CompareCriticalType.CRITICAL);
        when(tagsCompareHolder.compare(eq(null), eq(rightTags), any(), any())).thenReturn(tagsResult);
        when(externalDocumentationObjectCompareHolder.compare(eq(null), eq(rightExternalDocs), any(), any())).thenReturn(externalDocumentationObjectResult);
        when(parametersCompareHolder.listToMapLeft(any())).thenReturn(leftParameterMap);
        when(parametersCompareHolder.listToMapRight(any())).thenReturn(rightParameterMap);
        when(parametersCompareHolder.compare(eq(leftParameterMap), eq(rightParameterMap), any(), any())).thenReturn(parametersResult);
        when(requestBodyCompareHolder.compare( eq(null), eq(rightRequestBody), any(), any())).thenReturn(requestBodyResult);
        when(responsesCompareHolder.compare(eq(null), eq(rightResponses), any(), any())).thenReturn(responsesResult);
        when(callbacksCompareHolder.compare( eq(null), eq(rightCallbacks),any(), any())).thenReturn(callbacksResult);
        when(serversCompareHolder.compare(eq(null), eq(rightServers), any(), any())).thenReturn(serversResult);
        when(securitiesRequirementObjectCompareHolder.compare(eq(null), eq(rightSecurity), any(), any())).thenReturn(securitiesRequirementObjectResult);

        ICompareResult summaryResult = new LeafCompareResult(null, rightSummary, CompareResultType.CREATED, CompareCriticalType.INFO);
        ICompareResult descriptionResult = new LeafCompareResult(null, rightDescription, CompareResultType.CREATED, CompareCriticalType.INFO);
        ICompareResult operationIdResult = new LeafCompareResult(null, rightOperationId, CompareResultType.CREATED, CompareCriticalType.CRITICAL);
        ICompareResult deprecatedResult = new LeafCompareResult( null, rightDeprecated,CompareResultType.CREATED, CompareCriticalType.NONE);



        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("Tags", tagsResult);
        expected.put("Summary", summaryResult);
        expected.put("Description", descriptionResult);
        expected.put("ExternalDocs", externalDocumentationObjectResult);
        expected.put("OperationId", operationIdResult);
        expected.put("Parameters", parametersResult);
        expected.put("RequestBody", requestBodyResult);
        expected.put("Responses", responsesResult);
        expected.put("Callbacks", callbacksResult);
        expected.put("Deprecated", deprecatedResult);
        expected.put("Security", securitiesRequirementObjectResult);
        expected.put("Servers", serversResult);


        ICompareResult actual = spiedCompareHolderFactory.getOperationCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareUnchanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        TagsCompareHolder tagsCompareHolder = mock(TagsCompareHolder.class);
        when(spiedCompareHolderFactory.getTagsCompareHolder()).thenReturn(tagsCompareHolder);
        ExternalDocumentationObjectCompareHolder externalDocumentationObjectCompareHolder = mock(ExternalDocumentationObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getExternalDocumentationObjectCompareHolder()).thenReturn(externalDocumentationObjectCompareHolder);
        ParametersCompareHolder parametersCompareHolder = mock(ParametersCompareHolder.class);
        when(spiedCompareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        RequestBodyCompareHolder requestBodyCompareHolder = mock(RequestBodyCompareHolder.class);
        when(spiedCompareHolderFactory.getRequestBodyCompareHolder()).thenReturn(requestBodyCompareHolder);
        ResponsesCompareHolder responsesCompareHolder = mock(ResponsesCompareHolder.class);
        when(spiedCompareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        CallbacksCompareHolder callbacksCompareHolder = mock(CallbacksCompareHolder.class);
        when(spiedCompareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);
        ServersCompareHolder serversCompareHolder = mock(ServersCompareHolder.class);
        when(spiedCompareHolderFactory.getServersCompareHolder()).thenReturn(serversCompareHolder);
        SecuritiesRequirementObjectCompareHolder securitiesRequirementObjectCompareHolder = mock(SecuritiesRequirementObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getSecuritiesRequirementObjectCompareHolder()).thenReturn(securitiesRequirementObjectCompareHolder);

        Operation leftValue = new Operation();
        List<String> leftTags = mock(List.class);
        leftValue.setTags(leftTags);
        String leftSummary = "test";
        leftValue.setSummary(leftSummary);
        String leftDescription = "test";
        leftValue.setDescription(leftDescription);
        ExternalDocumentation leftExternalDocs = mock(ExternalDocumentation.class);
        leftValue.setExternalDocs(leftExternalDocs);
        String leftOperationId = "test";
        leftValue.setOperationId(leftOperationId);
        Map<String, Parameter> leftParameterMap = mock(Map.class);
        List<Parameter> leftParameters = mock(List.class);
        leftValue.setParameters(leftParameters);
        RequestBody leftRequestBody = mock(RequestBody.class);
        leftValue.setRequestBody(leftRequestBody);
        ApiResponses leftResponses = mock(ApiResponses.class);
        leftValue.setResponses(leftResponses);
        Map<String, Callback> leftCallbacks = mock(Map.class);
        leftValue.setCallbacks(leftCallbacks);
        Boolean leftDeprecated = false;
        leftValue.setDeprecated(leftDeprecated);
        List<SecurityRequirement> leftSecurity = mock(List.class);
        leftValue.setSecurity(leftSecurity);
        List<Server> leftServers = mock(List.class);
        leftValue.setServers(leftServers);

        Operation rightValue = new Operation();
        List<String> rightTags = mock(List.class);
        rightValue.setTags(rightTags);
        String rightSummary = "test";
        rightValue.setSummary(rightSummary);
        String rightDescription = "test";
        rightValue.setDescription(rightDescription);
        ExternalDocumentation rightExternalDocs = mock(ExternalDocumentation.class);
        rightValue.setExternalDocs(rightExternalDocs);
        String rightOperationId = "test";
        rightValue.setOperationId(rightOperationId);
        Map<String, Parameter> rightParameterMap = mock(Map.class);
        List<Parameter> rightParameters = mock(List.class);
        rightValue.setParameters(rightParameters);
        RequestBody rightRequestBody = mock(RequestBody.class);
        rightValue.setRequestBody(rightRequestBody);
        ApiResponses rightResponses = mock(ApiResponses.class);
        rightValue.setResponses(rightResponses);
        Map<String, Callback> rightCallbacks = mock(Map.class);
        rightValue.setCallbacks(rightCallbacks);
        Boolean rightDeprecated = false;
        rightValue.setDeprecated(rightDeprecated);
        List<SecurityRequirement> rightSecurity = mock(List.class);
        rightValue.setSecurity(rightSecurity);
        List<Server> rightServers = mock(List.class);
        rightValue.setServers(rightServers);

        ICompareResult tagsResult = new LeafCompareResult("tags", "tags", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult externalDocumentationObjectResult = new LeafCompareResult("externalDocumentationObject", "externalDocumentationObject", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult parametersResult = new LeafCompareResult("parameters", "parameters", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult requestBodyResult = new LeafCompareResult("requestBody", "requestBody", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult responsesResult = new LeafCompareResult("responses", "responses", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult callbacksResult = new LeafCompareResult("callbacks", "callbacks", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult serversResult = new LeafCompareResult("servers", "servers", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult securitiesRequirementObjectResult = new LeafCompareResult("securitiesRequirementObject", "securitiesRequirementObject", CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        when(tagsCompareHolder.compare(eq(leftTags), eq(rightTags), any(), any())).thenReturn(tagsResult);
        when(externalDocumentationObjectCompareHolder.compare(eq(leftExternalDocs), eq(rightExternalDocs), any(), any())).thenReturn(externalDocumentationObjectResult);
        when(parametersCompareHolder.listToMapLeft(any())).thenReturn(leftParameterMap);
        when(parametersCompareHolder.listToMapRight(any())).thenReturn(rightParameterMap);
        when(parametersCompareHolder.compare(eq(leftParameterMap), eq(rightParameterMap), any(), any())).thenReturn(parametersResult);
        when(requestBodyCompareHolder.compare( eq(leftRequestBody), eq(rightRequestBody), any(), any())).thenReturn(requestBodyResult);
        when(responsesCompareHolder.compare(eq(leftResponses), eq(rightResponses), any(), any())).thenReturn(responsesResult);
        when(callbacksCompareHolder.compare( eq(leftCallbacks), eq(rightCallbacks),any(), any())).thenReturn(callbacksResult);
        when(serversCompareHolder.compare(eq(leftServers), eq(rightServers), any(), any())).thenReturn(serversResult);
        when(securitiesRequirementObjectCompareHolder.compare(eq(leftSecurity), eq(rightSecurity), any(), any())).thenReturn(securitiesRequirementObjectResult);

        ICompareResult summaryResult = new LeafCompareResult(leftSummary, rightSummary, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult descriptionResult = new LeafCompareResult(leftDescription, rightDescription, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult operationIdResult = new LeafCompareResult(leftOperationId, rightOperationId, CompareResultType.UNCHANGED, CompareCriticalType.NONE);
        ICompareResult deprecatedResult = new LeafCompareResult( leftDeprecated, rightDeprecated, CompareResultType.UNCHANGED, CompareCriticalType.NONE);



        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("Tags", tagsResult);
        expected.put("Summary", summaryResult);
        expected.put("Description", descriptionResult);
        expected.put("ExternalDocs", externalDocumentationObjectResult);
        expected.put("OperationId", operationIdResult);
        expected.put("Parameters", parametersResult);
        expected.put("RequestBody", requestBodyResult);
        expected.put("Responses", responsesResult);
        expected.put("Callbacks", callbacksResult);
        expected.put("Deprecated", deprecatedResult);
        expected.put("Security", securitiesRequirementObjectResult);
        expected.put("Servers", serversResult);


        ICompareResult actual = spiedCompareHolderFactory.getOperationCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }

    @Test
    public void compareChanged() {
        CompareHolderFactory compareHolderFactory = new CompareHolderFactory();
        CompareHolderFactory spiedCompareHolderFactory = spy(compareHolderFactory);
        TagsCompareHolder tagsCompareHolder = mock(TagsCompareHolder.class);
        when(spiedCompareHolderFactory.getTagsCompareHolder()).thenReturn(tagsCompareHolder);
        ExternalDocumentationObjectCompareHolder externalDocumentationObjectCompareHolder = mock(ExternalDocumentationObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getExternalDocumentationObjectCompareHolder()).thenReturn(externalDocumentationObjectCompareHolder);
        ParametersCompareHolder parametersCompareHolder = mock(ParametersCompareHolder.class);
        when(spiedCompareHolderFactory.getParametersCompareHolder()).thenReturn(parametersCompareHolder);
        RequestBodyCompareHolder requestBodyCompareHolder = mock(RequestBodyCompareHolder.class);
        when(spiedCompareHolderFactory.getRequestBodyCompareHolder()).thenReturn(requestBodyCompareHolder);
        ResponsesCompareHolder responsesCompareHolder = mock(ResponsesCompareHolder.class);
        when(spiedCompareHolderFactory.getResponsesCompareHolder()).thenReturn(responsesCompareHolder);
        CallbacksCompareHolder callbacksCompareHolder = mock(CallbacksCompareHolder.class);
        when(spiedCompareHolderFactory.getCallbacksCompareHolder()).thenReturn(callbacksCompareHolder);
        ServersCompareHolder serversCompareHolder = mock(ServersCompareHolder.class);
        when(spiedCompareHolderFactory.getServersCompareHolder()).thenReturn(serversCompareHolder);
        SecuritiesRequirementObjectCompareHolder securitiesRequirementObjectCompareHolder = mock(SecuritiesRequirementObjectCompareHolder.class);
        when(spiedCompareHolderFactory.getSecuritiesRequirementObjectCompareHolder()).thenReturn(securitiesRequirementObjectCompareHolder);

        Operation leftValue = new Operation();
        List<String> leftTags = mock(List.class);
        leftValue.setTags(leftTags);
        String leftSummary = "test";
        leftValue.setSummary(leftSummary);
        String leftDescription = "test";
        leftValue.setDescription(leftDescription);
        ExternalDocumentation leftExternalDocs = mock(ExternalDocumentation.class);
        leftValue.setExternalDocs(leftExternalDocs);
        String leftOperationId = "test";
        leftValue.setOperationId(leftOperationId);
        Map<String, Parameter> leftParameterMap = mock(Map.class);
        List<Parameter> leftParameters = mock(List.class);
        leftValue.setParameters(leftParameters);
        RequestBody leftRequestBody = mock(RequestBody.class);
        leftValue.setRequestBody(leftRequestBody);
        ApiResponses leftResponses = mock(ApiResponses.class);
        leftValue.setResponses(leftResponses);
        Map<String, Callback> leftCallbacks = mock(Map.class);
        leftValue.setCallbacks(leftCallbacks);
        Boolean leftDeprecated = false;
        leftValue.setDeprecated(leftDeprecated);
        List<SecurityRequirement> leftSecurity = mock(List.class);
        leftValue.setSecurity(leftSecurity);
        List<Server> leftServers = mock(List.class);
        leftValue.setServers(leftServers);

        Operation rightValue = new Operation();
        List<String> rightTags = mock(List.class);
        rightValue.setTags(rightTags);
        String rightSummary = "test1";
        rightValue.setSummary(rightSummary);
        String rightDescription = "test1";
        rightValue.setDescription(rightDescription);
        ExternalDocumentation rightExternalDocs = mock(ExternalDocumentation.class);
        rightValue.setExternalDocs(rightExternalDocs);
        String rightOperationId = "test1";
        rightValue.setOperationId(rightOperationId);
        Map<String, Parameter> rightParameterMap = mock(Map.class);
        List<Parameter> rightParameters = mock(List.class);
        rightValue.setParameters(rightParameters);
        RequestBody rightRequestBody = mock(RequestBody.class);
        rightValue.setRequestBody(rightRequestBody);
        ApiResponses rightResponses = mock(ApiResponses.class);
        rightValue.setResponses(rightResponses);
        Map<String, Callback> rightCallbacks = mock(Map.class);
        rightValue.setCallbacks(rightCallbacks);
        Boolean rightDeprecated = true;
        rightValue.setDeprecated(rightDeprecated);
        List<SecurityRequirement> rightSecurity = mock(List.class);
        rightValue.setSecurity(rightSecurity);
        List<Server> rightServers = mock(List.class);
        rightValue.setServers(rightServers);

        ICompareResult tagsResult = new LeafCompareResult("tags", "tags", CompareResultType.CHANGED, CompareCriticalType.CRITICAL);
        ICompareResult externalDocumentationObjectResult = new LeafCompareResult("externalDocumentationObject", "externalDocumentationObject", CompareResultType.CHANGED, CompareCriticalType.CRITICAL);
        ICompareResult parametersResult = new LeafCompareResult("parameters", "parameters", CompareResultType.CHANGED, CompareCriticalType.CRITICAL);
        ICompareResult requestBodyResult = new LeafCompareResult("requestBody", "requestBody", CompareResultType.CHANGED, CompareCriticalType.CRITICAL);
        ICompareResult responsesResult = new LeafCompareResult("responses", "responses", CompareResultType.CHANGED, CompareCriticalType.CRITICAL);
        ICompareResult callbacksResult = new LeafCompareResult("callbacks", "callbacks", CompareResultType.CHANGED, CompareCriticalType.CRITICAL);
        ICompareResult serversResult = new LeafCompareResult("servers", "servers", CompareResultType.CHANGED, CompareCriticalType.CRITICAL);
        ICompareResult securitiesRequirementObjectResult = new LeafCompareResult("securitiesRequirementObject", "securitiesRequirementObject", CompareResultType.CHANGED, CompareCriticalType.CRITICAL);
        when(tagsCompareHolder.compare(eq(leftTags), eq(rightTags), any(), any())).thenReturn(tagsResult);
        when(externalDocumentationObjectCompareHolder.compare(eq(leftExternalDocs), eq(rightExternalDocs), any(), any())).thenReturn(externalDocumentationObjectResult);
        when(parametersCompareHolder.listToMapLeft(any())).thenReturn(leftParameterMap);
        when(parametersCompareHolder.listToMapRight(any())).thenReturn(rightParameterMap);
        when(parametersCompareHolder.compare(eq(leftParameterMap), eq(rightParameterMap), any(), any())).thenReturn(parametersResult);
        when(requestBodyCompareHolder.compare( eq(leftRequestBody), eq(rightRequestBody), any(), any())).thenReturn(requestBodyResult);
        when(responsesCompareHolder.compare(eq(leftResponses), eq(rightResponses), any(), any())).thenReturn(responsesResult);
        when(callbacksCompareHolder.compare( eq(leftCallbacks), eq(rightCallbacks),any(), any())).thenReturn(callbacksResult);
        when(serversCompareHolder.compare(eq(leftServers), eq(rightServers), any(), any())).thenReturn(serversResult);
        when(securitiesRequirementObjectCompareHolder.compare(eq(leftSecurity), eq(rightSecurity), any(), any())).thenReturn(securitiesRequirementObjectResult);

        ICompareResult summaryResult = new LeafCompareResult(leftSummary, rightSummary, CompareResultType.CHANGED, CompareCriticalType.INFO);
        ICompareResult descriptionResult = new LeafCompareResult(leftDescription, rightDescription, CompareResultType.CHANGED, CompareCriticalType.INFO);
        ICompareResult operationIdResult = new LeafCompareResult(leftOperationId, rightOperationId, CompareResultType.CHANGED, CompareCriticalType.CRITICAL);
        ICompareResult deprecatedResult = new LeafCompareResult( leftDeprecated, rightDeprecated, CompareResultType.CHANGED, CompareCriticalType.WARNING);



        NodeCompareResult expected = new NodeCompareResult(CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);
        expected.put("Tags", tagsResult);
        expected.put("Summary", summaryResult);
        expected.put("Description", descriptionResult);
        expected.put("ExternalDocs", externalDocumentationObjectResult);
        expected.put("OperationId", operationIdResult);
        expected.put("Parameters", parametersResult);
        expected.put("RequestBody", requestBodyResult);
        expected.put("Responses", responsesResult);
        expected.put("Callbacks", callbacksResult);
        expected.put("Deprecated", deprecatedResult);
        expected.put("Security", securitiesRequirementObjectResult);
        expected.put("Servers", serversResult);


        ICompareResult actual = spiedCompareHolderFactory.getOperationCompareHolder().compare(leftValue, rightValue, CompareCriticalType.WARNING, CompareCriticalType.CRITICAL);

        assertEquals(expected, actual);
    }
}