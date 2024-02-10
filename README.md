# log-record

+ 以注解的方式记录操作日志。

+ 参照美团技术团队的一篇文章：[如何优雅地记录操作日志？](https://tech.meituan.com/2021/09/16/operational-logbook.html)

### AOP执行步骤：

配置pointcut并包装为advisor -> 拦截被增强方法 -> 处理逻辑

### 注解执行步骤(后置通知)：

拦截目标方法 -> 执行目标方法 -> 获取方法的注解信息 -> 解析模板 -> 执行扩展方法（保存日志等）