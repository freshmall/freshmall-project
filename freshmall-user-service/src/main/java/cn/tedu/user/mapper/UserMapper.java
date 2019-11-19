package cn.tedu.user.mapper;


import com.fresh.common.pojo.User;

public interface UserMapper {

	int selectUserCountByUserName(String userName);

	void insertUser(User user);

	User selectUserByUserNameAndPassword(User user);
	
}
