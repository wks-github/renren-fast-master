package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.AuditEntity;

import java.util.Map;

/**
 * 
 *
 * @author guijing
 * @email sunlightcs@gmail.com
 * @date 2022-02-05 22:24:19
 */
public interface AuditService extends IService<AuditEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

