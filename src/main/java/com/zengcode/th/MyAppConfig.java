package com.zengcode.th;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ThreadPoolRejectedPolicy;
import org.apache.camel.spi.ThreadPoolProfile;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.jms.ConnectionFactory;
import javax.sql.DataSource;

import static org.apache.activemq.camel.component.ActiveMQComponent.*;


@Configuration
public class MyAppConfig extends WebMvcConfigurerAdapter {

    /*@Profile("default")
    @Bean
    @ConfigurationProperties(prefix = "config.datasource")
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost/arnon?useUnicode=true&amp;characterEncoding=UTF-8");
        return  dataSource;
    }
*/
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

   @Bean
    CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext context) {
                // your custom configuration goes here
                ThreadPoolProfile threadPoolProfile = new ThreadPoolProfile();
                threadPoolProfile.setId("myDefaultProfile");
                threadPoolProfile.setPoolSize(5);
                threadPoolProfile.setMaxPoolSize(15);
                threadPoolProfile.setMaxQueueSize(250);
                threadPoolProfile.setKeepAliveTime(25L);
                threadPoolProfile.setRejectedPolicy(ThreadPoolRejectedPolicy.Abort);
                context.getExecutorServiceManager().registerThreadPoolProfile(threadPoolProfile);

                //ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
                //context.addComponent("activemq", jmsComponentAutoAcknowledge(connectionFactory));
            }
        };
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * registry.addInterceptor(interceptor)
         .addPathPatterns("/**")
         .excludePathPatterns("/arnon/apiadmin/**",
         "/arnon/accessdenied.html",
         "/arnon/authenticated.html",
         "/arnon/ajax/**",
         "/arnon/static/**");
         */
        //registry.addInterceptor(new TransactionInterceptor()).addPathPatterns("/*");
    }



}