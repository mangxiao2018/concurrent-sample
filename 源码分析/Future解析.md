# Future解析

### 0、位置

```java
package java.util.concurrent;
```



### 1、类别

接口

### 2、功能介绍

异步计算的结果

### 3、方法

```java
boolean cancel(boolean mayInterruptIfRunning);
```

说明：尝试取消任务执行，如果任务已执行完或已取消，则取消失败，别外，当参数mayInterruptIfRunning=true时可以取消，否则不可以

```java
boolean isCancelled();
```

说明：判断任务是否已被取消

```java
boolean isDone();
```

说明：判断任务是否已执行完

```java
V get() throws InterruptedException, ExecutionException;
```

说明：等计算完成并获取结果

```java
V get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
```

说明：等计算完成并获取结果，有超时设置
