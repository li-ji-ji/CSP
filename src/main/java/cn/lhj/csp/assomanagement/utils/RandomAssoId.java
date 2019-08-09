package cn.lhj.csp.assomanagement.utils;

import java.util.Date;

public class RandomAssoId {

	public String getRandomAssoId(Date now) {
		String chars = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
		StringBuffer assoId=new StringBuffer();
		String nowString=String.valueOf(now.getTime());
		assoId.append(String.valueOf(chars.charAt((int)(Math.random() * 26))));
		assoId.append(String.valueOf(chars.charAt((int)(Math.random() * 26))));
		assoId.append(String.valueOf(chars.charAt((int)(Math.random() * 26))));
		assoId.append(String.valueOf(chars.charAt((int)(Math.random() * 26))));
		assoId.append(String.valueOf(chars.charAt((int)(Math.random() * 26))));
		assoId.append(String.valueOf(chars.charAt((int)(Math.random() * 26))));
		assoId.append(nowString.substring(nowString.length()-5, nowString.length()));
		return assoId.toString();
	}
}
