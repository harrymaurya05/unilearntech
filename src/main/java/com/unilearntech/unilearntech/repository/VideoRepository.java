package com.unilearntech.unilearntech.repository;


import com.unilearntech.unilearntech.models.Video;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 21/02/22.
 */
public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findByUser_id(Long user_id);
    List<Video> findAll();

}
