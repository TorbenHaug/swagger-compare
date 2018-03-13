package de.haug_dev.swagger_compare_rest;

import de.haug_dev.swagger_compare.swagger_compare_datatypes.CompareResult;
import de.haug_dev.swagger_compare.swagger_compare_facade.SwaggerCompareFacade;
import de.haug_dev.swagger_compare.swagger_compare_reader.InvalidOpenAPIFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController()
@RequestMapping("/api")
public class CompareController {


    private Logger logger = LoggerFactory.getLogger(CompareController.class);

    private SwaggerCompareFacade facade;

    @Autowired
    public CompareController(SwaggerCompareFacade facade) {
        this.facade = facade;
    }

    @PostMapping(value = "/compare")
    public CompareResult compare(@RequestBody CompareRequest value) throws MalformedURLException, InvalidOpenAPIFileException {
        CompareResult compareResult = facade.compare(value.urlLeft, value.urlRigth);
        return compareResult;
    }

    @PostMapping(value = "/compareFiles")
    public CompareResult compareFiles(@RequestParam("fileLeft") MultipartFile fileLeft, @RequestParam("fileRight") MultipartFile fileRight) throws IOException, InvalidOpenAPIFileException {
        logger.info("Left: " + new String(fileLeft.getBytes()));
        logger.info("Right: " + new String(fileRight.getBytes()));
        CompareResult compareResult = facade.compareFiles(new String(fileLeft.getBytes()), new String(fileRight.getBytes()));
        return compareResult;
    }

}
