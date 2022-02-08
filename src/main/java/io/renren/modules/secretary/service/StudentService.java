package io.renren.modules.secretary.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author wks
 * @date 2022/2/7 16:39
 */

public interface StudentService {
    IPage<Map<String, Object>> selectStudentList(@Param("page") Page<Map<String, Object>> page, @Param("params") Map<String, Object> params);
}
