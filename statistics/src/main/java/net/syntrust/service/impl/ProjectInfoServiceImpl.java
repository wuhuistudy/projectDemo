package net.syntrust.service.impl;

import net.syntrust.dao.ProjectInfoDao;
import net.syntrust.entity.PageInfo;
import net.syntrust.entity.ProjectInfo;
import net.syntrust.service.ProjectInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProjectInfoService")
public class ProjectInfoServiceImpl implements ProjectInfoService {
    @Autowired
    public ProjectInfoDao projectInfoDao;
    @Override
    public int insertProject(ProjectInfo projectInfo) {
        return projectInfoDao.insertProject(projectInfo);
    }
    
    @Override
    public List<ProjectInfo> queryProjectByLimit(PageInfo pageInfo) {
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
        return projectInfoDao.queryProjectByLimit(pageIndex*pageSize, pageSize);
    }

    @Override
    public int selectprojectCount() {
        return projectInfoDao.selectprojectCount();
    }

    @Override
    public ProjectInfo queryByProjectCode(String projectCode) {
        return projectInfoDao.queryByProjectCode(projectCode);
    }

    @Override
    public int updateProjectInfoByCode(ProjectInfo projectInfo) {
        return projectInfoDao.updateProjectInfoByCode(projectInfo);
    }

    @Override
    public int deleteProjectInfoByCode(String projectCode) {
        return projectInfoDao.deleteProjectInfoByCode(projectCode);
    }
}
