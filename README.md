# 使用步骤
### 一、下载好源码后，只需改两个地方就可以点运行了
1.首先改`application.yml`文件的数据库地址信息
```
url: jdbc:mysql://127.0.0.1:3306/数据库名?useSSL=false&useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&allowMultiQueries=true
username: root
password: 123456
```
2. 将 \resources\system.properties 下的`sys.generator.generatorPackage`属性改为你自己要生成数据库的名字

### 二.如果你想使用我的项目结构,则可直接点运行按钮

### 三.自定义
* 自定义包信息
根据注释修改在根目录下的`system.properties`文件

* 自定义生成模版内容
结合`src/main/java/com/cqie/easyteach/common/generator/entity/GeneratorConfig.java`(里面定义的模版所需数据信息),修改`generator/templates`中的相应文件的模版信息

### 四.善后
如果生成满意了要开始编码了,一定记得把`src/main/java/com/cqie/easyteach/common/generator/ApplicationImpl.java`文件注释掉!!!

## 配置过程
其实最终生成模版就是使用`freemarker.template.Template`提供的api进行代码生成.
本项目使用的是:
```
.process(Object dataModel, Writer out)```方法,第一个数据是用来装模版所需可见变量的,第二个数据为生成最终文件的Writer流.
```
中间进行了一些自动化选择模版生成相应文件的操作.