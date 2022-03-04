package com.unilearntech.unilearntech.service.encoding;

import com.unilearntech.unilearntech.models.VideoEncodingSyncStatus;

/**
 * Created by admin on 28/02/22.
 */
public interface VideoEncodingService {
    public VideoEncodingSyncStatus save(VideoEncodingSyncStatus videoEncodingSyncStatus);
    public VideoEncodingSyncStatus getVideoEncodingStatus(String requestId);
    public VideoEncodingSyncStatus updateVideoEncodingStatus(VideoEncodingSyncStatus videoEncodingSyncStatus);
}
