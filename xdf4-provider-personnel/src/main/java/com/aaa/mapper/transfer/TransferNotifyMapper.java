package com.aaa.mapper.transfer;

import com.aaa.pojo.personnel.TbTransferNotify;
import com.aaa.pojo.personnel.TbTransferNotifyVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TransferNotifyMapper {
    /*根据招聘id查询知会人*/
    List<TbTransferNotifyVo> selectTransferNotifys(Long id);
    int insertTransferNotify(TbTransferNotify notify);
}
