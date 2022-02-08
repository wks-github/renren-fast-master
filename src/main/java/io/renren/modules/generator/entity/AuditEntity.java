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
 * @date 2022-02-05 22:24:19
 */
@Data
@TableName("audit")
public class AuditEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer auditId;
	/**
	 * 关联请假条字段
	 */
	private Integer auditRecordId;
	/**
	 * 请假人姓名
	 */
	private String restName;
	/**
	 * 审批人id
	 */
	private Integer auditPeopleId;
	/**
	 * 请假人姓名
	 */
	private Integer restId;
	/**
	 * 审批人姓名
	 */
	private String auditPeopleName;
	/**
	 * 审批状态-0是未通过1是通过2是驳回
	 */
	private Integer auditStatus;
	/**
	 * 通过或者驳回原因
	 */
	private String reason;
	/**
	 * 审批时间
	 */
	private Date auditTime;
	/**
	 * 请假审核阶段-0是未审批1是班主任审批2是书记审批
	 */
	private Integer auditLevel;

}
