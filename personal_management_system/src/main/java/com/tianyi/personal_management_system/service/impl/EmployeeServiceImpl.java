package com.tianyi.personal_management_system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.tianyi.personal_management_system.consts.PsmRedisConsts;
import com.tianyi.personal_management_system.entity.Employee;
import com.tianyi.personal_management_system.entity.Taken;
import com.tianyi.personal_management_system.mapper.EmployeeMapper;
import com.tianyi.personal_management_system.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chen
 * @since 2020-04-04
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private EmployeeSecurityServiceImpl employeeSecurityService;
    @Override
    public Taken employeeLogin(String mobile, String password, String code) {
        //1.判断该账户是否已登录
        Object emObj=redisTemplate.opsForValue().get(PsmRedisConsts.PSM_REDIS_EMPLOYEE_MSG + mobile);
        if(emObj!=null){
            return Taken.builder().cookie(emObj.toString()).flag(true).build();
        }
        Employee employee = baseMapper.selectOne(new QueryWrapper<Employee>().lambda().eq(Employee::getMobile, mobile));
        boolean matches = bCryptPasswordEncoder.matches(password, employee.getPassword());
        redisTemplate.opsForValue().set(PsmRedisConsts.PSM_REDIS_EMPLOYEE_MSG+employee.getMobile(),JSON.toJSONString(employee));
        return Taken.builder().cookie(JSON.toJSONString(employee)).flag(matches).build();
    }

    @Override
    public Boolean employeeSign(Employee employee) {
        int insert = baseMapper.insert(employee);
        return true;
    }

    @Override
    public Boolean updateEmployeeMsg(Employee employee) {
        employee.setPassword(null);
        baseMapper.updateById(employee);
        return true;
    }

    @Override
    public Boolean loginOut(String mobile) {
        redisTemplate.opsForValue().set(PsmRedisConsts.PSM_REDIS_EMPLOYEE_MSG+mobile,null);
        return true;
    }

    @Override
    public Boolean updatePassword(String mobile, String password, String key) {
        Employee employee= JSONObject.parseObject(redisTemplate.opsForValue().get((PsmRedisConsts.PSM_REDIS_EMPLOYEE_MSG+mobile)).toString(),Employee.class);
        String employeeKey = employeeSecurityService.getEmployeeKey(employee.getId());
        if(bCryptPasswordEncoder.matches(key, employeeKey)){
            baseMapper.update(null,new UpdateWrapper<Employee>()
                    .lambda()
                    .set(Employee::getPassword,password)
                    .eq(Employee::getMobile,mobile)
            );
            return true;
        }
        return false;
    }
}
