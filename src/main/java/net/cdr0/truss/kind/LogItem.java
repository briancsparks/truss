package net.cdr0.truss.kind;

import net.cdr0.truss.Truss;
import net.cdr0.truss.utils.U;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static net.cdr0.truss.utils.Constants.SEND_ALL;
import static net.cdr0.truss.utils.Constants.DEBUG;

public class LogItem {
  private int level;
  private JSONObject data;
  private final HashMap<String, String> meta_;
  public long tick;

  private final Truss truss;


  // ------------------------------------------------------------------------------------------------------------------
  public LogItem(Truss tr) {
    this.tick = System.currentTimeMillis() - Truss.startMillis;

    this.truss = tr;
    this.meta_ = new HashMap<>();
    this.level = DEBUG;

    try {
      this.data = new JSONObject();
    } catch (Exception ex) {
      U.showException("TAG", ex, "LogItem c-tor");
    }

    if (Truss.useTick()) {
      put("tick", this.tick);
    }
  }

  // ------------------------------------------------------------------------------------------------------------------
  public <T> LogItem log(String key, T value) {
    return put(key, value);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public LogItem smartLog(String key, String value) {
    return smartPut(key, value);
  }


  // ------------------------------------------------------------------------------------------------------------------
  public LogItem meta(String key, String value) {
    if (this.meta_ == null || key == null || value == null) {
      return this;
    }

    meta_.put(key, value);

    return this;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public String getMetaData(String key) {
    return meta_.getOrDefault(key, "");
  }

  // ------------------------------------------------------------------------------------------------------------------
  public boolean hasMetaData(String key) {
    return meta_.containsKey(key);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void end() {
    if (SEND_ALL) {
      truss.sendLogItem(this, null, null, null, null);
      return;
    }

    truss.addLogItem(this);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void send() {
    truss.sendLogItem(this, null, null, null, null);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void send(String s) {
    truss.sendLogItem(this, s, null, null, null);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void send(String s, String s2, String s3, String s4) {
    truss.sendLogItem(this, s, s2, s3, s4);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public JSONObject getData() {
    return data;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public JSONObject deepCopy() {
    try {
      return new JSONObject(data.toString());
    } catch (JSONException e) {
      U.showException(e);
    }

    return null;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public String modName() {
    return truss.getModuleName();
  }

  // ------------------------------------------------------------------------------------------------------------------
  public String TAG() {
    return modName();
  }

  // ------------------------------------------------------------------------------------------------------------------
  public String toString() {
    return data.toString();
  }


  // ==================================================================================================================
  // Internal

  // ------------------------------------------------------------------------------------------------------------------
  private <T> LogItem put(String key, T value) {
    U.put(data, key, value);
    return this;
  }

  // ------------------------------------------------------------------------------------------------------------------
  private LogItem smartPut(String key, String value) {
    U.smartPut(data, key, value);
    return this;
  }

}
