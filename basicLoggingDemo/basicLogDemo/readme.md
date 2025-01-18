# this module is mainly used to demo logback logging
    Logback当前分成三个模块：logback-core，logback- classic和logback-access：
    logback-core 模块为其他两个模块奠定了基础。
    logback-classic 模块可以被同化为 Log4j 的显着改进版本。logback-classic 本身实现了 slf4j-api，
    因此我们可以在 logback 和其他日志框架（如 Log4j 或java.util.logging（JUL））之间来回切换。
    NOTE： Logback的内核重写了，在一些关键执行路径上性能提升10倍以上。而且logback不仅性能提升了，初始化内存加载也更小，对于大型应用来说，这是一个很大的优势。

    you need to be familiar with logback architecture and below components:
## logger: top layer caller:

## appender：An appender in Logback is responsible for delivering log messages to their destination. It could be a file, console, database, or even a remote service.
FileAppender to write log messages to a file,
ConsoleAppender to print logs on the console,
SocketAppender to send log messages over the network.

## layout：A layout defines how the log message is formatted. It takes the log event and converts it into a string that can be appended by the appender.
An appender uses a layout to format the log message before outputting it.

## encoding：how the log message is encoded into bytes before being sent to the destination.
If not specified, a default encoding (e.g., the system's default encoding etf-8) might be used.
PatternLayoutEncoder
JsonEncoder

## filter：Filters are used to control which log messages are processed and which are discarded
LevelFilter, ThresholdFilter, EvaluatorFilter
Filters are attached to appenders. Multiple filters can be added to an appender, and they are applied in a chain to determine if a log message should be processed by the appender.
by default, filter will be attached to specific appender.
note the diff between neutral and deny

## MDC：MDC provides a way to add contextual information to log messages. It allows you to add key-value pairs that are part of the logging context.
  enrich 上下文-- usage？ 
  shine brightest within client server architectures： tracing thread/ request id/ etc..
  
## simple config file in overall view:
```dockerfile
<configuration>
	<appender name="STDOUT"
		class="ch.qos.logback.core.ConsoleAppender">
		<layout class="ch.qos.logback.classic.PatternLayout">
      <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
		</layout>
	</appender>

	<root level="debug">
		<appender-ref ref="STDOUT" />
	</root>
</configuration>
```
## extension:
Logback-Classic focuses on application-internal logging, such as logging the behavior of business logic, database operations, and other internal processes of the application. 
Logback-Access, on the other hand, is dedicated to logging HTTP-related information in a web environment.

in the sample code , will demonstrate:
1. customized logging
2. how to use customized logging integrated with Kafka.
   https://blog.csdn.net/lovelichao12/article/details/110676851
   https://github.com/danielwegener/logback-kafka-appender
3. how to use customized logging integrated with Kafka and ElasticSearch.
  使用logback 把日志发送到kafka
4. how to use default logging kafka client


# reference: 
  https://blog.csdn.net/weixin_43999395/article/details/109504092
  讲的和总结都很好。

# Q:
current popular tracing like Tlog, TTL, all use MDC, but that based on HTTP , for MQ/DB transmation, is there a way to trace?





