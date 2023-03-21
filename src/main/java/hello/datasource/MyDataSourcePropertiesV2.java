package hello.datasource;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
//@Data
// 빨간 줄 무시해도 됨
// 외부 설정을 주입받을 객체
@ConfigurationProperties("my.datasource")
@AllArgsConstructor // 생성자 주입을 해준다.
public class MyDataSourcePropertiesV2 {
    private String url;
    private String username;
    private String password;

    private Etc etc;

    // 내부 클래스를 만들어줄것임
    // 타입도 안전하게 캐스팅이 가능하다.
    // 실수로 숫자를 입력하는 곳에 문자를 넣는 것을 방지해준다.
    @Getter
    @AllArgsConstructor
    //@Data
    public static class Etc{
        // 스프링은 케밥 표기법을 낙타 표기법으로 자동으로 변환해준다.
        private int maxConnection; // 최대 연결 수
        private Duration timeout;// 응답시의 레이턴시
        private List<String> options;
    }

}
