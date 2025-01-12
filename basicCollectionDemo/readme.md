## java collection
### basic collection
  comparator
  array/list/map/hashtable...
  JDK21: sequeceed collection why?

### java queue
  FIFO --》可自己定义缓存。。 
  #### blockingQueue --> wait
    ArrayBlockingQueue / LinkedBlockingQueue / PriorityBlockingQueue / DelayQueue / SynchronousQueue
  #### nonBlockingQueue  --> raise error
    ConcurrentLinkedQueue 
    put/take/offer/poll/peek
  #### bounded queue
  #### non-bounded queue --> Integer.MAX_VALUE
  #### dequeue
  #### priority queue --> delay queue
    优先队列（PriorityQueue）是一种特殊的队列，它并不是先进先出的，而是优先级高的元素先出队。已经打破了FIFO。。
    实现是二叉堆，大根堆或者小根堆
    延迟队列： 一种以时间为度量单位的优先的队列，当入队的元素到达指定的延迟时间之后方可出队
    优先队列的应用场景：任务调度、负载均衡、Dijkstra算法、A*算法等
    延迟队列的应用场景：定时任务、缓存系统、消息中间件等


### 安全性：不可变集合
 immutable collections
1.google的guava的库，
`
 ImmutableList<String> list = ImmutableList.<String>builder()
     .add("a")
     .add("b")
     .add("c") --使用可变的arraylist，随便加
     .build(); --一旦调用build方法，就copy到不可变列表里了
 }
`
2.从java9开始，List.of也是返回unmodified list。

安全是安全，可能会有一次性性能开销。

### advanced collection
  1. concurrentSkipListMap
     适用于高并发、有序映射存储和查找的场景
     跳表是一种随机化的数据结构，支持快速查找、插入和删除操作，平均时间复杂度为 Ologn。链表的基础上添加多级索引，实现快速查找
2. CopyOnWriteArrayList
COW容器：读写分离和复制容器，不是在原来容器上写，是copy原来的容器，写完在把引用指向新容器
都多写少
注意：只能保证数据最终一致性 不能保证数据realtime一致性
3. WeakHashMap, and whats the softReference?
java中四种引用：强弱软虚， outofmemory/soft就是垃圾回收会不会干掉她不知道/weak是肯定会被干掉/虚等于没引用，可以不管
WeakHashMap是基于弱引用，其对象可能随时被回收，适用于**缓存**的场景
   _但是使用WeakHashMap做缓存时要注意，如果只有它的key只有WeakHashMap本身在用，
   而在WeakHashMap之外没有对该key的强引用，那么GC时会回收这个key对应的entry。
   所以WeakHashMap不能用做主缓存，合适的用法应该是用它做二级的内存缓存，即那么过期缓存数据或者低频缓存数据_
同理，可想，软引用可以使用在内存敏感的缓存。

### self-defined collections

### 集合框架的性能优化
  1. 要理解集合框架的扩展机制和细节
主要是arrayList + hashMap
list类是1.5倍，这里其实还包了一个vector，hashmap是2倍，会涉及到rehash
linkedlist是个双向链表，不存在扩容问题。

  2. 分析不同的集合在高并发的表现
  3. 优化集合一提高性能？？ 从哪几方面下手？

## 泛型 （Generic Type）
### 什么是泛型，工作原理是什么
在代码逻辑不关注具体的数据类型时使用。例如：实现一个通用的排序算法，此时关注的是算法本身，而非排序的对象的类型。
泛型方法/类/接口， 
`
class GenericMethod{
    public <T> T[] sort(T[] elements){
        return elements;
    }
}
`

### 复杂泛型的使用和限制
泛型不能用在基本类型，静态方法，异常。等

### 类型擦除
泛型的 .java 源代码， 但到了。class就没有了
泛型信息对 Java 编译器可以见，对 Java 虚拟机不可见。换句话说，在运行期，类型是确定的
还有一个向上转型和向下转型的概念，（也是基于继承）
比如有个class叫Father，还有个叫Son
Father f = new Son(), ((Father)f).eat();向上转型--》 瘦身，
向下转型，转的不对可能报错，把Father强转为Son。如果本来就是SOn对象就没问题。
？ extends T  :用在什么场合？
？ super T
### 泛型在集合框架中的高级应用
public class ArrayList<E> extends AbstractList<E>
集合类基本都会用到泛型，因为主要描述是这种数据结构，而不是具体类型
常用名字：E = Elememt、T = Type、K = Key、V = Value
### 并发类集合 concurrent
1. concurrentHashMap
是用了lock元素和CAS操作
casTabAt: CAS操作 compareandset
2. 注意怎么设计一个演示线程安全的例子
3. 什么场合使用并发集合


 