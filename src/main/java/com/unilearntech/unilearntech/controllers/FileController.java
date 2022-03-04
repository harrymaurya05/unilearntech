package com.unilearntech.unilearntech.controllers;

import com.unilearntech.unilearntech.payload.request.FileStatusReqeust;
import com.unilearntech.unilearntech.payload.response.FileStatusResponse;
import com.unilearntech.unilearntech.payload.response.FileUploadResponse;
import com.unilearntech.unilearntech.payload.response.GetVideoResponse;
import com.unilearntech.unilearntech.service.file.FileStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 * Created by admin on 19/02/22.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired FileStoreService fileStoreService;

    @PostMapping(value="/upload")
    @PreAuthorize("hasRole('USER')")
    public FileUploadResponse allAccess(@RequestParam("file") MultipartFile inputfile) {
        return fileStoreService.storeAndEncodeFile(inputfile);
    }


    @PostMapping(value="/status")
    @PreAuthorize("hasRole('USER')")
    public FileStatusResponse getFileStatus(@RequestBody FileStatusReqeust reqeust) {
        return fileStoreService.getFileStatus(reqeust);
    }
    @GetMapping(value = "/user/videos")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public GetVideoResponse fetchVideosByUser(){
        return fileStoreService.fetchVideosByUser();
    }

    @GetMapping(value = "/all/videos")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public GetVideoResponse fetchAllVideos(){
        return fileStoreService.fetchVideos();
    }
}
