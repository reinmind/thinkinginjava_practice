package annotation.database;

/**
 * @author zx
 */
public @interface Uniqueness {
    Constraints constrains() default @Constraints(unique = true);
}
