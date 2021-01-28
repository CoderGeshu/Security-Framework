# Security-SpringMVC

一个使用 Spring MVC 并基于 Session 实现的认证授权功能：登录认证；不同的权限可以访问不同的资源。

***

### 系统功能

本项目使用 Map 来模拟数据库存储用户信息以及权限信息，具体请参照 `database/UserDB`  类中的信息；

在 `config/WebMvcConfig` 中，配置了视图解析器，以及将所有 `/` 请求导向登录页面，所有 `/resource/**` 请求都先设置拦截器进行拦截处理；

在拦截器 `interceptor/SimpleAuthenticationInterceptor` 中配置了拦截处理逻辑；

用户在登录时，首先会经过身份认证，由 `service/AuthenticationServiceImpl` 类来配置处理。

***

认证功能：对用户身份合法性的判断；

授权功能：对用户访问资源权限的控制。

***

用户为 id：1001，密码：123456，姓名：CoderGeshu；id：1002，密码：456789，姓名：Eric；

CoderGeshu 可以通过 `/resource/r1` 访问资源一；Eric 可以通过 `/resource/r2` 访问资源二。

***

因为是 Spring MVC 项目，运行时需自行配置 Tomcat。