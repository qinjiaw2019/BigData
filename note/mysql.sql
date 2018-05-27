-- DDL 数据库定义语言
-- DML 数据库操作语言
-- DCL 数据库控制语言
-- DQL 数据库查询语言
-- ==========================================数据库的常用数据类型===========================
-- 常用数据类型：
-- 			int：整型
-- 			double：浮点型，例如double(5,2)表示最多5位，其中必须有2位小数，即最大值为999.99；
-- 			char：固定长度字符串类型；    char(10)     'aaa       '  占10位
-- 			varchar：可变长度字符串类型； varchar(10)  'aaa'  占3为
-- 			text：字符串类型；
-- 			blob：字节类型；
-- 			date：日期类型，格式为：yyyy-MM-dd；
-- 			time：时间类型，格式为：hh:mm:ss
-- 			timestamp：时间戳类型 yyyy-MM-dd hh:mm:ss  会自动赋值
-- 			datetime:日期时间类型 yyyy-MM-dd hh:mm:ss


-- ==============================================DDL操作========================================
-- 1.创建数据库:create database 数据库名;
--   删除数据库:drop database 数据库名;
-- 2.显示所有的数据库:show databases;
-- 3.切换数据库:use 数据库名(即将要使用的数据库)
-- 	查看当前所在的数据库: select database();
-- 4.显示数据库的创建详细信息:
--   show create database db01;
-- 5.创建数据库时设置编码 
--   create database db02 character set utf8;
-- 6.修改数据库的编码:
--    alter database db02 character set bgk;
-- 7.查看编码:
--    show character set;
-- 8.创建表
-- 	create table teacher(
-- 		id varchar(20) primary key not null,
-- 		name varchar(20) not null,//会自动调整大小
-- 		age int,//不用写占用内存大小
-- 		sex char(2),//"a ",不会自动调整大小
-- 		addr varchar(50)
-- 	);
-- 9.插入数据:
-- 	insert into teacher(id,name,age,sex,addr) values('0001','zhang',25,'nn','beijing');
-- 10.删除表:
-- 	drop table teacher;  
-- 11.查看建表的信息
-- show create table 表名;

-- 12.查看表的详细信息
-- desc 表名;
	
-- 13.修改表名:
-- 	alter table 旧表名 rename to 新表名;
--  或者 alter table 旧表名 rename 新表名;
 
-- 14.往表中添加一列
--  alter table t_user add sex varchar(3);
 
-- 15.修改表中字段     alter table 表名 change 字段原名 字段新名 字段类型.
--  alter table t_user change name u_name varchar(2);
--  	将表t_user的name字段改成u_name
 	
-- 16者修改字段的类型
--  alter table 表名 modify 字段名 字段类型

-- 17.	删除字段
-- 	alter table 表名 drop 列名
	
-- 修还表的字符集
alter table table_name default character set utf8

-- 修改表字段的字符集
ALTER TABLE employee CHANGE column_name column_name column_tye CHARACTER SET utf8;

-- 修改表的字符集和所有列的字符集
alter table table_name convert to character set utf8;
	
-- 删除数据库
DROP DATABASE IF EXISTS ljy;
-- 创建数据库
CREATE DATABASE ljy;

-- 进入数据库
USE ljy;

-- 创建emp表
CREATE TABLE emp(
id INT,
NAME VARCHAR(100),
gender VARCHAR(10),
birthday DATE,
salary FLOAT(10,2),
entry_date DATE,
RESUME TEXT
);

-- 向emp表中插入数据
INSERT INTO emp(id,NAME,gender,birthday,salary,entry_date,RESUME)
VALUES(1,'zhangsan','female','1990-5-10',10000,'2015-5-5-','good girl');

INSERT INTO emp(id,NAME,gender,birthday,salary,entry_date,RESUME)
VALUES(2,'lisi','male','1995-5-10',10000,'2015-5-5','good boy');

INSERT INTO emp(id,NAME,gender,birthday,salary,entry_date,RESUME)
VALUES(3,'你好','male','1995-5-10',10000,'2015-5-5','good boy');

SELECT * FROM emp;

