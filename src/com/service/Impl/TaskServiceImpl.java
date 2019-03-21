package com.service.Impl;

import java.util.List;

import com.dao.TaskDao;
import com.form.SearchForm;
import com.form.TaskForm;
import com.service.TaskService;
import com.vo.SearchVo;

public class TaskServiceImpl implements TaskService {
    private TaskDao taskDao;

    public TaskDao getTaskDao() {
	return taskDao;
    }

    public void setTaskDao(TaskDao taskDao) {
	this.taskDao = taskDao;
    }

    @Override
    public void insertTask(TaskForm taskForm) {
	taskDao.insertTask(taskForm);
    }

    @Override
    public List getAllTask() {
	return taskDao.getAllTask();
    }

    @Override
    public List getTaskBySearch(SearchVo searchVo) {
	return taskDao.getTaskBySearch(searchVo);
    }

    @Override
    public void updateTask(TaskForm taskForm) {
	taskDao.updateTask(taskForm);
    }

    @Override
    public void populateTask(Integer taskId, TaskForm taskForm) {
	taskDao.populateTask(taskId, taskForm);
    }

    @Override
    public List getTodayTask(Integer userId) {
	return taskDao.getTodayTask(userId);
    }

    @Override
    public List getAlertTask(Integer userId) {	
	return taskDao.getAlertTask(userId);
    }

}
