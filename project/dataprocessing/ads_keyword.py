#!/usr/bin/env python
# -*- coding: utf-8 -*- 
"""
@version: python3.7
@author: nero
@contact: 627482453@qq.com
@software: PyCharm
@file: ads_keyword.py
@time: 2020/03/10
@description: // process keyword
"""
import jieba.posseg as pseg

from MysqlUtils import MysqlUtils

ads_table = "ads_keyword"
ads_keyword = "keyword, value, part"


class ADSKeyword(object):

    def __init__(self):
        self._mysql_utils = MysqlUtils()
        self._mysql_utils.open()

    def _get_keyword0(self) -> ((), ()):
        result = self._mysql_utils.select(table="keyword", col="keyword", condition="where 1=1")
        return result

    def _set_keyword0(self, keyword):
        for item in keyword:
            self._mysql_utils.insert(table=ads_table, col=ads_keyword,
                                     value=" \"" + item[0] + "\" , 0, 0")

    def _get_keyword(self, table):
        result = self._mysql_utils.select(table=table, col="text, attitudes_count", condition="where 1=1")
        return result

    def _set_keyword(self, text_list, part):
        for i in self._process_keyword(text_list):
            self._mysql_utils.insert(table=ads_table, col=ads_keyword,
                                     value=" \"" + i[0] + "\" , " + str(i[1]) + " , " + str(part))

    def _get_main_words(self, text):
        word_list = []
        words = pseg.cut(text.replace("\"", "\'"), use_paddle=True)
        for word, flag in words:
            if flag in ('nr', 'nt', 'ns', 'PER', 'LOC', 'ORG'):
                word_list.append(word)

        return set(word_list)

    def _process_keyword(self, text_list):
        result = []
        for text in text_list:
            main_words = self._get_main_words(text[0])
            for word in main_words:
                result.append((word, text[1]))
        return result

    def process(self):
        """

        # 1. 获取数据
        # 2. 分词
        # 3. 统计词频
        # 4. 返回字典
        # 5. 插入数据库

        :return:
        """

        # # 1 获取keyword
        keyword = self._get_keyword0()
        self._set_keyword0(keyword)

        # # 2 获取text, attitudes_count : day, hour, yes_day, last_day, week

        # ## 1 day
        keyword = self._get_keyword("day")
        self._set_keyword(keyword, 1)

        # ## 2 hour
        keyword = self._get_keyword("hour")
        self._set_keyword(keyword, 2)
        # ## 3 yes_day
        keyword = self._get_keyword("yes_day")
        self._set_keyword(keyword, 3)

        # ## 4 last_day
        keyword = self._get_keyword("last_day")
        self._set_keyword(keyword, 4)

        # ## 5 week
        keyword = self._get_keyword("week")
        self._set_keyword(keyword, 5)