-- 创建学生表 并插入数据
CREATE TABLE stu (
	sid	CHAR(6),
	sname		VARCHAR(50),
	age		INT,
	gender	VARCHAR(50)
);

INSERT INTO stu VALUES('S_1001', 'liuYi', 35, 'male');
INSERT INTO stu VALUES('S_1002', 'chenEr', 15, 'female');
INSERT INTO stu VALUES('S_1003', 'zhangSan', 95, 'male');
INSERT INTO stu VALUES('S_1004', 'liSi', 65, 'female');
INSERT INTO stu VALUES('S_1005', 'wangWu', 55, 'male');
INSERT INTO stu VALUES('S_1006', 'zhaoLiu', 75, 'female');
INSERT INTO stu VALUES('S_1007', 'sunQi', 25, 'male');
INSERT INTO stu VALUES('S_1008', 'zhouBa', 45, 'female');
INSERT INTO stu VALUES('S_1009', 'wuJiu', 85, 'male');
INSERT INTO stu VALUES('S_1010', 'zhengShi', 5, 'female');
INSERT INTO stu VALUES('S_1011', 'xxx', NULL, NULL);

SELECT * FROM stu;

-- 删除emp表
DROP TABLE emp;

-- 新建emp表
CREATE TABLE emp(
	empno		INT,
	ename		VARCHAR(50),
	job		VARCHAR(50),
	mgr		INT,
	hiredate	DATE,
	sal		DECIMAL(7,2),
	comm		DECIMAL(7,2),
	deptno		INT
	);
	
