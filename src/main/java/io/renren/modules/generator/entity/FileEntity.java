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
@TableName("file")
public class FileEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 核酸附件id
	 */
	@TableId
	private Integer fileId;
	/**
	 * 上传附件学生id
	 */
	private Integer studentId;
	/**
	 *
	 */
	private Date uploadTime;
	/**
	 * 附件上传地址
	 */
	private String fileUrl;
	/**
	 * 上传时的地理位置信息-扩展字段
	 */
	private String uploadLocation;

}
