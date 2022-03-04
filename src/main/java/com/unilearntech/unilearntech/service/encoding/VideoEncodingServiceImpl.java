package com.unilearntech.unilearntech.service.encoding;


import com.unilearntech.unilearntech.models.VideoEncodingSyncStatus;
import com.unilearntech.unilearntech.repository.VideoEncodingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 28/02/22.
 */
@Service
 class VideoEncodingServiceImpl implements  VideoEncodingService{

    @Autowired VideoEncodingRepository videoEncodingRepository;
    @Override public VideoEncodingSyncStatus save(VideoEncodingSyncStatus videoEncodingSyncStatus) {
        return videoEncodingRepository.save(videoEncodingSyncStatus);
    }

    @Override public VideoEncodingSyncStatus getVideoEncodingStatus(String requestId) {
        return videoEncodingRepository.getVideoEncodingSyncStatusDTO(requestId);

    }

    @Override public VideoEncodingSyncStatus updateVideoEncodingStatus(VideoEncodingSyncStatus videoEncodingSyncStatus) {
        return videoEncodingRepository.updateVideoEncodingSyncStatusDTO(videoEncodingSyncStatus);
    }

}
