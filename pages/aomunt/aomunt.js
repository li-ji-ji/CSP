// pages/aomunt/aomunt.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    choose: [],
    // 选择操作可视化  选中项数组
    sign: 0,
    url: "https://qzimp.cn/api/file/api/personFileInfo/findByStudentId?studentId=",
    userId:0
  },
  choose_img: function() {
    // 初始化选中文件的选中项数组(默认不显示)
    // 给每一个文件制作一个选择操作默认值
    this.setData({
      // 初始化选中项数组
      choose: []
    })
    var x = this.data.upArray.length

    // 使选中项数组的长度与文件数组的长度一致
    for (var i = 0; i < x; i++) {
      var y = {
        "choose": "none",
        "dis": "none",
        "fileId": this.data.upArray[i].id
      }
      this.setData({
        choose: this.data.choose.concat(y)
      })
    }
  },
  choose: function(e) {
    // 文件被选中时触发事件,并显示选中图片变化
    // 获得被选中的文件的序号
    var x = Number(e.currentTarget.dataset.type)
    // 获得已经制作好的选中项数组
    var y = this.data.choose
    // 选择炒作以及取消选择
    if (y[x].dis == "none") {
      y[x].choose = "in"
      y[x].dis = "block"
    } else {
      y[x].choose = "none"
      y[x].dis = "none"
    }
    this.setData({
      choose: y
    })
  },
  remove: function() {
    // 删除所选项
    // 获取文件数组长度
    var x = this.data.choose.length;
    // 获取文件
    var z = this.data.upArray
    // 获取选中项数组
    var y = this.data.choose
    // 文件减少变量
    var p = 0;
    // 删除选择的文件数组
    for (var i = 0; i < x; i++) {
      if (y[i].choose == "in") {
        wx.request({
          url: "https://qzimp.cn/api/file/api/personFileInfo/delete",
          // method: "POST",
          data: {
            id: y[i].fileId
          },
          header: {
            'content-type': 'application/json' // 默认值
          },
          success: function(res) {
            wx.showToast({
              title: '删除成功',
              icon: 'success',
              duration: 2000
            })
          }
        })

        p++
        // z.splice((i - p), 1)
      }
    }

    // 重新制作选择数组

    let pages = getCurrentPages() //获取页面数组

    let curPage = pages[pages.length - 1] //获取当前页

    curPage.onShow() //手动调用生命周期函数
  },
  order: function() {
    // 制作订单数组
    var that = this
    // 获取文件信息
    var x = this.data.choose.length;
    var y = this.data.choose
    var z = this.data.upArray
    var p = []
    var m = 0
    for (var i = 0; i < x; i++) {
      if (y[i].choose == "none") {
        m++
      }
      if (m == x) {
        wx.showModal({
          title: '提示',
          content: '请勾选文件',
        })
        return 0
      }
    }
    // 制作订单
    for (var i = 0; i < x; i++) {
      if (y[i].choose == "in") {
        var App = getApp()
        var fileImage = String(z[i].fileImage)
        var contact = App.globalData.user.phone
        var studentId=App.globalData.user.id
        var deliveryAddress = App.globalData.user.dormitoryAdd
        var status = "未支付"
        var color = "黑白"
        var paper = "A4"
        var use = "单面"
        var storeAddress = this.data.location[this.data.sign].name
        var array = {
          "nickName":"",
          "orderNo": "",
          "studentId": studentId ,
          "fileName": String(z[i].fileName),
          "printMode": "一般打印",
          "printCopy": "1",
          "deliveryMode": "到店自取",
          "orderTime": "",
          "page": Number(z[i].page),
          "isUrgent": "不加急",
          "price": this.data.parse.black * (Number(z[i].page)*1)*100,
          "note": "",
          "contact": "515155115",
          "mobile": "12345678912",
          "storeAddress": storeAddress,
          "deliveryAddress": "655514515",
          "status": status,
          "filePath": String(z[i].path),
          "orderImage": fileImage,
          "color": "黑白",
          "paper": "A4",
          "side": "单面",
        }
        p[p.length] = array
      }
    }
    // 传输订单到订单页面
    wx.navigateTo({
      url: '../orderList/orderList?order=' + JSON.stringify(p) + "&sign=" + that.data.sign + "&printIndex=" + that.data.printIndex,
    })
  },
  userFile: function() {
    var that = this
    wx.request({
      url: that.data.url + that.data.userId,
      method: "POST",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function(res) {
        that.setData({
          upArray: res.data
        })
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this
    var App = getApp()
    //获得从homepage中获得的数据
    var upArray = JSON.parse(options.upArray)
    this.setData({
      upArray: upArray,
      sign: options.sign,
      printIndex: options.printIndex,
      userId: App.globalData.user.id
    })
    this.choose_img()
    wx.request({
      url: "https://qzimp.cn/api/file/api/printShop/getAll",
      method: "GET",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function(res) {
        that.setData({
          location: res.data,
          parse: JSON.parse(res.data[options.sign].price)
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    this.userFile()
    this.choose_img()
  },
  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})