package com.vo;

import java.io.Serializable;

public class TaskLogVo implements Serializable{
    String date;
    String status;
    String statComment;
    int taskId;

    public String getDate() {
	return date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getStatComment() {
	return statComment;
    }

    public void setStatComment(String statComment) {
	this.statComment = statComment;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getTaskId() {
       return taskId;
    }

}
