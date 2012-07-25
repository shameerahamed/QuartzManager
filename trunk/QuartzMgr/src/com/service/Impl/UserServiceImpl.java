package com.service.Impl;

import java.util.List;

import com.dao.UserDao;
import com.form.LoginForm;
import com.service.UserService;
import com.vo.UserVo;

public class UserServiceImpl implements UserService
{
	private UserDao userDao;
	
	public UserServiceImpl(UserDao userDao)
	{
		this.userDao = userDao;
	}

	@Override
	public void getuser(LoginForm loginForm)
	{
	    userDao.getuser(loginForm);
	}

}
