package com.example.mall.controller.api;

import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.playframework.domain.SimpleResult;
import org.apache.playframework.web.controller.BaseController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@Slf4j
@Api(value = "api->交易订单管理API", tags = "api->交易订单管理API")
public class OrderController extends BaseController {

    @ApiOperation("审核失败")
    @PostMapping(value = "{id}")
    public R<SimpleResult<Boolean>> checkFail(
            @PathVariable("id") String id) {
        Boolean updateFlag = true;
        return successResult(updateFlag);
    }


}
