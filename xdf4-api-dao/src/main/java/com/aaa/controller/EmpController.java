package com.aaa.controller;

import com.aaa.pojo.*;
import com.aaa.searchpojo.SearchEmp;
import com.aaa.service.DeptService;
import com.aaa.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    EmpService empService;

    @RequestMapping("/selectByNoPwd")
    public Emp selectByNoPwd(@RequestBody Emp emp) {
        System.out.println("selectByNoPwd"+emp);
        return empService.selectByNoPwd(emp);
    }

    @GetMapping("/selectRolesByNo")
    public Roles selectRolesByNo(@RequestParam("empNo") String empNo) {
        return empService.selectRolesByNo(empNo);
    }

    @GetMapping("/selectResourcesByNo")
    public List<Transaction> selectResourcesByNo(@RequestParam("empNo") String empNo) {
        return empService.selectResourcesByNo(empNo);
    }

    @GetMapping("/selectByNo")
    public Emp selectByNo(@RequestParam("empNo") String empNo) {
        return empService.selectByNo(empNo);
    }

    @PostMapping("/changePassword")
    public int changePassword(@RequestParam("empNo") String empNo,@RequestParam("pwd") String pwd) {
        return empService.changePassword(empNo,pwd);
    }

    @GetMapping("/selall")
    public List<Emp> selectAll() {
        return empService.selectAll();
    }

    //条件查询员工
    @RequestMapping("/selectSeaEmp")
    public List<EmpVo> selectSeaEmp(@RequestBody SearchEmp emp){
        return empService.selectSeaEmp(emp);
    };

    //添加员工
    @PostMapping("/addEmp")
    public int addEmp(@RequestBody Emp emp){
        return empService.addEmp(emp);
    };

    //修改员工
    @PostMapping("/updEmp")
    public int updEmp(@RequestBody Emp emp){
        return empService.updEmp(emp);
    };

    //删除员工
    @DeleteMapping("/delEmp")
    public int delEmp(@RequestParam("emp_id") Long emp_id){
        return empService.delEmp(emp_id);
    };
}
