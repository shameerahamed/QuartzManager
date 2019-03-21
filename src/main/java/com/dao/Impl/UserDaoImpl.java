package com.dao.Impl;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;
import java.util.logging.*;

import com.dao.UserDao;
import com.form.LoginForm;
import com.vo.UserVo;

public class UserDaoImpl extends SqlMapClientTemplate implements UserDao {
    private static Logger logger = Logger.getLogger("UserDaoImpl");

    @Override
    public void getuser(LoginForm loginForm) {
	queryForObject("TodoApp.getLoginUser", loginForm, loginForm);

    }

}
