容器的深入研究
---
- 完整的容器分类法
- 填充容器
- Collection的功能方法
- 可选操作
- List的功能方法
- Set的存储操作
- 队列
- 理解Map
- 散列与散列码
- 选择接口的不同实现
- 实用方法  
- - 排序和查询
- - 设定Collection与Map不可修改
- - Collection与Map的同步控制
- 持有引用
- Java 1.0/1.1的容器
- - BitSet
- - Stack
- - Vector和Enumeration
- - Hashtable

理解HashMap
---
```
HashMap通过hashCode()进行快速查询
    HashMap*
        默认情况下的hashMap，性能通常也是最好的
    LinkedHashMap
        取得键值对的次序按照插入次序，但是迭代访问更快
    TreeMap
        基于红黑树的实现，它们会被排序
    WeakHashMap
        弱键映射，允许释放映射所指的对象
    ConcurrentHashMap
        一种线程安全的Map
    IdentityHashMap
        使用==号代替equals()对“键”进行比较的散列映射
```
```java
// String hashCode()源码
/** Cache the hash code for the string */
    private int hash; // Default to 0
/** The value is used for character storage. */
    private final char value[];
    public int hashCode() {
            int h = hash;
            if (h == 0 && value.length > 0) {
                char val[] = value;

                for (int i = 0; i < value.length; i++) {
                    //这里的31是个谜
                    h = 31 * h + val[i];
                }
                hash = h;
            }
            return h;
        }
```