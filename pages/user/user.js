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
    var that=this;
    var app=getApp();
    if (app.globalData.user.isAuthorized) {
      wx.login({
        success(res) {
          if (res.code) {
            //发起网络请求
            wx: wx.request({
              url: 'https://qzimp.cn/api/auth/bg/studentapi/login',
              data: {
                code: res.code
              },
              header: { 'content-type': 'application/x-www-form-urlencoded' },
              method: 'post',
              dataType: 'json',
              responseType: 'text',
              success: function (res) {
                var user = {
                  dormitoryAdd: res.data.dormitoryAdd,
                  famillyAdd: res.data.famillyAdd,
                  grade: res.data.grade,
                  hurl: res.data.hurl,
                  id: res.data.id,
                  major: res.data.major,
                  name: res.data.name,
                  phone: res.data.phone,
                  school: res.data.school,
                  sex: res.data.sex,
                  sn: res.data.sn,
                  wxname: res.data.wxname,
                  wxopenid: res.data.wxopenid,
                  isAuthorized: true
                }
                app.globalData.user = user;
                that.setData({
                  user:app.globalData.user
                })
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
          that.setData({
            user: user
          })
      },
      fail(res) {
          that.setData({
            user: user
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
    if (this.data.user.isAuthorized){
      if (that.data.user.id > 0) {
        wx.showToast({
          title: '信息已绑定',
          image: '/images/Tpis.png',
        })
      } else {
        wx.navigateTo({
          url: '/pages/binding/binding'
        })
      }
    }else{
      wx.showToast({
        title: '请授权登录',
        image: '/images/Tpis.png',
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
        var app=getApp();
        app.globalData.userInfo={};
        var user =  {
          id: 0,
          wxname: "游客",
          hurl: "/images/defaultHeaderImage.png",
          sex: "1",
          school: "未绑定学校信息",
          isAuthorized:false
    }
        app.globalData.user = user;
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
  },
  toAuthorize:function(){
    wx.showModal({
      title: '授权登录',
      content: '授权将获取您的基本信息',
      cancelText:'暂不登录',
      cancelColor:'#CCCCCC',
      confirmText:'前往登录',
      confirmColor:'#FF0000',
      success: function(res) {
        if (res.confirm) {
          wx.navigateTo({
            url: '/pages/authorize/authorize'
          })
        } else if (res.cancel) {
          wx.showToast({
            title: '取消登录',
            icon: 'none',
          })
        }
      },
    })
  }  
})