package de.haug_dev.swagger_compare.swagger_compare_reader;

import io.swagger.v3.parser.OpenAPIV3Parser;
import org.springframework.stereotype.Component;

@Component
public class OpenAPIV3ParserFactory {

    public OpenAPIV3Parser getParser() {
        return new OpenAPIV3Parser();
    }

}
