package com.iu.regions;

public class RegionsDTO {
	//멤버변수 접근지정자 : private
	//Getter/Setter
	//기본생성자 필수
	//멤버변수명은 Table의 컬럼명과 동일하게 선언해야한다!! 중요!!
	private Integer regions_id;//null이 들어갈 가능성이 있어서 Integer로 넣어야한다 왠만하면 Reference타입으로
	private String regions_name;//컬럼명과 동일하게 _로 들어가야한다
	
	
	public Integer getRegions_id() {
		return regions_id;
	}
	public void setRegions_id(Integer regions_id) {
		this.regions_id = regions_id;
	}
	public String getRegions_name() {
		return regions_name;
	}
	public void setRegions_name(String regions_name) {
		this.regions_name = regions_name;
	}
	
}
