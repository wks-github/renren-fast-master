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
 * @date 2022-02-05 22:24:18
 */
@Data
@TableName("rest")
public class RestEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer restId;
	/**
	 * 关联审核表所有审核记录id
	 */
	private Integer auditRecordId;
	/**
	 * 请假人姓名
	 */
	private String restName;
	/**
	 * 请假开始时间
	 */
	private Date startTime;
	/**
	 * 请假结束时间
	 */
	private Date endTime;
	/**
	 * 请假原因
	 */
	private String restReason;
	/**
	 * 请假发起时间
	 */
	private Date restTime;

}
