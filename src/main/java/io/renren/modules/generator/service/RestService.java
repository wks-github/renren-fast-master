package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.RestEntity;

import java.util.Map;

/**
 * 
 *
 * @author guijing
 * @email sunlightcs@gmail.com
 * @date 2022-02-05 22:24:18
 */
public interface RestService extends IService<RestEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

