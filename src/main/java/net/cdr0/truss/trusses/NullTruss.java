package net.cdr0.truss.trusses;

import net.cdr0.truss.kind.LogAttr;
import net.cdr0.truss.kind.LogItem;
import net.cdr0.truss.utils.U;

public class NullTruss extends MainTruss {

  // ------------------------------------------------------------------------------------------------------------------
  public NullTruss() {
    super("", "NullTruss", null);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public boolean onControl(String ctrlItem, int n, String a, String b, int n2, String c) {
    return false;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void addLogItem(LogItem item) {
    U.assert_(false, "Must construct MainTruss first.", false);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void sendLogItem(LogItem item, String s, String s2, String s3, String s4) {
    U.assert_(false, "Must construct MainTruss first.", false);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void addLogAttr(LogAttr attr) {
    U.assert_(false, "Must construct MainTruss first.", false);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void sendLogAttr(LogAttr attr, String s, String s2, String s3, String s4) {
    U.assert_(false, "Must construct MainTruss first.", false);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public String getSessionId() {
    U.assert_(false, "Must construct MainTruss first.", false);

    return "non-sessionid-from-null-truss";
  }

}
