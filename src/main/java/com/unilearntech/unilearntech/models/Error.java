/*
 *  Copyright 2011 Unicommerce eSolutions (P) Limited All Rights Reserved.
 *  UNICOMMERCE ESOLUTIONS PROPRIETARYARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, Dec 14, 2011
 *  @author singla
 */
package com.unilearntech.unilearntech.models;

import java.util.Map;

/**
 * @author singla
 */
public class Error {
    private int                 code;
    private String              fieldName;
    private String              description;
    private String              message;
    private Map<String, Object> errorParams;

    public Error() {

    }

    /**
     * @param description
     */
    public Error(String description) {
        this.description = description;
    }

    /**
     * @param code
     * @param message
     */
    public Error(int code, String message) {
        this.code = code;
        this.message = message;
        this.description = message;
    }

    /**
     * @param code
     * @param message
     */
    public Error(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    /**
     * @param code
     * @param message
     */
    public Error(int code, String message, String fieldName, String description) {
        this.code = code;
        this.message = message;
        this.fieldName = fieldName;
        this.description = description;
    }

    public Error(int code, String message, String description, Map<String, Object> errorParams) {
        this.code = code;
        this.message = message;
        this.description = description;
        this.errorParams = errorParams;
    }

    public Error(int code, String message, String fieldName, String description, Map<String, Object> errorParams) {
        this.code = code;
        this.message = message;
        this.fieldName = fieldName;
        this.description = description;
        this.errorParams = errorParams;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    public Map<String, Object> getErrorParams() {
        return errorParams;
    }

    public void setErrorParams(Map<String, Object> errorParams) {
        this.errorParams = errorParams;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "WsError [code=" + code + ", description=" + description + ", message=" + message + "]";
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

}
