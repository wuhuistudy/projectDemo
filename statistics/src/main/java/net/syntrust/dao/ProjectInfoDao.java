package net.syntrust.dao;

import net.syntrust.entity.ProjectInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectInfoDao {

    // 插入
    int insertProject(ProjectInfo projectInfo);
    //分页查询
    List<ProjectInfo> queryProjectByLimit(@Param("start")int start, @Param("count")int count);
    // 查询总数
    int selectprojectCount();
    //根据项目编号
    ProjectInfo queryByProjectCode(@Param("projectCode") String projectCode);
    // 根据项目code更新
    int updateProjectInfoByCode(ProjectInfo projectInfo);
    // 根据项目code删除(软删除)
    int deleteProjectInfoByCode(@Param("projectCode") String projectCode);

}
