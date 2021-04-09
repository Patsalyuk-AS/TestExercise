package com.github.patsalyukas.test;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestCases {

    @Test
    public void testAssertEqualsArray() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        assertArrayEquals(expected, actual, "Failure");
    }

    @Test
    public void testAssertEquals() {
        assertEquals("test", "test", "Failure - strings are not equal");
    }

    @Test
    public void testAssertNotEquals() {
        assertNotEquals("Failure - strings are same", "test", "test1");
    }

    @Test
    public void testAssertFalse() {
        assertFalse(false, "should be false");
    }

    @Test
    void testAssertTrue() {
        assertTrue(true, "should be true");
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull(new Object(), "should not be null");
    }

    @Test
    public void testAssertNull() {
        assertNull(null, "should be null");
    }

    @Test
    public void testAssertNotSame() {
        assertNotSame(new Object(), new Object(), "should not be same");
    }

    @Test
    public void testAssertSame() {
        Object object = new Object();
        assertSame(object, object, "should be same");
    }

    //JUnit Matchers assertThat
    @Test
    public void testAssertThatBothContatinsString() {
        assertThat("albumen", both(containsString("a")).and(containsString("b")));
    }

    @Test
    public void testAssertThatHasItems() {
        assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "two"));
    }

    @Test
    public void testAssertThatEveryItemContainString() {
        assertThat(Arrays.asList("funba", "ban", "banan"), everyItem(containsString("ba")));
    }

    @Test
    public void testAssertThatHamcrestCoreMatchers() {
        assertThat("good", allOf(equalTo("good"), startsWith("go")));
        assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
        assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
        assertThat(7, not(CombinableMatcher.<Integer>either(equalTo(3)).or(equalTo(4))));
        assertThat(new Object(), not(sameInstance(new Main())));

    }

}
