package com.aaa.springcloud.controller.informaction;

import com.aaa.springcloud.util.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InformactionNavController extends BaseController {

    @RequestMapping("/informaction/inlinkmanIndex")
    public String toInlinkIndex(){
        return "informaction/Inlinkman/index";
    }

    @RequestMapping("/informaction/outlinkmanIndex")
    public String toOutlinkIndex(){
        return "informaction/Outlinkman/index";
    }

    @RequestMapping("/informaction/documentIndex")
    public String toDocumentIndex(){
        return "informaction/Document/index";
    }
    @RequestMapping("/informaction/documentBinIndex")
    public String toDocumentBinIndex(){
        return "informaction/Document/docdustbin";
    }
}
