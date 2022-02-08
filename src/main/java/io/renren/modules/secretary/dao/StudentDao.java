package io.renren.modules.secretary.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.common.entity.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author wks
 * @date 2022/2/7 16:44
 */

@Mapper
@Repository
public interface StudentDao extends BaseMapper<Student> {

    @MapKey("user_id")
    IPage<Map<String, Object>> selectStudentList(@Param("page") Page<Map<String, Object>> page, @Param("params") Map<String, Object> params);
}
