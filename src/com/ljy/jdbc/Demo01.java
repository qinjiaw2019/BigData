package com.ljy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
	public static void main(String[] args) {
		try {
			// 1.注册驱动
			DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());//可以采用反射
//			2.获取与数据库的连接
			String url = "jdbc:mysql://localhost:3306/ljy";
			Connection conn = DriverManager.getConnection(url, "root","root");
			//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ljy?user=root&password=root");
			//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ljy",new Properties());
//			3.创建代表sql语句的对象
			Statement stat = conn.createStatement();
//			4.执行sql语句
			String sql="select empno,ename,sal from emp;";
			ResultSet resultSet = stat.executeQuery(sql);
//			5.如果是查询语句,返回结果集
			System.out.println("empno\tename\tsal");
			while(resultSet.next()){
				int empno = resultSet.getInt("empno");
				String ename = resultSet.getString("ename");
				double sal = resultSet.getDouble("sal");
				System.out.println(empno+"\t"+ename+"\t"+sal);
			}
//			6.释放资源
			resultSet.close();
			stat.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
