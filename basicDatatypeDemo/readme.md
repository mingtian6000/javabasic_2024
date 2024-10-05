### day1
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