package com.idempotent.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2019-09-12 15:56
 */
public class LoginLog implements Serializable {

    private Integer id;

    private Integer userId;

    private Integer type;

    private String description;

    private Date createTime;

    private Date updateTime;

    /**
     * 消息id
     */
    private String msgId;

    public LoginLog() {
    }

    public LoginLog(Integer id, Integer userId, Integer type, String description, Date createTime, Date updateTime, String msgId) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.msgId = msgId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", msgId='" + msgId + '\'' +
                '}';
    }
}
