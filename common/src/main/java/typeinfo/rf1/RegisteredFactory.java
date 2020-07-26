package typeinfo.rf1;

import typeinfo.factory.Factory;
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
    static List<Factory<? extends Part>> partFactory = new ArrayList<>();

    static {
        /**
         * 添加工厂对象
         */
        partFactory.add(new AirFilter.Factory());
        partFactory.add(new FuelFilter.Factory());
    }

    private static Random random = new Random(48);

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

class Filter extends Part {
}

class AirFilter extends Filter {
    /**
     * 一个继承Filter的工厂类，制造AirFilter
     */
    public static class Factory implements typeinfo.factory.Factory<AirFilter> {
        /**
         * @return 一个AirFilter对象
         */
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class FuelFilter extends Filter {
    public static class Factory implements typeinfo.factory.Factory<FuelFilter> {

        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

public class RegisteredFactory {

    public static List<Part> getParts() {
        List<Part> parts = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            parts.add(Part.createRandom());
        }
        return parts;
    }

}
