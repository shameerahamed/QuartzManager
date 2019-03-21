package com.dao;

import java.util.List;

import com.form.LoginForm;
import com.sun.jmx.snmp.UserAcl;
import com.vo.UserVo;

public interface UserDao {	
	public void getuser(LoginForm loginForm);
}
