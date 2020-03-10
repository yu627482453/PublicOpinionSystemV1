# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


class DailyIndexItem(scrapy.Item):

    name = "daily_index"
    # item for index_page
    index = scrapy.Field()


class DailyCommentItem(scrapy.Item):

    name = "daily_comment"
    # item for comment_page
    comment = scrapy.Field()


class KeywordItem(scrapy.Item):
    name = "keyword"

    keyword = scrapy.Field()


class ImmediateIndexItem(scrapy.Item):
    name = "immediate_index"

    # item for index_page
    index = scrapy.Field()


class ImmediateCommentItem(scrapy.Item):
    name = "immediate_comment"
    comment = scrapy.Field()
