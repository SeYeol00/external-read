package hello.datasource;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class MyDataSource {


    private String url;
    private String username;
    private String password;
    private int maxConnection; // 최대 연결 수
    private Duration timeout;// 응답시의 레이턴시
    private List<String> options;// 옵션들

    // 멀티라인 셀렉션 -> 옵션 두 번

    @PostConstruct
    public void init(){
        log.info("url = {}",url);
        log.info("username = {}",username);
        log.info("password = {}",password);
        log.info("maxConnection = {}",maxConnection);
        log.info("timeout = {}",timeout);
        log.info("options = {}",options);
    }
}
