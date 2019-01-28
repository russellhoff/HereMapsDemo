# HERE MAPS DEMO APPLICATION

This project aims to consume Here's Traffic API. We've been told that API follows OAUTH2 standard.

### Rest API
Base URL is `http://data.traffic.api.here.com/` and we're trying to consume the following Rest Methods (please, see HereMethods.java): 
* [HTTP GET] datex/2.3/flow/content.json
* [HTTP GET] datex/2.3/incident/content.json 

### What's working
We've been able to fetch new Access Tokens. To my knowledge, being able to get those means that tokens are right, so access to Rest Endpoints should be granted.

### What it isn't working
Consuming the two Rest methods mentioned above results in `java.net.SocketTimeoutException` exception:

```
java.net.SocketTimeoutException: connect timed out
	at java.net.DualStackPlainSocketImpl.waitForConnect(Native Method) ~[na:1.8.0_121]
	at java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:85) ~[na:1.8.0_121]
	at java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350) ~[na:1.8.0_121]
	at java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206) ~[na:1.8.0_121]
	at java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188) ~[na:1.8.0_121]
	at java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172) ~[na:1.8.0_121]
	at java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392) ~[na:1.8.0_121]
	at java.net.Socket.connect(Socket.java:589) ~[na:1.8.0_121]
	at okhttp3.internal.platform.Platform.connectSocket(Platform.java:129) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.connection.RealConnection.connectSocket(RealConnection.java:246) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.connection.RealConnection.connect(RealConnection.java:166) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.connection.StreamAllocation.findConnection(StreamAllocation.java:257) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.connection.StreamAllocation.findHealthyConnection(StreamAllocation.java:135) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.connection.StreamAllocation.newStream(StreamAllocation.java:114) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.connection.ConnectInterceptor.intercept(ConnectInterceptor.java:42) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:121) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.cache.CacheInterceptor.intercept(CacheInterceptor.java:93) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:121) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.http.BridgeInterceptor.intercept(BridgeInterceptor.java:93) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.http.RetryAndFollowUpInterceptor.intercept(RetryAndFollowUpInterceptor.java:126) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:121) ~[okhttp-3.12.0.jar:na]
	at okhttp3.RealCall.getResponseWithInterceptorChain(RealCall.java:254) ~[okhttp-3.12.0.jar:na]
	at okhttp3.RealCall$AsyncCall.execute(RealCall.java:200) ~[okhttp-3.12.0.jar:na]
	at okhttp3.internal.NamedRunnable.run(NamedRunnable.java:32) [okhttp-3.12.0.jar:na]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [na:1.8.0_121]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [na:1.8.0_121]
	at java.lang.Thread.run(Thread.java:745) [na:1.8.0_121]
```

### Before getting hands on
You should make a copy of IngartekConsulting.properties.sample file and edit every property within. The resulting name of the file should be IngartekConsulting.properties. Otherwise, edit HereConfig.java file.

### Running the App
We're developing that project in Eclipse, latest stable version of it. Simple run HereMapsDemoApplication.java file as a Spring Boot app.

### Building JAR
Place yourself in the root and type in your terminal `$ mvn clean package -DskipTests`. Afterwards, move to `target` directory and run it that way `java -jar ./HereMapsDemo-1.0.0-SNAPSHOT.jar`.