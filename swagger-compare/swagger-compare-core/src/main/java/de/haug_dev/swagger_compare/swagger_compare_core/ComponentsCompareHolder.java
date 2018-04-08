package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.ICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_datatypes.NodeCompareResult;
import io.swagger.v3.oas.models.Components;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentsCompareHolder implements ICompareHolder<Components> {

    private final SchemasCompareHolder schemasCompareHolder;
    private final ResponsesCompareHolder responsesCompareHolder;
    private final ParametersCompareHolder parametersCompareHolder;
    private final ExamplesCompareHolder examplesCompareHolder;
    private final RequestBodiesCompareHolder requestBodiesCompareHolder;
    private final HeadersCompareHolder headersCompareHolder;
    private final SecuritySchemesComparHolder securitySchemesComparHolder;
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
            SecuritySchemesComparHolder securitySchemesComparHolder,
            LinksCompareHolder linksCompareHolder,
            CallbacksCompareHolder callbacksCompareHolder
    ){

        this.schemasCompareHolder = schemasCompareHolder;
        this.responsesCompareHolder = responsesCompareHolder;
        this.parametersCompareHolder = parametersCompareHolder;
        this.examplesCompareHolder = examplesCompareHolder;
        this.requestBodiesCompareHolder = requestBodiesCompareHolder;
        this.headersCompareHolder = headersCompareHolder;
        this.securitySchemesComparHolder = securitySchemesComparHolder;
        this.linksCompareHolder = linksCompareHolder;
        this.callbacksCompareHolder = callbacksCompareHolder;
    }

    @Override
    public ICompareResult compare(Components left, Components right) {
        Components leftValue = left == null ? new Components() : left;
        Components rightValue = right == null ? new Components() : right;
        NodeCompareResult result = new NodeCompareResult();

        this.compare(leftValue.getSchemas(), rightValue.getSchemas(), "Schemas", schemasCompareHolder, result);
        this.compare(leftValue.getResponses(), rightValue.getResponses(), "Responses", responsesCompareHolder, result);
        this.compare(leftValue.getParameters(), rightValue.getParameters(), "Parameters", parametersCompareHolder, result);
        this.compare(leftValue.getExamples(), rightValue.getExamples(), "Examples", examplesCompareHolder, result);
        this.compare(leftValue.getRequestBodies(), rightValue.getRequestBodies(), "RequestBodies", requestBodiesCompareHolder, result);
        this.compare(leftValue.getHeaders(), rightValue.getHeaders(), "Headers", headersCompareHolder, result);
        this.compare(leftValue.getSecuritySchemes(), rightValue.getSecuritySchemes(), "SecuritySchemes", securitySchemesComparHolder, result);
        this.compare(leftValue.getLinks(), rightValue.getLinks(), "Links", linksCompareHolder, result);
        this.compare(leftValue.getCallbacks(), rightValue.getCallbacks(), "Callbacks", callbacksCompareHolder, result);

        return result;
    }
}
