## new features
1.Java 8 引入了函数式接口，这是只包含一个抽象方法的接口，
使用 @FunctionalInterface 注解来标识。可以使用 Lambda 表达式或方法引用来创建函数式接口的实例。
注意传入参数就是一个函数式接口的场合（比如我们那个MQ）

使用 @FunctionalInterface 注解确保接口只有一个抽象方法。
可以使用泛型来提高接口的通用性。
将自定义函数式接口作为方法参数，实现更灵活的编程。

2.很多 Java 标准库的方法中，可以使用 Lambda 表达式作为参数，实现函数式编程风格

从jdk8开始，Java就在不停升级
目前升到jdk21/23
jdk21 的新特性也不能不知道: 记住三个： 虚拟线程，sequencecollection，未命名模式，增强的siwtch


## 设计模式
1. 单例模式 Singleton:注意里private static的instance
2. 简单工场模式 FactoryPatternExample，使用抽象类或者接口，具体实现交给子类，调用时候在决定是哪个子类
3. 适配器模式 AdaptorExample
4. 装饰器模式 DecoratorExample coffee and coffeeDecorator
5. 观察者模式 ObserverPatternExample --> 消息队列实现通知，pub/sub模式
6. 策略模式？？ 
7. 代理模式：动态代理， 静态代理
8. 

## 反射
反射基本是一切的基石，所有框架，APM，rule engine基本都基于反射实现。
所以反射一定要吃透。
1. Reflection 获取类的基本信息，包括类名、修饰符、父类和实现的接口。basic Demo
2. ReflectionInvokeExample

## 注解：
在Java中注解其实就是写在接口、类、属性、方法上的一个标签，或者说是一个特殊形式的注释，与普通的//或/**/注释不同的是：
  普通注释只是一个注释，而注解在代码运行时是可以被反射读取并进行相应的操作，而如果没有使用反射或者其他检查，那么注解是没有任何真实作用的，
  也不会影响到程序的正常运行结果。@Override  @SuppressWarnings
Spring框架中常用的一些注解：@Controller、@Service、@RequestMapping，以此来实现某些功能。
元数据是添加到程序元素如方法、字段、类和包上的额外信息，注解就是一种载体形式
注解不能直接干扰程序代码的运行
回顾spring的发展历程：从xml的配置文件到现在注解用的天花乱坠，分久必合 合久必分》？
  xml的方式是集中式的元数据，不需要和代码绑定的，而注解是一种分散式的元数据设置方式
元注解： 注解的注解，不能改的，你只能用他定义其他的注解
### 自定义注解的创建和使用
比如定义一个authoraized注解或者cachable的注解
https://blog.csdn.net/KingBoyWorld/article/details/105337011
### 注解处理器的开发
更复杂，，针对你的注解做额外的处理 extends AbstractProcessor
1. 创建自定义注解，指定其 @Target 和 @Retention。
2. 创建注解处理器，继承自 AbstractProcessor，并实现 process 方法处理注解。
3. 注册注解处理器，在 META-INF/services/javax.annotation.processing.Processor 文件中添加处理器的全限定名。
4. 在代码中使用自定义注解。
   https://www.baeldung.com/java-annotation-processing-builder
有一步没看明白，为啥要注册注解处理器，不注册他不能处理吗？

   
### hackson的内容打算慢慢剥离出去，高另一个repo dedicate for hackthon and leetcode

##### 1.double的输出，注意类型的隐士转换
格式化输出的时候注意printf("%.6f%n", d)

##### 2.溢出处理
If you're using an ArrayList<Integer> in Java to perform summation and you encounter issues like overflow (when the sum exceeds the maximum value an int can hold), you can handle this situation in several ways.
很有意思的一道题
一般用long/bigInteger来handle
`for (int number : numbers) {
  // Check for overflow
  if (sum > 0 && number > Integer.MAX_VALUE - sum) {
    System.out.println("Overflow occurred!");
    return;
  }
  sum += number;
}`
注意stream中判断sum时候.mapToLong(Integer::longValue)来做类似以上for循环的处理。

##### 3.timecovertion: 没啥难度，但是要考虑所有的边界条件。。

### day2
##### 1.list map用stream的相互转化
- list -> map
`Map<Integer, Long> duplicates = numbers.stream()
      .collect(Collectors.groupingBy(n -> n, Collectors.counting())) // Group by number and count occurrences
      .entrySet()
      .stream()
      .filter(entry -> entry.getValue() > 1) // Filter entries with count greater than 1
      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)); // Collect to a map`
- map -> list
`List<Integer> element = result.keySet().stream().collect(Collectors.toList());`
有时候可能一步转化不了要借助多部转化

##### 2.计算矩阵对角线，注意找对下表，不用做list到array2D转化，其他没难度

### day3+4
##### 1.TowerBreaker：
代码不复杂，但实际是个逻辑问题，只用看奇数偶数这样。
- Single Tower Case:
  If there is only one tower (n = 1), the outcome depends on the height m:
    - If m = 1, Player 1 cannot make a move and loses.
    - If m > 1, Player 1 can always make a move and will win.
- Multiple Towers:
  When there are multiple towers (n > 1), the strategy involves assessing the overall state.
  The game's outcome changes based on whether m is even or odd:
    - If m = 1, Player 1 loses immediately regardless of n since no moves can be made.
    - If m > 1 and n is odd, Player 1 can always make moves that leave an even number of towers, allowing them to control the game.
    - If n is even, Player 2 can mirror Player 1's moves, leading to a potential win for Player 2.

##### 2.简单加密解密
注意直接用int x=charc就能拿到值，然后区分是哪个区间，找到规律
不要用character.getNumbericValue  那个不是常规我们理解的int value。。。

##### 3.superdigit
以为是简单递归问题，实则不是。。需要做时间复杂度优化。。其实只用吧拼接字符串的地方小小修改一下。。
if(!flg){sum = sum*k; flg=true;} //only for 1st time

##### 4.bribe and chaotic
实则是个链表问题， 如果满足不超过两次的swap，那么一共swap多少次。。要求时间复杂度要满足。。

##### 5.改版的回文。。