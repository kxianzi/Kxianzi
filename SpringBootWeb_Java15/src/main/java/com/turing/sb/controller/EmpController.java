package com.turing.sb.controller;

import com.turing.sb.entity.Dept;
import com.turing.sb.entity.Emp;
import com.turing.sb.service.DeptService;
import com.turing.sb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;

    //访问员工管理
//    @GetMapping("/emps")
//    public String emps(){
//        return "emps";
//    }

    //查询所有员工
    @GetMapping("/emps")
    public String emps(Model model){
        List<Emp> empList = empService.findAll();
        model.addAttribute("empList",empList);
        return "emps";
    }

    //根据id查询员工
    @GetMapping("/emps/{id}")

    //添加员工
    //@PostMapping("/emp")

    //修改员工
    //@PutMapping("/emp")

    //删除员工
    //@DeleteMapping("/emp/{id}")

    //添加员工
    @PostMapping("/emp")
    public String emp(Emp emp){
        empService.insert(emp);
        return "redirect:/emps";
    }

    //查询所有部门
    //异步请求
    @GetMapping("/depts")
    @ResponseBody
    public List<Dept> depts(){
        return deptService.findAll();
    }

    //删除员工
    @GetMapping("/emp/{empno}")
    public String emp(@PathVariable("empno") Integer empno){
        empService.delete(empno);
        return "redirect:/emps";
    }
}
