package springboot.mybatis.annotation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.mybatis.annotation.entity.Demo;
import springboot.mybatis.annotation.mapper.DemoMapper;
import springboot.mybatis.commonMapper.model.JsonData;

@RestController
public class DemoController {

	//注入服务对象
	@Autowired
	private DemoMapper mapper;
	
	@RequestMapping("/insert")
	public String service(){
		Demo demo = new Demo();
		demo.setName("张三");
		demo.setAge(20);
		mapper.save(demo);
		return demo.toString();
	}
	
	@RequestMapping("/getAll")
	public JsonData getAll(){
		List<Demo> all = mapper.getAll();
		for(Demo demo: all){
			System.out.println(demo.toString());
		}
		return JsonData.buildSuccess(all);
	}
	
}
