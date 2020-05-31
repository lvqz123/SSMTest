此项目是用来系统复习Spring、SpringMVC、Mybatis知识点，请结合笔记食用

>目前正在系统复习整理Mybatis相关内容

lab1-lab19为Spring相关内容

lab20-为Mybatis相关内容

**Spring:**
   
    配置文件中数据库相关信息为防止被黑，已经进行脱敏。
    导入项目后进行自行配置，Spring练习所用的sql为：account-Spring

lab1：手撕一个简单的IOC容器框架，引申到IOC概念更容易理解

lab2：开始使用SpringIOC，例子通过加载IOC容器来加载Bean，ApplicationContext和BeanFactory的区别

lab3：创建Bean的三种方式，Bean的作用范围scope,Bean的生命周期

lab4：**`何为依赖注入？`** 

依赖注入的几种方式：
1. 通过构造方法注入
2. 通过set方法注入
3. 复杂类型/集合类型注入

lab5：Spring常用注解，使用注解改写lab4案例

lab6：结合dbutil的Spring纯xml格式编写案例

lab7：在lab6的基础上使用注解改造（遗留一些问题，部分配置无法转换成注解）

lab8：解决lab7留下的问题，发现几个新的注解Configuration、ComponentScan、Bean、Import、PropertySource
，将案例改造为纯注解格式。

lab9：通过事务和动态代理打开AOP思想的理解（学习lab10之后）

lab10：通过案例理解cglib动态代理和jdk的动态代理

lab11：AOP通过xml配置案例

lab12：通知类型案例

lab13： AOP通过纯注解方式配置案例

lab14：使用SpringAOP修改lab9

lab15：关于JdbcTemplate的使用（了解掌握即可）

lab16：使用xml配置Spring事务

lab17：使用注解配置Spring事务

lab18：使用纯注解改造事务案例，顺便回顾注解的知识点

lab19:（了解） 编程式事务案例，编程式事务与声明式事务的区别是编程式事务会出现大量重复性代码，并不好维护
，所以在实际开发中用的不多，但是还是得了解，面试可能会遇到

**Mybatis:**

lab20：使用XML配置Mybatis的入门案例

lab21：使用注解配置Mybatis的入门案例

lab22：Mybatis也可以使用DaoImpl实现，不过开发用不常用。



