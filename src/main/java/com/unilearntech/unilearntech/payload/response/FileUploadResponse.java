package com.unilearntech.unilearntech.payload.response;

/**
 * Created by admin on 04/03/22.
 */
public class FileUploadResponse extends ServiceResponse {
    private static final long serialVersionUID = 5203534196562297316L;
    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
