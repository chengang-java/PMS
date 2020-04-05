package com.tianyi.personal_management_system.service;

import com.tianyi.personal_management_system.entity.EmployeeSecurity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 雇员密保用于密码找回 服务类
 * </p>
 *
 * @author chen
 * @since 2020-04-04
 */
public interface IEmployeeSecurityService extends IService<EmployeeSecurity> {
    /**
     * 获取密保
     * @param employeeId
     * @return
     */
   String getEmployeeKey(String employeeId);

    /**
     * 添加密保
     * @param EmployeeKey
     * @return
     */
   Boolean addEmployeeKey(String EmployeeKey,String employeeId);
}
