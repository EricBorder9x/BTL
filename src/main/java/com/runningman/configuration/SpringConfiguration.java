package com.runningman.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.runningman")
@PropertySource({"classpath:persistence-mssql.properties"})
public class SpringConfiguration implements WebMvcConfigurer {

    @Autowired
    private Environment env;
    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public DataSource myDataSource() {
        ComboPooledDataSource myDataSource = new ComboPooledDataSource();
        try {
            myDataSource.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (PropertyVetoException exc) {
            throw new RuntimeException(exc);
        }
        logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
        logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
        myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        myDataSource.setUser(env.getProperty("jdbc.user"));
        myDataSource.setPassword(env.getProperty("jdbc.password"));
        myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return myDataSource;
    }

    private Properties getHibernateProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        return props;
    }

    private int getIntProperty(String propName) {
        String propVal = env.getProperty(propName);
        int intPropVal = Integer.parseInt(propVal);
        return intPropVal;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(myDataSource());
        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();

        mailSenderImpl.setHost("smtp.gmail.com");
        mailSenderImpl.setPort(587);
        mailSenderImpl.setProtocol("smtp");
        mailSenderImpl.setUsername("hieuheo2310@gmail.com");
        mailSenderImpl.setPassword("@Hieu2310");

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.debug", "true");
        javaMailProperties.put("mail.smtp.host", "smtp.gmail.com");
        javaMailProperties.put("mail.smtp.port", "587");

        mailSenderImpl.setJavaMailProperties(javaMailProperties);

        return mailSenderImpl;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resource/**").addResourceLocations("/WEB-INF/resource/");
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");

        return bean;
    }

    @Bean(name = "multipartResolver")
    public MultipartResolver commomMultipartResolver() {
        CommonsMultipartResolver commonMultipartResolver = new CommonsMultipartResolver();
        commonMultipartResolver.setMaxUploadSize(-1);
        return commonMultipartResolver;
    }
}
