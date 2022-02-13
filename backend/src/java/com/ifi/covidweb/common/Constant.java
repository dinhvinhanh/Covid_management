package com.ifi.covidweb.common;

import java.util.ResourceBundle;

public class Constant {

    public final static String JUST_DETECTED = "Just detected";
    public final static String TREATING = "Being treated";
    public final static String ALL = "All";
    public final static String DIED = "Dead";
    public final static String CURED = "Cured";
    public final static String FE = "Female";
    public final static String MA = "Male";

    public static final Long NEW = 0L;
    private static ResourceBundle r = ResourceBundle.getBundle("application");
    public final static String IMAGE_PATH = System.getProperty("user.dir")+r.getString("image_path");
    public final static String REPORT_PATH = System.getProperty("user.dir")+r.getString("report_path");


}
