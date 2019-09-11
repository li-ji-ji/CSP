package cn.yzj.shop.po;

import java.util.ArrayList;
import java.util.List;

/**
 * region2包装类
 * @author syf
 *
 */
public class Region2DTO extends Region2{
		
		private List<Region2> region2s = new ArrayList<Region2>();

		public List<Region2> getRegion2s() {
			return region2s;
		}

		public void setRegion2s(List<Region2> region2s) {
			this.region2s = region2s;
		}

		@Override
		public String toString() {
			return "Region2DTO [region2s=" + region2s + "]";
		}
		
}
