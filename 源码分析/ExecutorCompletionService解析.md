# ExecutorCompletionService解析

### 0、位置

```java
package java.util.concurrent;
```

### 1、类别

类

### 2、功能介绍

构建了一个内部的任务队列类QueueingFuture，内核使用的是阻塞队列BlockingQueue实现的，通过把任务放到队列中，然后按个执行。

### 3、方法

```java
public ExecutorCompletionService(Executor executor)
```

说明：

```java
public ExecutorCompletionService(Executor executor,
                                     BlockingQueue<Future<V>> completionQueue)
```

说明：

```java
private RunnableFuture<V> newTaskFor(Callable<V> task)
```

说明：

```java
private RunnableFuture<V> newTaskFor(Runnable task, V result)
```

说明：

```java
public Future<V> submit(Callable<V> task)
```

说明：

```java
public Future<V> submit(Runnable task, V result)
```

说明：

```java
public Future<V> take()
```

说明：

```java
public Future<V> poll()
```

说明：

```java
public Future<V> poll(long timeout, TimeUnit unit)
```

说明：

### 3、属性说明

```java
    private final Executor executor;
    private final AbstractExecutorService aes;
    private final BlockingQueue<Future<V>> completionQueue;
```

说明：

