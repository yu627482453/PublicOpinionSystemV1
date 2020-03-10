#!/usr/bin/env python
# -*- coding: utf-8 -*- 
"""
@version: python3.7
@author: nero
@contact: 627482453@qq.com
@software: PyCharm
@file: test.py
@time: 2020/03/10
@description: // TODO
"""
from MysqlUtils import MysqlUtils

mysqlUtils = MysqlUtils()

mysqlUtils.open()

result = mysqlUtils.select("week", "*", "where 1=1 ")
print(result)

