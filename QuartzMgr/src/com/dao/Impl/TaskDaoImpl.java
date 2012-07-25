package com.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.dao.TaskDao;
import com.form.SearchForm;
import com.form.TaskForm;
import com.vo.SearchVo;

public class TaskDaoImpl extends SqlMapClientDaoSupport implements TaskDao {

    @Override
    public void insertTask(TaskForm taskForm) {
	getSqlMapClientTemplate().insert("TodoApp.insertTask", taskForm);
    }

    @Override
    public List getAllTask() {
	return getSqlMapClientTemplate().queryForList("TodoApp.getAllTask");
    }

    @Override
    public List getTaskBySearch(SearchVo searchVo) {
	return getSqlMapClientTemplate().queryForList("TodoApp.getSearchTask",
		searchVo);
    }

    @Override
    public void updateTask(TaskForm taskForm) {
	getSqlMapClientTemplate().update("TodoApp.updateTask", taskForm);
    }

    @Override
    public void populateTask(Integer taskId, TaskForm taskForm) {
	getSqlMapClientTemplate().queryForObject("TodoApp.populateTask",
		taskId, taskForm);
	
	if(taskForm.getDevDttm()!=null) {
	    taskForm.setIsDeviated(1);
	}

	ArrayList logList = (ArrayList) getSqlMapClientTemplate().queryForList(
		"TodoApp.populateLog", taskId);
	taskForm.setLogList(logList);
    }

    @Override
    public List getTodayTask(Integer userId) {
	return getSqlMapClientTemplate().queryForList("TodoApp.getTodayTask",userId);
    }

    @Override
    public List getAlertTask(Integer userId) {
	return getSqlMapClientTemplate().queryForList("TodoApp.getAlertTask",userId);
    }
    
    
}
