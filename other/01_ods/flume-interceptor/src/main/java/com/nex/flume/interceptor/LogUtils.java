package com.nex.flume.interceptor;

/**
 * @Project: flume-interceptor
 * @Package: com.nex.flume.interceptor
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月03日 16:25
 * @version: V1.0
 */
public class LogUtils {

    public static boolean validate(String log) {

        if (log == null) {
            return false;
        }

        if (!log.trim().startsWith("{") || !log.trim().endsWith("}")) {
            return false;
        }

        return true;
    }

}
