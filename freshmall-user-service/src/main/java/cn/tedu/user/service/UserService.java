package cn.tedu.user.service;

import java.util.UUID;

import com.fresh.common.pojo.User;
import com.fresh.common.utils.MapperUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.tedu.user.mapper.UserMapper;

import redis.clients.jedis.JedisCluster;


@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public Boolean checkUserName(String checkUserName) {
		int result = userMapper.selectUserCountByUserName(checkUserName);
		return result == 1;
	}

	public void saveUser(User user) {

			user.setUserId(UUID.randomUUID().toString());
			String md5Password = DigestUtils.md5Hex(user.getUserPassword());
			System.out.println("密码密文" + md5Password);
			user.setUserPassword(md5Password);
			userMapper.insertUser(user);
	}


	@Autowired
	private JedisCluster jedis;
	public String doLogin(User user) {
			/**
			 * 登录校验
			 */
		user.setUserPassword(DigestUtils.md5Hex(user.getUserPassword()));
		User exist = userMapper.selectUserByUserNameAndPassword(user);
		if (exist == null) {
			// 登录失败
			return "";
		} else {
			// 引入顶替的逻辑
			try {
				String userLoginIdent = "user_login_" + exist.getUserId();
				String ticket = "EM_TICKET" + System.currentTimeMillis() + exist.getUserId();
				String userJson = MapperUtil.MP.writeValueAsString(exist);
				if (jedis.exists(userLoginIdent)) {
					//顶替
					//删除上次登录的,新增
					jedis.del(jedis.get(userLoginIdent));
				}
				//设置数据
				jedis.setex(userLoginIdent, 60 * 60 * 3, ticket);
				jedis.setex(ticket, 60 * 60 * 2, userJson);
				return ticket;
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
	}
	public String checkLoginUserData(String ticket) {
		//要保证userLoginIdent的时间要大于ticket
		String userLoginIdent="user_login_"+ticket.substring(22);
		// Jedis jedis=new Jedis("10.42.62.159",6380);
		// ShardedJedis jedis=pool.getResource();
		Long leftTime = jedis.pttl(ticket);
		if(leftTime<1000*60*30){
			//进行续约
			Long expireTime=leftTime+1000*60*60;
			jedis.pexpire(ticket,expireTime);
			jedis.pexpire(userLoginIdent,60*60*1000);
		}
		return jedis.get(ticket);
	}
}
