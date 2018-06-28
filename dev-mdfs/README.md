#### 运行
用`intellij idea`分别打开`dev-mdfs/mdfs-datanode-server`文件夹和`dev-mdfs/mdfs-namenode-server`文件夹

- 运行`dev-mdfs/mdfs-datanode-server`


- 运行`dev-mdfs/mdfs-namenode-server`：<br>
`dev-mdfs/mdfs-namenode-server`的`application.yml`中`server: port: `和`spring: application: name: `分别如下修改(注：`dev-mdfs/mdfs-namenode-server`项目的`Run/Debug Configurations`中的`Single instance only`不要勾上,否则不能启动多个datanode)：
```
server:
  port: 8763

spring:
  jpa:
    show-sql: false
    hibernate:
      ddl-auto: create-drop
  application:
    name: datanode1
```
```
server:
  port: 8764

spring:
  jpa:
    show-sql: false
    hibernate:
      ddl-auto: create-drop
  application:
    name: datanode2
```
```
server:
  port: 8765

spring:
  jpa:
    show-sql: false
    hibernate:
      ddl-auto: create-drop
  application:
    name: datanode3
```
依次运行开启三个datanode


#### 使用
打开`postman`,按如图所示发送指令：

1. 向文件系统上传文件（这里上传两份文件）：

![send1](https://github.com/Weizerojust/SAHomework/blob/master/dev-mdfs/image/send1.png)


2. 查看当前文件管理系统中的内容：

![show1](https://github.com/Weizerojust/SAHomework/blob/master/dev-mdfs/image/show1.png)

可以看到刚刚上传的两个文件显示出来

3. 删除文件系统中的文件

![del](https://github.com/Weizerojust/SAHomework/blob/master/dev-mdfs/image/del.png)

这时候查看当前文件管理系统中的内容：

![show2](https://github.com/Weizerojust/SAHomework/blob/master/dev-mdfs/image/show2.png)

可以看到第一个文件夹中的文件已被删除

4. 下载文件系统中的文件（以`Send and Download`方式发送）：

![download](https://github.com/Weizerojust/SAHomework/blob/master/dev-mdfs/image/download.png)

在本地查看：

![download2](https://github.com/Weizerojust/SAHomework/blob/master/dev-mdfs/image/download2.png)