package net.syntrust.service.impl;

import net.syntrust.dao.DataSourceInfoDao;
import net.syntrust.entity.DataSourceInfo;
import net.syntrust.entity.PageInfo;
import net.syntrust.entity.Return;
import net.syntrust.service.DataSourceInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DataSourceInfoService")
public class DataSourceInfoServiceImpl implements DataSourceInfoService {
    @Autowired
    public DataSourceInfoDao dataSourceInfoDao;
    @Override
    public int insertDataSource(DataSourceInfo dataSourceInfo) {
        return dataSourceInfoDao.insertDataSource(dataSourceInfo);
    }

    @Override
    public DataSourceInfo queryByDatabaseCode(String databaseCode) {
        return dataSourceInfoDao.queryByDatabaseCode(databaseCode);
    }

    @Override
    public DataSourceInfo queryByAccountAndCode(String account,String databaseCode) {
        return dataSourceInfoDao.queryByAccountAndCode(account,databaseCode);
    }

    @Override
    public DataSourceInfo queryByCode(String databaseCode) {
        return dataSourceInfoDao.queryByCode(databaseCode);
    }

    @Override
    public int selectCount() {
        return dataSourceInfoDao.selectCount();
    }

    @Override
    public List<DataSourceInfo> queryByLimit(PageInfo pageInfo) {
        int pageIndex = 0;
        int pageSize = 10;
        String pageIndexStr = pageInfo.getPageIndex();
        String pageSizeStr = pageInfo.getPageSize();

        if (StringUtils.isNotBlank(pageIndexStr)) {
            pageIndex = Integer.valueOf(pageIndexStr) - 1;
        }
        if (StringUtils.isNotBlank(pageSizeStr)) {
            pageSize = Integer.valueOf(pageSizeStr);
        }
         return dataSourceInfoDao.queryByLimit(pageIndex*pageSize, pageSize);
    }

    @Override
    public int updateDataSourceInfoByCode(DataSourceInfo dataSourceInfo) {
        return dataSourceInfoDao.updateDataSourceInfoByCode(dataSourceInfo);
    }

    @Override
    public int deleteDataSourceInfoByAccount(String account) {
        return dataSourceInfoDao.deleteDataSourceInfoByAccount(account);
    }

    @Override
    public int deleteDataSourceInfoByCode(String databaseCode) {
        return dataSourceInfoDao.deleteDataSourceInfoByCode(databaseCode);
    }
}
