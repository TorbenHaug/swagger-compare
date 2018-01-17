package de.haug_dev.swagger_compare.swagger_compare_reader;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component
public class SwaggerCompareReader {

    Logger logger = LoggerFactory.getLogger(SwaggerCompareReader.class);

    OpenAPIV3Parser parser = new OpenAPIV3Parser();

    public OpenAPI[] read(URL left, URL right) throws InvalidOpenAPIFileException {
        OpenAPI[] result = new OpenAPI[2];
        try {
            logger.debug("Try reading left: " + left.toString());
            OpenAPI swaggerLeft = parser.read(left.toString());
            if(swaggerLeft == null){
                throw new InvalidOpenAPIFileException(left + " is not a valid OpenAPI-File");
            }
            logger.debug("Result left: " + swaggerLeft.toString());
            logger.debug("Try reading right: " + right.toString());
            OpenAPI swaggerRight = parser.read(right.toString());
            if(swaggerRight == null){
                throw new InvalidOpenAPIFileException(right + " is not a valid OpenAPI-File");
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
}