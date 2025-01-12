# this module is mainly used to demo logback logging
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
Logback-Classic focuses on application - internal logging, such as logging the behavior of business logic, database operations, and other internal processes of the application. 
Logback-Access, on the other hand, is dedicated to logging HTTP - related information in a web environment.

in the sample code , will demonstrate:
1. customized logging
2. how to use customized logging integrated with Kafka.
3. how to use customized logging integrated with Kafka and ElasticSearch.
4. how to use default logging kafka client

# Q:
current popular tracing like Tlog, TTL, all use MDC, but that based on HTTP , for MQ/DB transmation, is there a way to trace?


