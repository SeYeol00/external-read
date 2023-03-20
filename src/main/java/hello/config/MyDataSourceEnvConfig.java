package hello.config;


import hello.datasource.MyDataSource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.time.Duration;
import java.util.List;

@Slf4j
@Configuration
@AllArgsConstructor
public class MyDataSourceEnvConfig {

    // 스프링의 envrionment로 외부 설정을 가져온 것이다.
    private final Environment environment;


    @Bean
    public MyDataSource myDataSource(){
        return new MyDataSource(
                environment.getProperty("my.datasource.url"),
                environment.getProperty("my.datasource.username"),
                environment.getProperty("my.datasource.password"),
                // 기본은 스트링인데 타입을 줄 수가 있다. ,뒤에 지정하고 싶은 타입을 지정한다.
                environment.getProperty("my.datasource.etc.max-connection",Integer.class),
                environment.getProperty("my.datasource.etc.timeout", Duration.class),
                environment.getProperty("my.datasource.etc.options", List.class)
        );
    }

}
