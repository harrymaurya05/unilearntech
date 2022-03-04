package com.unilearntech.unilearntech.payload.response;

import com.unilearntech.unilearntech.models.VideoEncodingSyncStatus;

/**
 * Created by admin on 04/03/22.
 */
public class FileStatusResponse extends ServiceResponse {
    private static final long serialVersionUID = 5203534196562297316L;
    private VideoEncodingSyncStatus status;

    public VideoEncodingSyncStatus getStatus() {
        return status;
    }

    public void setStatus(VideoEncodingSyncStatus status) {
        this.status = status;
    }
}
