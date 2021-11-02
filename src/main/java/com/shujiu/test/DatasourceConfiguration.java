package com.shujiu.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 数据模块配置类入口
 *
 * @author jiaoteng
 */
@Slf4j
@MapperScan(basePackages = "com.shujiu.test.dao")
@Configuration
public class DatasourceConfiguration {


    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    @Value("${spring.datasource.driver-class-name:com.mysql.cj.jdbc.Driver}")
    public String driverClassName;

    @Value("${spring.datasource.initialSize:8}")
    public int initialSize;

    @Value("${spring.datasource.minIdle:24}")
    public int minIdle;

    @Value("${spring.datasource.maxActive:128}")
    public int maxActive;

    @Value("${spring.datasource.maxWait:60000}")
    public int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis:60000}")
    public int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis:300000}")
    public int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery:SELECT 1 FROM DUAL}")
    public String validationQuery;

    @Value("${spring.datasource.testWhileIdle:true}")
    public boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow:false}")
    public boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn:false}")
    public boolean testOnReturn;

    @Value("${spring.datasource.filters:stat,wall,log4j}")
    public String filters;

    @Value("${spring.datasource.logSlowSql:true}")
    public String logSlowSql;


    @SuppressWarnings("unchecked")
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        val filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }


    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("loginUsername", username);
        reg.addInitParameter("loginPassword", password);
        reg.addInitParameter("logSlowSql", logSlowSql);
        return reg;
    }


    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(dbUrl);
        log.info("==== database connection url:{} ===", dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            log.error("druid configuration initialization filter", e);
        }
        datasource.init();
        return datasource;
    }

}
