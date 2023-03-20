package hello.config;


import hello.datasource.MyDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

@Slf4j
@Configuration
public class MyDataSourceValueConfig {


    @Value("${my.datasource.url}")
    private String url;
    @Value("${my.datasource.username}")
    private String username;
    @Value("${my.datasource.password}")
    private String password;
    @Value("${my.datasource.etc.max-connection}")
    private int maxConnection; // 최대 연결 수
    @Value("${my.datasource.etc.timeout}")
    private Duration timeout;// 응답시의 레이턴시
    @Value("${my.datasource.etc.options}")
    private List<String> options;// 옵션들



    @Bean
    public MyDataSource myDataSource1(){
        return new MyDataSource(url,username,password,maxConnection,timeout,options);
    }

    @Bean
    public MyDataSource myDataSource2(
            // 파라미터로도 주입이 가능하다.
            @Value("${my.datasource.url}")
            String url,
            @Value("${my.datasource.username}")
            String username,
            @Value("${my.datasource.password}")
            String password,
            // : 뒤에 기본 값을 지정할 수 있다.
            @Value("${my.datasource.etc.max-connection}")
            int maxConnection, // 최대 연결 수
            @Value("${my.datasource.etc.timeout}")
            Duration timeout,// 응답시의 레이턴시
            @Value("${my.datasource.etc.options}")
            List<String> options// 옵션들
    ){
        return new MyDataSource(url, username, password, maxConnection, timeout, options);
    }
}
