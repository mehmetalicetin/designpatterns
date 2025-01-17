package com.i2i.transaction.entity.billrun;

import com.i2i.transaction.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Builder
@Getter
@Setter
@ToString
public class BillRunEntity implements BaseEntity {
	private Long billRunId;
	private Long billAcctId;
	private String loggedInUserName;
	private Timestamp sDate;
	private String applyOcc;
	private String invType;
	private String status;
	private Timestamp invDate;
	private Timestamp dueDate;
	private Timestamp cDate;
}
