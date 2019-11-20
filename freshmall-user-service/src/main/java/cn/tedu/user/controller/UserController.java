package cn.tedu.user.controller;


import javax.servlet.http.Cookie;
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


@RestController
@RequestMapping("user/manage")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 用户名的校验
	 */
	@RequestMapping("checkUserName")
	public SysResult checkUserName(String userName){
		Boolean exist=userService.checkUserName(userName);
		//判断返回值
		if(exist){
			//说明用户名已经存在
            return SysResult.build(201,"用户名已经存在",null);

		}else{
            return SysResult.ok();
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

	@RequestMapping("/query/{ticket}")
	public SysResult checkLoginUserData(@PathVariable String ticket){
		String userJson=userService.checkLoginUserData(ticket);
		if(StringUtils.isNotEmpty(userJson)){
			//userJson非空 说明用户在登录
			return SysResult.build(200,"登录正常",userJson);
		}else{
			//说明用户没有登录
			return SysResult.build(201,"登录失效",null);
		}
	}

    /**
     * 退出功能
     * @param user 用户
     * @param req  请求
     * @param res  响应
     * @return
     */
    @RequestMapping("logout")
    public SysResult doLogout(User user, HttpServletRequest req, HttpServletResponse res){
        //获取cookie集合
        Cookie[] cookies = req.getCookies();
        String token = "";
        for(Cookie cookie:cookies){
            //获取名字叫EM_TICKET的cookie的value值
            if(cookie.getName().equals("EM_TICKET")){
                token = cookie.getValue();
            }
        }
        //将cookie的value值传入service层的jedis中
        userService.doLogout(token);
        try {
            //req.getRequestDispatcher("/index.html").forward(req, res);
            res.sendRedirect("http://www.freshgree.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysResult.ok();

    }
}
