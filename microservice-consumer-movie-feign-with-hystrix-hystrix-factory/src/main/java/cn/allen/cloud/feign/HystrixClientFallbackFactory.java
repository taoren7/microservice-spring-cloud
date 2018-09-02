package cn.allen.cloud.feign;

import cn.allen.cloud.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {

        LOGGER.info("fallback; reason was: {}", throwable.getMessage());
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                User user = new User();
                user.setId(-1L);
                return user;
            }
        };
    }
}
