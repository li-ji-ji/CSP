package cn.lhj.csp.fileinfo.service;

public interface PaySystemService {
	
		public String placeOrder(String openid, String ip, int total_fee,String orderNo) throws Exception;
		
		public String notify_url(String data) throws Exception;
		
		public String cancelOrder(String out_trade_no, int total_fee) throws Exception;
		
		public String refund_url(String data) throws Exception;
}
