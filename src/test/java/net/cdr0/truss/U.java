package net.cdr0.truss;

public class U {

  // ======================================================================================================================================

  // ------------------------------------------------------------------------------------------------------------------
  public static String finish(String partial) {
    return "{" + partial + "}";
  }


  // ======================================================================================================================================

  // ------------------------------------------------------------------------------------------------------------------
  private static String partialStringify(String partial, String key, String rawValue, boolean quoteTheValue) {
    // The key is quoted; the rawValue must be manually quoted if we are storing a string.
    if (partial == null) {
      partial = "";
    }

    if (partial.length() > 0) {
      partial += ",";
    }

    String value = rawValue;
    if (quoteTheValue) {
      value = "\"" + value + "\"";
    }

    return partial + "\"" + key + "\":" + value;
  }


  // ======================================================================================================================================

  // ------------------------------------------------------------------------------------------------------------------
  private static String stringify(String partial, String key, String rawValue, boolean quoteTheValue) {
    return partialStringify(partial, key, rawValue, quoteTheValue);
  }


  // ======================================================================================================================================

  // ------------------------------------------------------------------------------------------------------------------
  static String toJson(String partial, String key, String value) {
    return stringify(partial, key, String.valueOf(value), true);
  }

  // ------------------------------------------------------------------------------------------------------------------
  static String toJson(String partial, String key, long value) {
    return stringify(partial, key, String.valueOf(value), false);
  }

  // ------------------------------------------------------------------------------------------------------------------
  static String toJson(String partial, String key, double value) {
    return stringify(partial, key, String.valueOf(value), false);
  }

  // ------------------------------------------------------------------------------------------------------------------
  static String toJson(String partial, String key, boolean value) {
    return stringify(partial, key, String.valueOf(value), false);
  }


  // ======================================================================================================================================

  // ------------------------------------------------------------------------------------------------------------------
  static String toJson(String key, String value) {
    return finish(toJson(null, key, value));
  }

  // ------------------------------------------------------------------------------------------------------------------
  static String toJson(String key, long value) {
    return finish(toJson(null, key, value));
  }

  // ------------------------------------------------------------------------------------------------------------------
  static String toJson(String key, double value) {
    return finish(toJson(null, key, value));
  }

  // ------------------------------------------------------------------------------------------------------------------
  static String toJson(String key, boolean value) {
    return finish(toJson(null, key, value));
  }

}
