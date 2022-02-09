### Mysite04, 05 Package Structure
<pre>
[src]
   |--- [main]
                 |--- [java]
                 |	         |--- com 
                 |	         |		|--- poscoict
                 |	         |		|		|--- config
                 |	         |		|		|		|--- app
                 |	         |		|		|		|		|--- DBConfig.java
                 |	         |		|		|		|		|--- MyBatisConfig.java
                 |	         |		|		|		|--- web
                 |	         |		|		|		|		|--- FileuploadConfig.java
                 |	         |		|		|		|		|--- MVCConfig.java
                 |	         |		|		|		|		|--- SecurityConfig.java
                 |	         |		|		|--- jblog
                 |	         |		|		|		|--- config
                 |	         |		|		|		|		|--- AppConfig.java
                 |	         |		|		|		|		|--- WebConfig.java
                 |	         |		|		|		|--- controller
                 |	         |		|		|		|--- exception
                 |	         |		|		|		|--- repository
                 |	         |		|		|		|--- service
                 |	         |		|		|		|--- vo
                 |	         |		|		|		|--- aop
                 |
                 |--- [resources]
                 |	         |--- com 
                 |	         |		|--- poscoict
                 |	         |		|		|--- jblog
                 |	         |		|		|		|--- config
                 |	         |		|		|		|		|--- app
                 |	         |		|		|		|		|		|--- jdbc.properties
                 |	         |		|		|		|		|		|--- mybatis
                 |	         |		|		|		|		|		|		|--- configuration.xml
                 |	         |		|		|		|		|		|		|--- mappers
                 |	         |		|		|		|		|		|		|		|--- blog.xml
                 |	         |		|		|		|		|		|		|		|--- category.xml
                 |	         |		|		|		|		|		|		|		|--- post.xml
                 |	         |		|		|		|		|		|		|		|--- user.xml
                 |	         |		|		|		|		|--- web
                 |	         |		|		|		|		|		|--- fileupload.properties
<pre> 