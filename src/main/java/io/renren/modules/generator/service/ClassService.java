package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.ClassEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 
 *
 * @author guijing
 * @email sunlightcs@gmail.com
 * @date 2022-02-06 18:16:28
 */
public interface ClassService extends IService<ClassEntity> {

    PageUtils queryPage(Map<String, Object> params);

    IPage<Map<String,Object>> selectPageList(@Param("page") Page<Map<String,Object>> page, @Param("params") Map<String, Object> params);


    //PageUtils selectPageList(Page<ClassEntity> page, Map<String, Object> params);
}

