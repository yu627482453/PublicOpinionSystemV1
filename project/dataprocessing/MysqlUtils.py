#!/usr/bin/env python
# -*- coding: utf-8 -*- 
"""
@version: python3.7
@author: nero
@contact: 627482453@qq.com
@software: PyCharm
@file: MysqlUtils.py
@time: 2020/03/10
@description: // TODO
"""
import configparser
import os
from typing import Any, Union

import pymysql
from pymysql.connections import Connection
from pymysql.cursors import Cursor


class MysqlUtils(object):

    _cursor: Union[Cursor, Any]
    _connect: Connection

    def __init__(self):
        self._sql = ""

    @property
    def sql(self):
        return self._sql

    @sql.setter
    def sql(self, sql):
        self._sql = sql

    def open(self):
        self._connect = self.get_connect()
        self._cursor = self._connect.cursor()

    def close(self):
        self._cursor.close()
        self._connect.close()

    def fetch(self):
        try:
            self._cursor.execute(self.sql)
        except Exception as e:
            print(e)
            self.sql = ""
            return

        self.sql = ""

        data = self._cursor.fetchall()
        return data

    def commit(self):
        try:
            self._cursor.execute(self.sql)
            # commit
            self._connect.commit()
        except pymysql.MySQLError as e:
            print(self.sql)
            print(e)
            # rollback
            self._connect.rollback()

        self.sql = ""

    def select(self, table, col, condition):
        self.sql = "SELECT {col} FROM {table} " \
              "{condition} ; ".format(col=col, table=table, condition=condition)

        return self.fetch()

    def insert(self, table, col, value):
        self.sql = "INSERT INTO {table} " \
                   "({col}) " \
                   "VALUES " \
                   "({value}) ; ".format(col=col, table=table, value=value)
        self.commit()

    def truncate(self, table):
        self.sql = "TRUNCATE TABLE {table} ; ".format(table=table)
        self.commit()

    def get_config(self) -> configparser.ConfigParser:
        """

        :rtype: configparser.ConfigParser
        :return: None
        """
        # get the config path
        # "../../../conf/"
        conf_re_path = "/../../conf/"
        config_path = os.path.abspath(os.path.curdir + conf_re_path)
        mysql_config_path = config_path + "\\mysql.ini"

        # get cf
        mysql_cf = configparser.ConfigParser()

        # set cf
        mysql_cf.read(mysql_config_path, encoding="utf-8")
        return mysql_cf

    def get_connect(self) -> Connection:
        """
        获取connect
        :return: connect
        :rtype: Connection
        """

        mysql_cf = self.get_config()

        host = mysql_cf.get("mysql", "host")
        port = mysql_cf.get("mysql", "port")
        user = mysql_cf.get("mysql", "user")
        password = mysql_cf.get("mysql", "password")
        db = mysql_cf.get("mysql", "db")
        charset = mysql_cf.get("mysql", "charset")

        return pymysql.connect(host=host, port=int(port), user=user, passwd=password, db=db, charset=charset)
