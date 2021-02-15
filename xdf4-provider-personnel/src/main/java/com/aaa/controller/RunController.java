package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personnelRun")
public class RunController {

    @RequestMapping("/recruitIndex")
    public String toRecruitIndex(){
        return "/Recruit/recruit_index";
    }
    @RequestMapping("/entryIndex")
    public String toEntryIndex(){
        return "/entry/entry_index";
    }
    @RequestMapping("/dimissionIndex")
    public String toDimissionIndex(){
        return "/dimission/dimission_index";
    }
    @RequestMapping("/transferIndex")
    public String toTransferIndex(){
        return "/transfer/transfer_index";
    }
}
