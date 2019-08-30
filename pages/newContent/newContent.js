Page({

  /**
   * 页面的初始数据
   */
  data: {
    newContent: {},
    comments: [],
    commentors: [],
    user: {},
    newTime: "",
    detail:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var app = getApp();
    that.setData({
      user: app.globalData.user
    })
    wx.getStorage({
      key: 'newsContent',
      success: function (res) {
        that.setData({
          newContent: res.data
        })
        console.log(that.data.newContent)
        wx.request({
          url: 'https://qzimp.cn/api/assist/updateNewsHits',
          data: {
            "id": that.data.newContent.id
          },
          success: function (res) {
            var comment = that.comment();
            comment;
          }
        })
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
  comment: function () {
    var that = this;
    var newsId = that.data.newContent.id;
    console.log(newsId);
    wx: wx.request({
      url: 'https://qzimp.cn/api/assist/findAllCommentByNewsId',
      data: {
        "newsId": that.data.newContent.id
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'post',
      dataType: 'json',
      responseType: 'text',
      success: function (res) {
        that.setData({
          comments: res.data
        })
        var ids = [];
        for (var i = 0; i < res.data.length; i++) {
          ids = ids.concat(parseInt(res.data[i].commentorId))
        }
        var idsStr = JSON.stringify(ids);
        wx: wx.request({
          url: 'https://qzimp.cn/api/auth/bg/studentapi/selectStudentBatch',
          data: {
            "ids": idsStr
          },
          header: {
            'content-type': 'application/x-www-form-urlencoded'
          },
          method: 'post',
          dataType: 'json',
          responseType: 'text',
          success: function (res) {
            that.setData({
              commentors: res.data
            })
          }
        })
      }

    })
  },
  commentSumbmit: function (res) {
    var that = this;
    var getNewDate = that.getNewDate()
    getNewDate;
    var commentText = res.detail.value
    commentText.commentTime = that.data.newTime
    var commentStr = JSON.stringify(commentText)
    console.log(commentStr)
    if (commentText.commentContent.length <= 25 && commentText.commentContent.length > 0 && commentText.commentContent!=""){
      wx: wx.request({
        url: 'https://qzimp.cn/api/assist/insertOneComment',
        data: commentStr,
        header: { 'content-type': 'application/json' },
        method: 'post',
        dataType: 'json',
        responseType: 'text',
        success: function (res) {
          if (res.data == 1) {
            wx: wx.showToast({
              title: '评论成功!',
              icon: 'success',
              duration: 1500,
              mask: true,
              success: function (res) { },
              fail: function (res) { },
              complete: function (res) { },
            })
            var comment = that.comment();
            comment;
            that.setData({
              detail: ""
            })
          } else {
            wx: wx.showToast({
              title: '评论失败!',
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
          wx: wx.showToast({
            title: '请求异常!',
            icon: 'success',
            duration: 1500,
            mask: true,
            success: function (res) { },
            fail: function (res) { },
            complete: function (res) { },
          })
        },
        complete: function (res) { },
      })
    }else{
      wx: wx.showToast({
        title: '评论不符合要求',
        image: '/images/Tpis.png',
        duration: 1500,
        mask: true,
        success: function (res) { },
        fail: function (res) { },
        complete: function (res) { },
      })
    }
  },
  getNewDate: function () {
    var that = this;
    var n = new Date();
    var y = n.getFullYear();
    var m = n.getMonth() + 1;
    var d = n.getDate();
    var h = n.getHours();
    var min = n.getMinutes();
    var s = n.getSeconds();
    console.log(n + y + m + d + h + min + s);
    that.setData({
      newTime: y + "-" + m + "-" + d + " " + h + ":" + min
    })
  }
})