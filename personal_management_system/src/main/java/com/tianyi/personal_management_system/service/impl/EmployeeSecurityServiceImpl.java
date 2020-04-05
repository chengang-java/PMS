package com.tianyi.personal_management_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tianyi.personal_management_system.entity.EmployeeSecurity;
import com.tianyi.personal_management_system.mapper.EmployeeSecurityMapper;
import com.tianyi.personal_management_system.service.IEmployeeSecurityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 雇员密保用于密码找回 服务实现类
 * </p>
 *
 * @author chen
 * @since 2020-04-04
 */
@Service
public class EmployeeSecurityServiceImpl extends ServiceImpl<EmployeeSecurityMapper, EmployeeSecurity> implements IEmployeeSecurityService {

    @Override
    public String getEmployeeKey(String employeeId) {
        return baseMapper.selectOne(new QueryWrapper<EmployeeSecurity>()
                .lambda()
                .eq(EmployeeSecurity::getEmployeeId, employeeId)).getEmployeeKey();
    }

    @Override
    public Boolean addEmployeeKey(String employeeKey, String employeeId) {
        EmployeeSecurity employeeSecurity = new EmployeeSecurity();
        employeeSecurity.setEmployeeId(employeeId);
        employeeSecurity.setEmployeeKey(employeeKey);
        baseMapper.insert(employeeSecurity);
        return true;
    }
}
