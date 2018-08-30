package net.syntrust.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class InterfaceInfo implements Serializable {

    //id
    private Integer id;
    //接口编号
    private String interfaceCode;
    // 接口说明
    private String interfaceDescription;
    // 地址
    private String interfaceAddress;
    // 请求类型
    private String requestType;
    // 入参
    private String entryParameters;
    // 结果
    private String results;
    // 所属项目
    private String projectBelong;
    // 备注
    private String remarks;
    // 创建时间
    private Date gmtCreate;
    // 修改时间
    private Date gmtModified;
    // 是否删除默认0，1表示软删除
    private Integer isDel;

}
