package com.cn.zyrs.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.apache.log4j.Logger;

public class OrderCodeFactory {
	private static Logger log = Logger.getLogger(OrderCodeFactory.class);
	
	final static Properties properties = PCUtils.getProperties("system-config.properties");
			
	final static String DRIVER_CLASS =properties.getProperty("db.driverClassName");// "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	final static String DATABASE_URL = properties.getProperty("db.url");//"jdbc:sqlserver://127.0.0.1:1433;databaseName=ZYRS_ManageSystem_DataBase_backUp";
	final static String DATABASE_USRE = properties.getProperty("db.username");//"sa";
	final static String DATABASE_PASSWORD = properties.getProperty("db.password");//"ZYRScrljsyc060822";
	
	public static String makeOrderCode(String deptid) {
		String demo = "";
		Connection connection=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 connection = DriverManager.getConnection(DATABASE_URL,
					DATABASE_USRE, DATABASE_PASSWORD);
			CallableStatement callableStatement = connection
					.prepareCall("{call GETNEWSERIAL(?,?)}");
//			String sql = "select * from students";
			// 返回值
			callableStatement.setString(1,deptid);
			//入参
			callableStatement.registerOutParameter(2, Types.VARCHAR);
			callableStatement.execute();
			demo = callableStatement.getString(2);
		} catch (Exception ex) {
			log.error("生成ordercode错误！", ex);
		}finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					log.error("连接数据库生成ordercode错误！", e);
				}
			}
		}

		return demo;
	}

}
