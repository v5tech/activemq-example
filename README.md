activemq-example
================

ActiveMQ、Apollo、Spring Jms 整合示例。


> 本实例演示环境为：ActiveMQ 5.10 、 Windows 7 X64 、jdk1.7、maven 3.0.5

> 本实例演示环境为：apollo-1.7 、 Windows 7 X64 、jdk1.7、maven 3.0.5


# 安装ActiveMQ

### 1. ActiveMQ 启动

* ActiveMQ 5.10

```
bin\activemq start
```

* ActiveMQ 5.9 or older

```bash
bin\activemq
```

### 2. ActiveMQ 停止

```bash
bin/activemq stop
```

### 3. 访问

[http://localhost:8161/admin/](http://localhost:8161/admin/)

默认的用户名密码为：admin/admin

具体可在`activemq-5.10.0\conf\jetty-realm.properties`文件中配置.


# 安装apollo

### 1. Installation

[下载apollo](http://www.apache.org/dyn/closer.cgi?path=activemq/activemq-apollo/1.7/apache-apollo-1.7-windows-distro.zip)后解压，假若解压目录为apollo-1.7

### 2. Creating a Broker Instance

```bash
apollo-1.7/bin/apollo create mybroker
```

### 3. Running a Broker Instance

```bash
apollo-1.7/bin/mybroker/bin/apollo-broker run
```

### Web Administration

* http [http://127.0.0.1:61680/](http://127.0.0.1:61680/)
* https [https://127.0.0.1:61681/](https://127.0.0.1:61681/)

默认的用户名密码为：admin/password

具体见`apollo-1.7\bin\mybroker\etc\users.properties`


# Screenshots

* ActiveMQ演示

![Screenshots/activemq.gif](Screenshots/activemq.gif)

* Apollo演示

![Screenshots/apollo.gif](Screenshots/apollo.gif)

* ActiveMQ Maven Plugin演示

![Screenshots/activemq-plugin.gif](Screenshots/activemq-plugin.gif)


# 参考文档

* [http://activemq.apache.org/version-5-getting-started.html](http://activemq.apache.org/version-5-getting-started.html)

* [http://activemq.apache.org/how-do-i-embed-a-broker-inside-a-connection.html](http://activemq.apache.org/how-do-i-embed-a-broker-inside-a-connection.html)

* [http://activemq.apache.org/amqp.html](http://activemq.apache.org/amqp.html)

* [http://activemq.apache.org/apollo/index.html](http://activemq.apache.org/apollo/index.html)

# 参考项目

* [https://github.com/bsnyder/spring-jms-examples](https://github.com/bsnyder/spring-jms-examples)

* [https://github.com/FuseByExample/activemq-amqp-example/](https://github.com/FuseByExample/activemq-amqp-example/)

* [https://github.com/city81/SpringJMSActiveMQ/](https://github.com/city81/SpringJMSActiveMQ/)
