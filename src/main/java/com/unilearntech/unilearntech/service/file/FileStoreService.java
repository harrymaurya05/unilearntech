package com.unilearntech.unilearntech.service.file;

import com.unilearntech.unilearntech.models.Video;
import com.unilearntech.unilearntech.utils.activemq.VideoEncodingEvent;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by admin on 20/02/22.
 */
public interface FileStoreService {
    ResponseEntity<?> storeAndEncodeFile(MultipartFile inputfile);
    List<Video> fetchVideosByUser();
    List<Video> fetchVideos();
    void encode(VideoEncodingEvent videoEncodingEvent);
}
