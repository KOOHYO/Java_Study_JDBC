package com.iu.regions;

public class RegionsDTO {
	//멤버변수 접근지정자 : private
	//Getter/Setter
	//기본생성자 필수
	//멤버변수명은 Table의 컬럼명과 동일하게 선언해야한다!! 중요!!
	private Integer region_id;//null이 들어갈 가능성이 있어서 Integer로 넣어야한다 왠만하면 Reference타입으로
	private String region_name;//컬럼명과 동일하게 _로 들어가야한다
	
	
	public Integer getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
}
