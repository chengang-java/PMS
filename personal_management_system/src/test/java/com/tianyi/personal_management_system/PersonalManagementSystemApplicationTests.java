package com.tianyi.personal_management_system;

import com.tianyi.personal_management_system.service.impl.EmployeeSecurityServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonalManagementSystemApplicationTests {
    @Autowired
    private EmployeeSecurityServiceImpl employeeSecurityService;
    @Test
    void contextLoads() {
        CodeGenerator codeGenerator=new CodeGenerator();
        codeGenerator.generate();
    }
    @Test
    void testServiceImpl(){
        employeeSecurityService.addEmployeeKey("123456","1");
    }
}
