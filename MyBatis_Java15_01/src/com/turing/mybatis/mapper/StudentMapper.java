package com.turing.mybatis.mapper;
/**
 * Student映射接口
 * @author fred
 *
 */

import com.turing.mybatis.entity.Student;

public interface StudentMapper {

	/**
	 * 根据id查找学生
	 * @param id
	 * @return Student
	 */
	Student getStuById(int id);
}
