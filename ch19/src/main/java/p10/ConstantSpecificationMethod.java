package p10;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author XiangZhang
 * @date 2020/9/21
 * @description 用枚举类获取jdk信息
 */
public enum ConstantSpecificationMethod {
    DATE_TIME{
        String getInfo(){
            return DateFormat.getDateInstance().format(new Date());
        }

    },
    CLASS_PATH{
        String getInfo(){
            return System.getenv("CLASS_PATH");
        }
    },
    VERSION{
       String getInfo(){
           return System.getProperty("java.version");
       }
    };

    abstract String getInfo();
    public String toString(){
        return getInfo();
    }
    public static void main(String args[]){
        for(ConstantSpecificationMethod csm:values()){
            System.out.println(csm);
        }
    }
}
