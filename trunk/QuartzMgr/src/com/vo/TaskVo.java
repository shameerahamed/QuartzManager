package com.vo;

import java.io.Serializable;

public class TaskVo implements Serializable {
    int taskId;
    String taskName;
    String taskDesc;
    String expStartDttm;
    String expEndDttm;
    String actStartDttm;
    String actEndDttm;
    int priority;
    int completePer;
    int isDeviated;
    String status;
    String devDttm;
    String devReason;

    public int getTaskId() {
	return taskId;
    }

    public void setTaskId(int taskId) {
	this.taskId = taskId;
    }

    public String getTaskName() {
	return taskName;
    }

    public void setTaskName(String taskName) {
	this.taskName = taskName;
    }

    public String getTaskDesc() {
	return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
	this.taskDesc = taskDesc;
    }

    public String getExpStartDttm() {
	return expStartDttm;
    }

    public void setExpStartDttm(String expStartDttm) {
	this.expStartDttm = expStartDttm;
    }

    public String getExpEndDttm() {
	return expEndDttm;
    }

    public void setExpEndDttm(String expEndDttm) {
	this.expEndDttm = expEndDttm;
    }

    public String getActStartDttm() {
	return actStartDttm;
    }

    public void setActStartDttm(String actStartDttm) {
	this.actStartDttm = actStartDttm;
    }

    public String getActEndDttm() {
	return actEndDttm;
    }

    public void setActEndDttm(String actEndDttm) {
	this.actEndDttm = actEndDttm;
    }

    public int getPriority() {
	return priority;
    }

    public void setPriority(int priority) {
	this.priority = priority;
    }

    public int getCompletePer() {
	return completePer;
    }

    public void setCompletePer(int completePer) {
	this.completePer = completePer;
    }

    public int getIsDeviated() {
	return isDeviated;
    }

    public void setIsDeviated(int isDeviated) {
	this.isDeviated = isDeviated;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getDevDttm() {
	return devDttm;
    }

    public void setDevDttm(String devDttm) {
	this.devDttm = devDttm;
    }

    public String getDevReason() {
	return devReason;
    }

    public void setDevReason(String devReason) {
	this.devReason = devReason;
    }

}
