package com.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.vo.TaskLogVo;
import com.vo.TaskVo;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.dao.TaskDao;
import com.form.TaskForm;
import com.vo.SearchVo;

public class TaskDaoImpl extends SqlMapClientDaoSupport implements TaskDao {

    @Override
    public void insertTask(TaskForm taskForm) {
    	TaskVo taskVo = (TaskVo) getSqlMapClientTemplate().insert("TodoApp.insertTask", taskForm);

    	taskVo.setStatComment(taskForm.getStatComment());
    	insertTaskLog(taskVo);

    }

    @Override
    public void insertTaskLog(TaskVo taskVo) {
        TaskLogVo taskLogVo = new TaskLogVo();
        taskLogVo.setStatComment(taskVo.getStatComment());
        taskLogVo.setStatus(taskVo.getStatus());
        taskLogVo.setTaskId(taskVo.getTaskId());

        getSqlMapClientTemplate().insert("TodoApp.insertTaskLog", taskLogVo);
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

        TaskVo taskVo = new TaskVo();
        taskVo.setStatComment(taskForm.getStatComment());
        taskVo.setStatus(String.valueOf(taskForm.getStatusCode()));
        taskVo.setTaskId(taskForm.getTaskId());

        insertTaskLog(taskVo);
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
