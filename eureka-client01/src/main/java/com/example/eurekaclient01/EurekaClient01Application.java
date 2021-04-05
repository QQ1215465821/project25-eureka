package com.example.eurekaclient01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClient01Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient01Application.class, args);
    }

}

/*
docker run -it -p 8081:8081 --name eureka_client_8081 lam/eureka-client01 --server.port=8081 --eureka.instance.hostname=host01
 */
/*
镜像创建容器配置
<component name="ProjectRunConfigurationManager">
  <configuration default="false" name="Docker镜像配置2" type="docker-deploy" factoryName="docker-image" server-name="Docker">
    <deployment type="docker-image">
      <settings>
        <option name="imageTag" value="lam/eureka-client01:latest" />
        <option name="command" value="--server.port=8082 --eureka.instance.hostname=host02" />
        <option name="containerName" value="eureka_client_8082" />
        <option name="entrypoint" value="" />
        <option name="commandLineOptions" value="-it -p 8082:8082" />
      </settings>
    </deployment>
    <method v="2" />
  </configuration>
</component>
 */