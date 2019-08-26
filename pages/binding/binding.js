Page({

  /**
   * 页面的初始数据
   */
  data: {
    user:{

    },
    userInfo:{

    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    wx.getStorage({
      key: 'userInfo',
      success: function(res) {
        that.setData({
          userInfo:res.data
        })
        console.log(that.data.userInfo)
      },
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
  cancel:function(res){
    wx.reLaunch({
      url: '/pages/user/user',
    })
  },
  binding:function(res){
    var that=this;
    var app=getApp();
    var information = res.detail.value;
    if (information.name == "" || information.school == "" || information.number == "" || information.Professional==""){
      wx.showToast({
        title: '请检查信息是否完整!',
        image: '/images/Tpis.png'
      })
    }else{
      wx.login({
        success(res) {
          if (res.code) {
            information.code=res.code;
            //发起网络请求
            wx: wx.request({
              url: 'https://qzimp.cn/api/auth/bg/studentapi/binding',
              data: information,
              header: { 'content-type': 'application/x-www-form-urlencoded' },
              method: 'post',
              dataType: 'json',
              responseType: 'text',
              success: function (res) {
                console.log(res.data);
                if(res.data.id>0){
                  app.globalData.user = res.data;
                  wx.reLaunch({
                    url: '/pages/user/user',
                  })
                }else{
                  wx.showToast({
                    title: '找不到信息!',
                    image: '/images/Tpis.png'
                  })
                }
              },
              fail: function (res) { 
                wx.showToast({
                  title: '绑定异常!',
                  image: '/images/Tpis.png'
                })
              },
              complete: function (res) {

               },
            })
          }
        }
      })

    }
  }
})