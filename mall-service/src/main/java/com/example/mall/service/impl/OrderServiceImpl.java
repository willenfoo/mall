package com.example.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall.common.ExceptionCode;
import com.example.mall.dto.order.OrderDto;
import com.example.mall.dto.order.OrderQueryDto;
import com.example.mall.entity.Order;
import com.example.mall.mapper.OrderMapper;
import com.example.mall.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.playframework.domain.PagerQuery;
import org.apache.playframework.domain.PagerResult;
import org.apache.playframework.util.BeanCopierUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 交易订单总表 服务实现类
 * </p>
 *
 * @author fuwei
 * @since 2019-03-12
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public Order findById(String id) {
        Order order = getById(id);
        if (order == null) {
            throw new ApiException(ExceptionCode.ORDER_NOT_EXIST);
        }
        return order;
    }

    @Override
    public OrderDto queryById(String id) {
        Order order = findById(id);
        return conversion(Arrays.asList(order)).get(0);
    }

    @Override
    public PagerResult<OrderDto> queryList(PagerQuery pagerQuery, OrderQueryDto queryDto) {
        log.info("订单, 查询列表开始, pagerQuery:{}, queryDto:{}", pagerQuery, queryDto);
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.orderByDesc(Order::getId);
        //索引字段放在前面

        queryWrapper.gt(Order::getId, 0);
        if (Objects.nonNull(queryDto.getCreateTimeStart())) {
            queryWrapper.ge(Order::getCreateTime, queryDto.getCreateTimeStart());
        }
        if (Objects.nonNull(queryDto.getCreateTimeEnd())) {
            queryWrapper.le(Order::getCreateTime, queryDto.getCreateTimeEnd());
        }
        IPage<Order> iPage = page(new Page(pagerQuery.getCurrent(), pagerQuery.getSize()), queryWrapper);
        PagerResult<OrderDto> pagerResult = new PagerResult(conversion(iPage.getRecords()), iPage.getTotal());
        log.info("订单, 查询列表结束");
        return pagerResult;
    }

    private List<OrderDto> conversion(List<Order> orders) {
        if (ObjectUtils.isEmpty(orders)) {
            return new ArrayList<>();
        }
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = new OrderDto();
            BeanCopierUtils.copyProperties(order, orderDto);
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }

}
