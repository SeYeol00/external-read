package hello;

import hello.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Import;

// 수동으로 빈을 등록해주는 configuration을 만들었다면 꼭 등록해주자
//@Import(MyDataSourceEnvConfig.class)
//@Import(MyDataSourceValueConfig.class)
//@Import(MyDataSourceConfigV1.class)
//@Import(MyDataSourceConfigV2.class)
@Import(MyDataSourceConfigV3.class)
// 컴포넌트 스캔의 영역을 하위로 지정해주자.
// 버전 업을 하면서 계속 빈을 다른 것을 사용할 것이다.
@SpringBootApplication(scanBasePackages = {"hello.datasource","hello.pay"})
@ConfigurationPropertiesScan // 이걸 달면 이 패키지 밑에 있는 모든 configurationproperties를 읽을 수 있다.
public class ExternalReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalReadApplication.class, args);
    }

}
