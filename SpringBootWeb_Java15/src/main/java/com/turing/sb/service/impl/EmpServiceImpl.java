package com.turing.sb.service.impl;

import com.turing.sb.entity.Emp;
import com.turing.sb.mapper.EmpMapper;
import com.turing.sb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;
    @Override
    public List<Emp> findAll() {
        return empMapper.selectByExample(null);
    }

    @Override
    public Emp fidById(Integer empno) {
        return empMapper.selectByPrimaryKey(empno);
    }

    @Override
    public void insert(Emp emp) {
        empMapper.insert(emp);
    }

    @Override
    public void update(Emp emp) {
        empMapper.updateByPrimaryKeySelective(emp);
    }

    @Override
    public void delete(Integer empno) {
        empMapper.deleteByPrimaryKey(empno);
    }
}
