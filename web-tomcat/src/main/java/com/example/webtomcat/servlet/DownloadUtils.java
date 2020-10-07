package com.example.webtomcat.servlet;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DownloadUtils {
    public static String getFileName(String userAgent, String filename) throws UnsupportedEncodingException {
        if (userAgent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "UTF-8");
            filename = filename.replace("+", " ");
        } else if (userAgent.contains("Firefox")) {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("UTF-8")) + "?=";
        } else {
            // 其他浏览器
            filename = URLEncoder.encode(filename, "UTF-8");
        }

        return filename;
    }
}
