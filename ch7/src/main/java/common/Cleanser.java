package common;

public class Cleanser {
    private String s = "Cleanser";
    public void append(String s){this.s += s;}
    public void dilute(){ append(" dilute()");}
    public void scrub(){append(" scrub()");}
    @Override
    public String toString() {
        return this.s;
    }
    Cleanser(){
        System.out.println("cleanser");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("cleanser finalize.");
    }
}
