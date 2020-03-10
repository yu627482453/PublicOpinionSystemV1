# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html

from weibo import SpiderUtils


class WeiboPipeline(object):

    def __init__(self) -> None:
        super().__init__()
        self.iter1 = iter(range(1, 20))

    def process_item(self, item, spider):

        # daily spider
        if spider.name == SpiderUtils.get_spider_name1():
            index_filename, comment_filename = SpiderUtils.get_log_filename()

            if index_filename is None or comment_filename is None:
                return

            else:
                if item.name == "daily_index":
                    with open(index_filename + ".log", "w+") as f:
                        f.write(item['index'])

                if item.name == "daily_comment":
                            with open(comment_filename + "_" + str(next(self.iter1)) + ".log", 'w+') as f:
                                f.write(item['comment'])

            return
        elif spider.name == SpiderUtils.get_spider_name2():
            if item.name == "keyword":
                SpiderUtils.keyword2mysql(item)
            elif item.name == "immediate_index":
                SpiderUtils.index2mysql(spider.list_id[1:], item)
            elif item.name == "immediate_comment":
                SpiderUtils.comment2mysql(item)
            else:
                pass
        else:
            pass
