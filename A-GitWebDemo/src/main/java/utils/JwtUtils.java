package utils;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import springboot.mybatis.commonMapper.model.User;

/*
 * https://www.cnblogs.com/wangjunwei/p/11469564.html
 * 微服务下登录检验解决方案 JWT讲解
    简介：微服务下登录检验解决方案 JWT讲解 json wen token

        1、JWT 是一个开放标准，它定义了一种用于简洁，自包含的用于通信双方之间以 JSON 对象的形式安全传递信息的方法。
            JWT 可以使用 HMAC 算法或者是 RSA 的公钥密钥对进行签名

            简单来说，就是通过一定规范来生成token，然后可以通过解密算法逆向解密token，这样就可以获取用户信息
            {
                id:888,
                name:'小D',
                expire:10000
            }
            
            funtion 加密(object, appsecret){
                xxxx
                return base64( token);
            }

            function 解密(token ,appsecret){

                xxxx
                //成功返回true,失败返回false
            }

            优点：
                1）生产的token可以包含基本信息，比如id、用户昵称、头像等信息，避免再次查库

                2）存储在客户端，不占用服务端的内存资源

            缺点：
                token是经过base64编码，所以可以解码，因此token加密前的对象不应该包含敏感信息
                如用户权限，密码等

        2、JWT格式组成 头部、负载、签名
           header+payload+signature

           头部：主要是描述签名算法
           负载：主要描述是加密对象的信息，如用户的id等，也可以加些规范里面的东西，如iss签发者，exp 过期时间，sub 面向的用户
           签名：主要是把前面两部分进行加密，防止别人拿到token进行base解密后篡改token

        3、关于jwt客户端存储
            可以存储在cookie，localstorage和sessionStorage里面
 * 
 */
public class JwtUtils {

	//发行者
	public static final String SUBJECT = "xdclass";
	//过期时间
	public static final long EXPIRE = 1000*60*60*24*7;//过期时间，毫秒，一周
	//秘钥
	public static final String APPSECRET = "xd666";
	
	//加密
	public static String geneJsonWebToken(User user){
		//加上校验。用户实体和用户属性的判断
		if (user == null || user.getId() == null || user.getName() == null || user.getAge() == null) {
			return null;
		}
		/*
		 * 设置claim的值
			SetIsuseAt发行时间
			setExpiration:过期时间，
			signWith里面定义算法和密钥，最后compact使字符串紧密一下
		 */
		String token = Jwts.builder().setSubject(SUBJECT)
				.claim("id", user.getId())
				.claim("name", user.getName())
				.claim("age", user.getAge())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
				.signWith(SignatureAlgorithm.HS256, APPSECRET).compact();
		return token;
		
	}
	
	/**
	 * 校验token
	 * @param token
	 * @return
	 */
	public static Claims checkJWT(String token){
		try {
			final Claims claims = Jwts.parser().setSigningKey(APPSECRET)
					.parseClaimsJws(token).getBody();
			return claims;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
