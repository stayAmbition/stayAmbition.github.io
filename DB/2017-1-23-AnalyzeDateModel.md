识表达人成长记 	
---
* 每张表记录的数据内容
	* 分模块对每张表记录的内容进行熟悉，学习系统需求
* 每张表重要字段
	* 非空字段、外键字段
* 数据库级别表与表之间的关系
	* 外键关系
* 表与表之间的业务关系
	* 建立在某个业务意义上去分析
	
	
### 用户购买商品模块 
	
#### 每张表的实际意义 	
	
	如何了解每张表的实际意义?
	查看数据库设计资料,数据库设计工具：power designer
	查看数据库表里面的结构注释
	
表名 | 意义
-------- | --------
users：  | 用户表-记录购买商品的用户信息 
orders： | 订单表-记录用户所创建的订单   
orderdetails：  | 订单明细表-记录了订单的详细信息即购买商品的信息   
items：   | 商品表-记录了商品信息  	
	
	特别注意：user表这里指终端的用户，非后台管理系统的用户	
	
####  每张表的重要字段

表名 | 非空字段 | 外键字段
-------- | -------- | --------
users：  | id(自增主键),username | 无
orders： | id(自增主键),number(订单号),users_id,createtime  | users_id
orderdetails：  |  id(自增主键),orders_id,items_id  | orders_id,items_id
items：   | id(自增主键),name,price  | 无

#### 表与表之间的外键关系
	
	外键所在的表叫做子表，外键指向的表为父表。 
	
	users<---[users_id]---orders<---[orders_id]---orderdetails---[items_id]--->items
	
#### 表与表之间的业务关系 
	
##### 先分析数据级别由关系的表之间的业务关系
	
	users和orders
	users--->orders  一个用户可以创建多个订单，一对多
	orders--->users  一个订单只由一个用户来创建,一对一。如果换个说法，多个订单可以由一个用户来创建，多对一
	
	orders和orderdetails
	orders--->orderdetails  一个订单可以包括多个订单明细，因为一个订单可以购买多个商品，每个商品的购买信息在orderdetails里记录,一对多
	orderdetails--->orders  一个订单明细只能包括在一个订单里，一对一
	
	orderdetails--->items   一个订单明细只对应一个商品明细，一对一
	items--->orderdetails   一个商品可以包括在多个订单明细中，一对多
	
##### 再分析数据库级别没有关系的表之间是否有业务关系 

	orders和items之间通过orderdetails之间建立关系
	orders--->items 一对多
	items--->orders 一对多
	orders和items是多对多关系
	
	同理users与items是多对多关系
	


