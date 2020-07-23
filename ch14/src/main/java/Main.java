import common.Circle;
import common.Rhomboid;
import common.Shape;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Vector;

/**
 * @author zx
 */
public class Main {
    /**
     * practice 3
     * des: Rhomboid向上转型为Shape，再向下转型为Circle
     */
     @Test
     public void f3(){
         Shape r = new Rhomboid();
         System.out.println("r:" + r);
         Shape s = r;
         System.out.println("s:" + s);
         System.out.println("object Name:" + s.getClass().getName());
         /**
          * practice 4
          * instanceof 类型检查
          */
         System.out.println("type check:" + (s instanceof Circle));

         /**
          * java.lang.ClassCastException: common.Rhomboid cannot be cast to common.Circle
          */
         //Circle c = (Circle)s;
         //System.out.println("c:" + c);
     }

     /**
      * practice 5
      * des: 旋转Shape，如果是Circle就不旋转
      */
      @Test
      public void f5(){
        Shape s1 = new Rhomboid();
        Shape s2 = new Circle();
        s1.rotate();
        s2.rotate();
      }

      /**
       * practice 6
       * des:修改Shape.java，使这个程序能将某个特定类型的所有形状都“标示”出来，每一个被导出的Shape类的toString（）
       * 应该能指示出Shape是否被标示
       */

      /**
       * practice 7
       * des: 通过命令行参数来生成指定类的对象
       */
       public static void main(String... args){
           Class cls = null;
           try {
               cls = Class.forName(args[0]);
               System.out.println(cls.getSimpleName());
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
       }

       /**
        * practice 8
        * des: 写一个方法，接收任意对象作为参数，并能够递归打印出该对象所在的继承体系中的所有类
        */
        @Test
        public void f8(){
            try {
                Class cls = Class.forName("org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor");
                dfsPrint(cls,"");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        void dfsPrint(Class cls,String ident) throws ClassNotFoundException{
            System.out.println(ident + "-" + cls);
            ident += "  ";
            Class up = cls.getSuperclass();
            if(up != null){
                dfsPrint(up,ident);
            }
            for(Class c: cls.getInterfaces()){
                dfsPrint(c,ident);
            }
        }
        /**
         * practice 9
         * des: 修改前一个练习，让这个方法使用Class.getDeclaredFields()来打印一个类中的域相关信息
         */
         @Test
         public void f9(){
             try {
                 Class cls = Class.forName("org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor");
                 dfsPrint_fields(cls,"");
             } catch (ClassNotFoundException e) {
                 e.printStackTrace();
             }
         }
    void dfsPrint_fields (Class cls,String ident) throws ClassNotFoundException{
        System.out.println(ident + "-" + cls.getSimpleName());
        ident += "  ";
        for(Field f : cls.getDeclaredFields()){
            System.out.println(ident + f.getName());
        }
        Class up = cls.getSuperclass();
        if(up != null){
            dfsPrint(up,ident);
        }
        for(Class c: cls.getInterfaces()){
            dfsPrint(c,ident);
        }
    }

    /**
     * practice 10
     * des:写一个程序，使它能判断char数组究竟是基本类型还是一个对象
     *
     * -class [C
     *   -class java.lang.Object
     *   -interface java.lang.Cloneable
     *   -interface java.io.Serializable
     *
     *   继承于Object显然是一个对象
     */
     @Test
     public void f10(){
        char[] x = new char[10];
        Class cls = x.getClass();
         try {
             dfsPrint(cls,"");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }


}
