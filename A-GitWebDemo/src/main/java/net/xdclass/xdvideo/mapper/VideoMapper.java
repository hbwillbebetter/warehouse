package net.xdclass.xdvideo.mapper;

import java.util.List;

import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.provider.VideoProvider;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
/**
 * video数据访问层
 *
 */
public interface VideoMapper {
	
	@Select("select * from video")
	/*
	 * 配置文件：# mybatis 下划线转驼峰配置,两者都可以
	 * #mybatis.configuration.mapUnderscoreToCamelCase=true
       mybatis.configuration.map-underscore-to-camel-case=true
	 */
//	@Results({
//		@Result(column = "cover_img",property = "coverImg"),
//		@Result(column = "create_time",property = "createTime")
//	})
	List<Video> findAll();

	@Select("SELECT * FROM video WHERE id = #{id}")
    Video findById(int id);
	
//    @Update("UPDATE video SET title=#{title} WHERE id =#{id}")
	//动态sql用@UpdateProvider
	@UpdateProvider(type=VideoProvider.class,method="updateVideo")
    int update(Video Video);

    @Delete("DELETE FROM video WHERE id =#{id}")
    int delete(int id);

    @Insert("INSERT INTO `video` ( `title`, `summary`, " +
        "`cover_img`, `price`, `create_time`)" +
        "VALUES" +
        "(#{title}, #{summary}, #{coverImg}, #{price},#{createTime});")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	int save(Video video);
	
	
}
