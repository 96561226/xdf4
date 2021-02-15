package com.aaa.service.Emp;

import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.Roles;
import com.aaa.pojo.Transaction;
import com.aaa.searchpojo.SearchEmp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "XDF4-API-DAO",contextId = "empId")
public interface EmpService {
    //添加员工
    @PostMapping("/emps/addEmp")
    int insert(Emp emp);
    @GetMapping("/emps/selectByNoPwd")
    public Emp selectByNoPwd(@RequestBody Emp emp) ;

    @GetMapping("/emps/selectRolesByNo")
    public Roles selectRolesByNo(@RequestParam("empNo") String empNo) ;

    @GetMapping("/emps/selectResourcesByNo")
    public List<Transaction> selectResourcesByNo(@RequestParam("empNo") String empNo) ;

    @GetMapping("/emps/selectByNo")
    public Emp selectByNo(@RequestParam("empNo") String empNo) ;

    @GetMapping("/emps/selall")
    public List<Emp> selectAll();

    //条件查询员工
    @RequestMapping("/emps/selectSeaEmp")
    List<EmpVo> selectSeaEmp(@RequestBody SearchEmp emp);

    //修改员工
    @PostMapping("/emps/updEmp")
    int updEmp(@RequestBody Emp emp);

}
