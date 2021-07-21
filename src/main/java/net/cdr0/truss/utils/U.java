package net.cdr0.truss.utils;

import com.sun.istack.internal.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class U {

  public static boolean isDebug = true;

  // ------------------------------------------------------------------------------------------------------------------
  public static void setIsDebug(boolean isDebuggable_) {
    isDebug = isDebuggable_;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static boolean isEmpty(String s) {
    return s == null || s.length() == 0;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static boolean isNotEmpty(String s) {
    return !isEmpty(s);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static boolean isBuildConfigEmpty(String s) {
    return s == null || s.length() == 0 || s.toLowerCase().equals("null");
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static String buildConfigString(String s, String def) {
    if (!isBuildConfigEmpty(s)) {
      return s;
    }

    return def;
  }

  // ------------------------------------------------------------------------------------------------------------------
  @Nullable
  public static String buildConfigString(String s) {
    if (!isBuildConfigEmpty(s)) {
      return s;
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static boolean assert_(boolean isGood, String message, boolean isDie) {

    if (isDebug) {

      if (!isGood) {
        // BBB: Set BP here
        if (isDie) {
          assert isGood : message;
        } else {
//          Log.e("utils", message);
        }
      }
    }

    return !isGood;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static boolean assert_(boolean value, String message) {
    return assert_(value, message, true);
  }

  // ------------------------------------------------------------------------------------------------------------------
  // Returns true if bad condition
  //
  //   if (!assert__(...)) {
  //      // We are good
  //   }
  //
  public static boolean assert__(boolean value, String message) {
    return !assert_(value, message);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static <E extends Exception> void showException(String TAG, E e) {
    showException(TAG, e, "");
  }

  public static <E extends Exception> void showException(String TAG, E e, boolean throwit) throws Exception {
    showException(TAG, e, "", throwit);
  }

  public static <E extends Exception> void showException(String TAG, E e, String where, boolean throwit) throws Exception {
    showException(TAG, e, where);

    if (throwit) {
      throw e;
    }
  }

  public static <E extends Exception> void showException(String TAG, E e, String where) {
    /// BBB: Set BP here for exceptions
//    Log.e(TAG, "Exception at " + where, e);
    e.printStackTrace();
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static void showException(Exception e) {
    // BBB BP for exceptions
    e.printStackTrace();
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static <T> void put(JSONObject data, String key, T value) {
    //if (ignoreKey(key)) { return this; }

    if (data == null) {
      return;
    }

    try {
      if (value != null) {
        data.put(key, value);
      } else {
        data.put(key, "null");
      }
    } catch (JSONException ex) {
      showException(ex);
    }
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static <T> T getOrDefault(HashMap<String, T> map, String key, T def) {
    if (!map.containsKey(key)) {
      return def;
    }
    return map.get(key);
  }

  // ------------------------------------------------------------------------------------------------------------------
  // Uninteresting
  // ------------------------------------------------------------------------------------------------------------------

  // ------------------------------------------------------------------------------------------------------------------
  public static boolean allEmpty(String s, String s2) {
    return isEmpty(s) && isEmpty(s2);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static boolean allEmpty(String s, String s2, String s3) {
    return allEmpty(s, s2) && isEmpty(s3);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static boolean allEmpty(String s, String s2, String s3, String s4) {
    return allEmpty(s, s2) && allEmpty(s3, s4);
  }


  // ------------------------------------------------------------------------------------------------------------------
  public static boolean anyEmpty(String s, String s2) {
    return isEmpty(s) || isEmpty(s2);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static boolean anyEmpty(String s, String s2, String s3) {
    return anyEmpty(s, s2) || isEmpty(s3);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public static boolean anyEmpty(String s, String s2, String s3, String s4) {
    return anyEmpty(s, s2) || anyEmpty(s3, s4);
  }


  // ------------------------------------------------------------------------------------------------------------------
  // I need all of these strings to be non-empty
  public static boolean allNotEmpty(String s, String s2) {
    return !isEmpty(s) && !isEmpty(s2);
  }

  // ------------------------------------------------------------------------------------------------------------------
  // I need all of these strings to be non-empty
  public static boolean allNotEmpty(String s, String s2, String s3) {
    return allNotEmpty(s, s2) && !isEmpty(s3);
  }

  // ------------------------------------------------------------------------------------------------------------------
  // I need all of these strings to be non-empty
  public static boolean allNotEmpty(String s, String s2, String s3, String s4) {
    return allNotEmpty(s, s2) && allNotEmpty(s3, s4);
  }


  // ------------------------------------------------------------------------------------------------------------------
  // Let me know if any of these are non-empty
  public static boolean anyNotEmpty(String s, String s2) {
    return !isEmpty(s) || !isEmpty(s2);
  }

  // ------------------------------------------------------------------------------------------------------------------
  // Let me know if any of these are non-empty
  public static boolean anyNotEmpty(String s, String s2, String s3) {
    return anyNotEmpty(s, s2) || !isEmpty(s3);
  }

  // ------------------------------------------------------------------------------------------------------------------
  // Let me know if any of these are non-empty
  public static boolean anyNotEmpty(String s, String s2, String s3, String s4) {
    return anyNotEmpty(s, s2) || anyNotEmpty(s3, s4);
  }

}
