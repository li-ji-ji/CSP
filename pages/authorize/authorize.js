Page({

  /**
   * 页面的初始数据
   */
  data: {

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
  login: function (res) {
    var that = this;
    var app = getApp();
    if (res.detail.userInfo) {
      var wxname = res.detail.userInfo.nickName;
      var hurl = res.detail.userInfo.avatarUrl;
      var sex = res.detail.userInfo.gender;
      var isAuthorized = true;
      var user = {
        id: 0,
        wxname: wxname,
        hurl: hurl,
        sex: sex,
        school: "未绑定学校信息",
        isAuthorized: isAuthorized
      }
      app.globalData.user = user
      wx.setStorage({
        key: 'userInfo',
        data: res.detail.userInfo,
      })
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
                if (res.data.id > 0) {
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
                }
              },
              fail: function (res) {
                wx.showToast({
                  title: '绑定失败!',
                  icon: 'none'
                })
              },
              complete: function (res) {
                wx.reLaunch({
                  url: '/pages/taskList/taskList'
                })
              },
            })
          }
        }
      })
    } else {
      wx.showToast({
        title: '取消授权',
        icon: 'none',
      })
    }
  },
  userLogin: function () {
    var that = this;
    var app = getApp();
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
              if (res.data.id > 0) {
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
              }
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
})