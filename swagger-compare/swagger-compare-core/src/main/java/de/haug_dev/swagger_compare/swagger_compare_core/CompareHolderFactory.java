package de.haug_dev.swagger_compare.swagger_compare_core;

import de.haug_dev.swagger_compare.swagger_compare_core.callbacks.CallbackCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.callbacks.CallbacksCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.examples.ExampleCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.examples.ExamplesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.headers.HeaderCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.headers.HeadersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.links.LinkCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.links.LinksCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.media.MediaTypeCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.media.MediaTypesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.misc.ExternalDocumentationObjectCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.misc.TagsCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.parameters.ParameterCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.parameters.ParametersCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.paths.OperationCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.paths.PathItemCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.paths.PathsCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.request_bodies.RequestBodiesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.request_bodies.RequestBodyCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.responses.ResponseCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.responses.ResponsesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.schemas.SchemaCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.schemas.SchemasCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.security_schemes.*;
import de.haug_dev.swagger_compare.swagger_compare_core.servers.ServerCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.servers.ServerVariableCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.servers.ServerVariablesCompareHolder;
import de.haug_dev.swagger_compare.swagger_compare_core.servers.ServersCompareHolder;
import org.springframework.stereotype.Component;

@Component
public class CompareHolderFactory {
    public CallbackCompareHolder getCallbackCompareHolder() {
        return new CallbackCompareHolder(this);
    }

    public CallbacksCompareHolder getCallbacksCompareHolder() {
        return new CallbacksCompareHolder(this);
    }

    public ComponentsCompareHolder getComponentsCompareHolder() {
        return new ComponentsCompareHolder(this);
    }

    public ExampleCompareHolder getExampleCompareHolder() {
        return new ExampleCompareHolder();
    }

    public ExamplesCompareHolder getExamplesCompareHolder() {
        return new ExamplesCompareHolder(this);
    }

    public ExternalDocumentationObjectCompareHolder getExternalDocumentationObjectCompareHolder() {
        return new ExternalDocumentationObjectCompareHolder();
    }

    public HeaderCompareHolder getHeaderCompareHolder() {
        return new HeaderCompareHolder();
    }

    public HeadersCompareHolder getHeadersCompareHolder() {
        return new HeadersCompareHolder(this);
    }

    public LinkCompareHolder getLinkCompareHolder() {
        return new LinkCompareHolder();
    }

    public LinksCompareHolder getLinksCompareHolder() {
        return new LinksCompareHolder(this);
    }

    public MediaTypeCompareHolder getMediaTypeCompareHolder() {
        return new MediaTypeCompareHolder();
    }

    public MediaTypesCompareHolder getMediaTypesCompareHolder() {
        return new MediaTypesCompareHolder(this);
    }

    public OAuthFlowObjectCompareHolder getOAuthFlowObjectCompareHolder() {
        return new OAuthFlowObjectCompareHolder(this);
    }

    public OAuthFlowsObjectCompareHolder getOAuthFlowsObjectCompareHolder() {
        return new OAuthFlowsObjectCompareHolder(this);
    }

    public CompareHolder getOpenAPICompareHolder() {
        return new CompareHolder(this);
    }

    public OperationCompareHolder getOperationCompareHolder() {
        return new OperationCompareHolder(this);
    }

    public ParameterCompareHolder getParameterCompareHolder() {
        return new ParameterCompareHolder(this);
    }

    public ParametersCompareHolder getParametersCompareHolder() {
        return new ParametersCompareHolder(this);
    }

    public PathItemCompareHolder getPathItemCompareHolder() {
        return new PathItemCompareHolder(this);
    }

    public PathsCompareHolder getPathsCompareHolder() {
        return new PathsCompareHolder(this);
    }

    public RequestBodiesCompareHolder getRequestBodiesCompareHolder() {
        return new RequestBodiesCompareHolder(this);
    }

    public RequestBodyCompareHolder getRequestBodyCompareHolder() {
        return new RequestBodyCompareHolder(this);
    }

    public ResponseCompareHolder getResponseCompareHolder() {
        return new ResponseCompareHolder(this);
    }

    public ResponsesCompareHolder getResponsesCompareHolder() {
        return new ResponsesCompareHolder(this);
    }

    public SchemaCompareHolder getSchemaCompareHolder() {
        return new SchemaCompareHolder();
    }

    public SchemasCompareHolder getSchemasCompareHolder() {
        return new SchemasCompareHolder(this);
    }

    public ScopeCompareHolder getScopeCompareHolder() {
        return new ScopeCompareHolder();
    }

    public ScopesCompareHolder getScopesCompareHolder() {
        return new ScopesCompareHolder(this);
    }

    public SecuritiesRequirementObjectCompareHolder getSecuritiesRequirementObjectCompareHolder() {
        return new SecuritiesRequirementObjectCompareHolder();
    }

    public SecuritySchemeCompareHolder getSecuritySchemeCompareHolder() {
        return new SecuritySchemeCompareHolder(this);
    }

    public SecuritySchemesCompareHolder getSecuritySchemesCompareHolder() {
        return new SecuritySchemesCompareHolder(this);
    }

    public ServerCompareHolder getServerCompareHolder() {
        return new ServerCompareHolder(this);
    }

    public ServerVariableCompareHolder getServerVariableCompareHolder() {
        return new ServerVariableCompareHolder();
    }

    public ServerVariablesCompareHolder getServerVariablesCompareHolder() {
        return new ServerVariablesCompareHolder(this);
    }

    public ServersCompareHolder getServersCompareHolder() {
        return new ServersCompareHolder(this);
    }

    public TagsCompareHolder getTagsCompareHolder() {
        return new TagsCompareHolder();
    }
}
