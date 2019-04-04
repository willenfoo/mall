package com.example.mall.dto.order;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderQueryDto {

    /**
     * 创建时间，开始
     */
    private String createTimeStart;

    /**
     * 创建时间，结束
     */
    private String createTimeEnd;

}
