package me.youngsil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Interface, Class, Enum
@Retention(RetentionPolicy.SOURCE)
public @interface Magic {
}
