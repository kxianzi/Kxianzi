package com.turing.sb.service.impl;

import com.turing.sb.entity.Dept;
import com.turing.sb.mapper.DeptMapper;
import com.turing.sb.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.selectByExample(null);
    }
}
