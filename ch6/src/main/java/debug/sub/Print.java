package debug.sub;

class Print {
    public static String debug(){
        //即时是子包下面的包也不能访问上级的Print
        //return debug.Print.pro();
        return debug();
    }
}
