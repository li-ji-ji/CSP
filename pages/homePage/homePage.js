// pages/homePage/homePage.js
Page({

	/**
	 * 页面的初始数据
	 */

  data: {
    //当前店面的数标
    printIndex: 0, //当前打印机的数标
    upArray: [], //s上传元素组成的数组
    error_dis: "none", //判断文件是否出错
    aheadUp_dis: "none",
    sign: 0,
    printNumber: 0, //
    frameNumber: 0,
    orderNumber: 0, //我的文件数
    printname: [],
    char_lt: "<",
    location: [], //店面数据
    array: {},
    ican: null,
    url: "https://qzimp.cn/api/file/api/personFileInfo/findByStudentId?studentId=",
    shopCartUrl: "https://qzimp.cn/api/file/api/shopCart/findByStudentId?studentId=",
  },

  display_error: function () {
    //错误弹窗(未启用)
    var x = this.data.error_dis;
    if (x == "none") {
      this.setData({
        error_dis: "block"
      })
    }
    if (x == "block") {
      this.setData({
        error_dis: "none"
      })
    }
  },
  goAomunt: function () {
    //跳转到订单页面
    var that = this
    var App = getApp()
    // that.setData({
    //   aheadUp_dis: "none"
    // })
    var upArray = JSON.stringify(this.data.upArray)
    // 数据传输
    var userId = App.globalData.user.id
    if(userId==undefined){
      wx.showModal({
        title: '提示',
        content: '请先去用户中心绑定信息',
        success: function (res) {
          if (res.confirm) {
            wx.reLaunch({
              url: '/pages/user/user'
            })
          } else if (res.cancel) {
          }
        }
      })
    }else{
      wx.navigateTo({
        url: "../aomunt/aomunt?sign=" + this.data.sign + "&printIndex=" + this.data.printIndex + "&upArray=" + JSON.stringify(that.data.upArray),
      })
    }
  },
  goorderList: function () {
    //我的购物
    wx.navigateTo({
      url: '../orderList/orderList?sign=' + this.data.sign + "&printIndex=" + this.data.printIndex
    })
  },
  goShopping: function () {
    //我的店面
    var location = JSON.stringify(this.data.location)
    wx.navigateTo({
      url: "../shooping/shopping?location=" + location,
    })
    this.setData({
      printIndex: 0
    })

  },
  gohistoricalOrder: function () {

    wx.navigateTo({
      url: '../historicalOrder/historicalOrder',
    })
  },
  getImg: function () {
    // 跳转到up页面上传文件
    var that = this
    // 跳转到up页面
    var App = getApp()
    var userId = App.globalData.user.id;
    if (userId == undefined) {
      wx.showModal({
        title: '提示',
        content: '请先去用户中心绑定信息',
        success: function (res) {
          if (res.confirm) {
            wx.reLaunch({
              url: '/pages/user/user'
            })
          } else if (res.cancel) {
          }
        }
      })
    }else{
      wx.navigateTo({
        url: '../up/up',
      })
    }
  },
  bindPickerChange: function (e) {
    this.setData({
      printIndex: e.detail.value
    })
  },
  printArray: function () {
    //建立店面打印机信息数组
    var x = 0
    var y = this.data.location[x].prints.length
    var z = [];
    for (var i = 0; i < y; i++) {
      z[i] = this.data.location[x].prints[i].printName;
    }

    this.setData({
      printname: z
    })
  },
  userFile: function () {
    var that = this
    var App = getApp()
    wx.request({
      url: that.data.url + App.globalData.user.id,
      method: "POST",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          upArray: res.data
        })
        that.orderNumberMonitoring()
      }
    })
  },
  printOrder: function () {
    var that = this
    var App = getApp()
    wx.request({
      url: that.data.shopCartUrl + App.globalData.user.id,
      method: "POST",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          frameNumber:res.data.length
        })
      }
    })
  },
  orderNumberMonitoring: function () {
    //获得当前upArray的长度
    var that = this
    that.setData({
      orderNumber: that.data.upArray.length
    })
  },


	/**
	 * 生命周期函数--监听页面加载
	 */
  onLoad: function (options) {
    // 获得服务器上的数据
    var that = this
    var App = getApp()
    that.setData({
      userId: App.globalData.user.id
    })
    if(that.data.userId != undefined){
      that.userFile()
      that.printOrder()
    }
    if (options.sign != undefined) {
      that.setData({
        sign: options.sign
      })
    }
    wx.request({
      url: "https://qzimp.cn/api/file/api/printShop/getAll",
      method: "GET",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          location: res.data
        })
        that.printArray()
      }
    })
    
    wx.getStorage({
      key: 'ican',
      success(res) {
      }
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
    var that = this
    wx.request({
      url: "https://qzimp.cn/api/file/api/printShop/getAll",
      method: "GET",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        that.setData({
          location: res.data
        })
        that.printArray()
      }
    })
    if(that.data.userId!=undefined){
      that.userFile()
    }
    //获得数据
    wx.getStorage({
      // 从up中获得数据，ican判断这个数据是否储存
      key: 'ican',
      success: function (ires) {
        if (ires.data == "yes") {
          //当这个数据可以存储时获得array（服务器传回来的数据）
          wx.getStorage({
            key: 'array',
            success: function (res) {
              var array = JSON.stringify(res.data)
              wx.request({
                url: "https://qzimp.cn/api/file/api/personFileInfo/insert",
                method: "POST",
                header: {
                  'content-type': 'application/json' // 默认值
                },
                data: array,
                success: function () {
                  that.userFile()
                }
              })
              that.setData({
                ican: "no"
              })
              // 将判断标记初始化
              wx.setStorage({
                key: "ican",
                data: "no"
              })
            }
          })
        }
      }
    })

  },

})
