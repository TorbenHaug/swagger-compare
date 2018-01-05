package de.haug_dev.swagger_compare_rest;

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
    public CompareResponse compare(@RequestBody CompareRequest value) throws MalformedURLException, InvalidOpenAPIFileException {
        logger.debug("Received: " + value);
        facade.compare(value.urlLeft, value.urlRigth);
        return new CompareResponse();
    }
}
