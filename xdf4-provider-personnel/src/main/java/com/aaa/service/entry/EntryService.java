package com.aaa.service.entry;

import com.aaa.pojo.*;
import com.aaa.pojo.personnel.SearchEntry;
import com.aaa.pojo.personnel.TbEntry;
import com.aaa.pojo.personnel.TbEntryApprover;
import com.aaa.pojo.personnel.TbTransfer;
import org.apache.ibatis.annotations.Param;

public interface EntryService {
    //入职  方法
    //新增入职申请表
    int addEntry(TbEntry entry);
    //作废入职申请表
    int updateEntry(TbEntry tbEntry);
    //批量删除
    int cancellationEntrys(int[] ids);
    //查询入职表表id
    Long selectEntryNo(TbEntry entry);
    //添加审批人
    int insertEntryApprover(TbEntryApprover approver);
    //    生成编号
    String selNo(@Param("noName") String noName);
    //条件查询入职表
    ReturnObj selectEntry(SearchEntry entry);
    //审批入职表
    ReturnObj approveEntry(TbEntry entry, Long emp_id);
}
