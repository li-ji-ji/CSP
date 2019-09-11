package cn.yzj.shop.po;

import java.util.ArrayList;
import java.util.List;

/**
 * region2包装类
 * @author syf
 *
 */
public class Region2DTO{
		
		private Region2 region2;
		private List<Region2> region2s = new ArrayList<Region2>();

		public Region2 getRegion2() {
			return region2;
		}

		public void setRegion2(Region2 region2) {
			this.region2 = region2;
		}

		public List<Region2> getRegion2s() {
			return region2s;
		}

		public void setRegion2s(List<Region2> region2s) {
			this.region2s = region2s;
		}

		@Override
		public String toString() {
			return "Region2DTO [region2=" + region2 + ", region2s=" + region2s + "]";
		}

}
