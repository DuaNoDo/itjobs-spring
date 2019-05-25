CREATE TABLE IT_company_member (
  IT_C_id varchar(30) NOT NULL,
  IT_C_pass varchar(50) NOT NULL,
  IT_C_num char(12) NOT NULL,
  IT_C_name varchar(20) NOT NULL,
  IT_C_mail varchar(50) NOT NULL,
  IT_C_phone varchar(13) NOT NULL,
  IT_C_zip varchar(20) DEFAULT NULL,
  IT_C_addr varchar(200) NOT NULL,
  IT_C_join_date datetime DEFAULT NULL,
  PRIMARY KEY (IT_C_id)
) ;

CREATE TABLE IT_personal_member (
  IT_id varchar(30) NOT NULL,
  IT_pass varchar(50) NOT NULL,
  IT_name varchar(20) NOT NULL,
  IT_mail varchar(50) NOT NULL,
  IT_phone varchar(13) NOT NULL,
  IT_gender char(2) NOT NULL,
  IT_zip varchar(20) DEFAULT NULL,
  IT_addr varchar(200) NOT NULL,
  IT_join_date datetime DEFAULT NULL,
  PRIMARY KEY (IT_id)
) ;

CREATE TABLE advertisement (
  adv_num int(11) NOT NULL AUTO_INCREMENT,
  adv_company varchar(50) NOT NULL,
  adv_name varchar(50) NOT NULL,
  adv_email varchar(50) NOT NULL,
  adv_content longtext NOT NULL,
  adv_reg_date datetime DEFAULT NULL,
  adv_readcount int(11) DEFAULT '0',
  adv_img varchar(255) DEFAULT NULL,
  adv_display char(5) DEFAULT NULL,
  PRIMARY KEY (adv_num)
);

CREATE TABLE board (
  num int(11) NOT NULL AUTO_INCREMENT,
  writer varchar(20) NOT NULL,
  email varchar(30) DEFAULT NULL,
  subject varchar(50) NOT NULL,
  passwd varchar(20) NOT NULL,
  reg_date datetime NOT NULL,
  readcount int(11) DEFAULT '0',
  ref int(11) NOT NULL,
  re_step smallint(6) NOT NULL,
  re_level smallint(6) NOT NULL,
  content text NOT NULL,
  ip varchar(20) NOT NULL,
  PRIMARY KEY (num)
);

CREATE TABLE likeadv (
  IT_id varchar(30) NOT NULL,
  adv_num int(11) NOT NULL,
  PRIMARY KEY (IT_id,adv_num),  
  CONSTRAINT likeadv_ibfk_1 FOREIGN KEY (IT_id) REFERENCES IT_personal_member (IT_id),
  CONSTRAINT likeadv_ibfk_2 FOREIGN KEY (adv_num) REFERENCES advertisement (adv_num)
) ;

CREATE TABLE notice (
  notice_num int(11) NOT NULL AUTO_INCREMENT,
  notice_title varchar(100) NOT NULL,
  notice_content text NOT NULL,
  notice_regTime datetime NOT NULL,
  PRIMARY KEY (notice_num)
) ;