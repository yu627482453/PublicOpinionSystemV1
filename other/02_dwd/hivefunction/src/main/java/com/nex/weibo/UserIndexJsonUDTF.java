package com.nex.weibo;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @Project: hivefunction
 * @Package: com.nex.weibo
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月05日 12:55
 * @version: V1.0
 */
public class UserIndexJsonUDTF extends GenericUDTF {
    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {
        ArrayList<String> fieldNames = new ArrayList<String>();
        ArrayList<ObjectInspector> fieldOIs = new ArrayList<ObjectInspector>();

        // 0. id
        fieldNames.add("id");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 1. screen_name
        fieldNames.add("screen_name");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 2. profile_url
        fieldNames.add("profile_url");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 3. profile_image_url
        fieldNames.add("profile_image_url");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 4. 在线天数
        fieldNames.add("statuses_count");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaIntObjectInspector);
        // 5. 认证状态
        fieldNames.add("verified");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaIntObjectInspector);
        // 6. 认证标签
        fieldNames.add("verified_reason");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 7. 个人简介
        fieldNames.add("description");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 8. 性别
        fieldNames.add("gender");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaIntObjectInspector);
        // 9. 粉丝数
        fieldNames.add("followers_count");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaIntObjectInspector);
        // 10. 关注数
        fieldNames.add("follow_count");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaIntObjectInspector);
        // 11. 文本信息
        fieldNames.add("text");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames, fieldOIs);
    }

    @Override
    public void process(Object[] objects) throws HiveException {

        // 1.取出line
        String input = objects[0].toString();
        // 2. 判断是否为空
        if (StringUtils.isBlank(input)) {
            return;
        } else {
            try {
                // 3. 获取cards (JSONArray)
                JSONObject jsonObject = new JSONObject(input);
                JSONObject jData = jsonObject.getJSONObject("data");
                JSONArray jCards = jData.getJSONArray("cards");
                // 4. 判断是否为空
                if (jCards == null) {
                    return;
                }
                // 5. 循环获取 card
                for (int i = 0; i < jCards.length(); i++) {
                    // get card
                    JSONObject jCard = jCards.getJSONObject(i);
                    // get mblog
                    JSONObject jMblog = jCard.getJSONObject("mblog");
                    JSONObject jUser = jMblog.getJSONObject("user");
                    String text = null;
                    try {
                        text = jMblog.getString("text");
                    } catch (JSONException e) {
                        text = null;
                    }
                    Object[] result = JsonUtils.getUserJson(jUser, text);

                    forward(result);
                }

            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
    }
            @Override
    public void close() throws HiveException {

    }
}
