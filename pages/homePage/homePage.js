// pages/homePage/homePage.js
Page({

	/**
	 * 页面的初始数据
	 */
	data: {
		//当前店面的数标
		printIndex: 0, //当前打印机的数标
		upArray: [], //s上传元素组成的数组
		error_dis: "none", //判断文件是否出错
		aheadUp_dis: "none",
		Index: 0,
		printNumber: 0, //
		frameNumber: 0,
		orderNumber: 0, //订单数
		printname: [],
		char_lt: "<",
		location: [], //店面数据
		array: {},
		ican: null
	},

	display_error: function() {
		//错误弹窗(未启用)
		// console.log("隐藏3:" + this.data.error_dis);
		var x = this.data.error_dis;
		if (x == "none") {
			this.setData({
				error_dis: "block"
			})
		}
		if (x == "block") {
			this.setData({
				error_dis: "none"
			})
		}

	},
	goAomunt: function() {
		//跳转到订单页面
		var that = this
		// that.setData({
		//   aheadUp_dis: "none"
		// })
		var upArray = JSON.stringify(this.data.upArray)
		// 数据传输
		wx.navigateTo({
			url: "../aomunt/aomunt?upArray=" + upArray + "&Index=" + this.data.Index + "&printIndex=" + this.data.printIndex,
		})
	},
	goorderList: function() {
		//我的购物
		wx.navigateTo({
			url: '../orderList/orderList?Index=' + this.data.Index + "&printIndex=" + this.data.printIndex
		})
	},
	goShopping: function() {
		//我的店面
		var location = JSON.stringify(this.data.location)
		wx.navigateTo({
			url: "../shooping/shopping?location=" + location,
		})
		this.setData({
			printIndex: 0
		})

	},
	bindPickerChange: function(e) {
		console.log('picker发送选择改变，携带值为', e.detail.value)
		this.setData({
			printIndex: e.detail.value
		})
	},
	printArray: function() {
		//建立店面打印机信息数组
		var x = 0
		var y = this.data.location[x].prints.length
		// console.log(".." + y)
		var z = [];
		for (var i = 0; i < y; i++) {
			z[i] = this.data.location[x].prints[i].printName;
		}

		this.setData({
			printname: z
		})
		console.log(this.data.printname)
	},
	orderNumberMonitoring: function() {
		//获得当前upArray的长度
		var that = this
		that.setData({
			orderNumber: that.data.upArray.length
		})
		// console.log("生命周期" + that.data.upImg.length)
	},
	/**
	 * 生命周期函数--监听页面加载
	 */
	onLoad: function(options) {
		// 获得服务器上的数据
		var that = this
		wx.request({
			url: "http://92.68.50.32:8206/api/file/api/printShop/getAll",
			method: "GET",
			header: {
				'content-type': 'application/json' // 默认值
			},
			success: function(res) {
				console.log(res)
				that.setData({
					location: res.data
				})
				// console.log(JSON.parse(res.data[1].printerConfig))
				that.printArray()
			}
		})
		if (this.data.ires== "yes") {
			this.setData({
				Index: options.Index
			})
			wx.setStorage({
				key: "ican",
				data: "no"
			})
		}
	},
	getImg: function() {
		// 跳转到up页面上传文件
		var that = this
		// that.setData({
		//   aheadUp_dis: "none"
		// })
		// 判断标记
		wx.setStorage({
			key: 'ican',
			data: that.data.ican
		})
		// 跳转到up页面
		var that = this
		wx.navigateTo({
			url: '../up/up',
		})
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
		//获得数据
		var that = this
		that.orderNumberMonitoring()
		wx.getStorage({
			// 从up中获得数据，ican判断这个数据是否储存
			key: 'ican',
			success: function(ires) {
				if (ires.data == "yes") {
					//当这个数据可以存储时获得array（服务器传回来的数据）
					wx.getStorage({
						key: 'array',
						success: function(res) {
							// 数据获取并拼接在原先的数据末尾
							that.setData({
								upArray: that.data.upArray.concat(res.data)
							})
							//获得数组长粗，输出给前台
							that.orderNumberMonitoring()
							that.setData({
								ican: "no"
							})
							// 将判断标记初始化
							wx.setStorage({
								key: "ican",
								data: "no"
							})
						}
					})
				}
			}
		})

	},


})
