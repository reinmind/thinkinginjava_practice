package util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zx
 */
public class TypeCounter extends HashMap<Class<?>,Integer> {
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object obj){
        Class<?> type = obj.getClass();
        if(!baseType.isAssignableFrom(type)) {
            try {
                throw new Exception(obj + " incorrect type:" +
                            type + ".should be type of subtype of " + baseType);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        countClass(type);
    }

    /**
     * superClass is subtype of baseType
     * @param type
     */
    public void countClass(Class<?> type){
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if(superClass != null && baseType.isAssignableFrom(superClass)){
            countClass(superClass);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for(Map.Entry<Class<?>,Integer> pair : entrySet()){
            result.append(pair.getKey().getSimpleName());
            result.append(" = ");
            result.append(pair.getValue());
            result.append(",");
        }
        result.delete(result.length() - 1, result.length());
        result.append("}");
        return result.toString();
    }
}
