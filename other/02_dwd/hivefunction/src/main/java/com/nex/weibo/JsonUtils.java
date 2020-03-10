package com.nex.weibo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @Project: hivefunction
 * @Package: com.nex.weibo
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月05日 13:17
 * @version: V1.0
 */
public class JsonUtils {

    public static Object[] getUserJson(JSONObject jUser, String text) throws JSONException {

        Object[] result = new Object[12];

        result[0] = jUser.getString("id");

        try {
            result[1] = jUser.getString("screen_name");
        } catch (JSONException e) {
            result[1] = null;
        }

        try {
            result[2] = jUser.getString("profile_url");
        } catch (JSONException e) {
            result[2] = null;
        }

        try {
            result[3] = jUser.getString("profile_image_url");
        } catch (JSONException e) {
            result[3] = null;
        }

        try {
            result[4] = jUser.getInt("statuses_count");
        } catch (JSONException e) {
            result[4] = null;
        }

        try {
            result[5] = jUser.getBoolean("verified") ? 1 : 0;
        } catch (JSONException e) {
            result[5] = null;
        }

        try {
            result[6] = jUser.getString("verified_reason");
        } catch (JSONException e) {
            result[6] = null;
        }

        try {
            result[7] = jUser.getString("description");
        } catch (JSONException e) {
            result[7] = null;
        }

        try {
            result[8] = jUser.getString("gender") == "m" ? 1 : jUser.getString("gender") == "f" ? 2 : 0;
        } catch (JSONException e) {
            result[8] = null;
        }

        try {
            result[9] = jUser.getInt("followers_count");
        } catch (JSONException e) {
            result[9] = null;
        }

        try {
            result[10] = jUser.getInt("follow_count");
        } catch (JSONException e) {
            result[10] = null;
        }

        if(text.length()>60000)
            text = text.substring(0, 60000);
        result[11] = text;


        return result;

    }

}
