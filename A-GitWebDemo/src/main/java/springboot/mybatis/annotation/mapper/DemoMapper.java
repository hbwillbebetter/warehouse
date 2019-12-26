package springboot.mybatis.annotation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import springboot.mybatis.annotation.entity.Demo;

@Mapper
public interface DemoMapper {
	//推荐使用#{}取值，不要用${},因为存在注入的风险
	@Insert("insert into Demo(name,age) values(#{name},#{age})")  
	//keyProperty java对象的属性，keyColumn表示数据库字段
    @Options(keyProperty="id",keyColumn="id",useGeneratedKeys=true)  
    public void save(Demo demo);
	
	@Select("select * from Demo")
	@Results({
			//数据字段的映射，我们在数据库内用下划线，开发的时候实体类不用下划线。所以就需要属性字段值和数据库的字段值进行映射
//			@Result(column="create_time",property="createTime") //javaType=java.util.
			@Result(column="name",property="name") //javaType=java.util.
	})
	List<Demo> getAll();
	
}
