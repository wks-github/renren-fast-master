package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.FileEntity;
import io.renren.modules.generator.service.FileService;
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
@RequestMapping("generator/file")
public class FileController {
    @Autowired
    private FileService fileService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:file:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fileService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{fileId}")
    @RequiresPermissions("generator:file:info")
    public R info(@PathVariable("fileId") Integer fileId){
		FileEntity file = fileService.getById(fileId);

        return R.ok().put("file", file);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:file:save")
    public R save(@RequestBody FileEntity file){
		fileService.save(file);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:file:update")
    public R update(@RequestBody FileEntity file){
		fileService.updateById(file);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:file:delete")
    public R delete(@RequestBody Integer[] fileIds){
		fileService.removeByIds(Arrays.asList(fileIds));

        return R.ok();
    }

}
