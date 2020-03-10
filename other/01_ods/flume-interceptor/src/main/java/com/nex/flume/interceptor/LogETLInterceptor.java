package com.nex.flume.interceptor;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project: flume-interceptor
 * @Package: com.nex.flume.interceptor
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月03日 16:20
 * @version: V1.0
 */
public class LogETLInterceptor implements Interceptor {
    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {

        // etl
        byte[] body = event.getBody();
        String log = new String(body, Charset.forName("UTF-8"));

        //validate
        if (!log.contains("{\"ok\": 0")) {
            if (LogUtils.validate(log)) {
                return event;
            }
        }

        return null;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        ArrayList<Event> interceptors = new ArrayList<>();

        for (Event event : list) {
            Event intercept1 = intercept(event);

            if (intercept1 != null){
                interceptors.add(event);
            }
        }

        return interceptors;
    }

    @Override
    public void close() {

    }

    public static class Builder implements Interceptor.Builder{

        @Override
        public Interceptor build() {
            return new LogETLInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
