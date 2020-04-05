package com.tianyi.personal_management_system.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chen
 * @since 2020-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Employee对象", description="")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键id")
    private String id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "出生日")
    private String brithday;

    @ApiModelProperty(value = "现居住地址")
    private String currentAddress;

    @ApiModelProperty(value = "身份证")
    private String idNum;

    @ApiModelProperty(value = "籍贯")
    private String address;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "个人简介")
    private String individualResume;

    @ApiModelProperty(value = "本人工作照")
    private String workPhoto;

    @ApiModelProperty(value = "账户密码")
    private String password;

    @ApiModelProperty(value = "部门id:所属部门")
    private String departmentId;

    @ApiModelProperty(value = "职位id:对应职位")
    private String positionId;

    @ApiModelProperty(value = "对应role表权限")
    private String roleId;


}
