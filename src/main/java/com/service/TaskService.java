package com.service;

import java.util.List;
import com.form.TaskForm;
import com.vo.SearchVo;

public interface TaskService {
    public void insertTask(TaskForm taskForm);

    public void updateTask(TaskForm taskForm);
    
    public void populateTask(Integer taskId,TaskForm taskForm);
    
    public List getAllTask();
    
    public List getTaskBySearch(SearchVo searchVo);

    // To get today's task
    public List getTodayTask(Integer userId);

    public List getAlertTask(Integer userId);
}
