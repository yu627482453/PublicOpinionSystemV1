# 03. Sqoop 导出

## 3.1 Sqoop 导出脚本

1. 创建脚本

在/home/atguigu/bin目录下创建脚本sqoop_export.sh
`[atguigu@hadoop102 bin]$ vim sqoop_export.sh`

2. 编写脚本

```bash
#!/bin/bash

db_name=gmall

export_data() {
/opt/module/sqoop/bin/sqoop export \
--connect "jdbc:mysql://hadoop102:3306/${db_name}?useUnicode=true&characterEncoding=utf-8"  \
--username root \
--password 000000 \
--table $1 \
--num-mappers 1 \
--export-dir /warehouse/$db_name/ads/$1 \
--input-fields-terminated-by "\t" \
--update-mode allowinsert \
--update-key "tm_id,category1_id,stat_mn,stat_date" \
--input-null-string '\\N'    \
--input-null-non-string '\\N'
}

case $1 in
  "ads_uv_count")
     export_data "ads_uv_count"
;;
  "ads_user_action_convert_day")
     export_data "ads_user_action_convert_day"
;;
  "ads_gmv_sum_day")
     export_data "ads_gmv_sum_day"
;;
   "all")
	 export_data "ads_uv_count"
	 export_data "ads_user_action_convert_day"
     export_data "ads_gmv_sum_day"
;;
esac

```

关于导出update还是insert的问题
	--update-mode：
updateonly   只更新，无法插入新数据
        allowinsert   允许新增 
	--update-key：允许更新的情况下，指定哪些字段匹配视为同一条数据，进行更新而不增加。多个字段用逗号分隔。
	--input-null-string和--input-null-non-string：
分别表示，将字符串列和非字符串列的空串和“null”转换成'\\N'。
官网地址：http://sqoop.apache.org/docs/1.4.6/SqoopUserGuide.html

```
Sqoop will by default import NULL values as string null. Hive is however using string \N to denote NULL values and therefore predicates dealing with NULL(like IS NULL) will not work correctly. You should append parameters --null-string and --null-non-string in case of import job or --input-null-string and --input-null-non-string in case of an export job if you wish to properly preserve NULL values. Because sqoop is using those parameters in generated code, you need to properly escape value \N to \\N:

```

Hive中的Null在底层是以“\N”来存储，而MySQL中的Null在底层就是Null，为了保证数据两端的一致性。在导出数据时采用--input-null-string和--input-null-non-string两个参数。导入数据时采用--null-string和--null-non-string。


3. 增加权限

`[atguigu@hadoop102 bin]$ chmod 777 sqoop_export.sh`

4. 执行脚本

`[atguigu@hadoop102 bin]$ sqoop_export.sh all`

5. 查看数据

```sql

SELECT * FROM ads_uv_count;
SELECT * FROM ads_user_retention_day_rate;
SELECT * FROM ads_user_action_convert_day;
SELECT * FROM ads_gmv_sum_day;
SELECT * FROM ads_gmv_sum_province;

```