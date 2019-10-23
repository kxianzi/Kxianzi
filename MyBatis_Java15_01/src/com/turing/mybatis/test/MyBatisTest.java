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
		//����mybatis�������ļ�·��
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
//		//��һ�ַ�ʽ��
//		try {
//			//�Ự������ʵ������ǰ��Connection����
//			//�򿪻Ự
//			SqlSession session = getSqlSessionFactory().openSession();
//			try {
//			 Student stu = session.selectOne("com.turing.haha.selectStu", 1);
//			 //��ӡ����
//			 System.out.println(stu);
//			} finally {
//			 //�رջỰ
//			 session.close();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//�ڶ��ַ�ʽ���ӿڷ�ʽ���Ƽ���
		try {
			//�ȴ򿪻Ự
			SqlSession session = getSqlSessionFactory().openSession();
			//����StudentMapper����
			//����ط��õ��˴���ģʽ
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			//���ýӿڵķ���
			Student stu = mapper.getStuById(2);
			//���Դ�ӡ
			System.out.println(stu);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	

}
