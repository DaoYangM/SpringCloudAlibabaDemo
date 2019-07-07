package top.daoyang.contentcenter.configuration;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.core.Balancer;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.alibaba.nacos.NacosDiscoveryProperties;
import org.springframework.cloud.alibaba.nacos.ribbon.NacosServer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class NacosWeightedRule extends AbstractLoadBalancerRule {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        BaseLoadBalancer loadBalancer = (BaseLoadBalancer) getLoadBalancer();

        // get load balance server name;
        String serviceName = loadBalancer.getName();
        NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
        String clusterName = nacosDiscoveryProperties.getClusterName();
        Map<String, String> metadata = nacosDiscoveryProperties.getMetadata();

        try {
            NacosServer nacosServer;
            List<Instance> allInstances = namingService.getAllInstances(serviceName)
                    .stream()
                    .filter(instance -> instance.getMetadata().get("version").equals(metadata.get("version")))
                    .collect(Collectors.toList());

            if (allInstances.isEmpty()) {
                return null;
            } else {
                List<Instance> collect = allInstances
                        .stream()
                        .filter(instance -> instance.getClusterName().equals(clusterName))
                        .collect(Collectors.toList());
                if (collect.isEmpty()) {
                    nacosServer = new NacosServer(namingService.selectOneHealthyInstance(serviceName));
                } else {
                    Instance instance = WeightRuleChooser.getHostByRandomWeightOverride(collect);
                    nacosServer = new NacosServer(instance);
                }
            }

            log.info("instance = {}", nacosServer.getInstance());
            return nacosServer;
        } catch (NacosException e) {
            e.printStackTrace();

            return null;
        }
    }
}

class WeightRuleChooser extends Balancer {
    static Instance getHostByRandomWeightOverride(List<Instance> instances) {
        return getHostByRandomWeight(instances);
    }
}