INSERT INTO emp VALUES(7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);
INSERT INTO emp VALUES(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO emp VALUES(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,500,30);
INSERT INTO emp VALUES(7566,'JONES','MANAGER',7839,'1981-04-02',2975,NULL,20);
INSERT INTO emp VALUES(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,1400,30);
INSERT INTO emp VALUES(7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,NULL,30);
INSERT INTO emp VALUES(7782,'CLARK','MANAGER',7839,'1981-06-09',2450,NULL,10);
INSERT INTO emp VALUES(7788,'SCOTT','ANALYST',7566,'1987-04-19',3000,NULL,20);
INSERT INTO emp VALUES(7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10);
INSERT INTO emp VALUES(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO emp VALUES(7876,'ADAMS','CLERK',7788,'1987-05-23',1100,NULL,20);
INSERT INTO emp VALUES(7900,'JAMES','CLERK',7698,'1981-12-03',950,NULL,30);
INSERT INTO emp VALUES(7902,'FORD','ANALYST',7566,'1981-12-03',3000,NULL,20);
INSERT INTO emp VALUES(7934,'MILLER','CLERK',7782,'1982-01-23',1300,NULL,10);

SELECT * FROM emp;


-- 创建部门表
CREATE TABLE dept(
	deptno		INT,
	dname		VARCHAR(14),
	loc		VARCHAR(13)
);
INSERT INTO dept VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO dept VALUES(20, 'RESEARCH', 'DALLAS');
INSERT INTO dept VALUES(30, 'SALES', 'CHICAGO');
INSERT INTO dept VALUES(40, 'OPERATIONS', 'BOSTON');

-- 查询学号为S_1001，或者姓名为liSi的记录
SELECT * FROM stu WHERE sid='S_1001' OR sname='liSi';

-- 查询学号为S_1001，S_1002，S_1003的记录
SELECT * FROM stu WHERE sid IN ('S_1001','S_1002','S_1003');

-- 查询学号不是S_1001，S_1002，S_1003的记录
SELECT * FROM stu WHERE sid NOT IN ('S_1001','S_1002','S_1003');

-- 查询年龄为null的记录
SELECT * FROM stu WHERE age IS NULL;

-- 查询年龄在20到40之间的学生记录
-- 方式1
SELECT * FROM stu WHERE age>=20 AND age<=40;
-- 方式2
SELECT * FROM stu WHERE age BETWEEN 20 AND 40;

-- 查询性别非男的学生记录
-- 方式1
SELECT * FROM stu WHERE gender != 'male'; -- != 记录不包含null的
-- 方式2
SELECT * FROM stu WHERE gender <> 'male'; 
-- 方式3
SELECT * FROM stu WHERE NOT gender='male';

-- 查询姓名不为null的学生记录
-- 方式1
SELECT * FROM stu WHERE sname IS NOT NULL;
-- 方式2
SELECT * FROM stu WHERE NOT sname IS NULL;

-- ========================================模糊查询===============================================
-- 查询姓名由5个字母构成的学生记录
SELECT * FROM stu WHERE sname LIKE '_____'; -- 一个_表示一个任意字符

-- 查询姓名由5个字母构成，并且第5个字母为“i”的学生记录
SELECT * FROM stu WHERE sname LIKE '____i';

-- 查询姓名以“z”开头的学生记录
SELECT * FROM stu WHERE sname LIKE 'z%'; -- %表示0个或多个字符

-- 查询姓名中第2个字母为“i”的学生记录
SELECT * FROM stu WHERE sname LIKE '_i%';

-- 查询姓名中包含“a”字母的学生记录
SELECT * FROM stu WHERE sname LIKE '%a%';

-- ========================================字段控制查询============================================
-- 查询 emp表中的工资情况,不重复
SELECT DISTINCT sal FROM emp; -- 使用distinct字段去除重复

-- 查看雇员的月薪与佣金之和--错误查法
SELECT * ,sal+comm AS sumSalary FROM emp;-- 这样查询会出错 原因是null 与任何数相加为null
-- 查看雇员的月薪与佣金之和--正确查法
SELECT *,sal+IFNULL(comm,0) AS sumSalary FROM emp;

-- ===========================================排序===============================================
-- 查询员工的信息,按照薪资升序排序
SELECT * FROM emp ORDER BY sal;-- 默认升序
-- 查询员工的信息,按照薪资升序排序
SELECT * FROM emp ORDER BY sal ASC;
-- 查询员工的信息,按照薪资升序排序
SELECT * FROM emp ORDER BY sal DESC;
SELECT *,sal+IFNULL(comm,0) AS sumSalary FROM emp ORDER BY sumSalary DESC;

-- 查询所有学生记录，按年龄降序排序 null默认是最小的
SELECT * FROM stu ORDER BY age DESC;-- 记录中null默认是最小的

-- 查询所有雇员，按月薪降序排序，如果月薪相同时，按编号升序排序 null默认是最小的
SELECT * FROM emp ORDER BY sal DESC,empno ASC;

-- ========================================聚合函数===================================================
-- count  统计指定列不为NULL的记录行数；
-- 查询emp表中记录数：
SELECT COUNT(*) FROM emp;

-- 查询emp表中有佣金的人数：
SELECT COUNT(comm) FROM emp;-- 只统计非空的记录
-- 查询emp表中月薪大于2500的人数：
SELECT COUNT(*) FROM emp WHERE sal>2500;

-- 统计月薪与佣金之和大于2500元的人数：
SELECT COUNT(*) FROM emp WHERE sal+IFNULL(comm,0)>2500;

-- 查询有佣金的人数，以及有领导的人数：
SELECT COUNT(comm),COUNT(mgr) FROM emp;

-- SUM 计算指定列的数值和，如果指定列类型不是数值类型，那么计算结果为0；
-- AVG 计算指定列的平均值，如果指定列类型不是数值类型，那么计算结果为0；
-- 查询所有雇员月薪和：
SELECT SUM(sal) FROM emp;

-- 查询所有雇员月薪和，以及所有雇员佣金和
SELECT SUM(sal),SUM(comm) FROM emp;

-- 查询所有雇员月薪+佣金和：
SELECT SUM(sal+IFNULL(comm,0)) AS sumsalary FROM emp;

-- 统计所有员工平均工资：
SELECT AVG(sal) FROM emp;

-- MAX 计算指定列的最大值，如果指定列是字符串类型，那么使用字符串排序运算;
-- MIN 计算指定列的最小值，如果指定列是字符串类型，那么使用字符串排序运算；

-- 查询最高工资和最低工资：
SELECT MAX(sal) AS 最高工资,MIN(sal) AS 最低工资 FROM emp;


-- =======================================分组查询==============================================
-- 查询每个部门的部门编号和每个部门的工资和
SELECT deptno,SUM(sal) FROM emp GROUP BY deptno;

-- 查询每个部门的部门编号以及每个部门的人数：
SELECT deptno,COUNT(*) FROM emp GROUP BY deptno;

-- 查询每个部门的部门编号以及每个部门工资大于1500的人数：
SELECT deptno,COUNT(*) AS 工资大于3000 FROM emp WHERE sal>=3000 GROUP BY deptno;

-- 查询工资总和大于9000的部门编号以及工资和：
SELECT deptno,SUM(sal) AS totalSalary FROM emp GROUP BY deptno HAVING totalSalary>9000;
SELECT deptno,SUM(sal) AS totalSalary FROM emp GROUP BY deptno HAVING SUM(sal)>9000;
-- having 和where的区别
 -- 1,having是用于分组后对数据进行过滤
 --   where是用于分组前对数据进行过滤
 -- 2,having后面可以使用分组函数
 --   where后面不能使用分组函数
 
-- ================================LIMIT===========================================
-- LIMIT用来限定查询结果的起始行，以及总行数
-- 查询5行记录，起始行从0开始
SELECT * FROM emp LIMIT 0,5;-- 起始行从0开始，即第一行开始！

-- 查询10行记录，起始行从3开始
SELECT * FROM emp LIMIT 2,5;


-- ================================完整性========================================== 
-- 1.实体完整性:表中的一行数据代表一个实体
--  作用:标识每一行数据不重复
--  约束类型:主键 primary key,唯一 unique,自增长 auto_increment


-- 2.域完整性
--  域代表当前单元格
--  作用: 确保当前单元格的数据正确性,不对照此列的其他单元格比较
-- 完整性约束:数据类型,非空(not null),默认值,check约束

-- 3.引用完整性(参照完整性)
--  外键约束 foreign key


-- 创建t_user表
CREATE TABLE t_user(
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户id,用于系统维护,主键',
	username VARCHAR(100) UNIQUE NOT NULL COMMENT '用户名,用于用户登录系统',
	PASSWORD VARCHAR(100) NOT NULL COMMENT '用户密码,用于用户登录系统',
	phone VARCHAR(20) NOT NULL COMMENT '用于电话号码',
	email VARCHAR(100) COMMENT '用户邮箱',
	age INT COMMENT '用户年龄',
	money DOUBLE(8,2) COMMENT '用户在系统中的余额'
);
 
-- 创建 t_order表
CREATE TABLE t_order(
	id INT PRIMARY KEY AUTO_INCREMENT COMMENT '订单id',
	u_id INT COMMENT '订单对应的用户',
	order_date TIMESTAMP COMMENT '订单生成时间',
	order_status INT DEFAULT 0 COMMENT '订单状态,0表示未支付',
	des VARCHAR(200) COMMENT '订单描述',
	price DOUBLE(6,2) COMMENT '订单价格',
	CONSTRAINT u_id_fk FOREIGN KEY(u_id) REFERENCES t_user(id) COMMENT '参照t_user(id)的外键 '
);

-- 删除外键
ALTER TABLE t_order DROP FOREIGN KEY u_id_fk;
-- 新增外键
ALTER TABLE t_order ADD CONSTRAINT u_id_fk FOREIGN KEY(u_id) REFERENCES t_user(id);

-- 修改订单价格范围
ALTER TABLE t_order MODIFY price DOUBLE(8,2) DEFAULT 0 COMMENT '订单价格';

DESC t_user;
-- ==========================================多表查询=================================
-- 1.链接查询
--  a交叉链接
-- 需求:查询所有的客户信息和所有的订单信息
SELECT * FROM t_user,t_order; -- 返回的是两张表的笛卡尔积(m*n),隐式查询--不使用关键字
--  或者
SELECT * FROM t_user CROSS JOIN t_order;

--  b内连接 inner join on
-- 需求:查询所有的有订单的客户信息,并把对应的订单信息查询出来
SELECT * FROM t_user t1,t_order t2 WHERE t2.u_id=t1.id;
--  或者
SELECT * FROM t_user t1 INNER JOIN t_order t2 ON t2.u_id=t1.id;

--  c外连接
-- 左外连接:left outer join 返回左表中所有的记录,同时返回右表中满足条件的记录
-- 需求:查询所有的用户信息,并将有订单的订单信息查询出来
SELECT * FROM  t_user t1 LEFT OUTER JOIN t_order t2 ON t2.u_id=t1.id;
-- 右外连接 right outer join
SELECT * FROM  t_user t1 RIGHT OUTER JOIN t_order t2 ON t2.u_id=t1.id;
-- 或者
SELECT * FROM  t_order t2 LEFT OUTER JOIN t_user t1 ON t2.u_id=t1.id;

-- 全外连接 full join     mysql不支持

-- 合并结果集:被合并的两个结果列数和列类型必须相同
-- union 取出重复记录
SELECT * FROM t_user UNION SELECT * FROM t_order; -- The used SELECT statements have a different number of columns
SELECT id,username FROM t_user UNION SELECT id,des FROM t_order;
-- union all 不去除重复记录
SELECT id,username FROM t_user UNION ALL SELECT id,des FROM t_order;

-- 自然链接 natural join
SELECT * FROM t_user NATURAL JOIN t_order; -- 内连接
SELECT * FROM t_user NATURAL LEFT JOIN t_order;-- 左连接
SELECT * FROM t_user NATURAL RIGHT JOIN t_order;-- 右连接

-- =================================子查询====================================
-- 工资高于JONES的员工。
SELECT * FROM emp WHERE sal>(SELECT sal FROM emp WHERE ename='JONES');
-- 查询与SCOTT同一个部门的员工。
SELECT * FROM emp WHERE deptno=(SELECT deptno FROM emp WHERE ename='SCOTT');

-- 工资高于30号部门所有人的员工信息
SELECT * FROM emp WHERE sal>(SELECT MAX(sal) FROM emp WHERE deptno='30');
-- 或者
SELECT * FROM emp WHERE sal >ALL(SELECT sal FROM emp WHERE deptno='30');

-- 查询工作和工资与MARTIN（马丁）完全相同的员工信息
SELECT * FROM emp WHERE (job,sal) IN (SELECT job,sal FROM emp WHERE ename='MARTIN');
-- 或者
SELECT * FROM emp WHERE job=(SELECT job FROM emp WHERE ename='MARTIN') AND sal=(SELECT sal FROM emp WHERE ename='MARTIN');

-- 有2个以上直接下属的员工信息
SELECT * FROM emp WHERE empno IN (SELECT mgr FROM emp GROUP BY mgr HAVING COUNT(mgr)>=2);


-- =====================================函数===========================================
-- 当前日期 CURRENT_DATE()
SELECT CURRENT_DATE();
-- 当前时间 CURRENT_TIME()
SELECT CURRENT_TIME();
-- 当前时间戳 CURRENT_TIMESTAMP()
SELECT CURRENT_TIMESTAMP();
-- 使用时间戳
UPDATE t_order SET order_date=(SELECT CURRENT_TIMESTAMP());

-- DATE(datetime) 返回datetime的日期部分
SELECT DATE('2016-11-23 14:23:45');-- 2016-11-23
SELECT DATE(CURRENT_TIMESTAMP());-- 2018-04-07
SELECT DATE(CURRENT_DATE());-- 2018-04-07
SELECT DATE(CURRENT_TIME());-- NULL

-- DATEDIFF (date1 ,date2 ) 两个日期差
SELECT DATEDIFF('2018-04-07 17:27:27',CURRENT_TIMESTAMP()); -- 单位是天
-- DATE_SUB (date2 , INTERVAL d_value d_type ) 在date2上减去一个时间

-- 返回字串字符集 CHARSET(str)
SELECT CHARSET("Hello world");-- utf8

-- CONCAT (string2  [,... ]) 连接字串
SELECT CONCAT('Hello','World',1);

-- UCASE (string2 ) 转换成大写
SELECT UCASE('hello world');

-- LCASE (string2 ) 转换成小写
SELECT LCASE('HELLO WORLD');

-- LENGTH (string ) string长度
SELECT LENGTH('Hello');

-- STRCMP (string1 ,string2 )逐字符比较两字串大小,
SELECT STRCMP('b','a');-- 小于返回-1,等于返回0 大于返回1

-- TRIM(str) 去除左右两边的空格
SELECT TRIM('   ni   hao    ');
-- LTRIM (string2 ) 去除左边的空格
SELECT LTRIM('   ni   hao    ');
-- RTRIM (string2 ) 去除右边的空格
SELECT RTRIM('   ni   hao    ');

-- ABS (number2 ) 绝对值
SELECT ABS(-10);

-- BIN (decimal_number ) 十进制转二进制
SELECT BIN(10);

-- CEILING (number2 ) 向上取整
SELECT CEILING(3.5);

-- FLOOR (number2 )向下取整
SELECT FLOOR(3.5);

-- FORMAT (number,decimal_places ) 保留小数位数
SELECT FORMAT(3.326,2); -- 四舍五入形式

-- LEAST (number , number2  [,..]) 求最小值
SELECT LEAST(1,2,3,4,5,6,7);

-- MOD (numerator ,denominator )求余
SELECT MOD(5,3);-- 2

-- RAND([seed]) 随机数
SELECT RAND();-- double


-- mysql 的数据导出 不用登录数据库
-- 1.导出整个数据库 ->命令行方式 
-- mysqldump -uroot -p ljy >C:\Users\lijia\Desktop\database\ljy.sql
-- 导出命令   用户名  数据库名  导出路径以及导出后的文件名

-- 2.导出数据库中的某张表 -> 命令行方式
-- mysqldump -uroot -p ljy t_user >C:\Users\lijia\Desktop\database\ljy_t_user.sql
-- 导出命令   用户名   数据库 表名  导出路径以及导出后的文件名

-- mysql的数据导入   需要登录数据库
-- 1.导入数据库 -->命令行方式
-- 	(1)新建一个与要导入的数据库名相同的数据库
--      (2)切换到该数据库下
--      (3)source C:\Users\lijia\Desktop\database\ljy.sql

-- 1.导入数据表 -->命令行方式
-- 	(1)新建一个与要导入的数据库名相同的数据库或者确保该数据库已经存在(其实不存在也能导入成功)
--      (2)切换到该数据库下	
--      (3)source C:\Users\lijia\Desktop\database\ljy_t_user.sql

-- 用数据库可视化工具备份与灰度(需要登录数据)


-- -----------------------------------------------------------------------------------------------------------------
-- mysql权限管理的简单操作

--创建用户
CREATE USER 'hadoop'@'192.168.93.111' IDENTIFIED BY 'hadoop';

--查询用户
SELECT USER ,HOST,PASSWORD FROM mysql.user;

--为hadoop用户新增其他地址的访问权限
UPDATE mysql.user SET HOST='192.168.93.111' WHERE USER='hadoop';
INSERT INTO mysql.user(HOST,USER,PASSWORD) VALUES('::1','hadoop',PASSWORD('hadoop'));
INSERT INTO mysql.user(HOST,USER,PASSWORD) VALUES('localhost','hadoop',PASSWORD('hadoop'));
--刷新权限设置
FLUSH PRIVILEGES;

--删除用户名或者密码是''的用户
DELETE FROM mysql.user WHERE USER='' OR PASSWORD='';

DELETE FROM mysql.user WHERE USER='hadoop' AND HOST='::1';

--给hadoop添加访问sqoop数据库的权限
GRANT ALL PRIVILEGES ON sqoop.* TO 'hadoop'@'%';
FLUSH PRIVILEGES;

--撤销hadoo访问数据库的权限
REVOKE ALL PRIVILEGES ON sqoop.* FROM 'hadoop'@'%';
FLUSH PRIVILEGES;

--给hadoop用户增加查询权限
GRANT SELECT ON sqoop.employee TO 'hadoop'@'%';
FLUSH PRIVILEGES;

--查询当前用户的权限
SHOW GRANTS;

--查询hadoop用户的权限
SHOW GRANTS FOR hadoop@'%';
--给用户增加删除权限
GRANT DELETE ON sqoop.employee TO 'hadoop'@'%';
FLUSH PRIVILEGES;

--删除用户
DELETE FROM mysql.user WHERE USER='hadoop';
FLUSH PRIVILEGES;


