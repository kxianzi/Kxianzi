package com.turing.sb.service;

import com.turing.sb.entity.Emp;

import java.util.List;

public interface EmpService {

    public List<Emp> findAll();

    public Emp fidById(Integer empno);

    public void insert(Emp emp);

    public void update(Emp emp);

    public void delete(Integer empno);
}
