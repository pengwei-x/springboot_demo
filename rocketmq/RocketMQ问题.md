# RocketMQ问题

###  No route info of this topic 报错





![img](https://img-blog.csdnimg.cn/20190611171817691.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RhdGFpeWFuZ3U=,size_16,color_FFFFFF,t_70)

#### 原因

1. brocker买有连接到mqnameserv
2. producer没有连接到mqnameserv
3.  topic没有创建
4.  防火墙

![image-20200623190030777](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200623190030777.png)

，在机器中有docker的网卡，所以导致，brocker总是代理到虚拟的网卡。

#### 步骤（我的问题解决）

- mqnameserver.cmd

- `mqbroker.cmd  -n localhost:9876 -c ../conf/broker.conf  autoCreateTopicEnable=true`  

   `| mqbroker  -n 10.0.1.1:9876  autoCreateTopicEnable=true`

  broker.conf 指定 broker ip
  
  ```properties
  brokerClusterName = DefaultCluster
  brokerName = broker-a
  brokerId = 0
  deleteWhen = 04
  fileReservedTime = 48
  brokerRole = ASYNC_MASTER
  flushDiskType = ASYNC_FLUSH
  //增加IP1(重点)
  brokerIP1=127.0.0.1
  ```

#### 引用结论

```
需要在启动的时候导入配置文件

#进入rocketmq根目录 cd incubator-rocketmq/distribution/target/apache-rocketmq
#编写配置文件，并写好配置 echo “brokerIP1=10.2.x.x” > broker.properties
#启动 mqnamesrv nohup sh bin/mqnamesrv &

#重点：mrbroker 启动时通过 -c 加载配置文件 nohup sh bin/mqbroker -n ${namesrvIp}:9876 -c
/opt/rocketmq/incubator-rocketmq/distribution/target/apache-rocketmq/broker.properties
&

原理：

rpcketMq broker的启动

rocketMq的broker 启动类

org.apache.rocketmq.broker.BrokerStartup 启动的时候会读取代码中的默认配置，关于
broker的配置在

org.apache.rocketmq.common.BrokerConfig 中，根据源代码可以得知，broker使用的默认IP为本机Ip

brokerIP1 = RemotingUtil.getLocalAddress(); 得到选取ip的思路是，遍历本地的所有网卡ip，过滤掉
“127.0” 和“192.168”开头的ip地址

然后得到第一个ip，为本机ip。

问题：

当这台机器有很多别的网卡（如：安装docker后），broker使用的ip，就可能会导致我们的客户端无法连接。

解决：

rockerMq，在加载默认配置后，根据，启动时是否包含 -c 参数

if (commandLine.hasOption(‘c’)) 确定是否执行代码加载额外配置文件

加载时，通过反射的方式，根据配置文件中的键值对，赋值到 BrokerConfig中对应的属性中。

最后：

rocketMq启动时会打印出所有“重要的配置” （被@ImportantField所注解的属性）
```



