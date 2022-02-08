package io.renren.modules.generator.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.generator.entity.ClassEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 
 * 
 * @author guijing
 * @email sunlightcs@gmail.com
 * @date 2022-02-06 18:16:28
 */
@Mapper
@Repository
public interface ClassDao extends BaseMapper<ClassEntity> {
    //自定义查询数据
    IPage<Map<String,Object>> selectPageList(@Param("page") Page<Map<String,Object>> page, @Param("params") Map<String, Object> params);

    //IPage<ClassEntity> selectPageList(Page<ClassEntity> page, Map<String, Object> params);
}
