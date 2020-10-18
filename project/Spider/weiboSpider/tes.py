#!/usr/bin/env python
# -*- coding: utf-8 -*- 
"""
@version: python3.7
@author: nero
@contact: 627482453@qq.com
@software: PyCharm
@file: tes.py
@time: 2020/10/18
@description: // TODO
"""

from scrapy import cmdline

cmd = 'scrapy crawl immediate -a idlist=_day'
cmdline.execute(cmd.split())
