#### spring cloud gateway 网关

##### spring-boot-starter-webflux

```xml
<dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-webflux</artifactId>
     <version>2.1.2.RELEASE</version>
</dependency>
```

[Spring Cloud Gateway](https://cloud.spring.io/spring-cloud-gateway/reference/html/)

*  GatewayFilter
> 需要通过spring.cloud.routes.filters 配置在具体路由下，只作用在当前路由上或通过
 1.  StripPrefixGatewayFilterFactory
 2.  PrefixPathGatewayFilterFactory
 3. AddRequestHeader GatewayFilter Factory
 4. RewritePath GatewayFilter Factory
 
* GlobalFilter 
> 全局过滤器，不需要在配置文件中配置，作用在所有的路由上，最终通过GatewayFilterAdapter包装成GatewayFilterChain可识别的过滤器，它为请求业务以及路由的URI转换为真实业务服务的请求地址的核心过滤器，不需要配置，系统初始化时加载，并作用在每个路由上。
* predicate
> Predicate来自于java8的接口。Predicate 接受一个输入参数，返回一个布尔值结果。该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）。可以用于接口请求参数校验、判断新老数据是否有变化需要进行更新操作。add–与、or–或、negate–非。
 1. After Route Predicate Factory
 2. Path Route Predicate Factory
 3. Query Route Predicate Factory
 4. Method Route Predicate Factory
 5. Host Route Predicate Factory
 6. Cookie Route Predicate Factory
 7. Header Route Predicate Factory
 
 * 访问
 1. http://localhost:9011/eureka-client/user/info?name=demo
 ```yml
spring:
  application:
    name: gateway-service
  cloud:
    gateway:
      enabled: true
      discovery:
        locator:
          enabled: true
          lower-case-service-id: true
```
 2. http://localhost:9011/demo/user/info?name=demo
 ```yml
spring:
  application:
    name: gateway-service
  cloud:
    gateway:
      enabled: true
      discovery:
        locator:
          enabled: false
          lower-case-service-id: true
      routes:
      - id: eureka-client
        uri: lb://EUREKA-CLIENT
        predicates:
          - Path=/demo/** # Path Route Predicate Factory
        filters:
          - StripPrefix=1 # 转发前去掉的前缀demo
    