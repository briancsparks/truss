package net.cdr0.truss.trusses;

import net.cdr0.truss.Truss;

public class MainTruss extends Truss {

  private final String sessionId;

  // ------------------------------------------------------------------------------------------------------------------
  public MainTruss(String appId, String module, String sessionId) {
    super(appId, module);

    Truss.mainTruss = this;
    Truss.mainTrussCreated = true;

    this.sessionId = sessionId;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public boolean onControl(String ctrlItem, int n, String a, String b, int n2, String c) {
    return super.onControl(ctrlItem, n, a, b, n2, c);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public String getSessionId() {
    return sessionId;
  }

}
