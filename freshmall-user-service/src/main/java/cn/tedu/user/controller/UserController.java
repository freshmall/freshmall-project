package cn.tedu.user.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fresh.common.pojo.User;
import com.fresh.common.utils.CookieUtils;
import com.fresh.common.vo.SysResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.tedu.user.service.UserService;
import redis.clients.jedis.JedisCluster;


@RestController
@RequestMapping("user/manage")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 用户名的校验
	 */
	@RequestMapping("checkUserName")
	public void checkUserName(String userName){
		Boolean exist=userService.checkUserName(userName);
		//判断返回值
		if(exist){
			//不可用

		}else{

		}
	}
	/**
	 * 注册用户
	 */
	@RequestMapping("save")
	public void saveUser(User user){
		userService.saveUser(user);
	}
	/**
	 * 用户登录
	 *
	 */
	@RequestMapping("login")
	public SysResult doLogin(User user,HttpServletRequest req,HttpServletResponse res){
		String ticket=userService.doLogin(user);
		if(StringUtils.isNotEmpty(ticket)){
			CookieUtils.setCookie(req, res,"EM_TICKET",ticket);
			return SysResult.ok();
		}else{
			return SysResult.build(201,"登录失败",null);
		}
	}

	@RestController
	public static class ClusterController {
		@Autowired
		private JedisCluster jedis;
		@RequestMapping("cluster")
		public String setAndGet(String key,String value){
			jedis.set(key, value);
			return jedis.get(key);
		}
	}
	@RequestMapping("/query/{ticket}")
	public SysResult checkLoginUserData(@PathVariable String ticket){
		String userJson=userService.checkLoginUserData(ticket);
		if(StringUtils.isNotEmpty(userJson)){
			//非空 登录状态在生效
			return SysResult.build(200,"登录正常",userJson);
		}else{
			//说明登录失效
			return SysResult.build(201,"登录失效",null);
		}
	}
}
