package com.teadone.itjobs.ad;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class AdvertisementVO {
	private int adv_num; 
    private String adv_company;
    private String adv_name;
    private String adv_email;
    private String adv_content;
    private Timestamp adv_reg_date;
    private int adv_readcount;
    private String adv_img;
    private String table;
    private int start;
    private int end;
    private String adv_display;
    private String[] adv_nums;
    private String IT_id;
    private String[] IT_ids;
    private String companySort;
}
