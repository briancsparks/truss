package net.cdr0.truss.utils;

public class Constants {

  public static final int       TRUSS_SEND_TELEMETRY  = 2001;

  public static final String    IPC_SEND_LOGITEM      = "IPC_SEND_LOGITEM";
  public static final String    IPC_SEND_LOGATTR      = "IPC_SEND_LOGATTR";

  public static final String    IPC_PARAM_SESSIONID   = "IPC_PARAM_SESSIONID";
  public static final String    IPC_PARAM_PAYLOAD     = "IPC_PARAM_PAYLOAD";

  public static final String    IPC_PARAM_S1          = "IPC_PARAM_S1";
  public static final String    IPC_PARAM_S2          = "IPC_PARAM_S2";
  public static final String    IPC_PARAM_S3          = "IPC_PARAM_S3";
  public static final String    IPC_PARAM_S4          = "IPC_PARAM_S4";

  public static final int       HTTP_CONNECT_TIMEOUT  = 12 * 1000;
  public static final int       HTTP_TIMEOUT          = 18 * 1000;

  public static final boolean   SEND_ALL              = false;
  public static final boolean   LOG_ALL_SENDS         = false;

  // Level
  public static final int       VERBOSE               = 2;
  public static final int       DEBUG                 = 3;
  public static final int       INFO                  = 4;
  public static final int       WARN                  = 5;
  public static final int       ERROR                 = 6;
  public static final int       ASSERT                = 7;

  // Rate Limit
  public static final int       DEFAULT_RATE_LIMIT    = 250;   // 4 per second

}
