package net.syntrust.controller;

import net.syntrust.entity.PageInfo;
import net.syntrust.entity.Return;
import net.syntrust.entity.ServerInfo;
import net.syntrust.service.ServerInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/serverInfo")
public class ServerInfoController {

    @Autowired
    public ServerInfoService serverInfoService;

    @RequestMapping("/insert")
    @ResponseBody
    public String insertServer(HttpServletRequest req, HttpServletResponse res){
        ServerInfo serverInfo = new ServerInfo();
        serverInfo.setAccessRestriction(req.getParameter("accessRestriction"));
        serverInfo.setIpAddress("777");
        serverInfo.setIsDel(0);
        serverInfo.setUserName("666");
        serverInfo.setPassWord("555");
        serverInfoService.insertServer(serverInfo);
        return "InsertSuccess";
    }

    @RequestMapping("/list")
    public Return showDataSource(HttpServletRequest req, HttpServletResponse res){
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageIndex(pageIndex);
        pageInfo.setPageSize(pageSize);
        pageInfo.setCount(serverInfoService.selectServerCount());
        List<ServerInfo> serverInfoList = serverInfoService.queryServerByLimit(pageInfo);
        return new Return("0000", serverInfoList, pageInfo.getCount());
    }

    @RequestMapping("/serverDetail")
    public Return showDataSourceDetailBy(HttpServletRequest req, HttpServletResponse res){
        String serverCode = req.getParameter("serverCode");
        if (StringUtils.isBlank(serverCode)){
            return new Return("9999","接口编码不能为空");
        }
        ServerInfo serverInfo = serverInfoService.queryByServerCode(serverCode);
        return new Return("0000",serverInfo,null);
    }

    @RequestMapping("/updateServer")
    public Return updateByDatabaseCode(HttpServletRequest req, HttpServletResponse res){
        String serverCode = req.getParameter("databaseCode");
        ServerInfo d = serverInfoService.queryByServerCode(serverCode);
        int i = serverInfoService.updateServerInfoByCode(d);
        return new Return("0000",i);
    }

    /**
     * 软删除接口
     * @param req
     * @param res
     * @return
     */
    @RequestMapping("deleteServer")
    public Return deleteDataSourceByCode(HttpServletRequest req, HttpServletResponse res){
        String serverCode = req.getParameter("serverCode");
        int i = serverInfoService.deleteServerInfoByCode(serverCode);
        return new Return("0000",i);
    }
}
