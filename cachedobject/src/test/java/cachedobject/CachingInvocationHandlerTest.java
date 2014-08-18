package cachedobject;


import static org.junit.Assert.*;
import org.junit.Test;

public class CachingInvocationHandlerTest {

    @Test public void toParameterTypes_returns_empty() {
        assertEquals(0, CachingInvocationHandler.toParameterTypes(null).length);
        assertEquals(0, CachingInvocationHandler.toParameterTypes(new Object[]{ }).length);
    }

    @Test public void toParameterTypes_returns_expected_classes() {
        assertArrayEquals(new Class<?>[]{ Integer.class, String.class }, CachingInvocationHandler.toParameterTypes(new Object[]{ 1, "hello" }));
    }

    @Test public void findMethod_returns_it() {
        assertNotNull(CachingInvocationHandler.findMethod(CachingObjectFactoryTest.MyImplementation.class, "value", null));
        assertNotNull(CachingInvocationHandler.findMethod(CachingObjectFactoryTest.MyImplementation.class, "parametrized", new Class<?>[]{ Integer.class, String.class, CachingObjectFactoryTest.ComplexParam.class }));
    }

    @Test public void matchParameterTypes_returns_true_when_null_or_empty() {
        assertTrue(CachingInvocationHandler.matchParameterTypes(null, null));
        assertTrue(CachingInvocationHandler.matchParameterTypes(new Class<?>[]{}, new Class<?>[]{}));
        assertTrue(CachingInvocationHandler.matchParameterTypes(null, new Class<?>[]{ }));
        assertTrue(CachingInvocationHandler.matchParameterTypes(new Class<?>[]{ }, null));
    }

    @Test public void matchParameterTypes_returns_false_when_length_is_different() {
          assertFalse(CachingInvocationHandler.matchParameterTypes(new Class<?>[]{ int.class }, new Class<?>[]{ }));
    }

    @Test public void matchParameterTypes_returns_true_when_parameters_are_the_same() {
        assertTrue(CachingInvocationHandler.matchParameterTypes(new Class<?>[]{ int.class }, new Class<?>[]{ int.class }));
    }

    @Test public void matchParameterTypes_returns_true_also_when_parameters_use_primitive_and_classes() {
        assertTrue(CachingInvocationHandler.matchParameterTypes(new Class<?>[]{ int.class }, new Class<?>[]{ Integer.class }));
    }

    @Test public void matchParameterTypes_returns_true_also_when_one_of_parameters_2_is_null() {
        assertTrue(CachingInvocationHandler.matchParameterTypes(new Class<?>[]{ int.class }, new Class<?>[]{ null }));
    }

}
