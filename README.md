
项目基于[cola](https://github.com/alibaba/COLA)生成:

```shell
mvn archetype:generate  \
-DgroupId=net.ibyg \
-DartifactId=netby-service \
-Dversion=1.0.0-SNAPSHOT \
-Dpackage=com.alibaba.netby \
-DarchetypeArtifactId=cola-framework-archetype-web \
-DarchetypeGroupId=com.alibaba.cola \
-DarchetypeVersion=4.0.1
```


技术架构： 

- dubbo
- rocketmq
- sharding-jdbc 
- mysql 
- redis 
- nacos
- zookeeper