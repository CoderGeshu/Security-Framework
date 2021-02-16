# Security-SpringMVC 项目

### 简介

使用 Spring MVC 并基于 Session 实现的认证授权功能；

本项目使用 Map 来模拟数据库存储用户信息以及权限信息，具体请参照 `database/UserDB`  类中的信息；

在 `config/WebMvcConfig` 中，配置了视图解析器，以及将所有 `/` 请求导向登录页面，所有 `/resource/**` 请求都先设置拦截器进行拦截处理；

在拦截器 `interceptor/SimpleAuthenticationInterceptor` 中配置了拦截处理逻辑；

用户在登录时，首先会经过身份认证，由 `service/AuthenticationServiceImpl` 类来配置处理。

***

### 项目运行

因为是 Spring MVC 项目，运行时需自行配置 Tomcat 及部署访问路径。

***

### 系统用户及权限

- 用户名：CoderGeshu，密码：123456，权限：p1；
- 用户名：Eric，密码：456789，权限：p2；

CoderGeshu 可以通过权限访问资源一 `/resource/r1`；Eric 可以通过权限访问资源二 `/resource/r2`。