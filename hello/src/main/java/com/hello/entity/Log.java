package com.hello.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by xuan on 2015/12/31.
 */
@Entity
@Table(name = "log")
public class Log {
    private Integer id;

    private String userId;
    private String userIp;
    private String className;      //类名
    private String methodName;    //方法名
    private String time;

    public Log() {
    }

    public Log(Integer id, String userId, String userIp, String className, String methodName, String time) {
        this.id = id;
        this.userId = userId;
        this.userIp = userIp;
        this.className = className;
        this.methodName = methodName;
        this.time = time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userIp='" + userIp + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
