package de.haug_dev.swagger_compare.swagger_compare_reader;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component
public class SwaggerCompareReader {

    private Logger logger = LoggerFactory.getLogger(SwaggerCompareReader.class);

    private OpenAPIV3Parser parser;

    @Autowired()
    public SwaggerCompareReader(OpenAPIV3ParserFactory parserFactory) {
        this.parser = parserFactory.getParser();
    }

    public OpenAPI[] read(URL left, URL right) throws InvalidOpenAPIFileException {
        OpenAPI[] result = new OpenAPI[2];
        try {
            String leftString = fixUri(left.toString());
            logger.debug("Try reading left: " + leftString);

            OpenAPI swaggerLeft = parser.read(leftString);
            if(swaggerLeft == null){
                throw new InvalidOpenAPIFileException(leftString + " is not a valid OpenAPI-File");
            }
            logger.debug("Result left: " + swaggerLeft.toString());

            String rightString = fixUri(right.toString());
            logger.debug("Try reading right: " + rightString);
            OpenAPI swaggerRight = parser.read(rightString);
            if(swaggerRight == null){
                throw new InvalidOpenAPIFileException(rightString + " is not a valid OpenAPI-File");
            }
            logger.debug("Result right: " + swaggerRight.toString());
            result[0] = swaggerLeft;
            result[1] = swaggerRight;
        }catch (Throwable e){
            logger.debug("Exception: ", e);
            throw e;
        }
        return result;
    }

    private String fixUri(String s) {
        return (s != null && s.startsWith("file:/"))? s.replace("file:/", "file:///") : s;
    }
}
