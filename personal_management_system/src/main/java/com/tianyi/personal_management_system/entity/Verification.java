package com.tianyi.personal_management_system.entity;

import lombok.Data;

/**
 * @author chengang
 * @version 1.0
 * @date 2020/4/4 16:46
 * 验证码基础对象
 */
@Data
public class Verification {
    /**
     * base64编码的图形验证码格式
     */
    private String imgStr;
}
