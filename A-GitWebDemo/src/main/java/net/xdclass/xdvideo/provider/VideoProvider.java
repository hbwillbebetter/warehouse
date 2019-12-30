package net.xdclass.xdvideo.provider;

import org.apache.ibatis.jdbc.SQL;

import net.xdclass.xdvideo.domain.Video;

/**
 * video构建动态sql语句
 */
public class VideoProvider {

	public String updateVideo(final Video video){
		return new SQL() {
			{
				UPDATE("video");
				//条件写法
				if(video.getTitle() != null){
					SET("title=#{title}");
				}
				if(video.getSummary() != null){
					SET("summary=#{summary}");
				}
				if(video.getCoverImg() != null){
					SET("coverImg=#{coverImg}");
				}
				if(video.getPrice() != null){
					SET("price=#{price}");
				}
				if(video.getCreateTime() != null){
					SET("createTime=#{createTime}");
				}
				//更新的条件
				WHERE("id=#{id}");
			}
		}.toString();
		
	}
	
}
