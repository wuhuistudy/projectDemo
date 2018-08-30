package net.syntrust.service;

import net.syntrust.entity.DataSourceInfo;
import net.syntrust.entity.InterfaceInfo;
import net.syntrust.entity.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InterfaceInfoService {
    int insertInterface(InterfaceInfo interfaceInfo);
    List<InterfaceInfo> queryInterfaceByLimit(PageInfo pageInfo);
    int selectInterfaceCount();
    InterfaceInfo queryByInterfaceCode(String databaseCode);
    int updateInterfaceInfoByCode(InterfaceInfo interfaceInfo);
    int deleteInterfaceInfoByCode(String databaseCode);
}
