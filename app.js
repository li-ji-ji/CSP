//app.js
App({

  /**
   * 当小程序初始化完成时，会触发 onLaunch（全局只触发一次）
   */
  onLaunch: function () {
    // wx.getStorage({
    //   key: 'userInfo',
    //   success(res) {
    //     that.globalData.userInfo = res.data;
    //     console.log(that.globalData.userInfo);
    //   },
    //   fail(res){
    //     console.log(res.data);
    //     wx.reLaunch({
    //         url: '/pages/authorize/authorize'
    //       })
    //   }
    // })
    
  },
  /**
   * 当小程序启动，或从后台进入前台显示，会触发 onShow
   */
  onShow: function (options) {
    var that=this;
    wx.getStorage({
      key: 'userInfo',
      success(res) {
        var wxname = res.data.nickName;
        var hurl = res.data.avatarUrl;
        var sex = res.data.gender;
        var isAuthorized = true;
        var user = {
          id: 0,
          wxname: wxname,
          hurl: hurl,
          sex: sex,
          school: "未绑定学校信息",
          isAuthorized: isAuthorized
        }
        that.globalData.user=user

      },
      fail(res) {
        that.globalData.user.isAuthorized = false;
      }
    })
    if (that.globalData.user.isAuthorized) {
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
                that.globalData.user = user;
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
      id: 0,
      wxname: "游客",
      hurl: "/images/defaultHeaderImage.png",
      sex: "1",
      school: "未绑定学校信息",
      isAuthorized:false
    }
  }
})
