#!/usr/bin/env python
# -*- coding: utf-8 -*- 
"""
@version: python3.7
@author: nero
@contact: 627482453@qq.com
@software: PyCharm
@file: SpiderUtils.py
@time: 2020/03/08
@description: utils for Spider
"""
import configparser
import json
import time
import os
import pymysql
import re

import jieba
import jieba.posseg as pseg
import jieba.analyse

project_name = "weibo"
conf_re_path = "/../../../conf/"

iter1 = iter(range(1, 10))


def get_index_url(id) -> str:
    """

    @return: index_url
    """

    index_url: str

    # get spider conf
    spider_conf = get_spider_config()

    # get the index_url to format
    index_url = spider_conf.get(project_name, "index_url")

    # get list_id
    list_id = spider_conf.get(project_name, "list" + id)

    return index_url.format(id=str(list_id))


def get_comment_url(id) -> str:
    """

    @param id: index_id
    @return: comment_url
    """

    comment_url: str

    # get spider conf
    spider_conf = get_spider_config()

    # get the index_url to format
    comment_url = spider_conf.get(project_name, "comment_url")

    return comment_url.format(id=str(id))


def get_daily_comment_url(index_text: str) -> dir:
    """

    @param index_text: response.text
    @return: result (a dir of comment)
    """

    # set the item
    length = 0
    index_mids = []
    comment_urls = []
    try:
        # get the json
        index_json = json.loads(index_text)
        # if cards exist
        if index_json.get('ok') == 1:

            # cards.for
            for card in index_json.get('data').get('cards'):
                try:
                    # get the index_mid
                    mid = card.get('mblog').get('mid')
                    index_mids.append(mid)
                    # splice the comment url
                    comment_urls.append(get_comment_url(mid))
                    length += 1
                except Exception as e_1:
                    print(e_1)
                    continue

    except Exception as e:
        print(e)

    result = {
        "length": length,
        "index_mids": index_mids,
        "comment_urls": comment_urls
    }

    return result


def get_main_config() -> configparser.ConfigParser:
    """

    @rtype: configparser.ConfigParser()
    @return: main_cf
    """

    # get the config path
    # "../../../conf/"
    config_path = os.path.abspath(os.path.curdir + conf_re_path)
    main_config_path = config_path + "\\main.ini"

    # get cf
    main_cf = configparser.ConfigParser()

    # set cf
    main_cf.read(main_config_path, encoding="utf-8")

    return main_cf


def get_spider_config() -> configparser.ConfigParser:
    """

    @rtype: configparser.ConfigParser()
    @return: spider_cf
    """

    # get the config path
    # "../../../conf/"
    config_path = os.path.abspath(os.path.curdir + conf_re_path)
    spider_config_path = config_path + "\\spider.ini"

    # get cf
    spider_cf = configparser.ConfigParser()

    # set cf
    spider_cf.read(spider_config_path, encoding="utf-8")

    return spider_cf


def get_mysql_config() -> configparser.ConfigParser:
    """

    @rtype: configparser.ConfigParser()
    @return: mysql_cf
    """
    # get the config path
    # "../../../conf/"
    config_path = os.path.abspath(os.path.curdir + conf_re_path)
    mysql_config_path = config_path + "\\mysql.ini"

    # get cf
    mysql_cf = configparser.ConfigParser()

    # set cf
    mysql_cf.read(mysql_config_path, encoding="utf-8")

    return mysql_cf


def get_spider_name1() -> str:
    """
    get the daily spider's name
    @return: name
    """
    spider_cf = get_spider_config()
    return spider_cf.get(project_name, "name1")


def get_spider_name2():
    """
    get the immediate spider's name
    @return:
    """
    spider_cf = get_spider_config()
    return spider_cf.get(project_name, "name2")


