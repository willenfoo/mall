package com.example.mall.controller.vo.order;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrderUpdateReq extends CommonAttribute {

    /**
     * 备注
     */
    @ApiModelProperty(value = "发票地址ID", example = "1", required = true)
    @NotBlank
    private String remark;

}
