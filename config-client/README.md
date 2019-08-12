#### config-client 读取远程GIT仓库配置。

1. congfig server 参数配置需bootstrap.yml文件中，格式如下：

``` yml
spring:
  cloud:
    config:
      name: config-client
      uri: http://localhost:8889
      profile: dev
      label: master


```
* boostrap 由父 ApplicationContext 加载，比 applicaton 优先加载
* boostrap 里面的属性不能被覆盖