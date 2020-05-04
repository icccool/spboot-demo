package com.spboot.web;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class DataSourceController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /***
     * 测试从连接池获得连接不关闭是否泄漏  !!!!!
     * @return
     */
    @RequestMapping(value = "/getConnectTest", method = RequestMethod.GET)
    public String dbTest() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "" + connection;
    }

    /***
     * 测试连接池
     * @return
     */
    @GetMapping(value = "/jdbcTemplateTest")
    public Object sqlTemplete() {
        String sql="select count(1) from t_ware_unite where unite_id=110";
        int count= jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }


}
