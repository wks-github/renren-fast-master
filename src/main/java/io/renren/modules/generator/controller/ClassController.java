package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.ClassEntity;
import io.renren.modules.generator.service.ClassService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author guijing
 * @email sunlightcs@gmail.com
 * @date 2022-02-06 18:16:28
 */
@RestController
@RequestMapping("generator/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:class:list")
    public R list(@RequestParam Map<String, Object> params){
        Page<Map<String,Object>> page = new Page<>(Long.valueOf(String.valueOf(params.get("limit"))) * (Long.valueOf(String.valueOf(params.get("page")))-1) + 1,Long.valueOf(String.valueOf(params.get("limit"))) * Long.valueOf(String.valueOf(params.get("page"))));
        IPage<Map<String, Object>> mapIPage = classService.selectPageList(page, params);
        PageUtils newPage = new PageUtils(mapIPage);
        return R.ok().put("page", newPage);
    }



    /**
     * 信息
     */
    @RequestMapping("/info/{classId}")
    @RequiresPermissions("generator:class:info")
    public R info(@PathVariable("classId") Long classId){
		ClassEntity classEntity = classService.getById(classId);

        return R.ok().put("class", classEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:class:save")
    public R save(@RequestBody ClassEntity classEntity){
        classEntity.setSecretaryId(ShiroUtils.getUserId());
		classService.save(classEntity);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:class:update")
    public R update(@RequestBody ClassEntity classEntity){
		classService.updateById(classEntity);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:class:delete")
    public R delete(@RequestBody Long[] classIds){
		classService.removeByIds(Arrays.asList(classIds));

        return R.ok();
    }

}
