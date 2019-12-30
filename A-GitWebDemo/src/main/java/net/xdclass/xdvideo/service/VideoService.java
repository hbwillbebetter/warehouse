package net.xdclass.xdvideo.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.xdclass.xdvideo.domain.Video;

/**
 * 视频业务类接口
 *
 */
public interface VideoService {

	List<Video> findAll();
	
    Video findById(int id);
	
    int update(Video Video);

    int delete(int id);

	int save(Video video);
}
