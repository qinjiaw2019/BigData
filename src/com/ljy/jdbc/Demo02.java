package com.ljy.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Demo02 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stat = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConnection();
			stat = connection.createStatement();
			String sql = "select * from emp";
			resultSet = stat.executeQuery(sql);
			List<Emp>list = new ArrayList<>();
			while(resultSet.next()){
				Emp emp = new Emp();
				emp.setComm(resultSet.getDouble("comm"));
				emp.setDeptno(resultSet.getInt("deptno"));
				emp.setEmpno(resultSet.getInt("empno"));
				emp.setEname(resultSet.getString("ename"));
				emp.setHiredate(resultSet.getDate("hiredate"));
				emp.setJob(resultSet.getString("job"));
				emp.setMgr(resultSet.getInt("mgr"));
				emp.setSal(resultSet.getDouble("sal"));
				list.add(emp);
			}
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, stat, connection);
		}
	}
}
