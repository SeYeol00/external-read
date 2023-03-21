package hello.pay;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// 스프링 웹과 같이 컨트롤러를 통해 로직을 실험하는게 아닌
// ApplicationRunner의 구현으로 로직을 실험할 수 있다.
// 테스트에 안 만드는 이유는 이게 실제 스프링 빈 등록을 측정하는 것이기 때문
@Component
@RequiredArgsConstructor
public class OrderRunner implements ApplicationRunner {

    private final OrderService orderService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        orderService.order(1000);
    }
}
