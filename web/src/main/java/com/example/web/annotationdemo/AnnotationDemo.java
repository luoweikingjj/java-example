package com.example.web.annotationdemo;

@MyAnnotation(bytePro = 1, shortPro = 1, intPro = 1, longPro = 1, floatPro = 1, doublePro = 1, charPro = 'a', booleanPro = true, stringPro = "aa", myEnum = MyEnum.ENUM1, annotation1 = @Annotation1, strings =
        {"1", "2", "3"})
@AnnotationType
public class AnnotationDemo {

    @AnnotationField
    public String annotationField;

    public static void main(String[] args) {

    }

    @AnnotationMethod
    public void method(){
        System.out.println("method");
    }
}
