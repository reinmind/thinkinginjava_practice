package typeinfo;

import typeinfo.factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 汽车组件类，包含组件列表，调用工厂的Factory（）构造函数添加组件
 *
 * @author zx
 */
class Part {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    /**
     * 工厂列表
     */
    static List<Factory<? extends Part>> partFactory = new ArrayList<>();

    static {
        /**
         * 添加工厂对象
         */
        partFactory.add(new AirFilter.Factory());
        partFactory.add(new FuelFilter.Factory());
    }

    private static Random random = new Random(47);

    /**
     * 随机生成一个整数，制造一个对应的汽车组件
     *
     * @return
     */
    public static Part createRandom() {
        int n = random.nextInt(partFactory.size());
        return partFactory.get(n).create();
    }
}
