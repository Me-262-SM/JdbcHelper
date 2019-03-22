package com.edu.sicnu.cs.zzy;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcHelper jdbcHelper = new JdbcHelper();
		String sql = "select *from students";
		jdbcHelper.Query(sql);
	}

}
