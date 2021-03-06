package com.example.mall.enums.order;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.ObjectUtils;

/**
 * 测试枚举
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderState implements IEnum<Integer> {

    ONE(1, "待审核"),

    TWO(2, "审核通过");

    private Integer value;
    private String desc;

    OrderState(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    public String getDesc(){
        return this.desc;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static OrderState fromValue(Integer value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (OrderState item : values()) {
            if (ObjectUtils.nullSafeEquals(value, item.getValue())) {
                return item;
            }
        }
        throw new RuntimeException(OrderState.class.getSimpleName() + "根据value找不到对应枚举, value:" + value);
    }

}
