// pages/trade/trade.js
Page({

	/**
	 * 页面的初始数据
	 */
  data: {
    money: 0,
    payment: true,
    error: true,
    user: {
    },
  },
  money: function () {
    var that = this
    var x = that.data.order
    var money = 0.0
    for (var i = 0; i < that.data.order.length; i++) {
      money = money + that.data.order[i].price
    }
    money = money / 100
    that.setData({
      money: money
    })
  },
  payment: function () {
    var that = this
    var App = getApp()
    var openid = that.data.user.wxopenid;
    var orderNo = that.data.order[0].orderNo
    wx.request({
      url: 'https://qzimp.cn/api/file/api/wechatPay/placeOrder',
      method: "POST",
      data: {
        openid: openid,
        reward: Number(that.data.money) * 100,
        //reward: 1,
        orderNo: orderNo
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      success: function (res) {
        wx.requestPayment({
          timeStamp: res.data.timeStamp,
          nonceStr: res.data.nonceStr,
          package: res.data.package,
          signType: res.data.signType,
          paySign: res.data.paySign,
          success(res) {
            wx.showToast({
              title: '支付成功',
              icon: 'success',
              duration: 2000
            })
            wx.navigateTo({
              url: "../historicalOrder/historicalOrder",
            })
          },
          fail(res) {
            wx.showToast({
              title: '支付失败',
              icon: 'success',
              duration: 2000
            })
            wx.navigateTo({
              url: "../historicalOrder/historicalOrder",
            })
          }
        })
      }
    })
  },
	/**
	 * 生命周期函数--监听页面加载
	 */
  onLoad: function (options) {
    var that = this
    var App = getApp()
    that.setData({
      sign: options.sign,
      printIndex: options.printIndex,
      user: App.globalData.user,
    })
    wx.request({
      url: "https://qzimp.cn/api/file/api/printShop/getAll",
      method: "GET",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          location: res.data,
        })
      }
    })
    var order = decodeURIComponent(options.order)
    order = JSON.parse(order)
    that.setData({
      order: order,
      money: 0,
    })
    that.money()
    var App = getApp()
    var name = App.globalData.user.name
    var phone = App.globalData.user.phone
    var dormitoryAdd = App.globalData.user.dormitoryAdd
    that.setData({
      name: name,
      phone: phone,
      dormitoryAdd: dormitoryAdd,
    })
  },

	/**
	 * 生命周期函数--监听页面初次渲染完成
	 */
  onReady: function () {

  },

	/**
	 * 生命周期函数--监听页面显示
	 */
  onShow: function () {

  },

	/**
	 * 生命周期函数--监听页面隐藏
	 */
  onHide: function () {

  },

	/**
	 * 生命周期函数--监听页面卸载
	 */
  onUnload: function () {

  },

	/**
	 * 页面相关事件处理函数--监听用户下拉动作
	 */
  onPullDownRefresh: function () {

  },

	/**
	 * 页面上拉触底事件的处理函数
	 */
  onReachBottom: function () {

  },

	/**
	 * 用户点击右上角分享
	 */
  onShareAppMessage: function () {

  }
})