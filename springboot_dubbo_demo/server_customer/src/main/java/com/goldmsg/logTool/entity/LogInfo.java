package com.goldmsg.logTool.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenjinxing on 2019/8/5.
 */
@Document(collection = "audio_tb_gmvcs_base_log_record")
public class LogInfo implements Serializable {
    @Id
    @Field("id")
    private String id;                          // 日志唯一标识(id)

    //在哪个时间，哪个类中发生了什么事情
    @Field("logTime")
    private Date logTime;                       // 日志发生时间（*****）
    @Field("log_action")
    private String log_action;                  // 日志操作行为（*****）
    @Field("log_msg")
    private String log_msg;                     // 日志全部信息（*****）
    @Field("request_ip")
    private String request_ip;                  // 请求ip
    @Field("type")
    private Integer type;                       // 日志类型，0：，1：，2：，3：  4：其他 5-99：预留
    @Field("size")
    private String size;                        // 日志大小，单位BYTE
    @Field("user_name")
    private String user_name;                   // 警员名称  （*****）
    @Field("user_code")
    private String user_code;                   // 警员编号
    @Field("org_name")
    private String org_name;                    // 部门名称 （*****）
    @Field("org_code")
    private String org_code;                    // 部门编号
    @Field("org_path")
    private String org_path;                    // 部门路径
    @Field("device_name")
    private String device_name;                 // 设备名称 （*****）
    @Field("device_code")
    private String device_code;                 // 设备编号
    @Field("device_userCode")
    private String device_userCode;             // 设备所属警员警号（*****）
    @Field("device_userName")
    private String device_userName;             // 设备所属警员姓名（*****）
    @Field("device_orgName")
    private String device_orgName;              // 设备所属部门名称（*****）
    @Field("device_orgCode")
    private String device_orgCode;              // 设备所属部门编号（*****）
    @Field("manufacturer")
    private String manufacturer;                // 平台信息 （*****）
    @Field("insertTime")
    private Date insertTime;                    // 记录插入时间 (入库时间)
    @Field("log_beginTime")
    private Date log_beginTime;               // 日志操作开始时间（*****）
    @Field("log_endTime")
    private Date log_endTime;                 // 日志操作结束时间（*****）
    @Field("remark")
    private String remark;                      // 备注
    @Field("is_deleted")
    private String is_deleted;                  // 删除状态，0表示正常，1表示已删除

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
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

    public String getRequest_ip() {
        return request_ip;
    }

    public void setRequest_ip(String request_ip) {
        this.request_ip = request_ip;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public String getOrg_path() {
        return org_path;
    }

    public void setOrg_path(String org_path) {
        this.org_path = org_path;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }


}
