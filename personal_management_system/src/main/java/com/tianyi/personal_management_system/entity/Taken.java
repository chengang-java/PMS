package com.tianyi.personal_management_system.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author chengang
 * @version 1.0
 * @date 2020/4/4 10:08
 */
@Data
@Builder
public class Taken {
    @ApiModelProperty("cookie正常生成的鉴别变量")
    private Boolean flag;
    @ApiModelProperty("cookie具体信息")
    private String cookie;
    @Tolerate
    public Taken(Boolean flag,String cookie){
        this.flag=flag;
        this.cookie=cookie;
    }
}
