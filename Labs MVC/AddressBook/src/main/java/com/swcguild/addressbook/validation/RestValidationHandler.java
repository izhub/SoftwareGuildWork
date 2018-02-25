/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook.validation;

import com.swcguild.addressbook.dto.ValidationErrorContainer;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@ControllerAdvice
public class RestValidationHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorContainer processValidationErrors(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        ValidationErrorContainer errors = new ValidationErrorContainer();
        
        for(FieldError currentError : fieldErrors){
            errors.addValidationError(currentError.getField(),currentError.getDefaultMessage());
        }
        return errors;
    }
    // ^ this advice will run anytime any method on any controller that has a 
    //@valid on RESTful endpoint
    // next: input as div in home.jsp after the </form> in add table 102
    // next: input error(function) in .js page : line 31
}
