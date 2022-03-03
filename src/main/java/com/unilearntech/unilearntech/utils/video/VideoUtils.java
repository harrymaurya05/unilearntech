package com.unilearntech.unilearntech.utils.video;

import java.io.IOException;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 02/03/22.
 */
public class VideoUtils {
    private static final Logger logger = LoggerFactory.getLogger(VideoUtils.class);
    public static Double findLengthOfVideo(String videoPath) throws IOException {
        Double videoLength;
        final FFprobe ffprobe = new FFprobe();
        FFmpegProbeResult probeResult = ffprobe.probe(videoPath);
        FFmpegFormat format = probeResult.getFormat();
        videoLength = format.duration;
        logger.info("Video Duration : "+videoLength);
        return videoLength;
    }

}