def get_log_filename() -> (str, str):
    """
    get the log filename
    @return:index_filename, comment_filename
    """

    # get log_abs_path
    main_cf = get_main_config()
    main_dir = main_cf.get("main", "main_path")

    spider_cf = get_spider_config()
    log_dir = spider_cf.get(project_name, "log_dir")

    # get filename
    pro_filename = time.strftime("%Y%m%d%H%M", time.localtime())

    # splice the filename
    index_filename = main_dir + log_dir + "/weiboindex-" + pro_filename
    comment_filename = main_dir + log_dir + "/weibocomment-" + pro_filename

    return index_filename, comment_filename


def parse_immediate_index(text: str) -> (list, list):
    """
    parse immediate index
    @param text: response.text
    @return: keyword, index_list
    """

    keyword = []
    index_list = []

    try:
        # get the json object
        json_object = json.loads(text)
        # if access
        if json_object.get('ok') != 1:
            assert Exception

        # get ods
        keywords = json_object.get("data").get("cardlistInfo").get("tags").get("keyword")
        # re
        pattern = re.compile(r'\$\$(\D+)+;')
        keyword_list = pattern.findall(keywords)

        for i in keyword_list:
            field = i.split('$$')
            # get keyword
            keyword.append(field[-1])

        try:
            # get cards
            cards = json_object.get('data').get('cards')
            # get mblog
            mblog = cards[0].get("card_group")[0].get('mblog')
            # save the index[0]
            index_list.append(parse_mblog(mblog))
        except Exception as e:
            print(e)

        # get cards[1:0]
        for card in cards[1:]:
            try:
                # get mblog
                mblog = card.get("mblog")
                # save the index[1:]
                index_list.append(parse_mblog(mblog))
            except Exception as e:
                print(e)

    except Exception as e:
        print(e)

    return keyword, index_list


def parse_immediate_comment(text: str, mid=None) -> list:
    """

    @param text: response.text
    @param mid: mblog_id
    @return: comment
    """

    comment = []

    try:
        # get json object
        json_object = json.loads(text)
        # if access
        if json_object.get("ok") != 1:
            assert Exception

        # get json data
        json_data = json_object.get('data').get('data')

        # traversal the json_data
        for data in json_data:
            # save the comment
            comment.append(parse_data(data, mid))

    except Exception as e:
        print(e)

    return comment


def parse_mblog(json_mblog: json) -> dir:
    """

    @param json_mblog: json mblog
    @return: return mblog
    """
    result = {
        "mid": json_mblog.get('mid'),
        "created_at": json_mblog.get('created_at'),
        "text": json_mblog.get('text'),
        "text_length": json_mblog.get('textLength'),
        "source": json_mblog.get('source'),
        "reposts_count": json_mblog.get('reposts_count'),
        "comments_count": json_mblog.get('comments_count'),
        "attitudes_count": json_mblog.get('attitudes_count'),
        "user": parse_user(json_mblog.get('user'))
    }
    return result


def parse_user(json_user: json) -> dir:
    """

    @param json_user: json user
    @return: user
    """
    result = {
        "id": json_user.get('id'),
        "screen_name": json_user.get('screen_name'),
        "profile_url": json_user.get('profile_url'),
        "profile_image_url": json_user.get('profile_image_url'),
        "statuses_count": json_user.get('statuses_count'),
        "verified": json_user.get('verified'),
        "verified_reason": json_user.get('verified') == 0 and "null" or json_user.get('verified_reason'),
        "description": json_user.get('description'),
        "gender": json_user.get('gender'),
        "followers_count": json_user.get('followers_count'),
        "follow_count": json_user.get('follow_count')
    }
    return result


def parse_data(json_data: json, mblog_id) -> dir:
    """

    @param json_data: json data
    @param mblog_id: mblog id
    @return: comment
    """
    result = {
        "id": json_data.get('id'),
        "text": json_data.get('text'),
        "like_count": json_data.get('like_count'),
        "created_at": json_data.get('created_at'),
        "mid": mblog_id,
        "user": parse_user(json_data.get('user'))
    }

    return result


