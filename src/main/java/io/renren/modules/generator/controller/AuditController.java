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

import io.renren.modules.generator.entity.AuditEntity;
import io.renren.modules.generator.service.AuditService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author guijing
 * @email sunlightcs@gmail.com
 * @date 2022-02-05 22:24:19
 */
@RestController
@RequestMapping("generator/audit")
public class AuditController {
    @Autowired
    private AuditService auditService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:audit:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = auditService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{auditId}")
    @RequiresPermissions("generator:audit:info")
    public R info(@PathVariable("auditId") Integer auditId){
		AuditEntity audit = auditService.getById(auditId);

        return R.ok().put("audit", audit);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:audit:save")
    public R save(@RequestBody AuditEntity audit){
		auditService.save(audit);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:audit:update")
    public R update(@RequestBody AuditEntity audit){
		auditService.updateById(audit);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:audit:delete")
    public R delete(@RequestBody Integer[] auditIds){
		auditService.removeByIds(Arrays.asList(auditIds));

        return R.ok();
    }

}
