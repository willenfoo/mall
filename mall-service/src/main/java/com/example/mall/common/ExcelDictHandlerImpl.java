package com.example.mall.common;

import cn.afterturn.easypoi.handler.inter.IExcelDictHandler;

/**
 * @author by jueyue on 18-8-3.
 */
public class ExcelDictHandlerImpl implements IExcelDictHandler {

    @Override
    public String toName(String dict, Object obj, String name, Object value) {
        if ("FEN_TO_YUAN".equals(dict)) {
            return String.valueOf(Double.parseDouble(String.valueOf(value)) / 100);
        }
        return String.valueOf(value);
    }

    @Override
    public String toValue(String dict, Object obj, String name, Object value) {
        return null;
    }
}
