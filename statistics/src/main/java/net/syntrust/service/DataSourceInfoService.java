package net.syntrust.service;

import net.syntrust.entity.DataSourceInfo;
import net.syntrust.entity.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DataSourceInfoService {


    int insertDataSource(DataSourceInfo dataSourceInfo);

    DataSourceInfo queryByDatabaseCode(String databaseCode);

    DataSourceInfo queryByAccountAndCode(String account,String databaseCode);

    DataSourceInfo queryByCode(String databaseCode);

    int selectCount();

    List<DataSourceInfo> queryByLimit(PageInfo pageInfo);

    int updateDataSourceInfoByCode(DataSourceInfo dataSourceInfo);

    int deleteDataSourceInfoByAccount(String account);

    int deleteDataSourceInfoByCode(String databaseCode);
}
