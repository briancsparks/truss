package net.cdr0.truss.utils;

import java.util.HashMap;
import java.util.Map;

public class Options {

  private final Map<String, Boolean> boolOpts   = new HashMap<>();
  private final Map<String, String>  strOpts    = new HashMap<>();
  private final Map<String, Long>    numberOpts = new HashMap<>();

  public Options() {

  }

  public void Set(String key, Boolean value) {
    boolOpts.put(key, value);
  }

  public void Set(String key, String value) {
    strOpts.put(key, value);
  }

  public void Set(String key, Long value) {
    numberOpts.put(key, value);
  }

  public boolean is_true(String key) {
    return boolOpts.getOrDefault(key, false);
  }

  public boolean is_false(String key) {
    if (!boolOpts.containsKey(key)) {
      return false;
    }

    boolean b = boolOpts.getOrDefault(key, false);
    return b == false;
  }

  public String string(String key) {
    return strOpts.getOrDefault(key, "");
  }

}
