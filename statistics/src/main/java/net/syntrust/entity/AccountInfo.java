package net.syntrust.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AccountInfo implements Serializable {

    // id
    private Integer id;
    // 账户
    private String account;
    // 密码
    private String password;
    // 创建时间
    private Date gmtCreate;
    // 修改时间
    private Date gmtModified;
    // 是否删除默认0，1表示软删除
    private Integer isDel;

}
