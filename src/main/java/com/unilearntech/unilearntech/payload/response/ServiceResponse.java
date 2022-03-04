/*
 *  Copyright 2011 Unicommerce eSolutions (P) Limited All Rights Reserved.
 *  UNICOMMERCE ESOLUTIONS PROPRIETARYARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, Dec 14, 2011
 *  @author singla
 */
package com.unilearntech.unilearntech.payload.response;

import com.unilearntech.unilearntech.models.Error;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



/**
 * @author singla
 */
public class ServiceResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1549846444746590813L;
    private boolean           successful;
    private String            message;
    private List<Error>     errors;


    public ServiceResponse() {

    }

    public ServiceResponse(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }

    /**
     * @return the successful
     */
    public boolean isSuccessful() {
        return successful;
    }

    /**
     * @param successful the successful to set
     */
    public void setSuccessful(boolean successful) {
        this.successful = successful;
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

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public ServiceResponse addError(Error error) {
        if (this.errors == null) {
            this.errors = new ArrayList<Error>();
        }
        this.errors.add(error);
        return this;
    }

    public ServiceResponse addErrors(List<Error> errors) {
        if (errors != null) {
            if (this.errors == null) {
                this.errors = new ArrayList<Error>();
            }
            this.errors.addAll(errors);
        }
        return this;
    }



    public boolean hasErrors() {
        return errors != null && errors.size() > 0;
    }



    public void setResponse(ServiceResponse response) {
        this.successful = response.isSuccessful();
        this.message = response.getMessage();
        this.errors = response.getErrors();

    }

    @Override
    public String toString() {
        return "ServiceResponse [successful=" + successful + ", message=" + message + ", errors=" + errors  + "]";
    }



}
