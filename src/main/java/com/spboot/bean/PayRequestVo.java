package com.spboot.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @Author WANG JI BO
 * @Date 2019/6/14 上午11:09
 * @Description
 **/
public class PayRequestVo {

    /**
     * 支付完成时间
     **/
    @NotEmpty(message = "支付完成时间不能空", groups = {Groups.Add.class})
    @Size(max = 14, message = "支付完成时间长度不能超过{max}位",groups = {Groups.Add.class})
    private String payTime;

    /**
     * 状态
     **/
    @Pattern(regexp = "0[0123]", message = "状态只能为00或01或02或03")
    private String status;


    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
