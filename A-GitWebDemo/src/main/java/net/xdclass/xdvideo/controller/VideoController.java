package net.xdclass.xdvideo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.service.VideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * video接口
 *
 */
@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
	
	@Autowired
	private VideoService videoService;

	@RequestMapping("test")
	public String test(){
		return "hello xdclass.net";
	}
	
	/**
	 * 分页接口
	 * @param page 当前第几页，默认是第一页
	 * @param size 每页显示几条
	 * @return
	 */
	@GetMapping("page")
	public Object pageVideo(@RequestParam(value="page",defaultValue="1") int page,
			@RequestParam(value="size",defaultValue="10") int size){
		PageHelper.startPage(page, size);
		List<Video> list = videoService.findAll();
		PageInfo<Video> pageInfo = new PageInfo<>(list);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("total_size", pageInfo.getTotal());//总条数
		data.put("total_page", pageInfo.getPages());//总页数
		data.put("current_page", page);//当前页
		data.put("data", pageInfo.getList());//总条数
		
		return data;
	}
	
	@GetMapping("find_by_id")
	public Object findById(@RequestParam(value="video_id",required=true) int videoId){
		return videoService.findById(videoId);
	}
	
	
}
