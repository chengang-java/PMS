package com.tianyi.personal_management_system.consts;

/**
 * @author chengang
 * @version 1.0
 * @date 2020/4/4 16:48
 * 存储系统的redis固定命名key前缀
 */
public class PsmRedisConsts {
    /**
     * 存储用户信息redisKey="psm_redis_employee_msg"+mobile
     */
    public static final String PSM_REDIS_EMPLOYEE_MSG="psm_redis_employee_msg";
    /**
     * 存储用户的验证码五分钟,过时自动删除: "psm_redis_employee_key"+mobile
     */
    public static final String PSM_REDIS_EMPLOYEE_KEY="psm_redis_employee_key";
}
