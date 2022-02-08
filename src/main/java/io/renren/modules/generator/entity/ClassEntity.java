package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author guijing
 * @email sunlightcs@gmail.com
 * @date 2022-02-06 18:16:28
 */
@Data
@TableName("class")
public class ClassEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long classId;
	/**
	 * 班级名称
	 */
	private String className;
	/**
	 * 级班简介
	 */
	private String classBrief;
	/**
	 * 班主任id
	 */
	private Long teacherId;
	/**
	 * 班主任名称
	 */
	private String teacherName;
	/**
	 * 书记id
	 */
	private Long secretaryId;
	/**
	 * 书记名称
	 */
	private String secretaryName;

}
