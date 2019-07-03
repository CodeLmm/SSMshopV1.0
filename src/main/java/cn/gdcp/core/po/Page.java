package cn.gdcp.core.po;

import java.util.List;

public class Page<T> {
	private int allPageNO;
    private int currPageNO;
    private int perNum ;
    private List<T> list;
	public int getAllPageNO() {
		return allPageNO;
	}
	public void setAllPageNO(int allPageNO) {
		this.allPageNO = allPageNO;
	}
	public int getCurrPageNO() {
		return currPageNO;
	}
	public void setCurrPageNO(int currPageNO) {
		this.currPageNO = currPageNO;
	}
	public int getPerNum() {
		return perNum;
	}
	public void setPerNum(int perNum) {
		this.perNum = perNum;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
    

}
