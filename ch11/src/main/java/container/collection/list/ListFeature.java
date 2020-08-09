package container.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * List在Collection基础上增加了大量方法
 * ArrayList：随机访问数组
 * LinkedList：代价较低在List中插入删除元素
 */
public class ListFeature<T> {
    private List<T> arrayList;
    private List<T> linkedList;
    public ListFeature(){
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
    }

    public void setArrayList(List<T> arrayList) {
        this.arrayList = arrayList;
    }

    public void setLinkedList(List<T> linkedList) {
        this.linkedList = linkedList;
    }

    public List<T> getArrayList() {
        return arrayList;
    }

    public List<T> getLinkedList() {
        return linkedList;
    }
}
