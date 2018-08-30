package net.syntrust.dao;

import net.syntrust.entity.DataSourceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataSourceInfoDao {

    // 插入
    int insertDataSource(DataSourceInfo dataSourceInfo);
    // 根据数据库code查询
    //List<DataSourceInfo> queryByDatabaseCode(@Param("databaseCode") String databaseCode);
    DataSourceInfo queryByDatabaseCode(@Param("databaseCode") String databaseCode);
    // 根据账户,数据库编号查询
    DataSourceInfo queryByAccountAndCode(@Param("account") String account,@Param("databaseCode") String databaseCode);
    //根据数据库编号
    DataSourceInfo queryByCode(@Param("databaseCode") String databaseCode);
    // 查询总数
    int selectCount();
    //分页查询
    List<DataSourceInfo> queryByLimit(@Param("start")int start, @Param("count")int count);
    // 根据账户更新
    int updateDataSourceInfoByCode(DataSourceInfo dataSourceInfo);
    // 根据账户account删除(软删除)
    int deleteDataSourceInfoByAccount(@Param("account")String account);
    // 根据数据库code删除(软删除)
    int deleteDataSourceInfoByCode(@Param("databaseCode") String databaseCode);
}
