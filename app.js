//app.js
App({

  /**
   * 当小程序初始化完成时，会触发 onLaunch（全局只触发一次）
   */
  onLaunch: function () {
    var that=this;
    console.log(that.globalData.user.userID);
    wx.getStorage({
      key: 'userInfo',
      success(res) {
        that.globalData.userInfo = res.data;
        console.log(that.globalData.userInfo);
      },
      fail(res){
        console.log(res.data);
        wx.reLaunch({
            url: '/pages/authorize/authorize'
          })
      }
    })
  },
  userLogin:function(){
    var that=this;
    if (that.globalData.user.id > 0) {
    } else {
      wx.login({
        success(res) {
          if (res.code) {
            //发起网络请求
            wx: wx.request({
              url: 'http://qzimp.cn/api/auth/bg/studentapi/login',
              data: {
                code: res.code
              },
              header: { 'content-type': 'application/x-www-form-urlencoded' },
              method: 'post',
              dataType: 'json',
              responseType: 'text',
              success: function (res) {
                that.globalData.user = res.data
              },
              fail: function (res) {
                wx.showToast({
                  title: '绑定失败!',
                  icon: 'none'
                })
              },
              complete: function (res) {

              },
            })
          }
        }
      })
    }
  },

  /**
   * 当小程序启动，或从后台进入前台显示，会触发 onShow
   */
  onShow: function (options) {
    var that=this;
    var userLogin = that.userLogin();
    userLogin;
  },

  /**
   * 当小程序从前台进入后台，会触发 onHide
   */
  onHide: function () {
    
  },

  /**
   * 当小程序发生脚本错误，或者 api 调用失败时，会触发 onError 并带上错误信息
   */
  onError: function (msg) {
    
  },
  globalData: {
    userInfo: {
      avatarUrl:"",
      city:"",
      gender:"",
      language :"",
      nickName:"",
      province:""
    },
    user: {
      id: 0
    }
  }
})
