package springboot.mybatis.commonMapper.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springboot.mybatis.commonMapper.model.User2;

//https://blog.csdn.net/qq_44676460/article/details/102969144

@Controller
@RequestMapping("/Thymeleaf")
public class ThymeleafController {

	@RequestMapping("/hello")
	public String hello(HttpServletRequest request, 
			@RequestParam(value="name", required=false, defaultValue="springboot-thymeleaf") String name){
		request.setAttribute("name", name);
		return "hello";
	}
	
	@RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        List list = new ArrayList();
        list.add(new User2("zs","123"));
        list.add(new User2("ls","456"));
        list.add(new User2("ww","789"));
        //添加值
        mv.addObject("uList",list);
        mv.addObject("msg","<span style='color:red'>hello spring!!!!!</span>");
        mv.addObject("name","zs");
        mv.setViewName("list"); //设置返回页面
        return mv;
    }


    @RequestMapping("/list2")
    public String list2(){
        return "list";
    }
}
