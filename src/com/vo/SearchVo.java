package com.vo;

import java.io.Serializable;

public class SearchVo implements Serializable {

    int userId;
    String taskName;
    String taskDate;
    String status;
    int priority;

    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
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

}
