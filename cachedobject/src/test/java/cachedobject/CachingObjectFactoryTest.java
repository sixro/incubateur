package cachedobject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CachingObjectFactoryTest {

    public static final int VALUE = 10;

    private MyImplementation implementation;

    @Before public void setup() {
        implementation = new MyImplementation();
    }

    @Test public void calls_delegate_once_also_with_two_calls() {
        MyInterface cachingObject = CachingObjectFactory.newCachingObject(MyInterface.class, implementation);

        assertEquals("first call", VALUE, cachingObject.value());
        assertEquals("second call", VALUE, cachingObject.value());
        assertEquals(1, implementation.called);
    }

    @Test public void differentiate_on_parameters() {
        MyInterface cachingObject = CachingObjectFactory.newCachingObject(MyInterface.class, implementation);

        assertEquals("first call", VALUE, cachingObject.parametrized(1, "hello", new ComplexParam(2)));
        assertEquals("second call with different params", VALUE, cachingObject.parametrized(2, "hello", new ComplexParam(2)));
        assertEquals(2, implementation.called);
    }

    @Test public void handle_nulls() {
        MyInterface cachingObject = CachingObjectFactory.newCachingObject(MyInterface.class, implementation);

        assertEquals("first call", VALUE, cachingObject.parametrized(new Integer(1), null, new ComplexParam(2)));
        assertEquals("second call", VALUE, cachingObject.parametrized(1, null, new ComplexParam(2)));
        assertEquals(1, implementation.called);
    }

    static interface MyInterface {

        public int value();

        public int parametrized(int hello, String hey, ComplexParam complexParam);

    }

    static class ComplexParam {

        private final int aVar;

        ComplexParam(int aVar) {
            this.aVar = aVar;
        }

        @Override
        public String toString() {
            return "ComplexParam{aVar=" + aVar + '}';
        }
    }

    static class MyImplementation implements MyInterface {

        public int called = 0;

        @Cache(maxAge = 30)
        @Override
        public int value() {
            called++;
            return VALUE;
        }

        @Cache(maxAge = 5 * 60)
        @Override
        public int parametrized(int hello, String hey, ComplexParam complexParam) {
            called++;
            return VALUE;
        }

    }

}
