

### Git 基本操作

- `git clone #{XX.git}`: 从远程仓库获取项目源码
- `git pull` : 拉取当前分支最新代码
- `git add . && git commit -m #{提交内容}` : 对当前所有修改进行提交(此时修改还在本地) `#{提交内容}` 代表占位符，直接替换内容
- `git push` : 提交代码到远程仓库
- `git checkout #{指定分支}` : 当前分支切换到指定分支  `#{指定分支}` 代表占位符，直接替换分支名称


### Maven 基本操作

- `mvn clean` : 移除所有编译后的字节码文件
- `mvn install` : mvn 打包成 jar，输出文件为：target/shujiu-test-1.0.0-SNAPSHOT.jar
- `mvn -U compile` : 下载所有非正式的依赖，并对当前代码进行编译

### Jar 启动
 

```shell
java -jar #{Launcher.jar}
```

### CURL 基本操作

```curl
// GET
curl http://localhost:8080/index/

// POST
curl http://localhost:8080/index/add \
-H 'content-type: application/json;charset=UTF-8' \
-d '{"name":"树九","age":18}' 

```


## 练习

### git 练习

1. git clone 获取代码
2. git commit / git push 提交代码变更
3. git checkout 切换分支


### maven 练习


1. mvn -U compile 编译
2. mvn install 打包


### jar 启动

1. 使用 java -jar 启动 maven install 打包后的 jar


### curl 练习

1. 使用 curl 调用接口

### 开发练习

##### PART 1：

1. 对 Person 类添加身高、体重的属性，身高为浮点型、体重为整型。
2. 新增 1个 GET 接口，要求返回 年龄：20；姓名：李晨；身高：180.3；体重：20。


##### PART 2：

1. 新增 Car 类(汽车) ，属性包含：最大车速(浮点型)、座位数(整型)、型号(字符串)
2. 新增 GET 查询接口，要求返回 最大车速：88.5；座位数：4；型号：奔驰GL-3
3. 新增 POST 接口，要求返回当前请求的参数。即：发送什么数据，就返回什么数据