package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_core.security_schemes.SecuritySchemesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.callbacks.CallbacksCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.examples.ExamplesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.parameters.ParametersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.Components;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentsCompareHolder extends AbstractCompareHolder<Components> {

    private final SchemasCompareHolder schemasCompareHolder;
    private final ResponsesCompareHolder responsesCompareHolder;
    private final ParametersCompareHolder parametersCompareHolder;
    private final ExamplesCompareHolder examplesCompareHolder;
    private final RequestBodiesCompareHolder requestBodiesCompareHolder;
    private final HeadersCompareHolder headersCompareHolder;
    private final SecuritySchemesCompareHolder securitySchemesCompareHolder;
    private final LinksCompareHolder linksCompareHolder;
    private final CallbacksCompareHolder callbacksCompareHolder;

    @Autowired
    public ComponentsCompareHolder(
            SchemasCompareHolder schemasCompareHolder,
            ResponsesCompareHolder responsesCompareHolder,
            ParametersCompareHolder parametersCompareHolder,
            ExamplesCompareHolder examplesCompareHolder,
            RequestBodiesCompareHolder requestBodiesCompareHolder,
            HeadersCompareHolder headersCompareHolder,
            SecuritySchemesCompareHolder securitySchemesCompareHolder,
            LinksCompareHolder linksCompareHolder,
            CallbacksCompareHolder callbacksCompareHolder
    ){

        this.schemasCompareHolder = schemasCompareHolder;
        this.responsesCompareHolder = responsesCompareHolder;
        this.parametersCompareHolder = parametersCompareHolder;
        this.examplesCompareHolder = examplesCompareHolder;
        this.requestBodiesCompareHolder = requestBodiesCompareHolder;
        this.headersCompareHolder = headersCompareHolder;
        this.securitySchemesCompareHolder = securitySchemesCompareHolder;
        this.linksCompareHolder = linksCompareHolder;
        this.callbacksCompareHolder = callbacksCompareHolder;
    }

    @Override
    public ICompareResult compare(Components left, Components right) {
        Components leftValue = left == null ? new Components() : left;
        Components rightValue = right == null ? new Components() : right;
        NodeCompareResult result = new NodeCompareResult();

        this.nodeCompare(leftValue.getSchemas(), rightValue.getSchemas(), "Schemas", schemasCompareHolder, result);
        this.nodeCompare(leftValue.getResponses(), rightValue.getResponses(), "Responses", responsesCompareHolder, result);
        this.nodeCompare(leftValue.getParameters(), rightValue.getParameters(), "Parameters", parametersCompareHolder, result);
        this.nodeCompare(leftValue.getExamples(), rightValue.getExamples(), "Examples", examplesCompareHolder, result);
        this.nodeCompare(leftValue.getRequestBodies(), rightValue.getRequestBodies(), "RequestBodies", requestBodiesCompareHolder, result);
        this.nodeCompare(leftValue.getHeaders(), rightValue.getHeaders(), "Headers", headersCompareHolder, result);
        this.nodeCompare(leftValue.getSecuritySchemes(), rightValue.getSecuritySchemes(), "SecuritySchemes", securitySchemesCompareHolder, result);
        this.nodeCompare(leftValue.getLinks(), rightValue.getLinks(), "Links", linksCompareHolder, result);
        this.nodeCompare(leftValue.getCallbacks(), rightValue.getCallbacks(), "Callbacks", callbacksCompareHolder, result);

        return result;
    }
}
