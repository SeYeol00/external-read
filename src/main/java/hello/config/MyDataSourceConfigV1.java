package hello.config;


import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourcePropertiesV1;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
// 이 속성을 가지고 값을 다 넣은 다음에 빈으로 주입 가능
//@EnableConfigurationProperties(MyDataSourcePropertiesV1.class)
@AllArgsConstructor
public class MyDataSourceConfigV1 {

    private final MyDataSourcePropertiesV1 myDataSourcePropertiesV1;


    // 객체화 시켜서 등록하는 방법
    // QueryDsl을 생각해보자
    @Bean
    public MyDataSource myDataSource(){
        return new MyDataSource(
                myDataSourcePropertiesV1.getUrl(),
                myDataSourcePropertiesV1.getUsername(),
                myDataSourcePropertiesV1.getPassword(),
                myDataSourcePropertiesV1.getEtc().getMaxConnection(),
                myDataSourcePropertiesV1.getEtc().getTimeout(),
                myDataSourcePropertiesV1.getEtc().getOptions());
    }

}
