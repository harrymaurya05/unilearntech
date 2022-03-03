package com.unilearntech.unilearntech.service.encoding;

import com.unilearntech.unilearntech.models.VideoEncodingSyncStatusDTO;

/**
 * Created by admin on 28/02/22.
 */
public interface VideoEncodingService {
    public VideoEncodingSyncStatusDTO save(VideoEncodingSyncStatusDTO videoEncodingSyncStatusDTO);
    public VideoEncodingSyncStatusDTO getVideoEncodingStatus(String requestId);
    public VideoEncodingSyncStatusDTO updateVideoEncodingStatus(VideoEncodingSyncStatusDTO videoEncodingSyncStatusDTO);
}
