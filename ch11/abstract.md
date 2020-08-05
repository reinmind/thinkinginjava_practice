持有对象
---
```
如果一个程序只包含固定数量的且生命周期已知的对象，那么这是一个非常简单的程序
```
- 泛型和类型安全的容器
- 基本概念
- 添加一组元素
- 容器的打印
- List
- 迭代器
```
    任何容器类，都必须有某种方式可以插入元素并将它们再次取回
    迭代器帮助脱离容器类型进行编程
```
```markdown
    Java中迭代器的特性  
---
- 使用iterator()要求容器返回Iterator，Iterator将准备返回序列的第一个元素
- 使用next（）获得序列的下一个元素
- 使用hasNext（）检查序列中是否还有元素
- 使用remove（）将迭代器新近返回的元素删除

```
- LinkedList
- Stack
- Set
- Map
- Queue
- Collection和Iterator
- Foreach与迭代器

两个类型
---
```
Collection: interface
    List: interface
    Queue: interface
        BlockingQueue: interface
        Deque: interface
        AbstractQueue: class
            PriorityQueue: class
        ConcurrentLinkedQueue: class
    Set: interface
        SortedSet:  interface
            CheckedSortedSet : abstract class
        HashSet: class
            LinkedHashSet: class
Map: interface
    HashMap: class
        LinkedHashMap: class
    AbstractMap: class
        TreeMap: class
    Hashtable: class
    SortedMap: class
```
```
collection: 
    add(): public
    remove(): public
```

散列与散列码
---
_**如果要使用自己的类作为HashMap的键，必须同时重载hashCode()和equals()**_
```
正确的equals方法必须同时满足下列五个条件  
1）自反性:x.equals(x)一定为true
2）对称性:x.equals(y)为true,那么y.equals(x)也为true
3）传递性:x.equlas(y)为true,y.equals(z)为true,那么z.equals(z)也为true
4）一致性:如果对象中用于等价比较的信息没有改变，无论调用x,y多少次，结果依然为true
5）对任何不是null的x,x.equals(null)一定返回false
```
设计模式
---
- 迭代器
```markdown
迭代器是一个对象,它的工作是遍历并选择序列中的对象
```