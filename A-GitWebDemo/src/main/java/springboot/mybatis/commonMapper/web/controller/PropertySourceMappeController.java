package springboot.mybatis.commonMapper.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.mybatis.commonMapper.model.JsonData;
import springboot.mybatis.commonMapper.model.ServerSettings;

/**
 * https://www.cnblogs.com/wangjunwei/p/11401360.html
 * 3、SpringBoot注解把配置文件自动映射到属性和实体类实战
    简介：讲解使用@value注解配置文件自动映射到属性和实体类
            
    1、配置文件加载
        方式一
            1、Controller上面配置
               @PropertySource({"classpath:resource.properties"})
            2、增加属性
                 @Value("${test.name}")
                  private String name;

        方式二：实体类配置文件
        步骤：
            1、添加 @Component 注解；
            2、使用 @PropertySource 注解指定配置文件位置；
            3、使用 @ConfigurationProperties 注解，设置相关属性；

            4、必须 通过注入IOC对象Resource 进来 ， 才能在类中使用获取的配置文件值。
                @Autowired
                private ServerSettings serverSettings;

                例子：
                    @Configuration
                    @ConfigurationProperties(prefix="test")
                    @PropertySource(value="classpath:resource.properties")
                    public class ServerConstant {


            常见问题：
                1、配置文件注入失败，Could not resolve placeholder
                    解决：根据springboot启动流程，会有自动扫描包没有扫描到相关注解, 
                    默认Spring框架实现会从声明@ComponentScan所在的类的package进行扫描，来自动注入，
                    因此启动类最好放在根路径下面，或者指定扫描包范围
                    spring-boot扫描启动类对应的目录和子目录
                2、注入bean的方式，属性名称和配置文件里面的key一一对应，就用加@Value 这个注解
                    如果不一样，就要加@value("${XXX}")
 *
 */
@RestController
//@PropertySource({"classpath:resource.properties"})
@RequestMapping("/test")
public class PropertySourceMappeController {
	
	@Value("${web.file.path}")
	private String filePath;
	
	@Autowired
	private ServerSettings serverSettings;
	
	@RequestMapping("/source1")
	public JsonData readSource(){
		
		System.out.println("配置注入打印，文件路径为:"+filePath);
		
		return JsonData.buildSuccess(filePath);
	}
	
	@GetMapping("/source2")
	public JsonData testProperties(){
		
		return JsonData.buildSuccess(serverSettings);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
