package net.syntrust.dao;

import net.syntrust.entity.InterfaceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterfaceInfoDao {

    // 插入
    int insertInterface(InterfaceInfo interfaceInfo);
    //分页查询
    List<InterfaceInfo> queryInterfaceByLimit(@Param("start")int start, @Param("count")int count);
    // 查询总数
    int selectInterfaceCount();
    //根据数据库编号
    InterfaceInfo queryByInterfaceCode(@Param("databaseCode") String databaseCode);
    // 根据接口code更新
    int updateInterfaceInfoByCode(InterfaceInfo interfaceInfo);
    // 根据接口code删除(软删除)
    int deleteInterfaceInfoByCode(@Param("databaseCode") String databaseCode);

}
