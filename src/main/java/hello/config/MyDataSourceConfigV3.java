package hello.config;


import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourcePropertiesV1;
import hello.datasource.MyDataSourcePropertiesV2;
import hello.datasource.MyDataSourcePropertiesV3;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
// 이 속성을 가지고 값을 다 넣은 다음에 빈으로 주입 가능
@EnableConfigurationProperties(MyDataSourcePropertiesV3.class)
@AllArgsConstructor
public class MyDataSourceConfigV3 {

    private final MyDataSourcePropertiesV3 myDataSourcePropertiesV3;


    // 객체화 시켜서 등록하는 방법
    // QueryDsl을 생각해보자
    @Bean
    public MyDataSource myDataSource(){
        return new MyDataSource(
                myDataSourcePropertiesV3.getUrl(),
                myDataSourcePropertiesV3.getUsername(),
                myDataSourcePropertiesV3.getPassword(),
                myDataSourcePropertiesV3.getEtc().getMaxConnection(),
                myDataSourcePropertiesV3.getEtc().getTimeout(),
                myDataSourcePropertiesV3.getEtc().getOptions());
    }

}
