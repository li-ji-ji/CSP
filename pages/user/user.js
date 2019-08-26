Page({

  /**
   * 页面的初始数据
   */
  data: {
    user: {

    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
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
    var that = this;
    var app = getApp();
    var user = app.globalData.user
    wx.getStorage({
      key: 'userInfo',
      success(res) {
        if (user.id > 0) {
          that.setData({
            user: user
          })
          console.log(that.data.user)
        } else {
          var name = res.data.nickName;
          var headImages = res.data.avatarUrl;
          var sex = res.data.gender;
          var userInfo = {
            "id": 0,
            "name": name,
            "hurl": headImages,
            "sex": sex,
            "school": "未绑定学校信息"
          }
          that.setData({
            user: userInfo
          })
        }
      },
      fail(res) {
        console.log(res.data);
        wx.reLaunch({
          url: '/pages/authorize/authorize'
        })
      }
    })
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
  MyRelease: function (res) {
    var that = this;
    if (that.data.user.id > 0) {
      var id = JSON.stringify(res.currentTarget.dataset.id);
      wx.navigateTo({
        url: '/pages/MyRelease/MyRelease?id=' + id
      })
    } else {
      wx.showToast({
        title: '请绑定信息',
        image: '/images/Tpis.png',
      })
    }
  },
  MyReceipt: function (res) {
    var that = this;
    if (that.data.user.id > 0) {
      var id = JSON.stringify(res.currentTarget.dataset.id);
      wx.navigateTo({
        url: '/pages/MyReceipt/MyReceipt?id=' + id
      })
    } else {
      wx.showToast({
        title: '请绑定信息',
        image: '/images/Tpis.png',
      })
    }

  },
  edit:function(res){
    var that=this;
    if (that.data.user.id>0){
      wx.navigateTo({
        url: '/pages/edit/edit'
      })
    }else{
      wx.showToast({
        title: '请绑定信息',
        image: '/images/Tpis.png',
      })
    }

  },
  binding:function(res){
    var that = this;
    if(that.data.user.id>0){
      wx.showToast({
        title: '信息已绑定',
        image: '/images/Tpis.png',
      })
    }else{
      wx.navigateTo({
        url: '/pages/binding/binding'
      })
    }
  },
  lookImages:function(res){
    var that = this;
    var urls = [that.data.user.hurl];
    wx.previewImage({
      urls: urls
    })
  },
  out:function(){
    wx.removeStorage({
      key: 'userInfo',
      success(res) {
        console.log(res)
        var app=getApp();
        app.globalData.userInfo={};
        wx.reLaunch({
          url: '/pages/user/user'
        })
      }
    })
  },
  wallet:function(){
    var that = this;
    if (that.data.user.id > 0) {
      wx.navigateTo({
        url: '/pages/MyWallet/MyWallet'
      })
    } else {
      wx.showToast({
        title: '请绑定信息',
        image: '/images/Tpis.png',
      })
    }
  },
  contact:function(){
    wx.showToast({
      title: '抱歉,建设中',
      image: '/images/Tpis.png',
    })
  }
  
})