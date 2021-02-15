package com.aaa.springcloud.service;

import com.aaa.pojo.CommonResult;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.conference.*;
import com.aaa.springcloud.mapper.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Transactional
@Service
public class ConferenceroomServiceImpl implements ConferenceroomService{
    //外置接口调用
    @Resource
    WZService wzService;
    //本包调用
    @Autowired
    ConferenceroomMapper conferenceroomMapper;
    @Autowired
    ConferenceroomApplyMapper conferenceroomApplyMapper;
    @Autowired
    ConferenceroomPropertyMapper conferenceroomPropertyMapper;
    @Autowired
    ConferenceroomApproverMapper conferenceroomApproverMapper;
    @Autowired
    PropertyMapper propertyMapper;

    @Override//点击会议室列表时查询出全部的基本信息
    public List<ConferenceroomVo> selConferenceroomList() {
        TbConferenceroom tbConferenceroom=new TbConferenceroom();
        return conferenceroomMapper.selConferenceRoomsByDT(tbConferenceroom);
    }

    @Override //点击详情时需要查询该会议室的使用情况 通过id查询 查询
    public List<ConferenceroomApplyVo> selConferenceroomApplyById(Long id) {
        SearchApply say= new SearchApply();
        say.setConferenceRoomId(id);
        return conferenceroomApplyMapper.selApplyByDT(say);
    }

    @Override//点击查看设备详情
    public List<ConferenceroomPropertyVo> selRoomProperById(Long conferenceRoomId) {
        return conferenceroomPropertyMapper.selRoomProperById(conferenceRoomId);
    }

    @Override//添加一个资产和会议室的关系 并修改资产状态
    public int addRPUpdP(TbConferenceroomProperty tcp) {
        //添加一个资产和会议室的关系
        int res1=conferenceroomPropertyMapper.addConferenceroomProperty(tcp);
        //通过会议室id查询会议室名称
        TbConferenceroom tcf=new TbConferenceroom();
        tcf.setConferenceRoomId(tcp.getConferenceRoomId());
        List<ConferenceroomVo> conferenceroomVos = conferenceroomMapper.selConferenceRoomsByDT(tcf);

        TbProperty tbProperty=new TbProperty();
        tbProperty.setPropertyId(tcp.getPropertyId());
        tbProperty.setPropertyPlace( conferenceroomVos.get(0).getConferenceRoomName());
        tbProperty.setStateId((long)1);
        //修改资产的使用情况 存放位置
        int res2=propertyMapper.updPropertyToMH(tbProperty);
        if (res1!=0&&res2!=0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override//删除一个资产和会议室的关系 并修改资产状态
    public int delRPUpdP(Long PropertyId) {
        TbProperty tp=new TbProperty();
        tp.setPropertyId(PropertyId);
        tp.setStateId((long)2);
        tp.setPropertyPlace("");
        //删除一个资产和会议室的关系
        int res1 = conferenceroomPropertyMapper.delConferenceroomProperty(tp.getPropertyId());
        //修改资产的使用情况 存放位置
        int res2=propertyMapper.updPropertyToMH(tp);
        if (res1!=0&&res2!=0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override//在添加申请时 给予下拉 房间查询 单表查询 和添加序列
    public CommonResult selRoomAndApplyAndCount() {
        //查询全部房间
        List<TbConferenceroom> tbConferencerooms = conferenceroomMapper.selTbConferenceroom();
        //查询员工
        List<Emp> emps = wzService.selectAll();
        //自动
        ReturnObj selno = wzService.selno("HYSQ-", "tb_conferenceRoom_apply", "apply_id");

        List list=new ArrayList();
        list.add(tbConferencerooms);
        list.add(emps);
        list.add(selno.getData());
        return new CommonResult(0,"查询成功",list);
    }

    @Override//点击添加申请 添加申请 查询申请查出id 添加 审批人
    public int addApplyAndApprover(TbConferenceroomApply tca,Long[] empids) {
        tca.setState(1);
        //判断时间是否重复 如果没数据就代表该时间可申请
        List<TbConferenceroomApply> tbTime1 = conferenceroomApplyMapper.selConferenceroomApplyByTime(tca);
        tca.setState(3);
        List<TbConferenceroomApply> tbTime2 = conferenceroomApplyMapper.selConferenceroomApplyByTime(tca);
        if (tbTime1.size()==0&&tbTime2.size()==0){
            //添加申请
            tca.setState(1);
            int res1 = conferenceroomApplyMapper.addConferenceroomApp(tca);
            if (res1!=0){
                //查询刚添加的会议室申请的id
                SearchApply say= new SearchApply();
                say.setApplyNo(tca.getApplyNo());
                List<ConferenceroomApplyVo> cfavs = conferenceroomApplyMapper.selApplyByDT(say);
                //添加审批人
                int res2=0;
                TbConferenceroomApprover cas=new TbConferenceroomApprover();
                for (Long i: empids) {
                    cas.setEmpId(i);
                    cas.setApplyId(cfavs.get(0).getApplyId());
                    cas.setState(1);
                    res2=conferenceroomApproverMapper.addConferenceroomApprover(cas);
                }
                if (res2!=0){
                    return 1;
                }
            }
            return 0;
        }
        return 2;
    }

    @Override//判断所有日期是否过期 如果过期 改状态  前判断结束日期是否已过去
    public int updStateByDate() {
        //设置查询条件  结束时间大于当前时间的申请
        SearchApply say= new SearchApply();
        say.setApplyEndTime(new Date());
        //查询
        List<ConferenceroomApplyVo> cfavs = conferenceroomApplyMapper.selApplyByDT(say);
        if (cfavs.size()!=0){
            for (ConferenceroomApplyVo i: cfavs) {
               if (i.getState()==1){
                   conferenceroomApplyMapper.updTbConferenceroomApp(4,i.getApplyId());
               }else if (i.getState()==3){
                   conferenceroomApplyMapper.updTbConferenceroomApp(5,i.getApplyId());
               }
            }
        }
        return 0;
    }

    @Override//动态查询全部的使用情况
    public ReturnObj selAllConRoomApply(SearchApply say) {
        int currentPage = say.getPage() == null ? 1:say.getPage();
        int pageSize = say.getLimit() == null ? 3:say.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<ConferenceroomApplyVo> conferenceroomApplyVos = conferenceroomApplyMapper.selApplyByDT(say);
        PageInfo<ConferenceroomApplyVo> pageinfo = new PageInfo<ConferenceroomApplyVo>(conferenceroomApplyVos);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<ConferenceroomApplyVo> list = pageinfo.getList();
        return new ReturnObj(0,"",total,list);
    }

    @Override
    public List<ConferenceroomApplyVo> selApproverByDT(SearchApply searchApply) {
        return conferenceroomApplyMapper.selApplyByDT(searchApply);
    }

    @Override
    public int cfRoomApprover(Long empId, Integer state, Long apply_id) {
        TbConferenceroomApprover tcar=new TbConferenceroomApprover();
        tcar.setEmpId(empId);
        tcar.setApplyId(apply_id);
        tcar.setState(3);
        int res1=conferenceroomApplyMapper.updTbConferenceroomApp(state,apply_id);
        int res2=conferenceroomApproverMapper.updConferenceroomApprover(tcar);
        if (res1!=0&&res2!=0){
            return 1;
        }
        return 0;
    }

    @Override
    public int Approverch(Long apply_id) {
        return conferenceroomApplyMapper.updTbConferenceroomApp(6,apply_id);
    }

}
