package com.example.mall.controller.admin;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.mall.common.ExcelDictHandlerImpl;
import com.example.mall.controller.vo.order.*;
import com.example.mall.dto.order.OrderDto;
import com.example.mall.dto.order.OrderQueryDto;
import com.example.mall.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.playframework.domain.PagerQuery;
import org.apache.playframework.domain.PagerResult;
import org.apache.playframework.domain.SimpleResult;

import org.apache.playframework.web.controller.BaseController;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.cglib.core.Transformer;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

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
@Api(value = "admin->商户发票申请API", tags = "admin->商户发票申请API")
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

    @ApiOperation("根据id查询")
    @GetMapping(value = "{id}")
    public R<OrderResp> findById(@PathVariable("id") String id) {
        OrderDto orderDto = orderService.queryDetailById(id);
        OrderResp orderResp = new OrderResp();
        BeanUtils.copyProperties(orderDto, orderResp);
        return success(orderResp);
    }

    @ApiOperation("查询列表")
    @GetMapping
    public R<PagerResult<OrderResp>> list(PagerQuery pagerQuery, OrderListReq listReq) {
        OrderQueryDto queryDto = new OrderQueryDto();
        BeanUtils.copyProperties(listReq, queryDto);
        PagerResult<OrderDto> pagerResult = orderService.queryList(pagerQuery, queryDto);
        return successPager(pagerResult, OrderResp.class);
    }

    @ApiOperation("查询列表-->导出")
    @GetMapping("export")
    public void export(OrderListReq listReq) {
        PagerQuery pagerQuery = new PagerQuery();
        pagerQuery.setCurrent(1);
        pagerQuery.setSize(50000L);
        OrderQueryDto queryDto = new OrderQueryDto();
        BeanUtils.copyProperties(listReq, queryDto);

        PagerResult<OrderDto> pagerResult = orderService.queryList(pagerQuery, queryDto);
        List<OrderDto> list = pagerResult.getRecords();
        List<OrderResp> orderResps = CollectionUtils.transform(list, new Transformer() {
            @Override
            public Object transform(Object o) {
                OrderResp orderResp = new OrderResp();
                BeanUtils.copyProperties(o, orderResp);
                return orderResp;
            }
        });

        OutputStream out = null;
        try {
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
            response.setHeader("Content-Disposition", initDownloadFileName("打款白名单列表", "xlsx"));
            out = response.getOutputStream();

            ExportParams params = new ExportParams();
            params.setSheetName("列表");
            params.setType(ExcelType.XSSF);
            params.setDictHandler(new ExcelDictHandlerImpl());
            Workbook workbook = ExcelExportUtil.exportExcel(params, OrderResp.class, orderResps);
            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

