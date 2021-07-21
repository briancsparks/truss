package net.cdr0.truss.trusses;

import net.cdr0.truss.Truss;
import net.cdr0.truss.kind.LogAttr;
import net.cdr0.truss.kind.LogItem;

public class HalfTruss extends Truss {

  // ------------------------------------------------------------------------------------------------------------------
  public HalfTruss(String moduleName) {
    super(moduleName);

    Truss.mainTruss.setCtlDestination(this);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void control(String ctrlItem, int n) {
    Truss.mainTruss.onControl(ctrlItem, n, null, null, 0, null);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void control(String ctrlItem, int n, String a, String b, int n2, String c) {
    Truss.mainTruss.onControl(ctrlItem, n, a, b, n2, c);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public boolean onControl(String ctrlItem, int n, String a, String b, int n2, String c) {
    return false;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void addLogItem(LogItem item) {
    Truss.mainTruss.addLogItem(item);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void sendLogItem(LogItem item, String s, String s2, String s3, String s4) {
    Truss.mainTruss.sendLogItem(item, s, s2, s3, s4);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void addLogAttr(LogAttr attr) {
    Truss.mainTruss.addLogAttr(attr);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void sendLogAttr(LogAttr attr, String s, String s2, String s3, String s4) {
    Truss.mainTruss.sendLogAttr(attr, s, s2, s3, s4);
  }

}
