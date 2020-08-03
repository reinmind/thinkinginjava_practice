package common;

public interface Processor {
    String name();
    Object process(Object input);
}
