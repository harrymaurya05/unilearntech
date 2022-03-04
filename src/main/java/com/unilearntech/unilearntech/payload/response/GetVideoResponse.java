package com.unilearntech.unilearntech.payload.response;

import java.util.List;

/**
 * Created by admin on 04/03/22.
 */
public class GetVideoResponse extends ServiceResponse {
    private static final long serialVersionUID = 5203534196562297316L;
    private List<VideoResponse> videos ;

    public List<VideoResponse> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoResponse> videos) {
        this.videos = videos;
    }
}
