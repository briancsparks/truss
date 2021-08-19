package net.cdr0.truss;

import net.cdr0.truss.trusses.ArrayListTruss;
import net.cdr0.truss.trusses.MainTruss;
import org.json.JSONException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import java.util.ArrayList;

import static net.cdr0.truss.U.finish;


public class TrussTest {

  static String key = "key";
  static String value = "value";

  Truss tr;

  @BeforeEach
  void setUp() {
    Truss.setUseTick(false);
    tr = new MainTruss("appId", "module", "sessionid");
  }

  @AfterEach
  void tearDown() {
  }



  // ------------------------------------------------------------------------------------------------------------------
  @Test
  public void logd() throws JSONException {
    ArrayListTruss capture = new ArrayListTruss(tr);

    tr.logd().log(key, value).end();

    JSONAssert.assertEquals(U.toJson(key, value), capture.getOutputItems().get(0), true);
  }

  // ------------------------------------------------------------------------------------------------------------------
  @Test
  public void testLogLongNumber() throws JSONException {
    ArrayListTruss capture = new ArrayListTruss(tr);

    tr.logd().log(key, 42).end();

    JSONAssert.assertEquals(U.toJson(key, 42), capture.getOutputItems().get(0), true);
  }

  // ------------------------------------------------------------------------------------------------------------------
  @Test
  public void testLogDoubleNumber() throws JSONException {
    ArrayListTruss capture = new ArrayListTruss(tr);

    tr.logd().log(key, 42.5).end();

    JSONAssert.assertEquals(U.toJson(key, 42.5), capture.getOutputItems().get(0), true);
  }

  // ------------------------------------------------------------------------------------------------------------------
  @Test
  public void testLogBoolean() throws JSONException {
    ArrayListTruss capture = new ArrayListTruss(tr);

    tr.logd().log(key, true).end();

    JSONAssert.assertEquals(U.toJson(key, true), capture.getOutputItems().get(0), true);
  }

  // ------------------------------------------------------------------------------------------------------------------
  @Test
  public void testLogMulti() throws JSONException {
    ArrayListTruss capture = new ArrayListTruss(tr);

    tr.logd()
          .log(key, value)
          .log("keyNumber", 55)
          .log("keyDouble", 99.25)
          .log("keyBoolean", false)
          .end();

    String expected = "";
    expected = U.toJson(expected, key, value);
    expected = U.toJson(expected, "keyNumber", 55);
    expected = U.toJson(expected, "keyDouble", 99.25);
    expected = U.toJson(expected, "keyBoolean", false);
    expected = finish(expected);

//    System.out.printf("------------------- testLogMulti \n    expected = %s\n      actual = %s\n", expected_, actual_);

    JSONAssert.assertEquals(expected, capture.getOutputItems().get(0), true);
  }

  // ------------------------------------------------------------------------------------------------------------------
  @Test
  public void testLogMultiMulti() throws JSONException {
    ArrayListTruss capture = new ArrayListTruss(tr);

    tr.logd()
          .log(key, value)
          .log("keyNumber", 55)
          .log("keyDouble", 99.25)
          .log("keyBoolean", false)
          .end();

    tr.logd()
          .log("keyNumber", 44)
          .end();


    ArrayList<String> expected = new ArrayList<>();

    String json = "";
    json = U.toJson(json, key, value);
    json = U.toJson(json, "keyNumber", 55);
    json = U.toJson(json, "keyDouble", 99.25);
    json = U.toJson(json, "keyBoolean", false);
    expected.add(finish(json));

    expected.add(U.toJson("keyNumber", 44));

    JSONAssert.assertEquals(expected.get(0), capture.getOutputItems().get(0), true);
    JSONAssert.assertEquals(expected.get(1), capture.getOutputItems().get(1), true);

  }

  // ------------------------------------------------------------------------------------------------------------------
  @Test
  public void testSmartLog() throws JSONException {
    ArrayListTruss capture = new ArrayListTruss(tr);

    tr.logd()
          .log(key, value)
          .smartLog("keyNumber", "55")
          .smartLog("keyDouble", "99.25")
          .smartLog("keyBoolean", "false")
          .end();

    String expected = "";
    expected = U.toJson(expected, key, value);
    expected = U.toJson(expected, "keyNumber", 55);
    expected = U.toJson(expected, "keyDouble", 99.25);
    expected = U.toJson(expected, "keyBoolean", false);
    expected = finish(expected);

    String actual = capture.getOutputItems().get(0);

    JSONAssert.assertEquals(expected, capture.getOutputItems().get(0), true);
  }

}