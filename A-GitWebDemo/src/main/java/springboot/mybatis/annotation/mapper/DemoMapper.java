package springboot.mybatis.annotation.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import springboot.mybatis.annotation.entity.Demo;

@Mapper
public interface DemoMapper {
	@Insert("insert into Demo(name,age) values(#{name},#{age})")  
    @Options(keyProperty="id",keyColumn="id",useGeneratedKeys=true)  
    public void save(Demo demo);
}
