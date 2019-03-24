package com.dao;

import java.util.List;

import com.form.SearchForm;
import com.form.TaskForm;
import com.vo.SearchVo;
import com.vo.TaskLogVo;
import com.vo.TaskVo;

public interface TaskDao {
    public void insertTask(TaskForm taskForm);

    public void updateTask(TaskForm taskForm);
    
    public void populateTask(Integer taskId,TaskForm taskForm);
    
    public List getAllTask();
    
    public List getTaskBySearch(SearchVo searchVo);

    public List getTodayTask(Integer userId);
    
    public List getAlertTask(Integer userId);

    public void insertTaskLog(TaskVo taskVo);
}
