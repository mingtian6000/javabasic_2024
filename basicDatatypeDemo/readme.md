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