package de.haug_dev.swagger_compare_rest;

import de.haug_dev.swagger_compare.swagger_compare_reader.InvalidOpenAPIFileException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.MalformedURLException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler({
            InvalidOpenAPIFileException.class
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage notFound(final Exception error) {
        Throwable rootError = getRootCause(error);
        logger.debug("Generating error: " + rootError.getMessage());
        return new ErrorMessage(rootError.getMessage(), ExceptionUtils.getStackTrace(rootError));
    }

    @ExceptionHandler({
            MalformedURLException.class
    })
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage badRequest(final Exception error) {
        Throwable rootError = getRootCause(error);
        logger.debug("Generating error: " + rootError.getMessage());
        return new ErrorMessage(rootError.getMessage(), ExceptionUtils.getStackTrace(rootError));
    }

    private Throwable getRootCause(Throwable throwable){
        if(throwable.getCause() == null) {
            return throwable;
        }
        return getRootCause(throwable.getCause());
    }
}