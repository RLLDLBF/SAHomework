#### 运行
用`intellij idea`打开`dev-mdfs/mdfs-config-server`文件夹并运行`ConfigServerApplication.java`中的`main`函数

打开`postman`

1. 查看当前文件管理系统中的内容
以`POST`方式发送`http://localhost:8888/GET1`，获取当前文件管理系统中的内容：
![运行前](https://github.com/Weizerojust/SAHomework/blob/master/dev-mdfs/img/GET1_1.png)


2. 向文件系统上传文件（这里上传两份文件）
以`POST`方式发送`http://localhost:8888/PUT`。其中`key`和`systempath`按如图所示设置：
![上传文件](https://github.com/Weizerojust/SAHomework/blob/master/dev-mdfs/img/PUT.png)

上传成功后重新运行第一步的命令，得到如下图结果，可以看到刚刚上传的两份文件已经存在文件管理系统中：
![上传文件查看](https://github.com/Weizerojust/SAHomework/blob/master/dev-mdfs/img/GET1_2.png)


3. 删除文件系统中的文件
以`POST`方式发送`http://localhost:8888/DEL`。其中`filename`按如图所示设置：
![删除文件](https://github.com/Weizerojust/SAHomework/blob/master/dev-mdfs/img/DEL.png)

删除成功后重新运行第一步的命令，得到如下图结果，可以看到`a.docx`已被删除：
![删除文件查看](https://github.com/Weizerojust/SAHomework/blob/master/dev-mdfs/img/GET1_3.png)

4. 下载文件系统中的文件
以`POST`方式发送`http://localhost:8888/GET2`。其中`filename`按如图所示设置，以`Send and Download`方式发送：
![下载文件](https://github.com/Weizerojust/SAHomework/blob/master/dev-mdfs/img/GET2_1.png)

下载后在本地可以看到本地文件夹中有刚刚下载的这个文件：
![下载文件本地](https://github.com/Weizerojust/SAHomework/blob/master/dev-mdfs/img/GET2_2.png)
