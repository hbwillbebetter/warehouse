package net.xdclass.xdvideo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.mapper.VideoMapper;
import net.xdclass.xdvideo.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoMapper videoMapper;
	
	@Override
	public List<Video> findAll() {
		return videoMapper.findAll();
	}

	@Override
	public Video findById(int id) {
		return videoMapper.findById(id);
	}

	@Override
	public int update(Video Video) {
		return videoMapper.update(Video);
	}

	@Override
	public int delete(int id) {
		return videoMapper.delete(id);
	}

	@Override
	public int save(Video video) {
		return videoMapper.save(video);
	}

}
