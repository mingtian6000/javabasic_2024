package org.example.logback.myappender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.contrib.json.classic.JsonLayout;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

public class CustomLayout extends JsonLayout {
    // define cloud cluster log layout
    private static String hostName;
    private static String appName;
    private static String nodeName;
    private static String nameSpace;

    static{
        hostName = System.getenv("HOSTNAME");
        appName = System.getenv("APP_NAME");
        nodeName = System.getenv("NODE_NAME");
        nameSpace = System.getenv("NAMESPACE");

        try {
            hostName = hostName == null ? InetAddress.getLocalHost().getHostName() : hostName;
            appName = appName == null ? "unknown" : appName;
            nodeName = nodeName == null ? "unknown" : nodeName.split("-")[0];
            nameSpace = nameSpace == null ? "unknown" : nameSpace;
        } catch (UnknownHostException e) {
            System.out.println("Failed to get host name");
        }
    }

    @Override
    protected void addCustomDataToJsonMap(Map<String, Object> map, ILoggingEvent event) {
        //super.addCustomDataToJsonMap(map, event);
        map.put("hostName", hostName);
        map.put("appName", appName);
        map.put("nodeName", nodeName);
        map.put("nameSpace", nameSpace);
    }
}
