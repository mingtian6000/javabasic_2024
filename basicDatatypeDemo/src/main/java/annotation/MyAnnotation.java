package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
//表示该注解在源文件中保留，以便在编译时处理
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation {
    String value() default "";
}
