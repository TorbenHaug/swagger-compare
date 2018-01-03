package de.haug_dev.swagger_compare_rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class CompareController {

    Logger logger = LoggerFactory.getLogger(CompareController.class);

    @RequestMapping(value = "/compare",method = RequestMethod.POST)
    public CompareResponse compare(@RequestBody CompareRequest value) {
        logger.debug("Received: " + value);
        return new CompareResponse();
    }
}
