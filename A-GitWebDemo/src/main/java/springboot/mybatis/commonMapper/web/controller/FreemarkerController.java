package springboot.mybatis.commonMapper.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springboot.mybatis.commonMapper.model.Role;
import springboot.mybatis.commonMapper.model.Stu;

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
	        Map<String, String> lqmxMap = new HashMap<String, String>();
	        lqmxMap.put("23", "詹姆斯");
	        lqmxMap.put("24", "科比");
	        lqmxMap.put("34", "字母哥");
	        mv.addObject("lqmxMap",lqmxMap);
	        mv.setViewName("freemarker_list"); //设置返回页面
	        return mv;
	    }
	 
	 //https://blog.csdn.net/weixin_44100514/article/details/86321592
	 @RequestMapping("/toIndex")
	    public ModelAndView free(){
	        ModelAndView mv = new ModelAndView();
	        mv.setViewName("index");//设置返回页面
	        Stu stu = new Stu();
	        stu.setStuId(1);
	        stu.setStuName("<font color='red'>zxf</font>"); 
	        /*stu.setStuAge(18);*/
	        stu.setStuSex(true);
	        stu.setStuDate(new Date());
	        mv.addObject("stu1",stu);

	        List<Integer> list = new ArrayList<>();
	        list.add(1);
	        list.add(2);
	        list.add(3);
	        list.add(4);
	        mv.addObject("list1",list);

	        Map<String,String> map = new HashMap<>();
	        map.put("a","a1");
	        map.put("b","b1");
	        map.put("c","c1");
	        map.put("d","d1");
	        map.put("e","e1");
	        mv.addObject("map1",map);
	        return mv;
	    }
}
