#!/usr/bin/env python
# -*- coding: utf-8 -*- 
"""
@version: python3.7
@author: nero
@contact: 627482453@qq.com
@software: PyCharm
@file: DailySpider.py
@time: 2020/03/08
@description: daily logs of weiboSpider
"""
from abc import ABC

import scrapy

from weibo import SpiderUtils
from weibo.items import DailyIndexItem, DailyCommentItem


class DailySpider(scrapy.Spider, ABC):
    # start the spider by the name.
    name = SpiderUtils.get_spider_name1()

    def __init__(self, idlist="0", **kwargs):
        super().__init__(**kwargs)
        self.list_id = idlist

    def start_requests(self):
        """
        Before starting to crawl.

        step:
            1. init DailyItem
            2. get the url
            3. scrapy.Request

        yield scrapy.Request() to self.parse_index

        """

        # get index url
        url = SpiderUtils.get_index_url(self.list_id)
        # yield scrapy.Request
        # to self.parse_index
        # item -> DailyItem
        yield scrapy.Request(url=url, callback=self.parse_index)

    def parse_index(self, response):
        """

        Parse the index page.
        step:
            1. get the item.
            2. save the index page.
            3. get the comment-mid to splice the comment-url.
            4. request the comment-page.

        @param response:
        """
        item = DailyIndexItem()
        item['index'] = response.text

        # get dir_comments from index
        # ["length": int, "mids": str, "comment_urls": str]
        dir_comments = SpiderUtils.get_daily_comment_url(response.text)

        yield item

        for i in range(dir_comments["length"]):
            yield scrapy.Request(url=dir_comments["comment_urls"][i], callback=self.parse_comment,
                                 meta={'mid': dir_comments["index_mids"][i]})

    def parse_comment(self, response):
        """
        Parse the comment page.

        step:
            1. save the comment.
            2. yield the item.

        @param response:
        @return:
        """

        item = DailyCommentItem()
        # get the mid
        mid = response.meta['mid']

        item['comment']= mid + "|" + response.text

        yield item
