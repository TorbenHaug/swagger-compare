package de.haug_dev.swagger_compare_rest;

import de.haug_dev.swagger_compare.swagger_compare_core.SwaggerCompareResult;
import de.haug_dev.swagger_compare.swagger_compare_core.dto.OpenAPICompareResult;
import de.haug_dev.swagger_compare.swagger_compare_facade.SwaggerCompareFacade;
import de.haug_dev.swagger_compare.swagger_compare_reader.InvalidOpenAPIFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;

@RestController()
@RequestMapping("/api")
public class CompareController {

    Logger logger = LoggerFactory.getLogger(CompareController.class);

    @Autowired
    SwaggerCompareFacade facade;

    @RequestMapping(value = "/compare",method = RequestMethod.POST)
    public OpenAPICompareResult compare(@RequestBody CompareRequest value) throws MalformedURLException, InvalidOpenAPIFileException {
        logger.debug("Received: " + value);
        OpenAPICompareResult compareResult = facade.compare(value.urlLeft, value.urlRigth);
        return compareResult;
    }
}