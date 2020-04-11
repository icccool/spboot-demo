package com.spboot.web;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "/datasource")
public class DataSourceController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

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
    @RequestMapping(value = "/sqlTemplete", method = RequestMethod.GET)
    public Object sqlTemplete() {
        Connection connection = null;
        return sqlSessionTemplate.selectOne("select * from t_basic_setting_production_cp where production_cp_id=48");
    }
}
