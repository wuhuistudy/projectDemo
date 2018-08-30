package net.syntrust.service.impl;

import net.syntrust.dao.ServerInfoDao;
import net.syntrust.entity.PageInfo;
import net.syntrust.entity.ServerInfo;
import net.syntrust.service.ServerInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServerInfoService")
public class ServerInfoServiceImpl implements ServerInfoService {

    @Autowired
    public ServerInfoDao serverInfoDao;

    @Override
    public int insertServer(ServerInfo serverInfo) {
        return serverInfoDao.insertServer(serverInfo);
    }

    @Override
    public List<ServerInfo> queryServerByLimit(PageInfo pageInfo) {
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
        return serverInfoDao.queryServerByLimit(pageIndex*pageSize, pageSize);
    }

    @Override
    public int selectServerCount() {
        return serverInfoDao.selectServerCount();
    }

    @Override
    public ServerInfo queryByServerCode(String serverCode) {
        return serverInfoDao.queryByServerCode(serverCode);
    }

    @Override
    public int updateServerInfoByCode(ServerInfo serverInfo) {
        return serverInfoDao.updateServerInfoByCode(serverInfo);
    }

    @Override
    public int deleteServerInfoByCode(String serverCode) {
        return serverInfoDao.deleteServerInfoByCode(serverCode);
    }
}
