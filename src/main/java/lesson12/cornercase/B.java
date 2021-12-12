package lesson12.cornercase;


import lesson12.exception.MethodException;
import lesson12.exception.ParticularMethodException;

public class B extends A {

    @Override
    protected void a() throws ParticularMethodException /*либо вообще другой, главное не расширяющий*/ {
        try {
            super.a();
        } catch (MethodException e) {
            e.printStackTrace();
        }
    }

    void b() {

    }
}
