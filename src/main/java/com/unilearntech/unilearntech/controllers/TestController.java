package com.unilearntech.unilearntech.controllers;

import com.unilearntech.unilearntech.models.User;
import com.unilearntech.unilearntech.models.Video;
import com.unilearntech.unilearntech.models.VideoEncodingSyncStatusDTO;
import com.unilearntech.unilearntech.repository.UserRepository;
import com.unilearntech.unilearntech.repository.VideoRepository;
import com.unilearntech.unilearntech.service.encoding.VideoEncodingService;
import com.unilearntech.unilearntech.utils.encrption.EncryptionUtils;
import java.io.IOException;
import java.util.Optional;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired VideoRepository videoRepository;
    @Autowired UserRepository userRepository;
	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired VideoEncodingService videoEncodingService;
	@GetMapping("/all")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}
  
	@GetMapping("/hari")
	public String testing() throws IOException {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Optional<User> user = userRepository.findByUsername(userDetails.getUsername());

        Video video = new Video(user.get(),30.526667,30.526667,"test",true,"test");
        video.setUser(user.get());
        video.setVideoUrl("test");
        video.setThumbUrl("test");
        video.setEnable(false);
        video.setVideoDuration(233);
        video.setVideoSize(new Long(2332));
		videoRepository.save(video);

//		final String TEST_PREFIX = "/Users/admin/Desktop/personal/javaProject/auth-server/src/main/resources/";
//		final Locale locale = Locale.US;
//		final FFmpeg ffmpeg = new FFmpeg();
//		final FFprobe ffprobe = new FFprobe();
//		String inFilename = TEST_PREFIX+"big_buck_bunny_720p_1mb.mp4";
//		String outFileName = TEST_PREFIX+"output.mp4";
//		FFmpegProbeResult in = ffprobe.probe(inFilename);
//
//		FFmpegBuilder builder =
//				new FFmpegBuilder()
//						.setInput(inFilename) // Filename, or a FFmpegProbeResult
//						.setInput(in)
//						.overrideOutputFiles(true) // Override the output if it exists
//						.addOutput(outFileName) // Filename for the destination
//						.setFormat("mp4") // Format is inferred from filename, or can be set
//						.setTargetSize(250_000) // Aim for a 250KB file
//						.disableSubtitle() // No subtiles
//						.setAudioChannels(1) // Mono audio
//						.setAudioCodec("aac") // using the aac codec
//						.setAudioSampleRate(48_000) // at 48KHz
//						.setAudioBitRate(32768) // at 32 kbit/s
//						.setVideoCodec("libx264") // Video using x264
//						.setVideoFrameRate(24, 1) // at 24 frames per second
//						.setVideoResolution(640, 480) // at 640x480 resolution
//						.setStrict(FFmpegBuilder.Strict.EXPERIMENTAL) // Allow FFmpeg to use experimental specs
//						.done();
//
//		FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
//
//		// Run a one-pass encode
//		executor.createJob(builder).run();
//
//		// Or run a two-pass encode (which is slower at the cost of better quality
//		executor.createTwoPassJob(builder).run();
		return "testing";
	}


	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		String videoName = "test.mp4";
		String userName = "hariom";
		String dateInString = "01012000";
		String test = EncryptionUtils.base64Encode(videoName+userName+dateInString);
		System.out.println(test);
		System.out.println(EncryptionUtils.base64UrlDecode(test));

		return "Admin Board.";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create/job")
	public String testActivemq() throws IOException {
		//String json = new Gson().toJson(createInvoiceRequest);
		jmsTemplate.send("craete-job", new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText("Hariom");
				textMessage.setStringProperty("AuthToken", "Testing");
				return textMessage;
			}
		});
		return "Hariom";
	}

	@GetMapping("/mongo")
	public String addMongoData(){
		VideoEncodingSyncStatusDTO videoEncodingSyncStatusDTO = new VideoEncodingSyncStatusDTO();
		videoEncodingService.save(videoEncodingSyncStatusDTO);
		return "Data Added";
	}

	@GetMapping("/thread")
	public String testThreading(){
		
		return "thread";
	}




}
