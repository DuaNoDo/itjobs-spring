package com.teadone.itjobs.mem;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class CMemVO {
	private String IT_C_id;
	private String IT_C_pass;
	private String IT_C_num;
	private String IT_C_name;
	private String IT_C_mail;
	private String IT_C_mail1;
	private String IT_C_mail2;
	private String IT_C_phone;
	private String IT_C_phone1;
	private String IT_C_phone2;
	private String IT_C_phone3;
	private String IT_C_zip;
	private String IT_C_addr1;
	private String IT_C_addr2;
	private int IT_C_Incentive;
	private Timestamp IT_C_LastLog;
}
