package com.example.mall.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mall.dto.order.OrderDto;
import com.example.mall.dto.order.OrderQueryDto;
import com.example.mall.entity.Order;
import org.apache.playframework.domain.PagerQuery;
import org.apache.playframework.domain.PagerResult;

/**
 * <p>
 * 交易订单总表 服务类
 * </p>
 *
 * @author fuwei
 * @since 2019-03-12
 */
public interface OrderService extends IService<Order> {

    /**
     * 根据id查询，查询不到会抛出异常
     * @param id
     * @return
     */
    Order queryById(String id);

    /**
     * 根据id查询，需要返回更多字段，用dto扩展，查询不到会抛出异常
     * @param id
     * @return
     */
    OrderDto queryDetailById(String id);

    /**
     * 分页查询
     * @param pagerQuery
     * @param queryDto
     * @return
     */
    PagerResult<OrderDto> queryList(PagerQuery pagerQuery, OrderQueryDto queryDto);

}
