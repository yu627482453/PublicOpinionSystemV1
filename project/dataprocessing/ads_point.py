#!/usr/bin/env python
# -*- coding: utf-8 -*- 
"""
@version: python3.7
@author: nero
@contact: 627482453@qq.com
@software: PyCharm
@file: ads_point.py
@time: 2020/03/11
@description: // TODO
"""
from MysqlUtils import MysqlUtils
import re

ads_table = "ads_point"
ads_point = "point, part"


class ADSPoint(object):
    def __init__(self):
        self._mysql_utils = MysqlUtils()
        self._mysql_utils.open()

    def _get_point0(self) -> ((), ()):
        result = self._mysql_utils.select(table="keyword", col="keyword", condition="where 1=1")
        return result

    def _set_point0(self, point):
        for item in point:
            self._mysql_utils.insert(table=ads_table, col=ads_point,
                                     value=" \"" + item[0] + "\" , 0")

    def _get_point(self, table):
        result = self._mysql_utils.select(table=table, col="text", condition="where 1=1")
        return result

    def _set_point(self, point_list, part):
        for point in point_list:
            result_list = self._process_point(point[0])
            for result in result_list:
                self._mysql_utils.insert(table=ads_table, col="point, part", value=" \"" + result + "\", " + str(part))

    def _process_point(self, text):

        pattern1 = re.compile(r'#([^#.]*)#')
        result1 = pattern1.findall(text)

        return result1

    def process(self):

        # # 0 清空数据
        self._mysql_utils.truncate("ads_point")

        # # 1 获取keyword
        point = self._get_point0()
        self._set_point0(point)

        # # 2 获取text: day, hour, yes_day, last_day, week

        # ## 1 day
        point = self._get_point("day")
        self._set_point(point, 1)

        # ## 2 hour
        point = self._get_point("hour")
        self._set_point(point, 2)
        # ## 3 yes_day
        point = self._get_point("yes_day")
        self._set_point(point, 3)

        # ## 4 last_day
        point = self._get_point("last_day")
        self._set_point(point, 4)

        # ## 5 week
        point = self._get_point("week")
        self._set_point(point, 5)

