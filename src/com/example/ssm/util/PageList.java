package com.example.ssm.util;

import java.util.List;

/**
 * rowCount : 每页的数量
 * pageNum : 当前页号
 * maxCount : 一共有多少
 * maxPage : 最大页数
 * @author PE
 *
 * @param <T>
 */
public class PageList<T> {

	private int rowCount;
	
	private int pageNum;
	
	private List<T> objs;
	
	private int maxCount;
	
	private int maxPage;

	public PageList() {
		super();
		this.rowCount = 5;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<T> getObjs() {
		return objs;
	}

	public void setObjs(List<T> objs) {
		this.objs = objs;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
		double c = maxCount;
		double r = rowCount;
		this.maxPage = (int) Math.ceil(c / r);
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
}
