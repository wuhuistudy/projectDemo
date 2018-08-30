package net.syntrust.service.impl;

import net.syntrust.dao.InterfaceInfoDao;
import net.syntrust.entity.InterfaceInfo;
import net.syntrust.entity.PageInfo;
import net.syntrust.service.InterfaceInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("InterfaceInfoService")
public class InterfaceInfoServiceImpl implements InterfaceInfoService {
    @Autowired
    public InterfaceInfoDao interfaceInfoDao;
    @Override
    public int insertInterface(InterfaceInfo interfaceInfo) {
        return interfaceInfoDao.insertInterface(interfaceInfo);
    }

    @Override
    public List<InterfaceInfo> queryInterfaceByLimit(PageInfo pageInfo) {
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
        return interfaceInfoDao.queryInterfaceByLimit(pageIndex*pageSize, pageSize);
    }

    @Override
    public int selectInterfaceCount() {
        return interfaceInfoDao.selectInterfaceCount();
    }

    @Override
    public InterfaceInfo queryByInterfaceCode(String databaseCode) {
        return interfaceInfoDao.queryByInterfaceCode(databaseCode);
    }

    @Override
    public int updateInterfaceInfoByCode(InterfaceInfo interfaceInfo) {
        return 0;
    }

    @Override
    public int deleteInterfaceInfoByCode(String databaseCode) {
        return 0;
    }
}
