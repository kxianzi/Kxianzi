package com.turing.mybatis.mapper;
/**
 * Studentӳ��ӿ�
 * @author fred
 *
 */

import com.turing.mybatis.entity.Student;

public interface StudentMapper {

	/**
	 * ����id����ѧ��
	 * @param id
	 * @return Student
	 */
	Student getStuById(int id);
}
