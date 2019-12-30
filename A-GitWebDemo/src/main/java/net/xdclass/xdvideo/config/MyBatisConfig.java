package net.xdclass.xdvideo.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

@Configuration
public class MyBatisConfig {

	@Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        //设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用
        p.setProperty("offsetAsPageNum","true");
        
        //设置为true时，使用RowBounds分页会进行count查询
        p.setProperty("rowBoundsWithCount","true");
        p.setProperty("reasonable","true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
