package com.example.mall.controller.admin.order;

import com.example.mall.enums.order.OrderState;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrderAddReq extends SaveCommonReq {

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态", dataType = "java.lang.Integer", example = "1", required = true)
    private OrderState state;

    /**
     * 备注
     */
    @ApiModelProperty(value = "发票地址ID", example = "3", required = true)
    @NotBlank
    private String remark;

}
