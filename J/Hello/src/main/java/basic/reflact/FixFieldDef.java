package basic.reflact;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(value = {ElementType.FIELD})
public @interface FixFieldDef {
    int order();

    int length();

    String align() default "LEFT";

    char padSpace() default ' ';
}
