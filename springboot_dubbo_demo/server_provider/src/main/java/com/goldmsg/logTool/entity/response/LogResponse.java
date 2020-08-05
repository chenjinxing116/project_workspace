package com.goldmsg.logTool.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by chenjinxing on 2019/8/5.
 */
@ApiModel(value = "LogResponse", description = "日志结果结果类")
public class LogResponse {
    private Date logTime;                       // 日志时间（*****）

    @ApiModelProperty(value = "平台信息")
    private String manufacturer;                // 平台信息 （*****）
    @ApiModelProperty(value = "登录警员部门编码")
    private String org_code;                    // 登录警员部门编码（*****）
    @ApiModelProperty(value = "登录警员部门名称")
    private String org_name;                    // 登录警员部门名称（*****）
    @ApiModelProperty(value = "警员名称")
    private String user_name;                   // 警员名称  （*****）
    @ApiModelProperty(value = "登录警员警号")
    private String user_code;                   // 登录警员警号
    @ApiModelProperty(value = "设备名称")
    private String device_name;                 // 设备名称 （*****）
    @ApiModelProperty(value = "设备编号")
    private String device_code;                 // 设备编号（*****）
    @ApiModelProperty(value = "设备所属警员警号")
    private String device_userCode;             // 设备所属警员警号（*****）
    @ApiModelProperty(value = "设备所属警员姓名")
    private String device_userName;             // 设备所属警员姓名（*****）
    @ApiModelProperty(value = "设备所属部门名称")
    private String device_orgName;              // 设备所属部门名称（*****）
    @ApiModelProperty(value = "设备所属部门编号")
    private String device_orgCode;              // 设备所属部门编号（*****）
    @JsonIgnore
    @ApiModelProperty(value = "记录插入时间")
    private Date insertTime;                    // 记录插入时间 (入库时间)（*****）
    @ApiModelProperty(value = "日志操作行为")
    private String log_action;                  // 日志操作行为（*****）
    @ApiModelProperty(value = "日志全部信息")
    private String log_msg;                     // 日志全部信息（*****）
    @ApiModelProperty(value = "日志操作开始时间")
    private Date log_beginTime;               // 日志操作开始时间（*****）
    @ApiModelProperty(value = "日志操作结束时间")
    private Date log_endTime;                 // 日志操作结束时间（*****）

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDevice_code() {
        return device_code;
    }

    public void setDevice_code(String device_code) {
        this.device_code = device_code;
    }

    public String getDevice_userCode() {
        return device_userCode;
    }

    public void setDevice_userCode(String device_userCode) {
        this.device_userCode = device_userCode;
    }

    public String getDevice_userName() {
        return device_userName;
    }

    public void setDevice_userName(String device_userName) {
        this.device_userName = device_userName;
    }

    public String getDevice_orgName() {
        return device_orgName;
    }

    public void setDevice_orgName(String device_orgName) {
        this.device_orgName = device_orgName;
    }

    public String getDevice_orgCode() {
        return device_orgCode;
    }

    public void setDevice_orgCode(String device_orgCode) {
        this.device_orgCode = device_orgCode;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getLog_action() {
        return log_action;
    }

    public void setLog_action(String log_action) {
        this.log_action = log_action;
    }

    public String getLog_msg() {
        return log_msg;
    }

    public void setLog_msg(String log_msg) {
        this.log_msg = log_msg;
    }

    public Date getLog_beginTime() {
        return log_beginTime;
    }

    public void setLog_beginTime(Date log_beginTime) {
        this.log_beginTime = log_beginTime;
    }

    public Date getLog_endTime() {
        return log_endTime;
    }

    public void setLog_endTime(Date log_endTime) {
        this.log_endTime = log_endTime;
    }
}
