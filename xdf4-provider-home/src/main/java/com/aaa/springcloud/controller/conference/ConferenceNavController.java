package com.aaa.springcloud.controller.conference;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConferenceNavController {

    @RequestMapping("/conference/cfRommList")
    public String toRoomList(){
        return "conference/room/cfRoomList";
    }
    @RequestMapping("/conference/cfApplyList")
    public String toApplyList(){
        return "conference/room/cfRoomApplyList";
    }

    @RequestMapping("/conference/propertyList")
    public String toPropertyList(){
        return "conference/proper/propertyList";
    }

    @RequestMapping("/conference/purchaseList")
    @PreAuthorize("hasAnyRole('ROLE_行政经理','ROLE_采购员','ROLE_master')")
    public String toPurchaseList(){
        return "conference/proper/purchaseList";
    }
    @RequestMapping("/conference/propertyApplyJY")
    public String topropertyApplyJY(){
        return "conference/proper/propertyApplyJY";
    }
    @RequestMapping("/conference/propertyApplyGH")
    public String topropertyApplyGH(){
        return "conference/proper/propertyApplyGH";
    }

    @RequestMapping("/conference/projectMyList")
    public String toprojectMyList(){
        return "conference/project/projectMyList";
    }
    @RequestMapping("/conference/projectList")
    public String toProjectList(){
        return "conference/project/projectList";
    }
}
