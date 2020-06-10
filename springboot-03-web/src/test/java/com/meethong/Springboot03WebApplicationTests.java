package com.meethong;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot03WebApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    public void conn() throws SQLException{
        System.out.println(dataSource.getClass());
        //获得连接
        Connection connection =   dataSource.getConnection();
        String dbName = connection.getMetaData().getDatabaseProductName();
        String dbVersion = connection.getMetaData().getDatabaseProductVersion();
        System.out.println("数据库名称是："+dbName+"；版本是：" + dbVersion);
        //关闭连接
        connection.close();
    }


}