def get_connect():

    mysql_cf = get_mysql_config()
    host = mysql_cf.get("mysql", "host")
    port = mysql_cf.get("mysql", "port")
    user = mysql_cf.get("mysql", "user")
    password = mysql_cf.get("mysql", "password")
    db = mysql_cf.get("mysql", "db")
    charset = mysql_cf.get("mysql", "charset")
    return pymysql.connect(host=host, port=int(port), user=user, passwd=password, db=db, charset=charset)


def execute_sql(sql):

    connect = get_connect()
    cursor = connect.cursor()

    try:
        cursor.execute(sql)
        # commit
        connect.commit()
    except pymysql.MySQLError as e:
        print(sql)
        print(e)
        # rollback
        connect.rollback()

def keyword2mysql(item):
    sql_insert_keyword = "INSERT INTO keyword " \
                         "( " \
                         "id, keyword " \
                         ") " \
                         "VALUES " \
                         "( " \
                         "{id}, \"{keyword}\" " \
                         ") ; "

    sql = sql_insert_keyword.format(id=next(iter1), keyword=item['keyword'])

    execute_sql(sql)

def index2mysql(tablename: str, item):
    sql_insert_index = "INSERT INTO {table} " \
                       "( " \
                       "mid, created_at, text, text_length, source, " \
                       "reposts_count, comments_count, attitudes_count, user " \
                       ") " \
                       "VALUES " \
                       "( " \
                       "\"{mid}\", \"{created_at}\", \"{text}\", {text_length}, \"{source}\", " \
                       "{reposts_count}, {comments_count}, " \
                       "{attitudes_count}, \"{user}\" " \
                       ") ; "

    index = item['index']
    text = first_process(index['text'])

    sql = sql_insert_index.format(
        table=tablename,
        mid=index['mid'], created_at=index['created_at'], text=text,
        text_length=index['text_length'],
        source=index['source'], reposts_count=index['reposts_count'], comments_count=index['comments_count'],
        attitudes_count=index['attitudes_count'], user=index['user']['id']
    )

    execute_sql(sql)

    user2mysql(index['user'])


def user2mysql(user):

    sql_insert_user = "INSERT INTO user " \
                      "( " \
                      "id, screen_name, profile_url, profile_image_url, statuses_count, verified, verified_reason, " \
                      "description, gender, followers_count, follow_count " \
                      ") " \
                      "VALUES " \
                      "( " \
                      "\"{id}\", \"{screen_name}\", \"{profile_url}\", \"{profile_image_url}\", {statuses_count}, " \
                      "{verified}, \"{verified_reason}\", \"{description}\", \"{gender}\", " \
                      " {followers_count}, {follow_count} " \
                      ") ; "

    sql = sql_insert_user.format(
        id=user['id'], screen_name=user['screen_name'], profile_url=user['profile_url'],
        profile_image_url=user['profile_image_url'], statuses_count=user['statuses_count'],
        verified=user['verified'], verified_reason=user['verified_reason'],
        description=user['description'].replace("\"", "\'"), gender=user['gender'],
        followers_count=user['followers_count'], follow_count=user['follow_count']
    )
    execute_sql(sql)

def comment2mysql(item):
    sql_insert_comment = "INSERT INTO comment " \
                         "( " \
                         "id, text, like_count, created_at, mid , user " \
                         ") " \
                         "VALUES " \
                         "( " \
                         "\"{id}\", \"{text}\", {like_count}, \"{created_at}\", \"{mid}\", \"{user}\" " \
                         ") ; "


    comment = item['comment']

    text = first_process(comment['text'])

    sql = sql_insert_comment.format(
        id=comment['id'], text=text, like_count=int(comment['like_count']),
        created_at=comment['created_at'], mid=comment['mid'], user=comment['user']['id']
    )
    execute_sql(sql)

    user2mysql(comment['user'])

def first_process(text):
    comp = re.compile(r'</?\w+[^>]*>')
    return comp.sub('', text)

def get_main_words(text):
    word_list = []
    words = pseg.cut(text.replace("\"", "\'"), use_paddle=True)
    for word, flag in words:
        if flag in ('nr', 'nt', 'ns', 'PER', 'LOC', 'ORG'):
            word_list.append(word)

    return ",".join(set(word_list))
