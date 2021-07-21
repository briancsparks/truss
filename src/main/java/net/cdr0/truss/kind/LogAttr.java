package net.cdr0.truss.kind;

import net.cdr0.truss.Truss;
import net.cdr0.truss.utils.U;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static net.cdr0.truss.utils.Constants.SEND_ALL;

public class LogAttr {

  private JSONObject data;
  private final HashMap<String, String> meta_;

  private final Truss truss;


  // ------------------------------------------------------------------------------------------------------------------
  public LogAttr(Truss tr) {
    this.truss = tr;
    this.meta_ = new HashMap<>();

    try {
      this.data = new JSONObject();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  // ------------------------------------------------------------------------------------------------------------------
  public <T> LogAttr attr(String name, T value) {
    return put(name, value);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public LogAttr meta(String key, String value) {
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
      truss.sendLogAttr(this, null, null, null, null);
      return;
    }

    truss.addLogAttr(this);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void send(String s, String s2, String s3, String s4) {
    truss.sendLogAttr(this, s, s2, s3, s4);
  }

  // ------------------------------------------------------------------------------------------------------------------
  // Internal
  private <T> LogAttr put(String key, T value) {
    U.put(data, key, value);
    return this;
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
  public JSONObject getData() {
    return data;
  }

}
