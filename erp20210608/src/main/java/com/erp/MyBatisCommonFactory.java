package com.erp;

import java.io.FileNotFoundException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MyBatisCommonFactory {
	static Logger logger = Logger.getLogger(MyBatisCommonFactory.class);
	public static SqlSessionFactory sqlSessionFactory = null;
	public static void init() {
		logger.info("init 호출 성공");
		try {
			String resource = "com/mybatis/MapperConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development");
			
		} catch (FileNotFoundException fe) {
			logger.info(fe.toString());
		}catch(Exception e) {
			logger.info(e.toString());
//			e.getMessage();
		}
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		init();
		return sqlSessionFactory;
	}
	
	public static void main(String[] args) {
		SqlSessionFactory sqlMapper = null;
		sqlMapper= MyBatisCommonFactory.getSqlSessionFactory();
		System.out.println(sqlMapper);
	}
}
