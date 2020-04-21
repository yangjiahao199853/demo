一：网上书店
1：用户管理：注册，登录，修改密码
2：图书管理：CURD
3：购物车：书籍加入购物车，修改，删除购物车内图书信息


二：数据库设计
1：用户表：
ID：					bigint(20)(32)
用户名:userName			varchar(50)	
密码：password			varchar(50)	
邮箱:email				varchar(50)

2：图书表：
ID: bigint(20)
书名：bookName			varchar(200)	
作者：author     		varchar(200)	
价格：price				decimal(8,2)
出版时间:publishtime		Datetime    
开本:booksize			bigint

3：购物车表：
ID:bigint(20)(32)
数量：quantity			Int
书号:bookId（外键，图书ID）	bigint(20)
用户ID：userId(外键，用户ID）	bigint(20)


三：接口：
1：注册：（通过邮箱激活）

2:
·登录：密码通过MD5加密

3新增图书：
·修改图书，
·删除图书
·查询图书（通过书名，作者，价格，支持模糊查询）

4：购物车
·新增购物车：书籍新增加购，判断用户名下是否有购物车，没有新增，有修改数量
·查询购物车：通过用户查询用户名下的购物车，外键书籍ID，查询书籍名称
·修改购物车：修改数量，增加书籍号
·删除购物车，删除用户名下购物车





