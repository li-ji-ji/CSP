Page({

  /**
   * 页面的初始数据
   */
  data: {
    item: {},
    user: {}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    var app = getApp();
    console.log(options)
    var item = JSON.parse(options.taskJson)
    that.setData({
      item: item,
      user: app.globalData.user
    })
    console.log(that.data.item)
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

  },
  formPay: function(res) {
    var that = this;
    var itemObj = that.data.item;
    itemObj.taskRemarks = res.detail.value.remarks;
    that.setData({
      item: itemObj
    })
    if (that.data.item.taskType == 1) {
      var publish = that.publish();
      publish;
    } else {
      var taskPublish = that.taskPublish();
      taskPublish;
    }
    console.log(res.detail.value.remarks)
    wx.showLoading({
      title: '支付中',
    })

  },
  publish: function() {
    var that = this;
    var taskJson = that.data.item;
    console.log(taskJson);
    var taskJsonStr = JSON.stringify(taskJson);
    var wxPay = that.wxPay(taskJsonStr)
    wxPay;
  },
  preview: function() {
    var that = this;
    wx.previewImage({
      urls: that.data.item.images,
    })
  },
  taskPublish: function() {
    var that = this;
    var taskJson = that.data.item;
    var images = taskJson.images;
    var taskJsonStr = JSON.stringify(taskJson);
    var wxPay = that.wxPay(taskJsonStr)
    wxPay;
  },
  wxPay: function(res) {
    var that = this
    var openid = that.data.user.wxopenid
    wx: wx.request({
      url: 'https://qzimp.cn/api/task/placeOrder',
      data: {
        "data": res,
        "openid": openid,
        "reward": that.data.item.taskReward
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'post',
      dataType: 'json',
      responseType: 'text',
      success: function(res) {
        console.log(res);
        if (res.data.code == "SUCCESS") {
          wx.requestPayment({
            timeStamp: res.data.timeStamp,
            nonceStr: res.data.nonceStr,
            package: res.data.package,
            signType: res.data.signType,
            paySign: res.data.paySign,
            success: function(res) {
              console.log(res);
              if (res.errMsg == "requestPayment:ok") {
                wx.showToast({
                  title: '支付成功!',
                  success: function (res) {
                    wx.redirectTo({
                      url: '/pages/MyRelease/MyRelease',
                    })
                  }
                })
              }
            },
            fail: function(res) {
              console.log(res)
              wx.showToast({
                title: '支付已取消!',
                icon: 'none',
                success:function(res){
                  wx.redirectTo({
                    url: '/pages/MyRelease/MyRelease',
                  })
                }
              })
            },
            complete: function(res) {
              setTimeout(function() {
                wx.hideLoading()
              }, 2000)
            }
          })
        } else {
          wx.hideLoading();
          wx.showToast({
            title: '支付异常!',
            icon: 'none'
          })
        }
      },
      fail: function(res) {},
      complete: function(res) {},
    })
  }
})