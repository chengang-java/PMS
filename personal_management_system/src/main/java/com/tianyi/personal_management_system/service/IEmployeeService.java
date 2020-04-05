package com.tianyi.personal_management_system.service;

import com.tianyi.personal_management_system.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tianyi.personal_management_system.entity.Taken;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chen
 * @since 2020-04-04
 */
public interface IEmployeeService extends IService<Employee> {
    /**
     *
     * @param mobile 登录手机号
     * @param password 登录密码
     * @param code 验证码
     * @return
     */
   Taken  employeeLogin(String mobile,String password,String code);

    /**
     * 注册接口
     * @param employee
     * @return
     */
   Boolean employeeSign(Employee employee);
    /**
     * 修改用户信息
     */
    Boolean updateEmployeeMsg(Employee employee);
    /**
     * 注销登录
     */
    Boolean loginOut(String mobile);

    /**
     * 重置密码
     * @param password
     * @param key 密保key
     * @return
     */
    Boolean updatePassword(String mobile, String password, String key);
}
