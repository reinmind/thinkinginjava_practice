接口
---
```
接口和内部类为我们提供了一种将接口与实现分离的更加结构化的方法
```
- 抽象类和抽象方法
```
介于普通类与接口之间的方法
```
- 接口
```
field : static final
```
- 完全解耦
- Java中的多重继承
- 通过继承来拓展接口
- 适配接口
- 接口中的域
- 嵌套接口
- 接口与工厂

设计模式
---
- 策略
```
创建一个能够根据所传递参数对象的不同而具有不同行为的方法
策略就是一个接口，实现这个接口的不同的类具有不同的策略方法，来处理相同的参数
```
- 适配器
```
适配器当中的代码将接受你所拥有的接口，并产生你所需要的接口
interface Processor
class Filter
class FilterAdapter implements Processor {
    Filter filter;
...
}
```
- 工厂
```
将代码完全与接口实现分离，这就使得我们可以透明地将某个实现替换为另一个实现
interface Service{
    + Object method1();
    + Object method2();
}
interface ServiceFactory{
    + Srevice getService();
}
class Factory{

}
```