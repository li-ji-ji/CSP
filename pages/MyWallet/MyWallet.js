Page({

  /**
   * 页面的初始数据
   */
  data: {
    wallet:{},
    user:{}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    var app=getApp();
    var user = app.globalData.user;
    that.setData({
      user:user
    })
    var refresh=that.refresh();
    refresh;
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
    var that=this;
    var refresh = that.refresh();
    refresh;
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
  refresh:function(){
    var that=this;
    wx: wx.request({
      url: 'https://qzimp.cn/api/task/getWallet',
      data: {
        "openid": that.data.user.wxopenid,
        "id": that.data.user.id,
        "name": that.data.user.name
      },
      header: { 'content-type': 'application/x-www-form-urlencoded' },
      method: 'post',
      dataType: 'json',
      responseType: 'text',
      success: function (res) {
        console.log(res);
        if (res.data != "fail") {
          that.setData({
            wallet: res.data
          })
        } else {
          wx.showToast({
            title: '找不到钱包,稍后再试',
            icon: 'none'
          })
        }
      },
      fail: function (res) {
        wx.showToast({
          title: '请求异常!',
          icon: 'none'
        })
      },
      complete: function (res) {

      },
    })
  }

})