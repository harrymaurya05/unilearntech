package com.unilearntech.unilearntech.service.file;

import com.unilearntech.unilearntech.payload.request.FileStatusReqeust;
import com.unilearntech.unilearntech.payload.response.FileStatusResponse;
import com.unilearntech.unilearntech.payload.response.FileUploadResponse;
import com.unilearntech.unilearntech.payload.response.GetVideoResponse;
import com.unilearntech.unilearntech.utils.activemq.VideoEncodingEvent;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by admin on 20/02/22.
 */
public interface FileStoreService {
    FileUploadResponse storeAndEncodeFile(MultipartFile inputfile);
    GetVideoResponse fetchVideosByUser();
    GetVideoResponse fetchVideos();
    void encode(VideoEncodingEvent videoEncodingEvent);
    FileStatusResponse getFileStatus(FileStatusReqeust fileStatusReqeust);
}
