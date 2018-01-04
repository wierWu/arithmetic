#!/usr/bin/python3
 
import pymysql
 
# 打开数据库连接
db = pymysql.connect("10.130.130.114","root","","test" )
 
# 使用cursor()方法获取操作游标 
cursor = db.cursor()
 
# SQL 插入语句

try:
   # 执行sql语句
   for i in range(10000):
   	uname='test'+str(i%100)
   	sex=i%2
   	age=i%100
   	sql = "insert into test(user_name,sex, age, c_date) values('%s', '%d', '%d', now())" % (uname, sex, age) 
   	print(sql)
   	# cursor.execute(sql)
   	# db.commit()
   
except:
   # 如果发生错误则回滚
   print('error')

   db.rollback()
 
# 关闭数据库连接
db.close()