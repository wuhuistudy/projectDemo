package net.syntrust.service;

import net.syntrust.entity.InterfaceInfo;
import net.syntrust.entity.PageInfo;
import net.syntrust.entity.ServerInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServerInfoService {

    int insertServer(ServerInfo serverInfo);
    List<ServerInfo> queryServerByLimit(PageInfo pageInfo);
    int selectServerCount();
    ServerInfo queryByServerCode(String serverCode);
    int updateServerInfoByCode(ServerInfo serverInfo);
    int deleteServerInfoByCode(String serverCode);

}
