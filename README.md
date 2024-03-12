BIG EVENT
---------
## 如何获得请求头参数

1. `request.getHeader("Authorization")`
2. `list(@RequestHeader(name="Authorization") String token, ...)`

## 拦截器实现

1、实现拦截器

> 实现 HandlerInterceptor 接口

- 放行，返回 true；
- 拦截，返回 false。

2、注册拦截器

> 实现 WebMvcConfigurer 接口

- `addInterceptor` 添加
- `excludePathPatterns` 排除路径

## 全局报错处理器

添加上注解`@ExceptionHandler(Exception.class)`，详情见`GlobalExceptionHandler`。