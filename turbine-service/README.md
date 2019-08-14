#### 断路器集群监控(Turbine)


1. @EnableTurbine 注解已经包含了@EnableDiscoveryClient注解，即已开启了注册服务
2. turbine.aggregator.cluster-config=default
   turbine.app-config=service-ribbon
   turbine.cluster-name-expression="default"
   turbine.combine-host-port=true
   * 上面的配置中，turbine.app-config参数配置Eureka中的serviceId列表，表明监控哪些服务；turbine.cluster-name-expression参数指定了集群名称为default，当服务数量非常多的时候，可以启动多个Turbine服务来构建不同的聚合集群，而该参数可以用来区分这些不同的聚合集群，同时该参数值可以再Hystrix仪表盘中用来定位不同的聚合集群，只需在Hystrix Stream的URL中通过cluster参数来指定；turbine.combine-host-port参数设置为true，可以让同一主机上的服务通过主机名与端口号的组合来进行区分，默认情况下会以host来区分不同的服务，这会使得在本机调试的时候，本机上的不同服务聚合成一个服务来统计。
3. 访问http://localhost:8883/hystrix，输入监控流http://localhost:9764/turbine.stream 