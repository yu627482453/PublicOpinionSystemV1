#!/usr/bin/env python
# -*- coding: utf-8 -*- 
"""
@version: python3.7
@author: nero
@contact: 627482453@qq.com
@software: PyCharm
@file: ImmediateSpider.py
@time: 2020/03/08
@description: immediate spider
"""
from abc import ABC

import scrapy

from weibo import SpiderUtils
from weibo.items import KeywordItem, ImmediateIndexItem, ImmediateCommentItem


class ImmediateSpider(scrapy.Spider, ABC):
    # start the spider by the name.
    name = SpiderUtils.get_spider_name2()
    list_id = ""

    def __init__(self, idlist=None, idcomment=None, **kwargs):
        super().__init__(**kwargs)
        # list id
        self.list_id = idlist
        # comment id
        self.comment_id = idcomment

    def start_requests(self):
        """
        do before requests
        @return:
        """

        if self.comment_id:
            # yield scrapy.Request
            # to self.parse_comment1
            # item -> DailyItem
            comment_url = SpiderUtils.get_comment_url(self.comment_id)
            yield scrapy.Request(url=comment_url, callback=self.parse_comment1)

        if self.list_id:
            # get index url
            url = SpiderUtils.get_index_url(self.list_id)
            # yield scrapy.Request
            # to self.parse_index
            # item -> DailyItem
            yield scrapy.Request(url=url, callback=self.parse_index)

    def parse_comment1(self, response):
        """
        parse comment if self.comment_id is not None
        @param response:
        @return:
        """

        # save the comment
        for comment in SpiderUtils.parse_immediate_comment(response.text):
            # get item
            item = ImmediateCommentItem()
            item['comment'] = comment

            yield item

    def parse_index(self, response):
        """
        parse the index if self.id_list is not None
        @param response:
        @return:
        """
        # save keyword, index
        keywords, indexs = SpiderUtils.parse_immediate_index(response.text)

        for keyword in keywords:
            item = KeywordItem()
            item['keyword'] = keyword
            yield item

        for it in indexs:
            item = ImmediateIndexItem()
            item['index'] = it
            yield item

            mid = it['mid']
            yield scrapy.Request(url=SpiderUtils.get_comment_url(mid), callback=self.parse_comment2,
                                 meta={'mid': mid})

    def parse_comment2(self, response):
        """
        parse the comment from index
        @param response:
        @return:
        """
        # get mid
        mid = response.meta['mid']
        # save the comment
        comments = SpiderUtils.parse_immediate_comment(response.text, mid)
        for comment in comments:
            item = ImmediateCommentItem()
            item['comment'] = comment
            yield item
