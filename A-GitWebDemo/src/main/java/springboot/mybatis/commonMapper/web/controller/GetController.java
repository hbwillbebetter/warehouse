package springboot.mybatis.commonMapper.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.xmlrpc.base.Params;

import springboot.mybatis.commonMapper.model.MyException;
import springboot.mybatis.commonMapper.model.User2;
@RestController
public class GetController {
	final Map<String, String> params = new HashMap<String, String>();
	@RequestMapping(value="/api/v1/account")
	public Object account(HttpServletRequest request){
		request.setAttribute("name", "springboot");
		params.put("money", "1000");
		return params;
	}
	
	
}