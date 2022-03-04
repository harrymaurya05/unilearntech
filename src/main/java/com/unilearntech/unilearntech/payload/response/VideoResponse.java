package com.unilearntech.unilearntech.payload.response;

/**
 * Created by admin on 04/03/22.
 */
public class VideoResponse  {
    private String videoName;
    private double videoSize;
    private double videoDuration;
    private String vidoeUrl;
    private String videoThumbnailUrl;

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public double getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(double videoSize) {
        this.videoSize = videoSize;
    }

    public double getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(double videoDuration) {
        this.videoDuration = videoDuration;
    }

    public String getVidoeUrl() {
        return vidoeUrl;
    }

    public void setVidoeUrl(String vidoeUrl) {
        this.vidoeUrl = vidoeUrl;
    }

    public String getVideoThumbnailUrl() {
        return videoThumbnailUrl;
    }

    public void setVideoThumbnailUrl(String videoThumbnailUrl) {
        this.videoThumbnailUrl = videoThumbnailUrl;
    }
}
