package typeinfo;

import java.util.ArrayList;
import java.util.List;

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
