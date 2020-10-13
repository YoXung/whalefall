![logo](assets/stack-logo.png "logo") 

# whale-fall-stack
[![java](https://img.shields.io/badge/Java-8-9cf)]()
[![maven](https://img.shields.io/badge/Apache%20Maven-3.6.3-blue)]()
[![SB](https://img.shields.io/badge/Spring%20Boot-2.2.10.RELEASE-lightgreen)]()
[![SC](https://img.shields.io/badge/Spring%20Cloud-Hoxton.SR8-green)]()
[![SCA](https://img.shields.io/badge/Spring%20Cloud%20Alibaba-2.2.1.RELEASE-orange)](https://github.com/alibaba/spring-cloud-alibaba)
#### DevOps
![devops](assets/msa-stack.png "devops") 

#### 工程结构
```
whalefall //基线工程
├── whalefall-framework   //框架组件
├── whalefall-common      //通用组件
├── whalefall-dubbo       //dubbo示例
|   ├── whalefall-dubbo-gateway     
|   ├── whalefall-dubbo-consumer-api
|   ├── whalefall-dubbo-consumer
|   ├── whalefall-dubbo-api
|   └── whalefall-dubbo-provider
├── whalefall-gateway     //spring cloud gateway示例
├── whalefall-mq-examples //mq示例
|   ├── whalefall-mq-kafka
|   |   ├── whalefall-mq-kafka-consume
|   |   ├── whalefall-mq-kafka-produce
|   ├── whalefall-mq-pulsar
|   ├── whalefall-mq-rabbitmq
|   ├── whalefall-mq-rocketmq
|   ├── whalefall-mq-zeromq
|   ├── whalefall-mq-activemq
|   ├── whalefall-mq-emq      
└──
```
#### 安装的各软件对应的版本为（仅供参考）：
|软件|版本 | 说明
|:---|:---|:---
|JDK | 1.8.0_202 | 其他版本未测试
|Maven | 3.6.3  | 
|MySQL | 8.0.21 | 
|Nginx | 1.19.2 |
|Nacos | 1.3.2  |
|Docker| 19.03.9| 