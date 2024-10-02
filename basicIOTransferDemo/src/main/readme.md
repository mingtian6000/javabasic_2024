1. we will demo basic java IO operations in this module
e.g. bytestreams/charstreams
2. will demo some network transportation(basic tcp/udp/http)
3. advanced file operation

4. NIO and its related framework
5. java logging 

   6. network transfer framework:
         网络调用类型
         （1）传统BIO（Blocking IO）
         同步阻塞式IO，服务器实现模式为一个连接一个线程，即客户端有连接请求时服务器端就需要启动一个线程进行处理，如果这个连接不做任何事情会造成不必要的线程开销，当然可以通过线程池机制改善。
         （2）NIO(Not-Blocking IO)
           NIO：同步非阻塞式IO，服务器实现模式为一个请求一个线程，即客户端发送的连接请求都会注册到多路复用器上，多路复用器轮询到连接有I/O请求时才启动一个线程进行处理。
         （3) AIO(NIO.2)
           异步非阻塞式IO，服务器实现模式为一个有效请求一个线程，客户端的I/O请求都是由OS先完成了再通知服务器应用去启动线程进行处理。
      HTTP 协议可能是现在Internet上使用得最多、最重要的协议了， JDK的java net包中已经提供了访问 HTTP 协议的基本功能，但是对于大部分应用程序来说。HttpClient可能才是应用最广泛的lib
        httpclient(resttemplate will leave to spring framework)
                  connection pooling;
                  timeout;
                  handling redirect;https://wheregoes.com/
                  HTTP重定向是指当用户请求一个URL时，服务器返回一个特殊的HTTP状态码（通常是301或302），指示客户端去访问另一个URL。
                  这种机制常用于网站迁移、页面更名、处理旧的或错误的链接等情况。在Linux中，实现HTTP重定向主要依赖于Web服务器的配置
                  以Apache为例，可以通过修改.htaccess文件或使用mod_rewrite模块来实现重定向。例如，使用mod_rewrite的RewriteRule指令，
                  可以将旧的URL模式映射到新的URL上，从而实现自动重定向。 
                  async request;

7. 
