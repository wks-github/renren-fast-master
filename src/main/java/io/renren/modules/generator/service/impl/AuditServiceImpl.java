package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.AuditDao;
import io.renren.modules.generator.entity.AuditEntity;
import io.renren.modules.generator.service.AuditService;


@Service("auditService")
public class AuditServiceImpl extends ServiceImpl<AuditDao, AuditEntity> implements AuditService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AuditEntity> page = this.page(
                new Query<AuditEntity>().getPage(params),
                new QueryWrapper<AuditEntity>()
        );

        return new PageUtils(page);
    }

}