# ExecutorService 解析

## 0、位置

```java
package java.util.concurrent;
```

## 1、功能介绍

> 功能介绍:

## 2、方法

```java
void shutdown();
```

说明：发起一个按顺序停止任务的关闭动作，该动作发起后不再接受新的任务请求，但原来已在执行中的任务会被逐个停止。

```java
List<Runnable> shutdownNow();
```

说明：终止所有任务，并返回任务列表

```java
boolean isShutdown();
```

说明：判断该Executor是否已被终止

```java
boolean isTerminated();
```

说明：判断是否所有的任务都已关闭

```java
boolean awaitTermination(long timeout, TimeUnit unit)
        throws InterruptedException;
```

说明:等待关闭，阻塞，直到所有的任务被执行完才进行任务关闭，另外，或者超时或当前线程被中断也才进行任务关闭，否则处于阻塞状态中。

```java
<T> Future<T> submit(Callable<T> task);
```

说明:提交有返回值的任务

```java
<T> Future<T> submit(Runnable task, T result);
```

说明：提交有返回值的任务

```java
Future<?> submit(Runnable task);
```

说明:提交有返回值的任务

```java
<T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
        throws InterruptedException;
```

说明：执行给定的集合里的任务，并把他们的状态和结果通过集合返回

```java
<T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                  long timeout, TimeUnit unit)
        throws InterruptedException;
```

说明：执行给定的集合里的任务，并把他们的状态和结果通过集合返回, 设置了超时

```java
<T> T invokeAny(Collection<? extends Callable<T>> tasks)
        throws InterruptedException, ExecutionException;
```

说明：执行给定的集合里的任务，并把他们的状态和结果通过集合返回

```java
<T> T invokeAny(Collection<? extends Callable<T>> tasks,
                    long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
```

说明：执行给定的集合里的任务，并把他们的状态和结果通过集合返回
