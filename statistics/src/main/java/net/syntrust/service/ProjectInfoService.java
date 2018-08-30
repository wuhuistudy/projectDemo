package net.syntrust.service;

import net.syntrust.entity.PageInfo;
import net.syntrust.entity.ProjectInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectInfoService {

    int insertProject(ProjectInfo projectInfo);
    List<ProjectInfo> queryProjectByLimit(PageInfo pageInfo);
    int selectprojectCount();
    ProjectInfo queryByProjectCode(String projectCode);
    int updateProjectInfoByCode(ProjectInfo projectInfo);
    int deleteProjectInfoByCode(String projectCode);

}
