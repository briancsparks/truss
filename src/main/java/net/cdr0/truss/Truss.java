package net.cdr0.truss;

import net.cdr0.truss.kind.LogAttr;
import net.cdr0.truss.kind.LogItem;
import net.cdr0.truss.trusses.MainTruss;
import net.cdr0.truss.trusses.NullTruss;
import net.cdr0.truss.utils.Options;
import net.cdr0.truss.utils.U;

import java.util.ArrayList;

import static net.cdr0.truss.utils.Constants.*;

// SEE ALSO: the CamCam-canary project (D:\data\projects\AndroidStudioProjects\cdr0\CamCam-canary)
//           it has the version of truss that has IpcRecvTruss, IpcSendTruss, TelemetryTruss, Payload, Uploader
//           and trussinterproc

public class Truss {

  // Only do some things on the first run
  private static boolean    isFirstRun        = true;

  // Keep track of the main Truss
  public static MainTruss   mainTruss         = null;
  public static boolean     mainTrussCreated  = false;

  // App and module names
  protected String          appId;
  protected String          moduleName;

  public static long startMillis              = -1;
  private static final Options options = new Options();

  // Other Trusses to forward messages to
  private ArrayList<Truss>  destinations;
  private ArrayList<Truss>  sendDestinations;

  private ArrayList<Truss>  ctlDestination;

  // ==========================================================================================================================================
  // constructors

  // ------------------------------------------------------------------------------------------------------------------
  // The base constructor for MainTruss
  protected Truss(String appId, String moduleName) {
    init_(appId, moduleName);

    boolean isFirstRun_ = isFirstRun;
    isFirstRun = false;

    // Since NullTruss inherits from MainTruss, this would otherwise cause infinite recursion.
    if (isFirstRun_) {
      mainTruss = new NullTruss();
    }
  }

  // ------------------------------------------------------------------------------------------------------------------
  // The base constructor for HalfTruss
  protected Truss(String moduleName) {
    init_(null, moduleName);

    if (!U.assert_(mainTrussCreated, "Must construct MainTruss first.", false)) {
      this.appId = mainTruss.getAppId();
    }
  }

  // ------------------------------------------------------------------------------------------------------------------
  // The base constructor for destination Trusses
  protected Truss(Truss sourceTruss) {
    init_(null, "");

    if (!U.assert_(mainTrussCreated, "Must construct MainTruss first.", false)) {
      this.appId = mainTruss.getAppId();
    }

    sourceTruss.setCtlDestination(this);

    sourceTruss.setDestination(this);
//    sourceTruss.setSendDestination(this);
  }

  // ------------------------------------------------------------------------------------------------------------------
  protected void init_(String appId, String module) {
    if (startMillis < 0) {
      startMillis = System.currentTimeMillis();
    }

    this.appId              = appId;
    this.moduleName         = module;

    this.destinations       = new ArrayList<>();
    this.sendDestinations   = new ArrayList<>();

    this.ctlDestination     = new ArrayList<>();
  }



  // ==========================================================================================================================================
  // logX()

  // ------------------------------------------------------------------------------------------------------------------
  public LogItem logv() {
    return log_x(VERBOSE);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public LogItem logd() {
    return log_x(DEBUG);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public LogItem logi() {
    return log_x(INFO);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public LogItem logw(String message) {
    return log_x(WARN).log("message", message);
  }

  // ------------------------------------------------------------------------------------------------------------------
  // TODO: Add exception object
  public LogItem loge(String message) {
    return log_x(ERROR).log("message", message);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void TODO(String message) {
    logw(message).end();
  }

  // ------------------------------------------------------------------------------------------------------------------
  public LogItem log_x(int level) {
    LogItem item = new LogItem(this);
    return fixupLogItem(item);
  }





  // ==========================================================================================================================================
  // Rate-limited versions

  // ------------------------------------------------------------------------------------------------------------------
  public LogItem logv(int rateLimitId) {
    return log_xyz(VERBOSE, rateLimitId, -1);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public LogItem logv(int rateLimitId, int rateLimit) {
    return log_xyz(VERBOSE, rateLimitId, rateLimit);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public LogItem logd(int rateLimitId) {
    return log_xyz(DEBUG, rateLimitId, -1);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public LogItem logd(int rateLimitId, int rateLimit) {
    return log_xyz(DEBUG, rateLimitId, rateLimit);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public LogItem log_xyz(int level, int rateLimitId, int rateLimit) {
    if (rateLimitId > 0) {
      if (rateLimit == -1) {
        rateLimit = DEFAULT_RATE_LIMIT;
      }

      // TODO: Implement rate limit
    }

    return log_x(level);
  }



  // ==========================================================================================================================================
  // trace()

  // ------------------------------------------------------------------------------------------------------------------
  public LogItem trace(String traceName) {
    LogItem item = new LogItem(this);
    return fixupLogItem(item);
  }



  // ==========================================================================================================================================

  // ------------------------------------------------------------------------------------------------------------------
  public boolean onControl(String ctrlItem, int n, String a, String b, int n2, String c) {
    boolean result = true;

    for (Truss truss : ctlDestination) {
      boolean boo = truss.onControl(ctrlItem, n, a, b, n2, c);
      result = result && boo;
    }

    return result;
  }

  // ==========================================================================================================================================
  // addLogItem() and friends -- Gets called from .end() and .send()
  // ------------------------------------------------------------------------------------------------------------------
  public void addLogItem(LogItem item) {
    for (Truss truss : destinations) {
      truss.addLogItem(item);
    }
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void sendLogItem(LogItem item, String s, String s2, String s3, String s4) {
    addLogItem(item);
    for (Truss truss : sendDestinations) {
      truss.sendLogItem(item, s, s2, s3, s4);
    }
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void addLogAttr(LogAttr attr) {
    for (Truss truss : destinations) {
      truss.addLogAttr(attr);
    }
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void sendLogAttr(LogAttr attr, String s, String s2, String s3, String s4) {
    addLogAttr(attr);
    for (Truss truss : sendDestinations) {
      truss.sendLogAttr(attr, s, s2, s3, s4);
    }
  }


  // ==========================================================================================================================================

  // ------------------------------------------------------------------------------------------------------------------
  // Mechanics

  // ------------------------------------------------------------------------------------------------------------------
  public void setCtlDestination(Truss destination) {
    this.ctlDestination.add(destination);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void setDestination(Truss destination) {
    this.destinations.add(destination);
  }

  // ------------------------------------------------------------------------------------------------------------------
  public void setSendDestination(Truss destination) {
    this.sendDestinations.add(destination);
  }

  // ==========================================================================================================================================
  // Boring

  // ------------------------------------------------------------------------------------------------------------------
  protected LogItem fixupLogItem(LogItem item) {
    // TODO: fixup (long output, short output, etc.)
    return item;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public String getAppId() {
    return appId;
  }

  // ------------------------------------------------------------------------------------------------------------------
  public String getModuleName() {
    return moduleName;
  }


  // ------------------------------------------------------------------------------------------------------------------
  public static void setUseTick(boolean useTick) {
    options.Set("useTick", useTick);
  }

  public static boolean useTick() {
    return !options.is_false("useTick");
  }


  // ------------------------------------------------------------------------------------------------------------------
  public static void option(String key, String value) {
    options.Set(key, value);
  }

  public static boolean is_true(String key) {
    return options.is_true(key);
  }

  public static boolean is_false(String key) {
    return options.is_false(key);
  }

  public static String option(String key) {
    return options.string(key);
  }
}
