package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResultType;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.OperationCompareResult;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperationCompareHolderTest {

    @Test
    public void testUnchanged() {
        Parameter parameterLeft = new Parameter();
        Boolean deprecatedLeft = false;
        RequestBody requestBodyLeft = new RequestBody();
        ApiResponses apiResponsesLeft = new ApiResponses();
        Operation operationLeft = new Operation();
        operationLeft.addParametersItem(parameterLeft);
        operationLeft.setDeprecated(deprecatedLeft);
        operationLeft.setRequestBody(requestBodyLeft);
        operationLeft.setResponses(apiResponsesLeft);
        OperationCompareHolder left = new OperationCompareHolder(operationLeft);

        Parameter parameterRight = new Parameter();
        Boolean deprecatedRight = false;
        RequestBody requestBodyRight = new RequestBody();
        ApiResponses apiResponsesRight = new ApiResponses();
        Operation operationRight = new Operation();
        operationRight.addParametersItem(parameterRight);
        operationRight.setDeprecated(deprecatedRight);
        operationRight.setRequestBody(requestBodyRight);
        operationRight.setResponses(apiResponsesRight);
        OperationCompareHolder right = new OperationCompareHolder(operationRight);

        OperationCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.UNCHANGED, actual.getCompareResultType());
    }

    @Test
    public void testChangedParameter() {
        Parameter parameterLeft = new Parameter();
        Boolean deprecatedLeft = false;
        RequestBody requestBodyLeft = new RequestBody();
        ApiResponses apiResponsesLeft = new ApiResponses();
        Operation operationLeft = new Operation();
        operationLeft.addParametersItem(parameterLeft);
        operationLeft.setDeprecated(deprecatedLeft);
        operationLeft.setRequestBody(requestBodyLeft);
        operationLeft.setResponses(apiResponsesLeft);
        OperationCompareHolder left = new OperationCompareHolder(operationLeft);

        Parameter parameterRight = new Parameter();
        parameterRight.$ref("/test/");
        Boolean deprecatedRight = false;
        RequestBody requestBodyRight = new RequestBody();
        ApiResponses apiResponsesRight = new ApiResponses();
        Operation operationRight = new Operation();
        operationRight.addParametersItem(parameterRight);
        operationRight.setDeprecated(deprecatedRight);
        operationRight.setRequestBody(requestBodyRight);
        operationRight.setResponses(apiResponsesRight);
        OperationCompareHolder right = new OperationCompareHolder(operationRight);

        OperationCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
    }

    @Test
    public void testChangedDeprecated() {
        Parameter parameterLeft = new Parameter();
        Boolean deprecatedLeft = false;
        RequestBody requestBodyLeft = new RequestBody();
        ApiResponses apiResponsesLeft = new ApiResponses();
        Operation operationLeft = new Operation();
        operationLeft.addParametersItem(parameterLeft);
        operationLeft.setDeprecated(deprecatedLeft);
        operationLeft.setRequestBody(requestBodyLeft);
        operationLeft.setResponses(apiResponsesLeft);
        OperationCompareHolder left = new OperationCompareHolder(operationLeft);

        Parameter parameterRight = new Parameter();
        Boolean deprecatedRight = true;
        RequestBody requestBodyRight = new RequestBody();
        ApiResponses apiResponsesRight = new ApiResponses();
        Operation operationRight = new Operation();
        operationRight.addParametersItem(parameterRight);
        operationRight.setDeprecated(deprecatedRight);
        operationRight.setRequestBody(requestBodyRight);
        operationRight.setResponses(apiResponsesRight);
        OperationCompareHolder right = new OperationCompareHolder(operationRight);

        OperationCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
    }

    @Test
    public void testChangedRequestBody() {
        Parameter parameterLeft = new Parameter();
        Boolean deprecatedLeft = false;
        RequestBody requestBodyLeft = new RequestBody();
        ApiResponses apiResponsesLeft = new ApiResponses();
        Operation operationLeft = new Operation();
        operationLeft.addParametersItem(parameterLeft);
        operationLeft.setDeprecated(deprecatedLeft);
        operationLeft.setRequestBody(requestBodyLeft);
        operationLeft.setResponses(apiResponsesLeft);
        OperationCompareHolder left = new OperationCompareHolder(operationLeft);

        Parameter parameterRight = new Parameter();
        Boolean deprecatedRight = false;
        RequestBody requestBodyRight = new RequestBody();
        requestBodyRight.$ref("/test");
        ApiResponses apiResponsesRight = new ApiResponses();
        Operation operationRight = new Operation();
        operationRight.addParametersItem(parameterRight);
        operationRight.setDeprecated(deprecatedRight);
        operationRight.setRequestBody(requestBodyRight);
        operationRight.setResponses(apiResponsesRight);
        OperationCompareHolder right = new OperationCompareHolder(operationRight);

        OperationCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
    }

    @Test
    public void testChangedResponses() {
        Parameter parameterLeft = new Parameter();
        Boolean deprecatedLeft = false;
        RequestBody requestBodyLeft = new RequestBody();
        ApiResponses apiResponsesLeft = new ApiResponses();
        Operation operationLeft = new Operation();
        operationLeft.addParametersItem(parameterLeft);
        operationLeft.setDeprecated(deprecatedLeft);
        operationLeft.setRequestBody(requestBodyLeft);
        operationLeft.setResponses(apiResponsesLeft);
        OperationCompareHolder left = new OperationCompareHolder(operationLeft);

        Parameter parameterRight = new Parameter();
        Boolean deprecatedRight = false;
        RequestBody requestBodyRight = new RequestBody();
        ApiResponses apiResponsesRight = new ApiResponses();
        apiResponsesRight.addApiResponse("test", new ApiResponse());
        Operation operationRight = new Operation();
        operationRight.addParametersItem(parameterRight);
        operationRight.setDeprecated(deprecatedRight);
        operationRight.setRequestBody(requestBodyRight);
        operationRight.setResponses(apiResponsesRight);
        OperationCompareHolder right = new OperationCompareHolder(operationRight);

        OperationCompareResult actual = left.compare(right);

        assertEquals(CompareResultType.CHANGED, actual.getCompareResultType());
    }
}