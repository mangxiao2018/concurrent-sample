# CompletionService 解析

## 0、位置

```java
package java.util.concurrent;
```

## 1、类别

接口

## 2、功能介绍

该接口用于对创建异步任务和任务执行完结果返回之间的解耦。

## 3、方法

```java
Future<V> submit(Callable<V> task);
```

说明：异步执行任务并返回Future结果

```java
Future<V> submit(Runnable task, V result);
```

说明：异步执行任务并返回Future结果

```java
Future<V> take() throws InterruptedException;
```

说明：取出一个元素数据

```java
Future<V> poll();
```

说明：取出一个元素数据

```java
Future<V> poll(long timeout, TimeUnit unit) throws InterruptedException;
```

说明：取出元素时待等timeout时长后超时

