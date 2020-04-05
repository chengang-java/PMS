package com.tianyi.personal_management_system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 雇员密保用于密码找回
 * </p>
 *
 * @author chen
 * @since 2020-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("employee_security")
@ApiModel(value="EmployeeSecurity对象", description="雇员密保用于密码找回")
public class EmployeeSecurity implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键id")
    private String id;
    @ApiModelProperty(value = "职员id")
    private String employeeId;
    @ApiModelProperty(value = "账户密保")
    private String employeeKey;
}
