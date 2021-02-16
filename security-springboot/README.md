# Security-SpringBoot 项目简介

使用 Spring Boot 集成 Spring Security 的项目。

### 项目运行

修改 `src/main/resources/application.properties` 中的配置与本地保持一致；

使用 `src/main/resources/static/db/create.sql` 语句进行数据库的创建（本人使用 MySQL 5.5）；

然后即可运行 `SecuritySpringbootApplication.java` 启动项目。

***

系统用户及权限：

- 用户名：CoderGeshu，密码：123456，角色：管理员，权限：p1，p2；
- 用户名：Eric，密码：456789，角色：普通用户，权限：p2；

CoderGeshu 可以通过权限访问资源一 `/resource/r1` 和 `/resource/r2`；Eric 可以通过权限访问资源二 `/resource/r2`。