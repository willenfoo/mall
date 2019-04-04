package com.example.mall.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.example.mall.enums.order.OrderState;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 交易订单总表
 * </p>
 *
 * @author fuwei
 * @since 2019-03-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 内部流水号
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态
     */
    private OrderState state;

    /**
     * 商户号-企业号
     */
    private String busiId;


}
