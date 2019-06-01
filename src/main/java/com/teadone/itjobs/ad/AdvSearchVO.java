package com.teadone.itjobs.ad;

import lombok.Data;

@Data
public class AdvSearchVO {
	private String sort;
	private String keyword;
	private String myId;
	private int start;
	private int end;
}
