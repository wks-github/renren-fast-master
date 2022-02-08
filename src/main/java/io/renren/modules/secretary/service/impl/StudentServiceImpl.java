package io.renren.modules.secretary.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.secretary.dao.StudentDao;
import io.renren.modules.secretary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wks
 * @date 2022/2/7 16:40
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public IPage<Map<String, Object>> selectStudentList(Page<Map<String, Object>> page, Map<String, Object> params) {
        return studentDao.selectStudentList(page, params);
    }
}
