package com.aaa.service.transfer;

import com.aaa.mapper.transfer.TransferApproverMapper;
import com.aaa.mapper.transfer.TransferMapper;
import com.aaa.mapper.transfer.TransferNotifyMapper;
import com.aaa.pojo.*;
import com.aaa.pojo.personnel.*;
import com.aaa.service.Emp.EmpService;
import com.aaa.service.Emp.FormService;
import com.aaa.service.Emp.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    TransferMapper transferMapper;
    @Autowired
    TransferApproverMapper approverMapper;
    @Autowired
    TransferNotifyMapper notifyMapper;
    @Autowired
    FormService formService;
    @Autowired
    EmpService empService;
    @Autowired
    RoleService roleService;
    @Override
    public int addTransfer(TbTransfer transfer) {
        int i = transferMapper.addTransfer(transfer);
        Long transferId = selectTransferNo(transfer);
        List<Long> longs = formService.selApprover(transfer.getDeptId());
        for (int j = 0; j < longs.size(); j++) {
            if (longs.get(j) != transfer.getEmpId()){
                i = notifyMapper.insertTransferNotify(new TbTransferNotify(null,transferId,longs.get(j),null));
            }
        }
        return i;
    }

    @Override
    public int updateTransfer(TbTransfer tbTransfer) {
        SearchTransfer transfer = new SearchTransfer();
        transfer.setTransferId(Long.valueOf(tbTransfer.getTransferId()));
        List<TbTransferVo> tbTransferVos = transferMapper.selectTransfer(transfer);
        if (tbTransferVos.get(0).getState() == 1){
            return transferMapper.updateTransfer(tbTransfer);
        }else {
            return 0;
        }
    }

    @Override
    public int cancellationTransfers(int[] ids) {
        int result = 0;
        for (int i = 0; i < ids.length; i++) {
            TbTransfer transfer = new TbTransfer();
            transfer.setTransferId(Long.valueOf(ids[i]));
            transfer.setState(Long.valueOf(4));
            result = updateTransfer(transfer);
        }
        return result;
    }

    @Override
    public Long selectTransferNo(TbTransfer transfer) {
        SearchTransfer searchTransfer = new SearchTransfer();
        searchTransfer.setTransferNo(transfer.getTransferNo());
        List<TbTransferVo> tbTransferVos = transferMapper.selectTransfer(searchTransfer);
        return tbTransferVos.get(0).getTransferId();
    }

    @Override
    public int insertTransferApprover(TbTransferApprover approver) {
        return approverMapper.insertTransferApprover(approver);
    }

    @Override
    public String selNo(String noName) {
        return transferMapper.selNo(noName);
    }

    @Override
    public ReturnObj selectTransfer(SearchTransfer transfer) {
        int currentPage = transfer.getPage() == null ? 1:transfer.getPage();
        int pageSize = transfer.getLimit() == null ? 3:transfer.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<TbTransferVo> tbTransferVos = transferMapper.selectTransfer(transfer);
        PageInfo<TbTransferVo> pageinfo = new PageInfo<TbTransferVo>(tbTransferVos);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<TbTransferVo> list = pageinfo.getList();
        return new ReturnObj(0,"success",total,list);
    }

    @Override
    public List<TbTransferType> selectTypeAll() {
        return transferMapper.selectTypeAll();
    }

    @Override
    public EmpVo selectEmpById(int id) {
        return transferMapper.selectEmpById(id);
    }


    @Override
    public ReturnObj approveTransfer(TbTransfer transfer,Long emp_id) {
        //修改岗位调动表状态
        int i = transferMapper.updateTransfer(transfer);
        if (i==0){
            return new ReturnObj(400,"审批失败",i,null);
        }
        Emp emp = new Emp();
        emp.setEmp_id(transfer.getEmpId());
        emp.setDept_id(transfer.getNewDeptId());
        emp.setRole_id(transfer.getNewRoleId());
        int e = empService.updEmp(emp);
        if (e==0){
            return new ReturnObj(400,"岗位调动失败",e,null);
        }

        //修改审批人状态
        TbTransferApprover approver = new TbTransferApprover();
        approver.setEmpId(emp_id);
        approver.setTransferId(transfer.getTransferId());
        int j = approverMapper.updateState(approver);
        if (j==0){
            return new ReturnObj(400,"审批人状态异常",i,null);
        }
        return new ReturnObj(200,"审批完成",i,i);
    }

}
