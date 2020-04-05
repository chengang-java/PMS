package com.tianyi.personal_management_system.controller;


import com.tianyi.personal_management_system.consts.PsmRedisConsts;
import com.tianyi.personal_management_system.entity.Employee;
import com.tianyi.personal_management_system.entity.Taken;
import com.tianyi.personal_management_system.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chen
 * @since 2020-04-04
 */
@RestController
@RequestMapping("//employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @PostMapping("/login")
    public Taken login(String mobile, String password, String key){
       return employeeService.employeeLogin(mobile,password,key);
    }

    @PostMapping("/updateEmp")
    public Boolean updateEmployeeMsg(Employee employee){
        return employeeService.updateEmployeeMsg(employee);
    }

    @PutMapping("/resetPwd")
    public Boolean reset(String mobile, String password, String key){
        return employeeService.updatePassword( mobile,  password, key);
    }

    @DeleteMapping("/loginOut")
    public Boolean loginOut(String mobile) {
        employeeService.loginOut(mobile);
        return true;
    }
}
