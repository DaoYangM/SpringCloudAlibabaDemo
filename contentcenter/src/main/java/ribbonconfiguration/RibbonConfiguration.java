package ribbonconfiguration;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.daoyang.contentcenter.configuration.NacosWeightedRule;

@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule nacosWeightedRule() {
        return new NacosWeightedRule();
    }
}
