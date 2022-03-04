package com.unilearntech.unilearntech.repository;


import com.unilearntech.unilearntech.models.VideoEncodingSyncStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 28/02/22.
 */
@Repository
public class VideoEncodingRepository {
    @Autowired
    private MongoOperations mongoOperations;


    public VideoEncodingSyncStatus save(VideoEncodingSyncStatus videoEncodingSyncStatus) {
        mongoOperations.save(videoEncodingSyncStatus);
        return videoEncodingSyncStatus;
    }
    public VideoEncodingSyncStatus getVideoEncodingSyncStatusDTO(String requestId){
        VideoEncodingSyncStatus videoEncodingSyncStatusDTO = fetch(requestId);
        if(videoEncodingSyncStatusDTO == null){
            VideoEncodingSyncStatus videoEncodingSyncStatus = new VideoEncodingSyncStatus(requestId);
            videoEncodingSyncStatusDTO = updateVideoEncodingSyncStatusDTO(videoEncodingSyncStatus);
        }
        return  videoEncodingSyncStatusDTO;
    }

    public VideoEncodingSyncStatus updateVideoEncodingSyncStatusDTO(VideoEncodingSyncStatus videoEncodingSyncStatus){
        return save(videoEncodingSyncStatus);
    }

    public VideoEncodingSyncStatus fetch(String requestId){
       return mongoOperations.findOne(new Query(
                        Criteria.where("requestId").is(requestId)),
                VideoEncodingSyncStatus.class);
    }

}

