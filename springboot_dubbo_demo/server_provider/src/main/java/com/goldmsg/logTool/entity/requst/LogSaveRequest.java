package com.goldmsg.logTool.entity.requst;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel(value = "RelevanceFileRequest", description = "日志保存请求实体")
public class LogSaveRequest {

    @NotNull
    @ApiModelProperty(value = "日志操作开始时间", required = true)
    private Date log_beginTime;                    // 开始时间（*****）
    @NotNull
    @ApiModelProperty(value = "日志操作结束时间", required = true)
    private Date log_endTime;                      // 结束时间（*****）
    @NotNull
    @ApiModelProperty(value = "平台信息", required = true)
    private String manufacturer;                // 平台信息 （*****）
    @NotNull
    @ApiModelProperty(value = "登录警员部门编码", required = true)
    private String org_code;                    // 登录警员部门编码（*****）
    @NotNull
    @ApiModelProperty(value = "警员名称", required = true)
    private String user_name;                   // 警员名称  （*****）
    @NotNull
    @ApiModelProperty(value = "登录警员警号", required = true)
    private String user_code;                   // 登录警员警号
    @NotNull
    @ApiModelProperty(value = "设备名称", required = true)
    private String device_name;                 // 设备名称 （*****）
    @NotNull
    @ApiModelProperty(value = "设备编号", required = true)
    private String device_code;                 // 设备编号（*****）

    @ApiModelProperty(value = "日志操作行为 optional", required = true)
    private String log_action;                  // 日志操作行为（*****）
    @NotNull
    @ApiModelProperty(value = "日志全部信息", required = true)
    private String log_msg;                     // 日志全部信息（*****）

//    @ApiModelProperty(value = "记录插入时间", required = true)
//    private Date insertTime;                    // 记录插入时间 (入库时间)（*****）

//    private Integer type;                       // 日志类型，0：，1：，2：，3：  4：其他 5-99：预留
//
//    private String request_ip;                  // 请求ip
//
//    private String size;                        // 日志大小，单位BYTE
//
//    private String org_name;                    // 部门名称 （*****）
//    private String org_path;                    // 部门路径
//
//    private String remark;                      // 备注
//
//    private String is_deleted;                  // 删除状态，0表示正常，1表示已删除

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
}
