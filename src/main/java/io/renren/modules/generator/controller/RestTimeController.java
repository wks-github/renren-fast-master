package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.generator.entity.RestEntity;
import io.renren.modules.generator.service.RestService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author guijing
 * @email sunlightcs@gmail.com
 * @date 2022-02-05 22:24:18
 */
@RestController
@RequestMapping("generator/rest")
public class RestTimeController {
    @Autowired
    private RestService restService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:rest:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = restService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{restId}")
    @RequiresPermissions("generator:rest:info")
    public R info(@PathVariable("restId") Integer restId){
		RestEntity rest = restService.getById(restId);

        return R.ok().put("rest", rest);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:rest:save")
    public R save(@RequestBody RestEntity rest){
		restService.save(rest);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:rest:update")
    public R update(@RequestBody RestEntity rest){
		restService.updateById(rest);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:rest:delete")
    public R delete(@RequestBody Integer[] restIds){
		restService.removeByIds(Arrays.asList(restIds));

        return R.ok();
    }

}
