Page({

  /**
   * 页面的初始数据
   */
  data: {
    user:{

    },
    inputKey:0
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var app = getApp();
    that.setData({
      user:app.globalData.user
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
  lookImages: function (res) {
    var that = this;
    var urls = [that.data.user.hurl];
    wx.previewImage({
      urls: urls
    })
  },
  updataWxName:function(res){
    var that=this;
    var app = getApp();
    //发起网络请求
    var data = res.detail.value;
    console.log(data);
    if (data.wxname==""){
      wx.showToast({
        title: '昵称不能为空!',
        image: '/images/Tpis.png',
      })
    }else{
      if (data.wxname.length>12){
        wx.showToast({
          title: '最大长度为12',
          image: '/images/Tpis.png',
        })
      }else{
        wx: wx.request({
          url: 'https://qzimp.cn/api/auth/bg/studentapi/updataUser',
          data: data,
          header: { 'content-type': 'application/x-www-form-urlencoded' },
          method: 'post',
          dataType: 'json',
          responseType: 'text',
          success: function (res) {
            if (res.data) {
              wx.showToast({
                title: '修改成功!'
              })
              app.globalData.user.wxname=data.wxname;
              that.setData({
                user: app.globalData.user,
                inputKey:0
              })
            } else {
              wx.showToast({
                title: '修改失败!',
                icon: 'none'
              })
            }
          },
          fail: function (res) {
            wx.showToast({
              title: '修改异常!',
              icon: 'none'
            })
          },
          complete: function (res) {

          },
        })
      }
    }
  },
  input:function(){
    var that=this;
    if(that.data.inputKey==0){
      that.setData({
        inputKey:1
      })
    }
  },
  updataImage:function(){
    var that = this;
    var app=getApp();
    wx.chooseImage({
      count:1,
      success: function (res) {
        var imagePath = res.tempFilePaths[0];

        wx.uploadFile({
          url: 'https://qzimp.cn/api/file/uploadFile', //仅为示例，非真实的接口地址
          filePath: imagePath,
          name: 'file',
          success(res) {
             imagePath = JSON.parse(res.data).data.src;
             var data={
               "id":that.data.user.id,
               "hurl":imagePath
             }
            wx: wx.request({
              url: 'https://qzimp.cn/api/auth/bg/studentapi/updataUser',
              data: data,
              header: { 'content-type': 'application/x-www-form-urlencoded' },
              method: 'post',
              dataType: 'json',
              responseType: 'text',
              success: function (res) {
                if (res.data) {
                  wx.showToast({
                    title: '修改成功!'
                  })
                  app.globalData.user.hurl = data.hurl;
                  that.setData({
                    user: app.globalData.user,
                  })
                } else {
                  wx.showToast({
                    title: '修改失败!',
                    icon: 'none'
                  })
                }
              },
              fail: function (res) {
                wx.showToast({
                  title: '修改异常!',
                  icon: 'none'
                })
              },
              complete: function (res) {

              },
            })
          }
        })
      },
    })
  }
})