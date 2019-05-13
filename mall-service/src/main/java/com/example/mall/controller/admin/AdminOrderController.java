package com.example.mall.controller.admin;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.mall.controller.vo.order.*;
import com.example.mall.dto.order.OrderDto;
import com.example.mall.dto.order.OrderQueryDto;
import com.example.mall.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.playframework.domain.PagerQuery;
import org.apache.playframework.domain.PagerResult;
import org.apache.playframework.domain.SimpleResult;
import org.apache.playframework.util.BeanCopierUtils;
import org.apache.playframework.web.controller.BaseController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fuwei
 * @since 2018-12-25
 */
@RestController
@RequestMapping("/enterprise/busiInvoiceLog")
@Api(value = "enterprise->商户发票申请API", tags = "enterprise->商户发票申请API")
public class AdminOrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("新增")
    @PostMapping
    public R<SimpleResult<Boolean>> add(@Validated @RequestBody OrderAddReq addReq) {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(addReq, orderDto);
        Boolean updateFlag = orderService.save(orderDto);
        return successResult(updateFlag);
    }

    @ApiOperation("修改")
    @PostMapping(value = "{id}")
    public R<SimpleResult<Boolean>> update(
            @PathVariable("id") Long id,
            @Validated @RequestBody OrderUpdateReq updateReq) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        BeanUtils.copyProperties(updateReq, orderDto);
        Boolean updateFlag = orderService.updateById(orderDto);
        return successResult(updateFlag);
    }

    @ApiOperation("查询列表")
    @GetMapping
    public R<PagerResult<OrderResp>> list(PagerQuery pagerQuery, OrderListReq listReq) {
        OrderQueryDto queryDto = new OrderQueryDto();
        BeanUtils.copyProperties(listReq, queryDto);
        PagerResult<OrderDto> pagerResult = orderService.queryList(pagerQuery, queryDto);
        return successPager(pagerResult, OrderResp.class);
    }

    @ApiOperation("根据id查询")
    @GetMapping(value = "{id}")
    public R<OrderResp> findById(@PathVariable("id") String id) {
        OrderDto orderDto = orderService.queryById(id);
        OrderResp orderResp = new OrderResp();
        BeanCopierUtils.copyProperties(orderDto, orderResp);
        return success(orderResp);
    }

}

