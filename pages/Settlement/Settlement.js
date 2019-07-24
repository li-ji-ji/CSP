Page({

  /**
   * 页面的初始数据
   */
  data: {
    item: {},
    num: 0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    console.log(options)
    var item = JSON.parse(options.taskJson)
    var num = JSON.parse(options.num)
    that.setData({
      item: item,
      num: num
    })
    console.log(that.data.item)
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

  },
  formPay: function (res) {
    var that = this;
    console.log(res.detail.value.remarks)
    wx.showLoading({
      title: '支付中',
    })
    wx.login({
      success(res) {
        if (res.code) {
          //发起网络请求
          wx: wx.request({
            url: 'http://244z00029g.zicp.vip/getOpenId',
            data: {
              code: res.code,
              reward: that.data.item.taskReward
            },
            header: { 'content-type': 'application/x-www-form-urlencoded' },
            method: 'post',
            dataType: 'json',
            responseType: 'text',
            success: function (res) {
              console.log(res);
              if (res.data.code == "SUCCESS") {
                wx.requestPayment({
                  timeStamp: res.data.timeStamp,
                  nonceStr: res.data.nonceStr,
                  package: res.data.package,
                  signType: res.data.signType,
                  paySign: res.data.paySign,
                  success: function (res) {
                    console.log(res);
                    if (res.errMsg=="requestPayment:ok"){
                      wx.showToast({
                        title: '支付成功!'
                      })
                      var publish = that.publish();
                      publish;
                    }
                  },
                  fail: function (res) {
                    console.log(res)
                    wx.showToast({
                      title: '支付已取消!',
                      icon: 'none',
                    })
                  },
                  complete: function (res) {
                    setTimeout(function () {
                      wx.hideLoading()
                    }, 2000)
                  }
                })
              }
            },
            fail: function (res) { },
            complete: function (res) { },
          })
        }
      }
    })
    // wx.requestPayment({
    //   timeStamp: '',
    //   nonceStr: '',
    //   package: '',
    //   signType: 'MD5',
    //   paySign: '',
    //   success(res){
    //     console.log(res)
    //   }
    // })
  },
  publish: function () {
    var that = this;
    var taskJson = that.data.item;
    console.log(taskJson)
    wx: wx.request({
      url: 'http://244z00029g.zicp.vip/PublishingTasks',
      data: taskJson,
      header: { 'content-type': 'application/x-www-form-urlencoded' },
      method: 'post',
      dataType: 'json',
      responseType: 'text',
      success: function (res) {
        console.log(res.data)
        var superiortaskId = res.data;
        var expresses = that.data.item.expresses;
        for (var i = 0; i < expresses.length; i++) {
          expresses[i].superiortaskId = superiortaskId;
        }
        console.log(JSON.stringify({ "expresses": expresses }));
        wx: wx.request({
          url: 'http://244z00029g.zicp.vip/insertExpressList',
          data: { "expresses": JSON.stringify({ "expresses": expresses }) },
          header: { 'content-type': 'application/x-www-form-urlencoded' },
          method: 'post',
          dataType: 'json',
          responseType: 'text',
          success: function (res) {
            if (res.data > 0) {
              wx: wx.showToast({
                title: '下单成功!',
                icon: 'success',
                duration: 1500,
                mask: true,
                success: function (res) { },
                fail: function (res) { },
                complete: function (res) { },
              })
            }

          },
          fail: function (res) {

          },
          complete: function (res) {

          },
        })
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  }
})