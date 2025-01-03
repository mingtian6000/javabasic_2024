package annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("MyAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class MyAnnotationProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            //获取被 @MyAnnotation 注解的元素集合
            Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
            for (Element element : annotatedElements) {
                if (element.getKind().isClass() || element.getKind().isExecutable()) {
                    MyAnnotation myAnnotation = element.getAnnotation(MyAnnotation.class);
                    String value = myAnnotation.value();
                    System.out.println("Found @MyAnnotation on " + element.getSimpleName() + " with value: " + value);
                }
            }
        }
        return true;
    }
}
