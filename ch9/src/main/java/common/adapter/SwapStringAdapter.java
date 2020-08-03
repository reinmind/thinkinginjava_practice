package common.adapter;

import common.Processor;
import common.SwapString;

public class SwapStringAdapter implements Processor {
    private SwapString swapString;
    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    /**
     *
     * @param input
     * @return
     */
    @Override
    public String process(Object input) {
        return swapString.swap((String)input);
    }

    public SwapStringAdapter(SwapString swapString) {
        this.swapString = swapString;
    }
}
