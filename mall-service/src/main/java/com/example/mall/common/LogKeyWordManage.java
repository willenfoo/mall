package com.example.mall.common;

/**
 * 日志关键字，
 * 属性命名，以app或者facade开头，Controller或者Facade的前缀加上方法命，
 * 如果api文档需要添加详细的notes,添加一个属性以后,Facade的前缀加上方法命,加上notes
 * 比如 OrderFacadeImpl中的checkPass方法，  属性名称为 FACADE_ORDER_CHECK_PASS，如果需要更加详细的notes，请命名为FACADE_ORDER_CHECK_PASS_NOTES
 *      OrderController中的checkPass方法，  属性名称为 APP_ORDER_CHECK_PASS，如果需要更加详细的notes，请命名为APP_ORDER_CHECK_PASS_NOTES
 * @author fuei
 */
public final class LogKeyWordManage {

    /*******************************************************facade start **********************************************************************/


    /*******************************************************facade end **********************************************************************/


    /*******************************************************app start **********************************************************************/
    /**
     * 得到订单售后信息，是否支持退款、退货退款、退货按钮
     */
    public static final String APP_ORDER_GET_AFTER_INFO = "得到订单售后信息";


}
