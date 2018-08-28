package cn.allen.cloud.config;

import cn.allen.cloud.ExcludeFromComponentScan;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
