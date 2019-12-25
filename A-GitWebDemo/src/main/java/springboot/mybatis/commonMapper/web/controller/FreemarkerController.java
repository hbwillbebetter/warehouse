package springboot.mybatis.commonMapper.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springboot.mybatis.commonMapper.model.Role;

@Controller
@RequestMapping("/Freemaker")
public class FreemarkerController {

	 @RequestMapping("/list")
	    public ModelAndView list(){
	        ModelAndView mv = new ModelAndView();
	        List list = new ArrayList();
	        list.add(new Role("1","普通用户"));
	        list.add(new Role("2","会员"));
	        list.add(new Role("3","超级会员"));
	        //添加值
	        mv.addObject("loginName","张三");
	        mv.addObject("roleList",list);
	        mv.addObject("name","zs");
	        mv.setViewName("freemaker_list"); //设置返回页面
	        return mv;
	    }
}
