package springboot.hello;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HelloController {
	@RequestMapping("/")
	public String hello(){
		return "Greetings from Spring Boot!";
	}

}

/**
 * @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
 * @RestController注解的使用：返回return内容，无法返回jsp页面。
 * 
 * 1.如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，
 * 配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 * 
 * 2.相当于@Controller+@ResponseBody两个注解的结合，返回json数据不需要在方法前面加@ResponseBody注解了，
 * 但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
 */
//@CrossOrigin
//@RestController /* @Controller + @ResponseBody*/
//class HospitalController {
//
//    //注入Service服务对象
//    @Autowired
//    private HospitalService hospitalService;
//
//    /**
//     * 查询所有医院信息（未分页）
//     */
//
//    @RequestMapping(value = "findAllHospital",method = RequestMethod.GET)
//    public  List<Hospital> findAllHospital(){
//        List<Hospital> hospitalList= hospitalService.findAllHospital();
//        return hospitalList;
//    }
//}


/**
 * @Controller注解的使用：在对应方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面；若返回json等内容到页面，则需要加@ResponseBody注解
 * 2.如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 * 
 * @ResponseBody注解的使用：
 * 3.如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
 * 
 *
 *
 */
//@CrossOrigin
//@Controller
//class FileUploadController {
//	// 跳转到上传文件的页面
//	@RequestMapping(value = "/gouploadimg", method = RequestMethod.GET)
//	public String goUploadImg() {
//		// 跳转到 templates 目录下的 uploadimg.html
//		return "uploadimg";
//	}
//
//	// 处理文件上传
//	@RequestMapping(value = "/testuploadimg", method = RequestMethod.POST)
//	public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
//		System.out.println("调用文件上传方法");
//		String contentType = file.getContentType();
//		String fileName = file.getOriginalFilename();
//		return null;
//	}
//}
