package com.turing.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.turing.mybatis.entity.Student;
import com.turing.mybatis.mapper.StudentMapper;

public class MyBatisTest {
	
	private static SqlSessionFactory getSqlSessionFactory() throws IOException {
		//设置mybatis主配置文件路径
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
//		//第一种方式：
//		try {
//			//会话对象（其实就是以前的Connection对象）
//			//打开会话
//			SqlSession session = getSqlSessionFactory().openSession();
//			try {
//			 Student stu = session.selectOne("com.turing.haha.selectStu", 1);
//			 //打印测试
//			 System.out.println(stu);
//			} finally {
//			 //关闭会话
//			 session.close();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//第二种方式：接口方式（推荐）
		try {
			//先打开会话
			SqlSession session = getSqlSessionFactory().openSession();
			//创建StudentMapper对象
			//这个地方用到了代理模式
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			//调用接口的方法
			Student stu = mapper.getStuById(2);
			//测试打印
			System.out.println(stu);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	

}
