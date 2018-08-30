package net.syntrust.controller;

import net.syntrust.entity.ProjectInfo;
import net.syntrust.entity.Return;
import net.syntrust.service.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/projectInfo")
public class ProjectInfoController {
    @Autowired
    public ProjectInfoService projectInfoService;
    @RequestMapping("/insert")
    @ResponseBody
    public Return insertProject(){
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setAccessAddress("2222");
        projectInfo.setAcceptanceTime(new Date(System.currentTimeMillis()));
        projectInfo.setProjectCode("9953552122");
        int data =projectInfoService.insertProject(projectInfo);
        return new Return("0000",data);
    }
}
