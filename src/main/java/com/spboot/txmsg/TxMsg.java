package com.spboot.txmsg;

/**
 * @Author WANG JI BO
 * @Date 2020/4/9 11:36 上午
 * @Description
 **/
public class TxMsg {
    String tag;
    Object args;
    String msg;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Object getArgs() {
        return args;
    }

    public void setArgs(Object args) {
        this.args = args;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
