package com.unilearntech.unilearntech.service.encoding;


import com.unilearntech.unilearntech.models.VideoEncodingSyncStatusDTO;
import com.unilearntech.unilearntech.repository.VideoEncodingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 28/02/22.
 */
@Service
 class VideoEncodingServiceImpl implements  VideoEncodingService{

    @Autowired VideoEncodingRepository videoEncodingRepository;
    @Override public VideoEncodingSyncStatusDTO save(VideoEncodingSyncStatusDTO videoEncodingSyncStatusDTO) {
        return videoEncodingRepository.save(videoEncodingSyncStatusDTO);
    }

    @Override public VideoEncodingSyncStatusDTO getVideoEncodingStatus(String requestId) {
        return videoEncodingRepository.getVideoEncodingSyncStatusDTO(requestId);

    }

    @Override public VideoEncodingSyncStatusDTO updateVideoEncodingStatus(VideoEncodingSyncStatusDTO videoEncodingSyncStatusDTO) {
        return videoEncodingRepository.updateVideoEncodingSyncStatusDTO(videoEncodingSyncStatusDTO);
    }

}
