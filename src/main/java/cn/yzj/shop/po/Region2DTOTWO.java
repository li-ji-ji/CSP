package cn.yzj.shop.po;

import java.util.List;

public class Region2DTOTWO {

	private Region2 region2;
	private List<Region2DTO> region2DTO;

	public Region2 getRegion2() {
		return region2;
	}

	public void setRegion2(Region2 region2) {
		this.region2 = region2;
	}

	public List<Region2DTO> getRegion2DTO() {
		return region2DTO;
	}

	public void setRegion2DTO(List<Region2DTO> region2dto) {
		region2DTO = region2dto;
	}

	@Override
	public String toString() {
		return "Region2DTOTWO [region2=" + region2 + ", region2DTO=" + region2DTO + "]";
	}

}
