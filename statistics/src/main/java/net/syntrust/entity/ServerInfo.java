package net.syntrust.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ServerInfo implements Serializable {

    // id
    private Integer id;
    // 机房编号
    private String serverCode;
    // 机房
    private String machineRoomName;
    // 内存
    private String memory;
    // 硬盘
    private String hardDisk;
    // 系统
    private String system;
    // ip
    private String ipAddress;
    // 带宽
    private String netWorkBandWidth;
    // 用户名
    private String userName;
    // 密码
    private String passWord;
    // 访问限制
    private String accessRestriction;
    // 备注
    private String remarks;
    // 项目（对应部署项目，存项目编号）
    private String projectInfo;
    // 创建时间
    private Date gmtCreate;
    // 修改时间
    private Date gmtModified;
    // 是否删除默认0，1表示软删除
    private Integer isDel;

}
