// pages/homePage/shooping/shopping.js
Page({

	/**
	 * 页面的初始数据
	 */
	data: {
		location: null
	},
	getHomeData: function(e) {
		var x = parseInt(e.currentTarget.dataset.type);
		console.log("获得的下标:" + x);

		// this.printArray(x)
		wx.setStorage({
			key: "ican",
			data: "yes"
		})
		wx.navigateTo({
      url: "../homePage/homePage?Index=" + x,
		})
	},

	/**
	 * 生命周期函数--监听页面加载
	 */
	onLoad: function(options) {
		var location = options.location
		console.log(location)
		location = JSON.parse(location)
		console.log(location)
		this.setData({
			location: location
		})
	},
  
	onShow: function() {

	},
	goHome: function() {
		wx.navigateTo({
			url: "../homePage"
		})
	},

})
//page/index/index
