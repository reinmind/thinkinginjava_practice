package entity;

/**
 * @author zx
 */
public abstract class Shape {


    void draw(){
        System.out.println(this + ".draw()");
    }

    /**
     * practice 5
     * 如果是Circle类就不旋转
     */
    public void rotate(){
        Class c = this.getClass();
        String name = c.getSimpleName();
        if("Circle".equals(name)) {
            return;
        }
        System.out.println(c + " is rotating.");
    }
    @Override
    public abstract String toString();

    /**
     * practice 6
     * des: 没看懂题目什么意思
     */


}
