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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Project: hivefunction
 * @Package: com.nex.weibo
 * @Description: TODO
 * @author: nero
 * @date: 2020年03月05日 9:43
 * @version: V1.0
 */
public class IndexJsonUDTF extends GenericUDTF {
    @Override
    public StructObjectInspector initialize(StructObjectInspector argOIs) throws UDFArgumentException {

        ArrayList<String> fieldNames = new ArrayList<String>();
        ArrayList<ObjectInspector> fieldOIs = new ArrayList<ObjectInspector>();

        // 0. id
        fieldNames.add("id");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 1. 文本内容
        fieldNames.add("text");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 2. 文本长度
        fieldNames.add("text_length");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaIntObjectInspector);
        // 3. 创建时间
        fieldNames.add("created_at");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 4. 转发数
        fieldNames.add("reposts_count");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaIntObjectInspector);
        // 5. 评论数
        fieldNames.add("comments_count");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaIntObjectInspector);
        // 6. 点赞数
        fieldNames.add("attitudes_count");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaIntObjectInspector);
        // 7. 数据来源
        fieldNames.add("source");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 8. 图片数
        fieldNames.add("pic_num");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 9. 图片json
        fieldNames.add("pics_json");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 10. url
        fieldNames.add("scheme");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        // 11. 发布用户id
        fieldNames.add("user_id");
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
                    // 创造容器
                    Object[] result = new Object[12];
                    // get card
                    JSONObject jCard = jCards.getJSONObject(i);
                    // get mblog
                    JSONObject jMblog = jCard.getJSONObject("mblog");
                    try {
                        result[0] = jMblog.getString("id");
                    } catch (JSONException e) {
                        continue;
                    }
                    try {
                        String text = jMblog.getString("text");
                        if (text.length() > 60000) {
                            text = text.substring(0, 60000);
                        }
                        result[1] = text;
                    } catch (JSONException e) {
                        result[1] = null;
                    }
                    try {
                        result[2] = jMblog.getInt("textLength");
                    } catch (JSONException e) {
                        result[2] = null;
                    }
                    try {
                        String createdAt = jMblog.getString("created_at");
                        // Wed Mar 04 10:03:03 +0800 2020
                        if(createdAt.contains("小时前")){

                            Pattern compile = Pattern.compile("-?[1-9]\\d*");
                            Matcher matcher = compile.matcher(createdAt);

                            if (matcher.find()) {
                                int diff = Integer.parseInt(matcher.group(0));
                                Date date_now = new Date();
                                Date date_created = new Date(date_now.getTime() - diff * 60 * 60 * 1000);
                                result[3] = date_created.toString().replace("CST", "+0800");
                            }

                        } else if (createdAt.contains("分钟前")) {
                            Pattern compile = Pattern.compile("-?[1-9]\\d*");
                            Matcher matcher = compile.matcher(createdAt);

                            if (matcher.find()) {
                                int diff = Integer.parseInt(matcher.group(0));
                                Date date_now = new Date();
                                Date date_created = new Date(date_now.getTime() - diff * 60 * 1000);
                                result[3] = date_created.toString().replace("CST", "+0800");
                            }
                        } else {
                            result[3] = createdAt;
                        }
                    } catch (JSONException e) {
                        result[3] = null;
                    } catch (NumberFormatException e) {
                        result[3] = null;
                    }
                    try {
                        result[4] = jMblog.getInt("reposts_count");
                    } catch (JSONException e) {
                        result[4] = null;
                    }
                    try {
                        result[5] = jMblog.getInt("comments_count");
                    } catch (JSONException e) {
                        result[5] = null;
                    }
                    try {
                        result[6] = jMblog.getInt("attitudes_count");
                    } catch (JSONException e) {
                        result[6] = null;
                    }
                    try {
                        result[7] = jMblog.getString("source");
                    } catch (JSONException e) {
                        result[7] = null;
                    }
                    try {
                        result[8] = jMblog.getInt("pic_num");
                    } catch (JSONException e) {
                        result[8] = null;
                    }
                    try {
                        result[9] = jMblog.getString("pics");
                    } catch (JSONException e) {
                        result[9] = null;
                    }
                    try {
                        result[10] = jCard.getString("scheme");
                    } catch (JSONException e) {
                        result[10] = null;
                    }
                    try {
                        result[11] = jMblog.getJSONObject("user").getString("id");
                    } catch (JSONException e) {
                        result[11] = null;
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
