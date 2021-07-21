package net.cdr0.truss;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrussTest {

  static String key = "key";
  static String value = "value";

  static String key2 = "key2";
  static String value2 = "value2";

  static String jsonKeyValue = "{\"" + key + "\": \"" + value + "\"}";
  static String jsonKeyValue2 = "{\"" + key2 + "\": \"" + value2 + "\"}";
//  static String j = squote(String.format("{'%s':'%s'}", key, value));


  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void logd() {
  }

  // ------------------------------------------------------------------------------------------------------------------
//  @Test
//  public void testLogd() throws JSONException {
//    Truss tr = new MainTruss("appId", "module", "sessionid");
//    ArrayListTruss capture = new ArrayListTruss(tr);
//
//    tr.logd().log(key, value).end();
//
//    JSONAssert.assertEquals(jsonKeyValue, capture.getOutput().get(0), false);
//  }

  // ------------------------------------------------------------------------------------------------------------------
//  @Test
//  public void logd_chosen() throws JSONException {
//    Truss tr                  = new MainTruss("appId", "module");
//    ChosenItemsTrussX filter   = new ChosenItemsTrussX(tr, "special");
//    ArrayListTruss capture    = new ArrayListTruss(filter);
//
//    tr.logd().log(key2, value2).end();
//    tr.logd().log(key, value).end(true);
//
//    JSONAssert.assertEquals(jsonKeyValue, capture.getOutput().get(0), false);
//  }

  // ------------------------------------------------------------------------------------------------------------------
//  @Test
//  public void logd_chosen_name() throws JSONException {
//    Truss tr                  = new MainTruss("appId", "module");
//    ChosenItemsTrussX filter   = new ChosenItemsTrussX(tr, "special");
//    ArrayListTruss capture    = new ArrayListTruss(filter);
//
//    tr.logd().log(key2, value2).end();
//    tr.logd().log(key, value).end(true, "special");
//
//    JSONAssert.assertEquals(jsonKeyValue, capture.getOutput().get(0), false);
//  }

  // ------------------------------------------------------------------------------------------------------------------
//  @Test(expected = IndexOutOfBoundsException.class)
//  public void logd_not_chosen_name() throws JSONException {
//    Truss tr                  = new MainTruss("appId", "module");
//    ChosenItemsTrussX filter   = new ChosenItemsTrussX(tr, "special");
//    ArrayListTruss capture    = new ArrayListTruss(filter);
//
//    tr.logd().log(key2, value2).end();
//    tr.logd().log(key, value).end(true, "not_special");
//
//    String str = capture.getOutput().get(0);
//  }

}