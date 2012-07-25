package com.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.vo.TaskVo;

public class SearchForm extends ActionForm {
    List taskList;

    int userId;
    String taskName;
    String taskDate;
    String status;
    int priority;

    public List getTaskList() {
	return taskList;
    }

    public void setTaskList(List taskList) {
	this.taskList = taskList;
    }

    public String getTaskName() {
	return taskName;
    }

    public void setTaskName(String taskName) {
	this.taskName = taskName;
    }

    public String getTaskDate() {
	return taskDate;
    }

    public void setTaskDate(String taskDate) {
	this.taskDate = taskDate;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public int getPriority() {
	return priority;
    }

    public void setPriority(int priority) {
	this.priority = priority;
    }

    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

}
