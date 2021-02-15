package com.aaa.springcloud.controller.personnel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PerosonnelNavController {
    @RequestMapping("/personnelRun/recruitIndex")
    public String toRecruitIndex(){
        return "personnel/Recruit/recruit_index";
    }
    @RequestMapping("/personnelRun/entryIndex")
    public String toEntryIndex(){
        return "personnel/entry/entry_index";
    }
    @RequestMapping("/personnelRun/dimissionIndex")
    public String toDimissionIndex(){
        return "personnel/dimission/dimission_index";
    }
    @RequestMapping("/personnelRun/transferIndex")
    public String toTransferIndex(){
        return "personnel/transfer/transfer_index";
    }
}
