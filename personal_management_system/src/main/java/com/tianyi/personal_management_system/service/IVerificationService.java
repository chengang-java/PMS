package com.tianyi.personal_management_system.service;

import com.tianyi.personal_management_system.entity.Verification;

/**
 * @author chengang
 * @version 1.0
 * @date 2020/4/4 16:45
 * 图形验证码的服务service
 */

public interface IVerificationService {
    /**
     * 获取验证码
     * @return
     */
    Verification getVerificode();

    /**
     * 校验验证码
     * @return
     */
    Boolean checkVerficode();
}
