// pages/historicalOrder/historicalOrder.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    operationTextDisplay: [],
    operationText: [],
    operationbindtap: [],
    printOrderArray: {},
    shopCartArray: {},
    printShopName: "",
    printShopUrl: "http://qzimp.cn/api/file/api/printShop/getAll",
    shopCartUrl: "http://qzimp.cn/api/file/api/shopCart/findByStudentId?studentId=",
    deleteShopCartUrl: "http://qzimp.cn/api/file/api/shopCart/delete?id=",
    refundShopCartUrl: "http://qzimp.cn/api/file/api/wechatPay/cancelOrder"
  },
  /**
   * 生命周期函数--监听页面加载
   */
  confirmReceipt: function(event) {
    var shopCart = event.currentTarget.dataset.index
    var orders = shopCart.printOrders
    var that = this
    wx.showModal({
      title: '提示',
      content: '确认收货嘛',
      success: function(res) {
        if (res.confirm) {
          shopCart.status = '确认收货'
          for (var i = 0; i < orders.length; i++) {
            orders.status = '确认收货'
          }
          wx.request({
            url: 'http://qzimp.cn/api/file/api/shopCart/update',
            method: "POST",
            header: {
              'content-type': 'application/json' // 默认值
            },
            data: JSON.stringify(shopCart),
            success: function() {
              console.log(shopCart)
              var operationTextDisplay=[]
              var operationText=[]
              console.log(operationTextDisplay)
              operationTextDisplay.push("display:none;");
              operationText.push("");
              that.setData({
                operationTextDisplay: operationTextDisplay,
                operationText: operationText,
              })
              that.onLoad()
              console.log(operationTextDisplay)
              console.log("success");
            }
          })
        } else if (res.cancel) {}
      }
    })
  },
  tohistoricalOrderDetail: function(event) {
    var shopCart = event.currentTarget.dataset.index
    wx.navigateTo({
      url: "../historicalOrderDetail/historicalOrderDetail?shopCart=" + JSON.stringify(shopCart),
    })
  },
  pay: function(event) {
    var that = this
    var App = getApp()
    var openid = App.globalData.user.wxopenid
    var reward = event.target.dataset.index.totalFee
    var orderNo = event.target.dataset.index.orderNo
    wx.request({
      url: 'http://qzimp.cn/api/file/api/wechatPay/placeOrder',
      method: "POST",
      data: {
        openid: openid,
        reward: Number(reward) * 100,
        //reward: 1,
        orderNo: orderNo
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      success: function(res) {
        wx.requestPayment({
          timeStamp: res.data.timeStamp,
          nonceStr: res.data.nonceStr,
          package: res.data.package,
          signType: res.data.signType,
          paySign: res.data.paySign,
          success(res) {
            wx.navigateTo({
              url: "../historicalOrder/historicalOrder",
            })
            wx.showToast({
              title: '支付成功',
              icon: 'success',
              duration: 2000
            })
          },
          fail(res) {
            wx.navigateTo({
              url: "../historicalOrder/historicalOrder",
            })
            wx.showToast({
              title: '支付失败',
              icon: 'loading',
              duration: 2000
            })
          }
        })
      }
    })
  },
  deleteOrder: function(event) {
    var that = this;
    wx.showModal({
      title: '提示',
      content: '确认要删除该订单嘛?',
      success: function(res) {
        if (res.confirm) {
          wx.request({
            url: that.data.deleteShopCartUrl + event.target.dataset.index,
            method: "POST",
            header: {
              'content-type': 'application/json'
            },
            success: function(res) {
              if (res.data == '删除成功') {
                wx.navigateTo({
                  url: "../historicalOrder/historicalOrder",
                })
                wx.showToast({
                  title: '删除成功',
                  icon: 'success',
                  duration: 2000
                })
              }
            }
          })
        }
      }
    })
  },
  refund: function(event) {
    var that = this;
    var shopCart = event.target.dataset.index;
    var out_trade_no = shopCart.orderNo;
    var total_fee = shopCart.totalFee*100;
    wx.showModal({
      title: '提示',
      content: '确认要退款嘛?',
      success: function(res) {
        if (res.confirm) {
          wx.request({
            url: that.data.refundShopCartUrl,
            method: "POST",
            data: {
              out_trade_no: out_trade_no,
              total_fee: 1
            },
            header: {
              'content-type': 'application/x-www-form-urlencoded'
            },
            success: function(res) {
              var msg = JSON.stringify(res.data);
              if (res.data == '退款成功') {
                wx.showToast({
                  title: '退款成功',
                  icon: 'success',
                  duration: 2000
                })
              } else {
                wx.showToast({
                  title: msg,
                  icon: 'success',
                  duration: 2000
                })
              }
            }
          })
        }
      }
    })
  },
  shopCart: function() {
    var that = this
    var App = getApp()
    wx.request({
      url: that.data.shopCartUrl + App.globalData.user.id,
      method: "POST",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function(res) {
        var length = res.data.length;
        var shopCartArray = res.data;
        let operationTextDisplay = that.data.operationTextDisplay;
        let operationText = that.data.operationText;
        let operationbindtap = that.data.operationbindtap;
        for (var i = 0; i < length / 2; i++) {
          var temp = shopCartArray[length - i - 1];
          shopCartArray[length - i - 1] = shopCartArray[i];
          shopCartArray[i] = temp;
        }
        for (var i = 0; i < length; i++) {
          if (shopCartArray[i].status == '未支付') {
            operationTextDisplay.push("");
            operationText.push("去支付");
            operationbindtap.push("pay");
          } else if (shopCartArray[i].status == '等待商家接单') {
            operationTextDisplay.push("");
            operationText.push("退款");
            operationbindtap.push("refund");
          } else if (shopCartArray[i].status == '商家已打印') {
            operationTextDisplay.push("");
            operationText.push("确认收货");
            operationbindtap.push("confirmReceipt");
          } else {
            operationTextDisplay.push("display:none;");
            operationText.push("");
            operationbindtap.push("");
          }
        }
        that.setData({
          shopCartArray: res.data,
          operationTextDisplay: operationTextDisplay,
          operationText: operationText,
          operationbindtap: operationbindtap
        })
      }
    })
  },
  printShopName: function() {
    var that = this
    wx.request({
      url: that.data.printShopUrl,
      method: "POST",
      header: {
        'content-type': 'application/json'
      },
      success: function(res) {
        that.setData({
          printShopName: res.data[0].name
        })
      }
    })
  },
  onLoad: function(options) {
    var that = this
    var App = getApp()
    var studentId = App.globalData.user.id;
    that.shopCart();
    that.printShopName();
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