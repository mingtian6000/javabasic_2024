算法：
## 基本的排序
### 冒泡
每次将最小的元素下沉到当前数组的后面，遍历时遇到大的就交换
2 for  1 swap
### 选择
每次选择最小的元素放到当前数组的前面
2 for 1 swap
### 插入
每次将当前元素插入到已经排好序的数组中
遍历的元素依次与其前面的元素进行比较，并把比它大的元素依次向后移动
one for, one while,no swap
### 归并排序
  
### 快速排序
lumotu/hocre
有点难，还在看。。

sumary: 时间复杂度上，冒泡和插入差不多，选择最烂，快排最好
### 二分查找
## 递归
```tree
void f(Node head){
    if(head == null){
        return;
    }
    f(head.left);
    f(head.right);
}
```
```quicksort
void quicksort(int[] arr, int left, int right){
    if(left >= right){
        return;
    }
    int pivot = partition(arr, left, right);
    quicksort(arr, left, pivot-1);
    quicksort(arr, pivot+1, right);
}
```

## 进阶数据结构 ： 链表， 树 图

### tree
#### 二叉树
  pre-order: root -> left -> right
  in-order: left -> root -> right
  post-order: left -> right -> root
  leave-order
  任何递归都可以改为非递归： 
  pre-order 出栈-》打印（处理）-》先压右 在压👈
  post-order
    cur 压收集栈2-》 压cur左 压cur👉到栈1-》 弹栈1 --》 loop
  in-order: 左边界入栈 -》null，出栈-》
   整颗tree都按左边界分解掉了。。
  如何直观打印一颗二叉树？
##### binarySearchTree checkBST
  排序好的二叉树，左边小于根，右边大于根
  中序遍历求解，升序
#### complete binary Tree 完全二叉树
  铺满的，最后一层可以不满但都集中在左边
  为啥要讨论完全二叉树？ 用在二叉堆，huffman codding和 BST 的balancing上？？
  
#### BFS Breadth-First Search
BFS 是一种分层搜索算法，它从起始节点开始，逐层向外扩展搜索。首先访问起始节点，然后访问起始节点的所有邻居节点，
接着访问邻居节点的邻居节点，依此类推，直到找到目标节点或遍历完整个图。 宽度遍历通常使用队列实现，为啥？

#### DFS Depth-First Search
DFS 是一种优先沿着深度方向搜索的算法，它从起始节点开始，沿着一条路径尽可能深地访问节点，直到无法继续，然后回溯并尝试其他路径。
通常使用栈或者递归实现

个人觉得比较难得是递归和链表

lt141
