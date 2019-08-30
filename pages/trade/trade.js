// pages/trade/trade.js
Page({

	/**
	 * 页面的初始数据
	 */
	data: {
		choose: ["送货上门", "上门取货"],
		chooseId: 0,
		delivery: true,
		door: false,
		user: {
			"name": "点我输入",
			"nmber": "点我输入",
			"address": "点我输入",
		},
		money: 0,
		payment: false
	},
	name: function(e) {
		console.log(e);
		var x = e.detail.value
		var y = this.data.user
		if (x == undefined) {
			return 0
			console.log("11111")
		} else if (x == "") {
			console.log("22222")
			y.name = null
			this.setData({
				user: y
			})
		} else {
			y.name = x
			this.setData({
				user: y
			})

		}
	},
	number: function(e) {
		console.log(e);
		var x = e.detail.value
		var y = this.data.user
		if (x == undefined) {
			return 0
			console.log("11111")
		} else if (x == "") {
			console.log("22222")
			y.number = null
			this.setData({
				user: y
			})
		} else {
			y.number = x
			this.setData({
				orderDemand: y
			})

		}
	},
	address: function(e) {
		console.log(e);
		var x = e.detail.value
		var y = this.data.user
		if (x == undefined) {
			return 0
			console.log("11111")
		} else if (x == "") {
			console.log("22222")
			y.address = null
			this.setData({
				user: y
			})
		} else {
			y.address = x
			this.setData({
				orderDemand: y
			})

		}
	},
	choose: function(e) {
		var n = parseInt(e.currentTarget.dataset.type);
		if (n == 0) {
			this.setData({
				delivery: true,
				door: false
			})
		} else {
			this.setData({
				delivery: false,
				door: true
			})
		}
		this.setData({
			chooseId: n
		})
	},
	money: function() {
		var that = this
		console.log(that.data.order.length)
		var x = that.data.order
		var money = 0
		for (var i = 0; i < that.data.order.length; i++) {
			if (x[i].page <= 0 && x[i].demand.userPage <= 0) {
				that.setData({
					money: "系统判断您文件的页数有问题，麻烦手动输入",
					payment: false
				})
				break
			} else {
				if (x[i].page < x[i].demand.userPage) {
					money = money+Number(x[i].demand.userPage)*Number(x[i].demand.number)
				} else {
					money = money+Number(x[i].page)*Number(x[i].demand.number)
				}
			}
		}
		money = money * 0.5
		console.log(money)
		that.setData({
			money: money,
			payment: true
		})
	},
	payment: function() {

	},
	/**
	 * 生命周期函数--监听页面加载
	 */
	onLoad: function(options) {
		var that = this
		that.setData({
			Index: options.Index,
			printIndex: options.printIndex
		})
		wx.request({
			url: "https://qzimp.cn/api/file/api/printShop/getAll",
			method: "GET",
			header: {
				'content-type': 'application/json' // 默认值
			},
			success: function(res) {
				that.setData({
					location: res.data,
				})
			}
		})
		console.log(options.order)
		var order = decodeURIComponent(options.order)
		console.log(order)
		order = JSON.parse(order)
		console.log(order)
		that.setData({
			order: order,
			money: 0,
		})
		that.money()

	},

	/**
	 * 生命周期函数--监听页面初次渲染完成
	 */
	onReady: function() {

	},

	/**
	 * 生命周期函数--监听页面显示
	 */
	onShow: function() {

	},

	/**
	 * 生命周期函数--监听页面隐藏
	 */
	onHide: function() {

	},

	/**
	 * 生命周期函数--监听页面卸载
	 */
	onUnload: function() {

	},

	/**
	 * 页面相关事件处理函数--监听用户下拉动作
	 */
	onPullDownRefresh: function() {

	},

	/**
	 * 页面上拉触底事件的处理函数
	 */
	onReachBottom: function() {

	},

	/**
	 * 用户点击右上角分享
	 */
	onShareAppMessage: function() {

	}
})
