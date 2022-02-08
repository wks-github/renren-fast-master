package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.AuditEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author guijing
 * @email sunlightcs@gmail.com
 * @date 2022-02-05 22:24:19
 */
@Mapper
public interface AuditDao extends BaseMapper<AuditEntity> {
	
}
