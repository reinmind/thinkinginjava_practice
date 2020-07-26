package typeinfo.rf2;

import typeinfo.factory.Factory;
import typeinfo.factory.Factory2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    /**
     * 工厂列表
     */
    static List<Class<? extends Factory2<? extends Part>>> partFactory = new ArrayList<>();

    static {
        /**
         * 添加工厂对象
         */
        partFactory.add(AirFilter.Factory.class);
        partFactory.add(FuelFilter.Factory.class);
    }

    private static Random random = new Random(48);

    /**
     * 随机生成一个整数，制造一个对应的汽车组件
     *
     * @return
     */
    public static Part createRandom() throws IllegalAccessException, InstantiationException {
        int n = random.nextInt(partFactory.size());
        return partFactory.get(n).newInstance().getStuff().newInstance();
    }
}

class Filter extends Part {
}

class AirFilter extends Filter {
    /**
     * 一个继承Filter的工厂类，制造AirFilter
     */
    public static class Factory implements typeinfo.factory.Factory2<AirFilter> {
        @Override
        public Class<AirFilter> getStuff() {
            return AirFilter.class;
        }
        /**
         * @return 一个AirFilter对象
         */

    }
}

class FuelFilter extends Filter {
    public static class Factory implements typeinfo.factory.Factory2<FuelFilter> {
        @Override
        public Class<FuelFilter> getStuff() {
            return FuelFilter.class;
        }
    }
}

public class RegisteredFactory2 {

    public static List<Part> getParts() {
        List<Part> parts = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            try {
                parts.add(Part.createRandom());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return parts;
    }

}
