package io.renren.modules.secretary.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.annotation.SysLog;
import io.renren.common.utils.Constant;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.common.validator.ValidatorUtils;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.modules.secretary.service.StudentService;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.form.PasswordForm;
import io.renren.modules.sys.service.SysUserRoleService;
import io.renren.modules.sys.service.SysUserService;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static io.renren.common.utils.ShiroUtils.getUserId;

/**
 * @author wks
 * @date 2022/2/7 16:21
 */
@RestController
@RequestMapping("/secretary/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    /**
     * 所有学生列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        Page<Map<String,Object>> page = new Page<>(Long.valueOf(String.valueOf(params.get("limit"))) * (Long.valueOf(String.valueOf(params.get("page")))-1) + 1,Long.valueOf(String.valueOf(params.get("limit"))) * Long.valueOf(String.valueOf(params.get("page"))));
        IPage<Map<String, Object>> mapIPage = studentService.selectStudentList(page, params);
        PageUtils newPage = new PageUtils(mapIPage);

        return R.ok().put("page", newPage);
    }

    /**
     * 获取登录的用户信息
     */
//    @GetMapping("/info")
//    public R info(){
//        return R.ok().put("user", getUser());
//    }
//
//
//
//    /**
//     * 用户信息
//     */
//    @GetMapping("/info/{userId}")
//    @RequiresPermissions("sys:user:info")
//    public R info(@PathVariable("userId") Long userId){
//        SysUserEntity user = sysUserService.getById(userId);
//
//        //获取用户所属的角色列表
//        List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
//        user.setRoleIdList(roleIdList);
//
//        return R.ok().put("user", user);
//    }
//
//    /**
//     * 保存用户
//     */
//    @SysLog("保存用户")
//    @PostMapping("/save")
//    @RequiresPermissions("sys:user:save")
//    public R save(@RequestBody SysUserEntity user){
//        ValidatorUtils.validateEntity(user, AddGroup.class);
//
//        user.setCreateUserId(getUserId());
//        sysUserService.saveUser(user);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改用户
//     */
//    @SysLog("修改用户")
//    @PostMapping("/update")
//    @RequiresPermissions("sys:user:update")
//    public R update(@RequestBody SysUserEntity user){
//        ValidatorUtils.validateEntity(user, UpdateGroup.class);
//
//        user.setCreateUserId(getUserId());
//        sysUserService.update(user);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除用户
//     */
//    @SysLog("删除用户")
//    @PostMapping("/delete")
//    @RequiresPermissions("sys:user:delete")
//    public R delete(@RequestBody Long[] userIds){
//        if(ArrayUtils.contains(userIds, 1L)){
//            return R.error("系统管理员不能删除");
//        }
//
//        if(ArrayUtils.contains(userIds, getUserId())){
//            return R.error("当前用户不能删除");
//        }
//
//        sysUserService.deleteBatch(userIds);
//
//        return R.ok();
//    }

}
