package net.cdr0.truss.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class OptionsTest {

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }


  @Test
  void test_is_true() {
    Options options = new Options();

    options.Set("foo", true);
    boolean actual = options.is_true("foo");

    assertThat(actual, equalTo(true));
  }

  @Test
  void test_blank_is_not_true() {
    Options options = new Options();

    boolean actual = options.is_true("foo");

    assertThat(actual, equalTo(false));
  }

  @Test
  void test_false_is_not_true() {
    Options options = new Options();

    options.Set("foo", false);
    boolean actual = options.is_true("foo");

    assertThat(actual, equalTo(false));
  }

  @Test
  void test_is_false() {
    Options options = new Options();

    options.Set("foo", false);
    boolean actual = options.is_false("foo");

    assertThat(actual, equalTo(true));
  }

  @Test
  void test_blank_is_not_false() {
    Options options = new Options();

    boolean actual = options.is_false("foo");

    assertThat(actual, equalTo(false));
  }

  @Test
  void test_true_is_not_false() {
    Options options = new Options();

    options.Set("foo", true);
    boolean actual = options.is_false("foo");

    assertThat(actual, equalTo(false));
  }

  @Test
  void test_string() {
    Options options = new Options();

    options.Set("foo", "bar");
    String actual = options.string("foo");

    assertThat(actual, equalTo("bar"));
  }

}