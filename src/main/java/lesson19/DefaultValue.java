package lesson19;

import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultValue {
    String value() default "15";
    Class<?> clazz() default DefaultValue.class;
}
