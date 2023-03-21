package hello.config;


import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourcePropertiesV1;
import hello.datasource.MyDataSourcePropertiesV2;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@Slf4j
// 이 속성을 가지고 값을 다 넣은 다음에 빈으로 주입 가능
//@EnableConfigurationProperties(MyDataSourcePropertiesV1.class)
@AllArgsConstructor
public class MyDataSourceConfigV2 {

    private final MyDataSourcePropertiesV2 myDataSourcePropertiesV2;


    // 객체화 시켜서 등록하는 방법
    // QueryDsl을 생각해보자
    @Bean
    public MyDataSource myDataSource(){
        return new MyDataSource(
                myDataSourcePropertiesV2.getUrl(),
                myDataSourcePropertiesV2.getUsername(),
                myDataSourcePropertiesV2.getPassword(),
                myDataSourcePropertiesV2.getEtc().getMaxConnection(),
                myDataSourcePropertiesV2.getEtc().getTimeout(),
                myDataSourcePropertiesV2.getEtc().getOptions());
    }

}
