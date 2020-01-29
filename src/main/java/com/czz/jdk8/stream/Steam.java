package com.czz.jdk8.stream;

/**
 * @author cheng.zz@burgeon.com
 * @create 2020-01-14 14:43
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 *  创建 Stream
 * 一个数据源（如：集合、数组），获取一个流
 *  中间操作
 * 一个中间操作链，对数据源的数据进行处理
 *  终止操作(终端操作)
 * 一个终止操作，执行中间操作链，并产生结果
 *
 *
 *
 *  default Stream<E> stream() : 返回一个顺序流
 *  default Stream<E> parallelStream() : 返回一个并行流
 *
 *
 * Java8 中的 Arrays 的静态方法 stream() 可
 * 以获取数组流：
 *  static <T> Stream<T> stream(T[] array): 返回一个流
 * 重载形式，能够处理对应基本类型的数组：
 *  public static IntStream stream(int[] array)
 *  public static LongStream stream(long[] array)
 *  public static DoubleStream stream(double[] array)
 *
 *
 * 可以使用静态方法 Stream.of(), 通过显示值
 * 创建一个流。它可以接收任意数量的参数。
 *  public static<T> Stream<T> of(T... values) : 返回一个流
 *
 *
 * 可以使用静态方法 Stream.iterate() 和
 * Stream.generate(), 创建无限流。
 *
 *  迭代
 * public static<T> Stream<T> iterate(final T seed, final
 * UnaryOperator<T> f)
 *  生成
 * public static<T> Stream<T> generate(Supplier<T> s)
 *
 *Stream 的中间操作
 * 多个中间操作可以连接起来形成一个流水线，除非流水
 * 线上触发终止操作，否则中间操作不会执行任何的处理！
 * 而在终止操作时一次性全部处理，称为“惰性求值”。
 *
 * filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
 * distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去
 * 除重复元素
 * limit(long maxSize) 截断流，使其元素不超过给定数量。
 * skip(long n) 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素
 * 不足 n 个，则返回一个空流。与 limit(n) 互补
 *
 *
 * Stream 的中间操作
 * map(Function f) 接收一个函数作为参数，该函数会被应用到每个元
 * 素上，并将其映射成一个新的元素。
 * mapToDouble(ToDoubleFunction f) 接收一个函数作为参数，该函数会被应用到每个元
 * 素上，产生一个新的 DoubleStream。
 * mapToInt(ToIntFunction f) 接收一个函数作为参数，该函数会被应用到每个元
 * 素上，产生一个新的 IntStream。
 * mapToLong(ToLongFunction f) 接收一个函数作为参数，该函数会被应用到每个元
 * 素上，产生一个新的 LongStream。
 * flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另
 * 一个流，然后把所有流连接成一个流
 *
 * sorted() 产生一个新流，其中按自然顺序排序
 * sorted(Comparator comp) 产生一个新流，其中按比较器顺序排序
 *
 * 终端操作会从流的流水线生成结果。其结果可以是任何不是流的
 * 值，例如：List、Integer，甚至是 void 。
 * allMatch(Predicate p) 检查是否匹配所有元素
 * anyMatch(Predicate p) 检查是否至少匹配一个元素
 * noneMatch(Predicate p) 检查是否没有匹配所有元素
 * findFirst() 返回第一个元素
 * 终端操作会从流的流水线生成结果。其结果可以是任何不是流的
 * 值，例如：List、Integer，甚至是 void 。
 * findAny() 返回当前流中的任意元素
 *
 *Stream 的终止操作
 * 方 法 描 述
 * count() 返回流中元素总数
 * max(Comparator c) 返回流中最大值
 * min(Comparator c) 返回流中最小值
 * reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。
 * 返回 T
 * 归约
 * reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。
 * 返回 Optional<T>
 *
 *
 * collect(Collector c) 将流转换为其他形式。接收一个 Collector接口的
 * 实现，用于给Stream中元素做汇总的方法
 *
 * toList List<T> 把流中元素收集到List
 * List<Employee> emps= list.stream().collect(Collectors.toList());
 * toSet Set<T> 把流中元素收集到Set
 * Set<Employee> emps= list.stream().collect(Collectors.toSet());
 * toCollection Collection<T> 把流中元素收集到创建的集合
 * Collection<Employee>emps=list.stream().collect(Collectors.toCollection(ArrayList::new));
 * counting Long 计算流中元素的个数
 * long count = list.stream().collect(Collectors.counting());
 * summingInt Integer 对流中元素的整数属性求和
 * inttotal=list.stream().collect(Collectors.summingInt(Employee::getSalary));
 * averagingInt Double 计算流中元素Integer属性的平均
 * 值
 * doubleavg= list.stream().collect(Collectors.averagingInt(Employee::getSalary));
 * summarizingInt IntSummaryStatistics 收集流中Integer属性的统计值。
 * 如：平均值
 * IntSummaryStatisticsiss= list.stream().collect(Collectors.summarizingInt(Employee::getSalary));
 * joining String 连接流中每个字符串
 * String str= list.stream().map(Employee::getName).collect(Collectors.joining());
 * maxBy Optional<T> 根据比较器选择最大值
 * Optional<Emp>max= list.stream().collect(Collectors.maxBy(comparingInt(Employee::getSalary)));
 * minBy Optional<T> 根据比较器选择最小值
 * Optional<Emp> min = list.stream().collect(Collectors.minBy(comparingInt(Employee::getSalary)));
 * reducing 归约产生的类型 从一个作为累加器的初始值
 * 开始，利用BinaryOperator与
 * 流中元素逐个结合，从而归
 * 约成单个值
 * inttotal=list.stream().collect(Collectors.reducing(0, Employee::getSalar, Integer::sum));
 * collectingAndThen 转换函数返回的类型 包裹另一个收集器，对其结
 * 果转换函数
 * inthow= list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
 * groupingBy Map<K, List<T>> 根据某属性值对流分组，属
 * 性为K，结果为V
 * Map<Emp.Status, List<Emp>> map= list.stream()
 * .collect(Collectors.groupingBy(Employee::getStatus));
 * partitioningBy Map<Boolean, List<T>> 根据true或false进行分区
 * Map<Boolean,List<Emp>>vd= list.stream().collect(Collectors.partitioningBy(Employee::getManage));
 *
 *
 *
 */
public class Steam {
}
