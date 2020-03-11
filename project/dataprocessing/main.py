#!/usr/bin/env python
# -*- coding: utf-8 -*- 
"""
@version: python3.7
@author: nero
@contact: 627482453@qq.com
@software: PyCharm
@file: main.py
@time: 2020/03/10
@description: // TODO
"""
from ads_keyword import ADSKeyword
from ads_point import ADSPoint

if __name__ == '__main__':

    # 1. process keyword
    ads_keyword = ADSKeyword()
    ads_keyword.process()

    # 2. process point
    ads_point = ADSPoint()
    ads_point.process()
