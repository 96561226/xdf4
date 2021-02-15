package com.aaa.demo.service;

import com.aaa.demo.mapper.ApproverMapper;
import com.aaa.demo.mapper.PactMapper;
import com.aaa.demo.service.income.IncomeService;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.*;
import com.aaa.pojo.finance.TbIncome;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PactServiceImpl implements PactService {
    @Autowired
    PactMapper pactMapper;
    @Autowired
    ApproverMapper approverMapper;
    @Autowired
    IncomeService incomeService;
    @Override
    public int insert(TbPact tbPact) {
        int i = pactMapper.insert(tbPact);
        return i;
    }

    @Override
    public ReturnObj selectAll(SearchPact searchPact) {
        int currentPage = searchPact.getPage() == null ? 1:searchPact.getPage();
        int pageSize = searchPact.getLimit() == null ? 3:searchPact.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<TbPactVo> bs =pactMapper.selectAll(searchPact);
        PageInfo<TbPactVo> pageinfo = new PageInfo<TbPactVo>(bs);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<TbPactVo> list = pageinfo.getList();
        return new ReturnObj(0,"",total,list);
    }


    @Override
    public int update(Integer p_id) {
        TbPact byID = findByID(p_id);
        if(byID.getState()==5){
            return pactMapper.update(p_id);
        }else{
            return 0;
        }
    }

    @Override
    public TbPact findByID(Integer p_id) {
        return pactMapper.findByID(p_id);
    }



    @Override
    public List<TbPactState> selState() {
        return pactMapper.selState();
    }

    @Override
    public String selNo() {
        return pactMapper.selNo();
    }

    @Override
    public Integer selectEntryNo(String p_no) {
        SearchPact searchPact = new SearchPact();
        searchPact.setP_no(p_no);
        List<TbPactVo> tbPactVos = pactMapper.selectAll(searchPact);
        return tbPactVos.get(0).getP_id();
    }

    @Override
    public int insertPactApprover(TbPactApprover tbPactApprover) {
        return pactMapper.insertPactApprover(tbPactApprover);
    }

    @Override
    public int insertAfter(TbafterSale tbafterSale) {
        int i = pactMapper.insertAfter(tbafterSale);
        i = pactMapper.addAfterCount(tbafterSale);
        return i;
    }

    @Override
    public int updatePactState(TbPactVo pact,String cname) {
        int i = pactMapper.updatePactState(new TbPact(pact));
        if (pact.getState() == 1) {
            i = pactMapper.addPactCount(new TbPact(pact));
            TbIncome income = new TbIncome();
            income.setInvolveType(Long.valueOf(1));
            income.setMoney(pact.getPactmoney());
            income.setGathering(Long.valueOf(3));
            income.setRegister(Long.valueOf(pact.getEmp_id()));
            income.setEmpId(Long.valueOf(pact.getEmp_id()));
            income.setDeptId(Long.valueOf(pact.getDept_id()));
            income.setUnits(cname);
            income.setContract(Long.valueOf(pact.getP_id()));
            income.setIncomeDeclare(pact.getDetails());
            income.setState(Long.valueOf(1));
            incomeService.addIncome(income);
        }
        TbPactApprover approver = new TbPactApprover(null,pact.getP_id(),pact.getEmp_id(),null);
        i = approverMapper.updateApprover(approver);
        return i;
    }
}
