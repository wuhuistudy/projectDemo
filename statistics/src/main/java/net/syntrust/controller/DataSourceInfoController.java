package net.syntrust.controller;

import net.syntrust.entity.DataSourceInfo;
import net.syntrust.entity.PageInfo;
import net.syntrust.entity.Return;
import net.syntrust.service.DataSourceInfoService;
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
@RequestMapping(value = "/dataSource")
public class DataSourceInfoController {

    @Autowired
    public DataSourceInfoService dataSourceInfoService;

    /**
     * 新增数据库信息
     * @return
     */
    @RequestMapping(value = "/insert",method = {RequestMethod.POST,RequestMethod.GET})
    public Return insertDataSource(HttpServletRequest req, HttpServletResponse res){
        //测试代码修改提交
        System.out.println("test code update");
        DataSourceInfo data = new DataSourceInfo();
        String databaseCode = req.getParameter("databaseCode");
        String databaseDescription = req.getParameter("databaseDescription");
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String dataQuantity = req.getParameter("dataQuantity");
        String tableDtructureDescription = req.getParameter("tableDtructureDescription");
        String remarks = req.getParameter("remarks");
        data.setAccount(account);
        data.setPassword(password);
        data.setDatabaseCode(databaseCode);
        data.setDatabaseDescription(databaseDescription);
        data.setDataQuantity(Integer.valueOf(dataQuantity));
        data.setPassword(password);
        data.setRemarks(remarks);
        data.setTableDtructureDescription(tableDtructureDescription);
        data.setGmtCreate(new Date(System.currentTimeMillis()));
        data.setGmtModified(new Date(System.currentTimeMillis()));
        data.setIsDel(0);
        dataSourceInfoService.insertDataSource(data);
        return new Return("0000",data);
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
        pageInfo.setCount(dataSourceInfoService.selectCount());
        List<DataSourceInfo> dataSourceInfoList = dataSourceInfoService.queryByLimit(pageInfo);
        return new Return("0000", dataSourceInfoList, pageInfo.getCount());
    }

    /**
     * 根据具体的账户和数据库编号，放回数据库信息
     * @param req
     * @param res
     * @return
     */
    @RequestMapping("/dataSourceDetail")
    public Return showDataSourceDetailBy(HttpServletRequest req, HttpServletResponse res){
        String databaseCode = req.getParameter("databaseCode");
        if (StringUtils.isBlank(databaseCode)){
            return new Return("9999","数据库编号不能为空");
        }
        DataSourceInfo dataSourceInfo = dataSourceInfoService.queryByCode(databaseCode);
        return new Return("0000",dataSourceInfo,null);
    }


    /**
     * 根据数据库编号更新
     * @param req
     * @param res
     * @return
     */
    @RequestMapping("/updateDataSource")
    public Return updateByDatabaseCode(HttpServletRequest req, HttpServletResponse res){
        String databaseCode = req.getParameter("databaseCode");
        databaseCode = "777";
        DataSourceInfo d = dataSourceInfoService.queryByDatabaseCode(databaseCode);
        d.setPassword("1111");
        d.setAccount("3333");
        int i = dataSourceInfoService.updateDataSourceInfoByCode(d);
        return new Return("0000",i);
    }

    @RequestMapping("deleteDataSource")
    public Return deleteDataSourceByCode(HttpServletRequest req, HttpServletResponse res){
        String databaseCode = req.getParameter("databaseCode");
        int i = dataSourceInfoService.deleteDataSourceInfoByCode(databaseCode);
        return new Return("0000",i);
    }

}
