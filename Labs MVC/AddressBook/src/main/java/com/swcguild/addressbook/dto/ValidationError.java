/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook.dto;

/**
 *
 * @author apprentice
 */
public class ValidationError {
    
    private String fieldName;
    private String message;
    
    public ValidationError(String fieldname, String message){
        this.fieldName = fieldName;
        this.message = message;
    }
    
    public String getFieldName(){
        return fieldName;
    }
    
    public String getMessage(){
        return message;
    }
}
