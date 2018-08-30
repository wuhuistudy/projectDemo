package net.syntrust.controller;

import net.syntrust.entity.DataSourceInfo;
import net.syntrust.entity.InterfaceInfo;
import net.syntrust.entity.PageInfo;
import net.syntrust.entity.Return;
import net.syntrust.service.InterfaceInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/interface")
public class InterfaceInfoController {

    @Autowired
    public InterfaceInfoService interfaceInfoService;

    /**
     * 新增接口信息
     * @return
     */
    @RequestMapping(value = "/insert",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Return insertInterface(){
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setEntryParameters("qweqw");
        interfaceInfo.setGmtCreate(new Date(System.currentTimeMillis()));
        interfaceInfo.setGmtModified(new Date(System.currentTimeMillis()));
        interfaceInfo.setInterfaceAddress("110..0111");
        interfaceInfo.setInterfaceDescription("ceshi");
        interfaceInfo.setProjectBelong("00000");
        interfaceInfo.setIsDel(0);
        int i = interfaceInfoService.insertInterface(interfaceInfo);
        return new Return("0000",i);
    }

    /**
     * 分页查询
     * @param req
     * @param res
     * @return
     */
    @RequestMapping("/list")
    public Return showDataSource(HttpServletRequest req, HttpServletResponse res){
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageIndex(pageIndex);
        pageInfo.setPageSize(pageSize);
        pageInfo.setCount(interfaceInfoService.selectInterfaceCount());
        List<InterfaceInfo> interfaceInfoList = interfaceInfoService.queryInterfaceByLimit(pageInfo);
        return new Return("0000", interfaceInfoList, pageInfo.getCount());
    }

    /**
     * 接口详情
     * @param req
     * @param res
     * @return
     */
    @RequestMapping("/interfaceDetail")
    public Return showDataSourceDetailBy(HttpServletRequest req, HttpServletResponse res){
        String databaseCode = req.getParameter("databaseCode");
        if (StringUtils.isBlank(databaseCode)){
            return new Return("9999","接口编码不能为空");
        }
        InterfaceInfo interfaceInfo = interfaceInfoService.queryByInterfaceCode(databaseCode);
        return new Return("0000",interfaceInfo,null);
    }

    /**
     * 根据接口编号更新对应的详情
     * @param req
     * @param res
     * @return
     */
    @RequestMapping("/updateInterface")
    public Return updateByDatabaseCode(HttpServletRequest req, HttpServletResponse res){
        String databaseCode = req.getParameter("databaseCode");
        InterfaceInfo d = interfaceInfoService.queryByInterfaceCode(databaseCode);
        int i = interfaceInfoService.updateInterfaceInfoByCode(d);
        return new Return("0000",i);
    }

    /**
     * 软删除接口
     * @param req
     * @param res
     * @return
     */
    @RequestMapping("deleteInterface")
    public Return deleteDataSourceByCode(HttpServletRequest req, HttpServletResponse res){
        String databaseCode = req.getParameter("databaseCode");
        int i = interfaceInfoService.deleteInterfaceInfoByCode(databaseCode);
        return new Return("0000",i);
    }
}
