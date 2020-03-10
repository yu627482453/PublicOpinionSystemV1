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
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Project: hivefunction
 * @Package: com.nex.weibo
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月05日 12:17
 * @version: V1.0
 */
public class CommentJsonUDTF extends GenericUDTF {
    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {
        ArrayList<String> fieldNames = new ArrayList<String>();
        ArrayList<ObjectInspector> fieldOIs = new ArrayList<ObjectInspector>();

        // 0. id
        fieldNames.add("id");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 1. 创建时间
        fieldNames.add("created_at");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 2. 位序
        fieldNames.add("floor_number");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 3. 文本内容
        fieldNames.add("text");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 4. 点赞数
        fieldNames.add("like_count");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaIntObjectInspector);
        // 5. index中 id
        fieldNames.add("index_id");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 6. 用户 id
        fieldNames.add("user_id");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);


        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames, fieldOIs);

    }

    @Override
    public void process(Object[] objects) throws HiveException {

        String input = objects[0].toString();

        if (StringUtils.isBlank(input)) {
            return;
        } else {

            String[] logContents = input.split("\\|");
            if (logContents.length != 2 || StringUtils.isBlank(logContents[1])) {
                return;
            }

            try {
                JSONObject jsonObject = new JSONObject(logContents[1]);
                JSONObject jData = jsonObject.getJSONObject("data");
                JSONArray aData = jData.getJSONArray("data");

                if (aData == null) {
                    return;
                }

                for (int i = 0; i < aData.length(); i++) {
                    // 创造容器
                    Object[] result = new Object[7];
                    // get data
                    JSONObject data = aData.getJSONObject(i);
                    // 0
                    try {
                        result[0] = data.getString("id");
                    } catch (JSONException e) {
                        continue;
                    }
                    // 1
                    try {
                        String createdAt = data.getString("created_at");
                        // Wed Mar 04 10:03:03 +0800 2020
                        if(createdAt.contains("小时前")){

                            Pattern compile = Pattern.compile("-?[1-9]\\d*");
                            Matcher matcher = compile.matcher(createdAt);

                            if (matcher.find()) {
                                int diff = Integer.parseInt(matcher.group(0));
                                Date date_now = new Date();
                                Date date_created = new Date(date_now.getTime() - diff * 60 * 60 * 1000);
                                result[1] = date_created.toString().replace("CST", "+0800");
                            }

                        } else if (createdAt.contains("分钟前")) {
                            Pattern compile = Pattern.compile("-?[1-9]\\d*");
                            Matcher matcher = compile.matcher(createdAt);

                            if (matcher.find()) {
                                int diff = Integer.parseInt(matcher.group(0));
                                Date date_now = new Date();
                                Date date_created = new Date(date_now.getTime() - diff * 60 * 1000);
                                result[1] = date_created.toString().replace("CST", "+0800");
                            }
                        } else {
                            result[1] = createdAt;
                        }
                    } catch (JSONException e) {
                        result[1] = null;
                    } catch (NumberFormatException e) {
                        result[1] = null;
                    }
                    // 2
                    try {
                        result[2] = data.getString("floor_number");
                    } catch (JSONException e) {
                        result[2] = null;
                    }
                    // 3
                    try {
                        String text = data.getString("text");
                        if (text.length() > 60000) {
                            text = text.substring(0, 60000);
                        }
                        result[3] = text;
                    } catch (JSONException e) {
                        result[3] = null;
                    }
                    // 4
                    try {
                        result[4] = data.getInt("like_count");
                    } catch (JSONException e) {
                        result[4] = null;
                    }
                    // 5
                    try {
                        result[5] = logContents[0];
                    } catch (Exception e) {
                        result[5] = null;
                    }
                    // 6
                    try {
                        result[6] = data.getJSONObject("user").getString("id");
                    } catch (JSONException e) {
                        result[6] = null;
                    }

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
