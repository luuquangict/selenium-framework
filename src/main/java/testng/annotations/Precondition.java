package testng.annotations;

public @interface Precondition {
    public String value() default "";
}
