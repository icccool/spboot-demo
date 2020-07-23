package com.spboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Inherited;
import java.util.Map;

/**
 * @Author WANG JI BO
 * @Date 2020/5/30 12:17 下午
 * @Description
 **/
@Service
public abstract class AbstractOrderService {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
////    @Autowired
////    private CreateOrderInTransService createOrderInTransService;
//
//    public void doCreate(Map orderIno) {
//        jdbcTemplate.update("update t_ware_unite set scheme_name='21' where unite_id=7");
//        jdbcTemplate.update("update t_ware_unite set scheme_name='31' where unite_id=8");
//
//
////        createOrderInTransService.doCreate(orderIno);
//    }
//
//    @Service
//    class CreateOrderInTransService{
//
//        @Transactional
//        public void doCreate(Map orderIno) {
//            jdbcTemplate.update("update t_ware_unite set scheme_name='19' where unite_id=7");
//            jdbcTemplate.update("update t_ware_unite set scheme_name='29' where unite_id=8");
//            int a= 1/0;
////            //扣减库存
////            deductStock(orderInfo);
////            //保存订单
////            saveOrder(orderInfo);
//        }
//    }



}
