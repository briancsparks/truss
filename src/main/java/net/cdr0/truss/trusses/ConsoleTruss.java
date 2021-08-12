package net.cdr0.truss.trusses;

import net.cdr0.truss.Truss;
import net.cdr0.truss.kind.LogAttr;
import net.cdr0.truss.kind.LogItem;
import sun.rmi.runtime.Log;

public class ConsoleTruss extends Truss {

  public ConsoleTruss(Truss sourceTruss) {
    super(sourceTruss);

    sourceTruss.setSendDestination(this);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public boolean onControl(int n, String a, String b, int n2, String c) {
    return false;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void addLogItem(LogItem item) {
    if (item == null) { return; }
    System.out.printf("%s: %s", item.TAG(), item.toString());
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void sendLogItem(LogItem item, String s, String s2, String s3, String s4) {
    if (item == null) { return; }

    System.out.printf("%s: LogItem: (%s|%s|%s|%s) -- %s", item.TAG(), s, s2, s3, s4, item.toString());
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void addLogAttr(LogAttr attr) {
    if (attr == null) { return; }

    System.out.printf("%s: %s", attr.TAG(), attr.toString());
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void sendLogAttr(LogAttr attr, String s, String s2, String s3, String s4) {
    if (attr == null) { return; }

    System.out.printf("%s: LogItem: (%s|%s|%s|%s) -- %s", attr.TAG(), s, s2, s3, s4, attr.toString());
  }

}
