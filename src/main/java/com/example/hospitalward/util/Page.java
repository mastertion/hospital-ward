package com.example.hospitalward.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页类，封装分页基本信息。首页默认1
 * 
 * @author Administrator
 * @version v1.0
 */
@Data
public  class Page {
	private  Integer pageNum;
	private  Integer pageSize;
	private String clause;
	private Integer count;
}
