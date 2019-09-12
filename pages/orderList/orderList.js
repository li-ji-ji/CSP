// pages/orderList/orderList.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    price:0,
    orderDemand: {},
    sign: null,
    printIndex: null,
    orderIndex: null,
    color: [],
    paper: [],
    side: [],
    isUrgent: ["加急", "不加急"],
    display: "none",
    printCopy: null,
    //点击
    onColor: null,
    onPaper: null,
    onUse: null,
    onIsUrgent: null,
    onPrintMode: null,
    //动态弹窗
    chooseSize: false,
    animationData: {},
    trade: [],
    delivery: true,
    door: false,
    user: {},
    choose: ["送货上门", "到店自取"],
    chooseId: 0,
    deliveryMode: "送货上门",
    error_cause: "",
    test: {
      orderNo: "2342o3u42sdafjlk",
      totalFee: 0,
      studentId: 0,
      status: "未支付",
    },
  },
  display: function() {
    this.setData({
      display: "none"
    })
  },
  name: function(e) {
    var x = e.detail.value
    var y = this.data.user
    y.name = x
    this.setData({
      user: y
    })
  },
  number: function(e) {
    var x = e.detail.value
    var y = this.data.user
    y.phone = x
    this.setData({
      user: y
    })
  },
  address: function(e) {
    var x = e.detail.value
    var y = this.data.user
    y.address = x
    this.setData({
      user: y
    })
  },
  choose: function(e) {
    var n = parseInt(e.currentTarget.dataset.type);
    var deliveryMode = this.data.deliveryMode
    if (n == 0) {
      this.setData({
        price: 0,
        delivery: true,
        door: false,
        deliveryMode: "送货上门",
        chooseId: n
      })
    } else {
      this.setData({
        delivery: false,
        door: true,
        deliveryMode: "到店自取",
        chooseId: n
      })
    }
  },
  chooseSezi: function(e) {
    // 这是一个弹窗动画
    // 用that取代this，防止不必要的情况发生
    var that = this;
    // 创建一个动画实例
    var animation = wx.createAnimation({
      // 动画持续时间
      duration: 500,
      // 定义动画效果，当前是匀速
      timingFunction: 'ease-out'
    })
    // 将该变量赋值给当前动画
    that.animation = animation
    // 先在y轴偏移，然后用step()完成一个动画
    animation.translateY(200).step()
    // 用setData改变当前动画
    that.setData({
      // 通过export()方法导出数据
      animationData: animation.export(),
      // 改变view里面的Wx：if
      chooseSize: true
    })
    // 设置setTimeout来改变y轴偏移量，实现有感觉的滑动
    setTimeout(function() {
      animation.translateY(0).step()
      that.setData({
        animationData: animation.export()
      })
    }, 200)
    // 获得点解定当默认的demand设置
    var x = {
      "color": that.data.order[e.currentTarget.dataset.type].color,
      "paper": that.data.order[e.currentTarget.dataset.type].paper,
      "side": that.data.order[e.currentTarget.dataset.type].side,
      "printCopy": that.data.order[e.currentTarget.dataset.type].printCopy,
      "isUrgent": that.data.order[e.currentTarget.dataset.type].isUrgent,
      "printMode": that.data.order[e.currentTarget.dataset.type].printMode,
    }
    that.setData({
      orderDemand: x
    })
    for (var i = 0; i < that.data.color.length; i++) {
      if (that.data.orderDemand.color == that.data.color[i])
        that.setData({
          onColor: i
        })
    }
    for (var i = 0; i < that.data.paper.length; i++) {
      if (that.data.orderDemand.paper === that.data.paper[i])
        that.setData({
          onPaper: i
        })
    }
    for (var i = 0; i < that.data.side.length; i++) {
      if (that.data.orderDemand.side === that.data.side[i])
        that.setData({
          onUse: i
        })
    }
    for (var i = 0; i < that.data.isUrgent.length; i++) {
      if (that.data.orderDemand.isUrgent == that.data.isUrgent[i])
        that.setData({
          onIsUrgent: i
        })
    }
    for (var i = 0; i < that.data.printMode.length; i++) {
      if (that.data.orderDemand.printMode === that.data.printMode[i])
        that.setData({
          onPrintMode: i
        })
    }
    that.setData({
      printCopy: that.data.orderDemand.printCopy,
      orderIndex: e.currentTarget.dataset.type
    })
  },
  hideModal: function(e) {
    // 这是一个弹窗弹回动画
    var that = this;
    var animation = wx.createAnimation({
      duration: 1000,
      timingFunction: 'ease-out'
    })
    that.animation = animation
    animation.translateY(200).step()
    that.setData({
      animationData: animation.export()

    })
    setTimeout(function() {
      animation.translateY(0).step()
      that.setData({
        animationData: animation.export(),
        chooseSize: false
      })
    }, 200)
    that.setData({
      orderDemand: {}
    })
  },



  remove: function(e) {
    // 删除
    var that = this
    wx.showModal({
      title: '提示',
      content: '确认删除吗',
      success: function(res) {
        if (res.confirm) {
          var z = that.data.order
          z.splice((e.currentTarget.dataset.type), 1)
          that.setData({
            order: z,
          })
        } else if (res.cancel) {}
      }
    })
  },


  // 更改demand
  chooseColor: function(e) {
    var n = parseInt(e.currentTarget.dataset.type);
    var x = this.data.orderDemand
    x.color = this.data.color[n]
    this.setData({
      orderDemand: x,
      onColor: n
    })
  },
  choosePaper: function(e) {
    var n = parseInt(e.currentTarget.dataset.type);
    var x = this.data.orderDemand
    x.paper = this.data.paper[n]
    this.setData({
      orderDemand: x,
      onPaper: n
    })
  },
  chooseUse: function(e) {
    var n = parseInt(e.currentTarget.dataset.type);
    var x = this.data.orderDemand
    x.side = this.data.side[n]
    this.setData({
      orderDemand: x,
      onUse: n
    })
  },
  chooseUrgent: function(e) {
    var n = parseInt(e.currentTarget.dataset.type);
    var x = this.data.orderDemand
    x.isUrgent = this.data.isUrgent[n]
    this.setData({
      orderDemand: x,
      onIsUrgent: n
    })
  },
  choosePrintMode: function(e) {
    var n = parseInt(e.currentTarget.dataset.type);
    var x = this.data.orderDemand
    x.printMode = this.data.printMode[n]
    this.setData({
      orderDemand: x,
      onPrintMode: n
    })
  },
  printNumber: function(e) {
    var x = e.detail.value
    var y = this.data.orderDemand
    if (x == undefined) {
      return 0
    } else if (x == "") {
      y.printCopy = null
      this.setData({
        orderDemand: y
      })
    } else {
      y.printCopy = x
      this.setData({
        orderDemand: y
      })

    }
  },
  goback_confirm: function() {
    var that = this
    var x = that.data.orderDemand
    var y = that.data.order
    if (x.printCopy == null || x.printCopy <= 0) {
      x.printCopy = that.data.printCopy
    }
    y[that.data.orderIndex].color = x.color
    y[that.data.orderIndex].paper = x.paper
    y[that.data.orderIndex].side = x.side
    y[that.data.orderIndex].isUrgent = x.isUrgent
    y[that.data.orderIndex].printMode = x.printMode
    y[that.data.orderIndex].printCopy = x.printCopy
    var m = 0
    if (y[that.data.orderIndex].color == "黑白") {
      if (y[that.data.orderIndex].side == "单面") {
        m = y[that.data.orderIndex].page * y[that.data.orderIndex].printCopy * Number(that.data.parse.black) * 100
      } else if (y[that.data.orderIndex].side == "双面") {
        m = Math.ceil(y[that.data.orderIndex].page * y[that.data.orderIndex].printCopy * 0.5) * Number(that.data.parse.black) * 100
      } else {
        ("字段出现问题1")
      }
    } else if (y[that.data.orderIndex].color == "彩色") {
      if (y[that.data.orderIndex].side == "单面") {
        m = y[that.data.orderIndex].page * y[that.data.orderIndex].printCopy * Number(that.data.parse.color) * 100
      } else if (y[that.data.orderIndex].side == "双面") {
        m = Math.ceil(y[that.data.orderIndex].page * y[that.data.orderIndex].printCopy * 0.5) * Number(that.data.parse.color) * 100
      } else {
        ("字段出现问题2")
      }
    } else {}
    if (y[that.data.orderIndex].isUrgent == "加急") {
      m += that.data.parse.urgent * 100
    }
    if (y[that.data.orderIndex].printMode == "论文打印"){
      m += that.data.parse.thesis * 100
    }

    y[that.data.orderIndex].price = m

    that.setData({
      order: y
    })
    that.hideModal()
  },
  goTrade: function() {
    var that = this
    var App = getApp()
    var ii = 0
    var order = that.data.order
    var price = that.data.price
    if (this.data.deliveryMode == "送货上门") {
      if (price == 0) {
        price = that.data.parse.deliveryMode * 100
        order[0].price += that.data.parse.deliveryMode * 100
      }
      if (that.data.user.name == "") {
        that.setData({
          error_cause: "昵称未输入",
          display: "block"
        })
        return 0
      }
      if (that.data.user.phone == null) {
        that.setData({
          error_cause: "联络方式未输入",
          display: "block"
        })
        return 0
      } else {
        if (that.data.user.phone.length != 11) {
          that.setData({
            error_cause: "联络方式输入错误",
            display: "block"
          })
          return 0
        }
      }
      if (that.data.user.address == "") {
        that.setData({
          error_cause: "地址未输入",
          display: "block"
        })
        return 0
      }
    }
    if (this.data.deliveryMode == "到店自取") {
      if(price>0){
        price -= that.data.parse.deliveryMode * 100
        order[0].price -= that.data.parse.deliveryMode * 100
      }
      if (that.data.user.name == "") {
        that.setData({
          error_cause: "昵称未输入",
          display: "block"
        })
        return 0
      }
      if (that.data.user.phone == null) {
        that.setData({
          error_cause: "联络方式未输入",
          display: "block"
        })
        return 0
      } else {
        if (that.data.user.phone.length != 11) {
          that.setData({
            error_cause: "联络方式输入错误",
            display: "block"
          })
          return 0
        }
      }
    }
    var shopCart = that.data.test
    shopCart.totalFee = 0;
    for (var i = 0; i < order.length; i++) {
      order[i].nickName = that.data.user.name
      order[i].contact = that.data.user.phone
      order[i].price = order[i].price
      shopCart.studentId = App.globalData.user.id
      shopCart.totalFee = shopCart.totalFee + order[i].price
      if (that.data.deliveryMode == "送货上门") {
        order[i].deliveryMode = "送货上门"
        order[i].deliveryAddress = that.data.user.dormitoryAdd
      } else {
        order[i].deliveryMode = "到店自取"
        order[i].deliveryAddress = ""
      }
      that.setData({
        price: price,
        order: order,
        test: shopCart
      })
    }
    wx.request({
      url: "https://qzimp.cn/api/file/api/shopCart/insert",
      method: "POST",
      header: {
        'content-type': 'application/json' // 默认值
      },
      data: JSON.stringify(that.data.test),
      success: function(res) {
        for (var i = 0; i < that.data.order.length; i++) {
          order[i].orderNo = res.data.orderNo
          that.setData({
            order: order
          })
        }
        for (var i = 0; i < that.data.order.length; i++) {
          wx.request({
            url: "https://qzimp.cn/api/file/api/printOrder/insert",
            method: "POST",
            header: {
              'content-type': 'application/json' // 默认值
            },
            data: JSON.stringify(order[i]),
            success: function(res) {
              ii++;
              if (ii == that.data.order.length)
                that.go()
            }
          })
        }
      }
    })
  },
  go: function() {
    var that = this
    var order = JSON.stringify(that.data.order)
    order = encodeURIComponent(order)
    wx.navigateTo({
      url: "../trade/trade?order=" + order + "&sign=" + that.data.sign + "&printIndex=" + that.data.printIndex,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    // 获得打印店面以及打印机的信息
    var that = this
    var App = getApp()
    that.setData({
      sign: options.sign,
      printIndex: options.printIndex,
      user: App.globalData.user
    })
    //打印机信息的获得
    wx.request({
      url: "https://qzimp.cn/api/file/api/printShop/getAll",
      method: "GET",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function(res) {
        var y = JSON.parse(res.data[options.sign].price)
        var x = JSON.parse(res.data[options.sign].printerConfig)
        that.setData({
          location: res.data,
          parse: y,
          color: x.color,
          paper: x.paper,
          side: x.side,
          printMode: x.printMode
        })

      }
    })
    // 解析打印机的信息
    var order = JSON.parse(options.order)
    that.setData({
      order: order
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
    this.setData({
      trade: []
    })
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