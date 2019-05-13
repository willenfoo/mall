package com.example.mall.controller.vo.order;

import com.example.mall.enums.order.OrderState;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderListReq {

    @ApiModelProperty(value = "状态", dataType = "java.lang.Integer", example = "1", required = true)
    private OrderState state;
}
