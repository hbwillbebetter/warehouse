package net.xdclass.xdvideo.controller.admin;

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

/**
 * video接口
 *
 */
@RestController
@RequestMapping("/admin/api/v1/video")
public class VideoAdminController {
	
	@Autowired
	private VideoService videoService;

	/**
	 * 根据id删除视频
	 * @param videoId
	 * @return
	 */
	@DeleteMapping("del_by_id")
	public Object delById(@RequestParam(value="video_id",required=true)int videoId){
		return videoService.delete(videoId);
	}
	/**
	 * 根据id更新视频
	 * @param video
	 * @return
	 */
	@PutMapping("update_by_id")
	public Object update(@RequestBody Video video){
		return videoService.update(video);
	}
	/**
	 * 保存视频对象
	 * @param video
	 * @return
	 */
	@PostMapping("save")
	public Object save(@RequestBody Video video){
		int rows = videoService.save(video);
		System.out.println("保存对象的id= "+video.getId());
		return rows;
	}
	
	
}
