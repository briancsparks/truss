package net.cdr0.truss.trusses;

import net.cdr0.truss.Truss;
import net.cdr0.truss.kind.LogAttr;
import net.cdr0.truss.kind.LogItem;

import java.util.ArrayList;

public class ArrayListTruss extends Truss {

  private ArrayList<String> outputItems;
  private ArrayList<String> outputAttrs;

  // ------------------------------------------------------------------------------------------------------------------
  public ArrayListTruss(Truss sourceTruss) {
    super(sourceTruss);

    outputItems = new ArrayList<>();
    outputAttrs = new ArrayList<>();
  }


  // ------------------------------------------------------------------------------------------------------------------
  public boolean onControl(String ctrlItem, int n, String a, String b, int n2, String c) {
    return false;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void addLogItem(LogItem item) {
    outputItems.add(item.toString());
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void sendLogItem(LogItem item, String s, String s2, String s3, String s4) {
//      Truss.mainTruss.sendLogItem(item, s, s2, s3, s4);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void addLogAttr(LogAttr attr) {
    outputAttrs.add(attr.toString());
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void sendLogAttr(LogAttr attr, String s, String s2, String s3, String s4) {
//      Truss.mainTruss.sendLogAttr(attr, s, s2, s3, s4);
  }

}
