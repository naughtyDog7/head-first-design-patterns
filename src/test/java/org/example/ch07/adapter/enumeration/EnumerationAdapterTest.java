package org.example.ch07.adapter.enumeration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.List;

class EnumerationAdapterTest {

    @Test
    public void adapterWorkingTest() {
        List<String> list = List.of("first", "second", "third");

        Enumeration<String> enumeration = EnumerationAdapter.fromIterator(list.iterator());
        Assertions.assertTrue(enumeration.hasMoreElements());
        Assertions.assertEquals("first", enumeration.nextElement());
        Assertions.assertTrue(enumeration.hasMoreElements());
        Assertions.assertEquals("second", enumeration.nextElement());
        Assertions.assertTrue(enumeration.hasMoreElements());
        Assertions.assertEquals("third", enumeration.nextElement());
    }
}
