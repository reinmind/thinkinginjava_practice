package p9;

import java.util.EnumMap;
import java.util.Map;

import static enumerated.AlarmPoints.*;
import enumerated.*;
/**
 * @author XiangZhang
 * @date 2020/9/21
 * @description EnumMap命令设计模式
 */
interface Command { void action();}

public class EnumMaps {
    public static void main(String[] args) {
        //根据场景放入命令
        EnumMap<AlarmPoints,Command> em = new EnumMap(AlarmPoints.class);
        em.put(KITCHEN,() -> System.out.println("kitchen fire"));
        em.put(BATHROOM,() -> System.out.println("Bathrom alert!"));
        for(Map.Entry<AlarmPoints,Command> e: em.entrySet()){
            System.out.print(e.getKey() + ": ");
            e.getValue().action();
        }

        //如果不存在枚举值
        try{
            em.get(UTILITY).action();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
