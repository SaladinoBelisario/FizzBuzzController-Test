package com.sample.restcontrolleradvice.exception;

import com.sample.restcontrolleradvice.dto.BuzzException;
import com.sample.restcontrolleradvice.dto.FizzBuzzException;
import com.sample.restcontrolleradvice.dto.FizzException;
import com.sample.restcontrolleradvice.dto.GlobalError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FizzException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody GlobalError handleFizzException(final FizzException exception,
                                                         final HttpServletRequest request) {

        GlobalError err = new GlobalError();
        err.setMessage(exception.getMessage());
        err.setErrorReason(exception.getErrorReason());
        return err;
    }

    @ExceptionHandler(BuzzException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody GlobalError handleBuzzException(final BuzzException exception,
                                                         final HttpServletRequest request) {

        GlobalError err = new GlobalError();
        err.setMessage(exception.getMessage());
        err.setErrorReason(exception.getErrorReason());
        return err;
    }

    @ExceptionHandler(FizzBuzzException.class)
    @ResponseStatus(value = HttpStatus.INSUFFICIENT_STORAGE)
    public @ResponseBody GlobalError handleFizzBuzzException(final FizzBuzzException exception,
                                                             final HttpServletRequest request) {

        GlobalError err = new GlobalError();
        err.setMessage(exception.getMessage());
        err.setErrorReason(exception.getErrorReason());
        return err;
    }

}
