package net.syntrust.dao;

import net.syntrust.entity.InterfaceInfo;
import net.syntrust.entity.ServerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServerInfoDao {

    // 插入
    int insertServer(ServerInfo serverInfo);
    //分页查询
    List<ServerInfo> queryServerByLimit(@Param("start")int start, @Param("count")int count);
    // 查询总数
    int selectServerCount();
    //根据数据库编号
    ServerInfo queryByServerCode(@Param("serverCode") String serverCode);
    // 根据接口code更新
    int updateServerInfoByCode(ServerInfo interfaceInfo);
    // 根据接口code删除(软删除)
    int deleteServerInfoByCode(@Param("serverCode") String serverCode);

}
