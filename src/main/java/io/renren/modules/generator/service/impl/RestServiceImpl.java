package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.RestDao;
import io.renren.modules.generator.entity.RestEntity;
import io.renren.modules.generator.service.RestService;


@Service("restService")
public class RestServiceImpl extends ServiceImpl<RestDao, RestEntity> implements RestService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RestEntity> page = this.page(
                new Query<RestEntity>().getPage(params),
                new QueryWrapper<RestEntity>()
        );

        return new PageUtils(page);
    }

}