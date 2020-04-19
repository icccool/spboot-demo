package com.spboot.baseclass;

/**
 * @Author WANG JI BO
 * @Date 2020/3/24 3:12 下午
 * @Description
 **/

public abstract class BaseExt2 extends BaseExt {

    @Override
    public void afterPropertiesSet() {
        System.out.println(this.getClass() + "测试子类重写父类方法----->" + this.getNameServer());
    }

}
