// pages/orderList/orderList.js
Page({

	/**
	 * 页面的初始数据
	 */
	data: {
		orderDemand: {},
		Index: null,
		printIndex: null,
		orderIndex:null,
		color: [],
		paper: [],
		use: [],

		number: null,
		//点击
		onColor: null,
		onPaper: null,
		onUse: null,
		//动态弹窗
		chooseSize: false,
		animationData: {}
	},




	chooseSezi: function(e) {
		// 这是一个弹窗动画
		// 用that取代this，防止不必要的情况发生
		var that = this;
		// 创建一个动画实例
		var animation = wx.createAnimation({
			// 动画持续时间
			duration: 500,
			// 定义动画效果，当前是匀速
			timingFunction: 'ease-out'
		})
		// 将该变量赋值给当前动画
		that.animation = animation
		// 先在y轴偏移，然后用step()完成一个动画
		animation.translateY(200).step()
		// 用setData改变当前动画
		that.setData({
			// 通过export()方法导出数据
			animationData: animation.export(),
			// 改变view里面的Wx：if
			chooseSize: true
		})
		// 设置setTimeout来改变y轴偏移量，实现有感觉的滑动
		setTimeout(function() {
			animation.translateY(0).step()
			that.setData({
				animationData: animation.export()
			})
		}, 200)
		// 获得点解定当默认的demand设置
		that.setData({
			orderDemand: that.data.order[e.currentTarget.dataset.type].demand
		})
		console.log("that.data.orderDemand")
		console.log(that.data.orderDemand)
		for (var i = 0; i < that.data.color.length; i++) {
			if (that.data.orderDemand.color == that.data.color[i])
				that.setData({
					onColor: i
				})
		}
		for (var i = 0; i < that.data.paper.length; i++) {
			if (that.data.orderDemand.paper === that.data.paper[i])
				that.setData({
					onPaper: i
				})
		}
		for (var i = 0; i < that.data.use.length; i++) {
			if (that.data.orderDemand.use ===that.data.use[i])
				that.setData({
					onUse: i
				})
		}
		that.setData({
			number: that.data.orderDemand.number,
			orderIndex:e.currentTarget.dataset.type
		})
	},
	hideModal: function(e) {
		// 这是一个弹窗弹回动画
		var that = this;
		var animation = wx.createAnimation({
			duration: 1000,
			timingFunction: 'ease-out'
		})
		that.animation = animation
		animation.translateY(200).step()
		that.setData({
			animationData: animation.export()

		})
		setTimeout(function() {
			animation.translateY(0).step()
			that.setData({
				animationData: animation.export(),
				chooseSize: false
			})
		}, 200)
		that.setData({
			orderDemand: {}
		})
	},



	remove: function(e) {
		// 删除
		var that = this
		console.log(that.data.order)
		var z = that.data.order
		console.log(z)
		z.splice((e), 1)
		console.log(z)
		that.setData({
			order: z,
		})
	},


	// 更改demand
	chooseColor: function(e) {
		var n = parseInt(e.currentTarget.dataset.type);
		var x = this.data.orderDemand
		// console.log(x)
		// console.log(e)
		// console.log(n)
		x.color = this.data.color[n]
		// console.log(x)
		this.setData({
			orderDemand: x,
			onColor: n
		})
	},
	choosePaper: function(e) {
		var n = parseInt(e.currentTarget.dataset.type);
		var x = this.data.orderDemand
		x.use = this.data.use[n]
		this.setData({
			orderDemand: x,
			onPaper: n
		})
	},
	chooseUse: function(e) {
		var n = parseInt(e.currentTarget.dataset.type);
		var x = this.data.orderDemand
		x.paper = this.data.paper[n]
		this.setData({
			orderDemand: x,
			onUse: n
		})
	},
	printNumber: function(e) {	
		console.log(e);
		var x = e.detail.value
		var y = this.data.orderDemand
		if (x == undefined) {
			return 0
			console.log("11111")
		} else if (x == "") {
			console.log("22222")
			y.number = null
			this.setData({
				orderDemand: y
			})
		} else {
			y.number = x
			this.setData({
				orderDemand: y
			})
	
		}
	},
	printUserPage: function(e) {
		var x = e.detail.value
		var y = this.data.orderDemand
		if (x == undefined) {
			return 0
			console.log("11111")
		} else if (x == "") {
			console.log("22222")
			y.userPage = null
			this.setData({
				orderDemand: y
			})
		} else {
			y.userPage = x
			this.setData({
				orderDemand: y
			})
	
		}
	},
	goback_confirm: function() {
		var that = this
		var x = that.data.orderDemand
		var y=that.data.order
		if (x.number == null||x.number <= 0) {
			x.number = that.data.number
		}
		if (x.userPage <= 0||x.userPage==null) {
			x.userPage = that.data.number
		}
		y.demand=x
		that.setData({
			order:y
		})
		that.hideModal()
	},
	goTrade:function(){
		var that=this
		var order=JSON.stringify(that.data.order)
		console.log(order)
		order = encodeURIComponent(order)
		console.log(order)
		wx.navigateTo({
			url: "../trade/trade?order="+order +"&Index="+that.data.Index+"&printIndex="+that.data.printIndex,
		})
	},
	/**
	 * 生命周期函数--监听页面加载
	 */
	onLoad: function(options) {
		// 获得打印店面以及打印机的信息
		var that = this
		that.setData({
			Index: options.Index,
			printIndex: options.printIndex
		})
		//打印机信息的获得
		wx.request({
			url: "http://92.68.50.32:8206/api/file/api/printShop/getAll",
			method: "GET",
			header: {
				'content-type': 'application/json' // 默认值
			},
			success: function(res) {
		var x=JSON.parse(res.data[options.Index].printerConfig)
		console.log(x)
				that.setData({
					location: res.data,
					color:x.color,
					paper:x.paper,
					use:x.use,
				})
				
			}
		})
		// 解析打印机的信息
		var order = JSON.parse(options.order)
		that.setData({
			order: order
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
