package com.form;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.utils.DateUtils;

/**
 * @author sham1778
 * 
 */
public class TaskForm extends ActionForm {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int userId;
    int taskId;
    String taskName;
    String taskDesc;
    String expStartDttm;
    String expEndDttm;
    String actStartDttm;
    String actEndDttm;
    int priority;
    Integer completePer;
    int isDeviated;
    int statusCode;
    String devDttm;
    String devReason;
    String statComment;

    ArrayList taskList;
    ArrayList logList;

    public ArrayList getLogList() {
        return logList;
    }

    public void setLogList(ArrayList logList) {
        this.logList = logList;
    }

    public ArrayList getTaskList() {
	return taskList;
    }

    public void setTaskList(ArrayList taskList) {
	this.taskList = taskList;
    }

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

    public String getTaskDesc() {
	return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
	this.taskDesc = taskDesc;
    }

    public String getExpStartDttm() {
	/*
	 * if(!expStartDttm.isEmpty()) { return
	 * DateUtils.formatDate(expStartDttm); }
	 */
	return expStartDttm;
    }

    public void setExpStartDttm(String expStartDttm) {
	this.expStartDttm = expStartDttm;
    }

    public String getExpEndDttm() {
	/*
	 * if(!expEndDttm.isEmpty()) { return DateUtils.formatDate(expEndDttm);
	 * }
	 */
	return expEndDttm;
    }

    public void setExpEndDttm(String expEndDttm) {
	this.expEndDttm = expEndDttm;
    }

    public String getActStartDttm() {
	/*
	 * if(!actStartDttm.isEmpty()) { return
	 * DateUtils.formatDate(actStartDttm); }
	 */
	return actStartDttm;
    }

    public void setActStartDttm(String actStartDttm) {
	this.actStartDttm = actStartDttm;
    }

    public String getActEndDttm() {
	/*
	 * if(!actEndDttm.isEmpty()) { return DateUtils.formatDate(actEndDttm);
	 * }
	 */
	return actEndDttm;
    }

    public void setActEndDttm(String actEndDttm) {
	this.actEndDttm = actEndDttm;
    }

    public String getDevDttm() {	
	/*Long millis = new Long(devDttm);	
	devDttm = String.format("%d hrs %d min, %d sec",
		    TimeUnit.MILLISECONDS.toHours(millis),
		    TimeUnit.MILLISECONDS.toMinutes(millis),
		    TimeUnit.MILLISECONDS.toSeconds(millis) - 
		    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
		);*/
        return devDttm;
    }
    
    public String getDisplayDevDttm() {	
	Long millis = new Long(devDttm);	
	if(millis < 0)
        {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        StringBuilder sb = new StringBuilder(64);
        sb.append(days);
        sb.append(" Days ");
        sb.append(hours);
        sb.append(" Hours ");
        sb.append(minutes);
        sb.append(" Minutes ");
        sb.append(seconds);
        sb.append(" Seconds");

        return(sb.toString());
    }

    public void setDevDttm(String devDttm) {
        this.devDttm = devDttm;
    }

    public int getPriority() {
	return priority;
    }

    public void setPriority(int priority) {
	this.priority = priority;
    }

    public Integer getCompletePer() {
	return completePer;
    }

    public void setCompletePer(Integer completePer) {
	this.completePer = completePer;
    }

    public int getIsDeviated() {
	return isDeviated;
    }

    public void setIsDeviated(int isDeviated) {
	this.isDeviated = isDeviated;
    }

    public int getStatusCode() {
	return statusCode;
    }

    public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
    }

    public String getDevReason() {
	return devReason;
    }

    public void setDevReason(String devReason) {
	this.devReason = devReason;
    }

    public int getTaskId() {
	return taskId;
    }

    public void setTaskId(int taskId) {
	this.taskId = taskId;
    }

    public String getStatComment() {
	return statComment;
    }

    public void setStatComment(String statComment) {
	this.statComment = statComment;
    }

    public void resetForm(ActionMapping mapping, HttpServletRequest request) {
	    taskId = 0;
	    taskName = null;
	    taskDesc = null;
	    expStartDttm  = null;
	    expEndDttm  = null;
	    actStartDttm = null;
	    actEndDttm = null;
	    priority = 0;
	    completePer = null;
	    isDeviated = 0;
	    statusCode = 0;
	    devDttm  = null;
	    devReason  = null;
	    statComment = null;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
        if(getTaskName().isEmpty()) {
            errors.add(null, new ActionError("errors.required", "Task Name"));
        }
        
        if (getExpStartDttm().isEmpty()) {
            errors.add(null,new ActionError("errors.required", "Expected Start DTTM"));
        } else {
            if(DateUtils.textToDate(getExpStartDttm()) == null) {
        	errors.add(null,new ActionError("errors.date", "Expected Start DTTM"));
            }
        }
        
        if (getExpEndDttm().isEmpty()) {
            errors.add(null,new ActionError("errors.required", "Expected End DTTM"));
        } else {
            if(DateUtils.textToDate(getExpEndDttm()) == null) {
        	errors.add(null,new ActionError("errors.date", "Expected End DTTM"));
            }
        }
        //!getExpStartDttm().isEmpty() && !getExpEndDttm().isEmpty()
        if((!getTaskName().isEmpty() && errors.size() == 0) || (getTaskName().isEmpty() && errors.size() == 1)) {
            if(DateUtils.compareDate(expStartDttm, expEndDttm) > 0) {
                errors.add(null, new ActionError("date.greater","Expected End DTTM","Expected Start DTTM"));
            }
        }
        
        if(!getActStartDttm().isEmpty()) {
            if(DateUtils.textToDate(getActStartDttm()) == null) {
        	errors.add(null,new ActionError("errors.date", "Actual End DTTM"));
            }
        }
        
        if(!getActEndDttm().isEmpty()) {
            if(DateUtils.textToDate(getActEndDttm()) == null) {
        	errors.add(null,new ActionError("errors.date", "Actual End DTTM"));
            }
        }
        
        if(!getActStartDttm().isEmpty() && !getActEndDttm().isEmpty()  && errors.size() == 0) {
            if(DateUtils.compareDate(expStartDttm, expEndDttm) > 0) {
                errors.add(null, new ActionError("date.greater","Actual End DTTM","Actual Start DTTM"));
            }
        }
        
        if(getStatusCode() == 3) {
           if(getStatComment().isEmpty()) {
               errors.add(null,new ActionError("errors.required","For OnHold Status - Comment"));
           }
        }
        
        return errors;
    }
}

