# broken-leg-girl（断腿少女）

#### 介绍
  &emsp;&emsp;断腿少女计划2（开发中~）  

#### 软件架构
  &emsp;&emsp;打算使用springboot + springcloud + hibernate ~~+ mybatis~~ 搭建

#### 开发进度
  &emsp;&emsp;2020/4/1 
   - **整合 springdata-jpa-hibernate**  
  
  &emsp;&emsp;2020/4/2 
   - **整合 Redis**  
   - ~~整合 mybaits~~ ——失败，取消整合  
   
  &emsp;&emsp;2020/4/3
   - **使用转换器解决中文乱码和POST请求不支持问题**  
   - **添加基于Redis分布式锁 + token防重复提交**  
   - **整合nacos配置中心和服务注册发现功能**  
   - **整合链路追踪Sleuth与Zipkin**  
   
  &emsp;&emsp;2020/4/7
  - **整合rabbitMQ**  
  
#### 安装教程
  1. `broken-leg-girl`目录执行maven命令`clean install -N`安装父项目（只有在父项目发生改变时才需要重新安装）；
  2. `broken-leg-girl-framework`目录执行maven命令`clean install`安装框架（只有在框架发生改变时才需要重新安装）；
  3. `app-api`目录执行maven命令`clean install`安装api包（只有在api发生改变时才需要重新安装）；
  4. 解压`software`下的`nacos-server-1.2.0.zip`，并进入`nacos/bin`目录，在Terminal或CMD执行`startup.cmd`以启动nacos；
  5. 在`software`目录下执行`java -jar zipkin-server-2.12.9-exec.jar`以启动zipkin；
  6. 修改`YAML/public-config.yml`配置中心的配置文件，并访问`http://localhost:8848/nacos`提交配置文件。

#### 使用说明
  1. broken-leg-girl-framework主要内容包括启动类、扫包、Redis初始化及工具类等；
  2. api主要用于放置部分工具类以及配合feign定义对外接口使用。

#### 参与贡献
  &emsp;&emsp;潘泓彤 & 范创杰
