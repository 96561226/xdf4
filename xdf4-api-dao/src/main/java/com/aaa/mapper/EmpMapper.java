package com.aaa.mapper;
import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.Roles;
import com.aaa.searchpojo.SearchEmp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EmpMapper {

    //添加员工
    int insert(Emp emp);
    //查询所有的员工
    List<Emp> selectAll();

    //根据工号 密码查询账号
    Emp selectByNoPwd(Emp emp);

    //根据工号找到用户
    Emp selectByNo(String empNo);

    //根据部门查询员工
    List<Emp> selectEmpByDept(Long dept_id);


    //根据工号修改密码
    int updatePwd(@Param("empNo") String empNo, @Param("pwd") String pwd);

    //条件查询员工详细信息
    List<EmpVo> selectSeaEmp(SearchEmp emp);

    //修改员工
    int updEmp(Emp emp);

    //删除员工
    int delEmp(Long emp_id);

}
