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
  onLoad: function (options) {
    var that = this;
    var app = getApp();
    var user = app.globalData.user
    that.setData({
      user: user
    })
    console.log(that.data.user)
    var item = JSON.parse(options.item);
    that.setData({
      item: item
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

  },
  receipt: function (res) {
    var that=this;
    var taskreward = res.currentTarget.dataset.taskreward;
    var taskid = res.currentTarget.dataset.taskid
    wx.showModal({
      title: '提示',
      content: '接单后如因您主观原因取消订单,则2小时内不能接单,如对方主观原因友好协商,让对方主动取消订单。此订单您可以赚到抽佣后的' + taskreward + '元,是否确定接单?',
      success: function (res) {
        if (res.confirm) {
          var receiverid = that.data.user.userId
          console.log('用户点击确定')
          wx: wx.request({
            url: 'http://244z00029g.zicp.vip/acceptTask',
            data: {
              "taskid": taskid,
              "receiverid": receiverid
            },
            header: {
              'content-type': 'application/x-www-form-urlencoded'
            },
            method: 'post',
            dataType: 'json',
            responseType: 'text',
            success: function (res) {
              console.log(res.data)
              if(res.data==true){
                wx: wx.showToast({
                  title: '接单成功',
                  icon: 'success',
                  duration: 1500,
                  mask: true,
                })
              }else{
                wx: wx.showToast({
                  title: '您下手太慢',
                  icon: 'none',
                  duration: 1500,
                  mask: true,
                })
              }
            },
            fail: function (res) {

            },
            complete: function (res) {

            },
          })
          wx.navigateBack({
            delta:1
          })
        } else if (res.cancel) {
          wx: wx.showToast({
            title: '取消接单',
            icon: 'none',
            duration: 1500,
            mask: true,
          })
        }
      }
    })


  }
})