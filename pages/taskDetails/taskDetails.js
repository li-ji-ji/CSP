Page({

  /**
   * 页面的初始数据
   */
  data: {
    item: {},
    user: {},
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var app = getApp();
    var user = app.globalData.user
    that.setData({
      user: user
    })
    console.log(that.data.user)
    var item = JSON.parse(options.item);
    that.setData({
      item: item
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
  receipt: function (res) {
    var that = this;
    var taskreward = res.currentTarget.dataset.taskreward;
    var taskid = res.currentTarget.dataset.taskid
    wx.showModal({
      title: '提示',
      content: '接单后如因您主观原因取消订单,则2小时内不能接单,如对方主观原因友好协商,让对方主动取消订单。此订单您可以赚到抽佣后的' + taskreward / 100 + '元,是否确定接单?',
      success: function (res) {
        if (res.confirm) {
          var receiverid = that.data.user.id
          wx: wx.request({
            url: 'http://244z00029g.zicp.vip/acceptTask',
            data: {
              "taskid": taskid,
              "receiverid": receiverid
            },
            header: {
              'content-type': 'application/x-www-form-urlencoded'
            },
            method: 'post',
            dataType: 'json',
            responseType: 'text',
            success: function (res) {
              console.log(res.data)
              if (res.data == true) {
                wx: wx.showToast({
                  title: '接单成功',
                  icon: 'success',
                  duration: 1500,
                  mask: true,
                })
              } else {
                wx: wx.showToast({
                  title: '您下手太慢',
                  icon: 'none',
                  duration: 1500,
                  mask: true,
                })
              }
            },
            fail: function (res) {

            },
            complete: function (res) {

            },
          })
          wx.navigateBack({
            delta: 1
          })
        } else if (res.cancel) {
          wx: wx.showToast({
            title: '取消接单',
            icon: 'none',
            duration: 1500,
            mask: true,
          })
        }
      }
    })


  },
  lookImages: function (res) {
    var that = this;
    var urls = [res.currentTarget.dataset.hurl];
    wx.previewImage({
      urls: urls
    })
  },
  lookContentImage: function (res) {
    var that = this;
    var urls = res.currentTarget.dataset.contentimages;
    wx.previewImage({
      current: that.data.current,
      urls: urls
    })
  },
  imagesItem: function (res) {
    console.log(res.currentTarget.dataset.imagesitem)
    var current = res.currentTarget.dataset.imagesitem
    var that = this;
    that.setData({
      current: current
    })
  },
  more: function (res) {
    var that = this;
    var taskStatus = res.currentTarget.dataset.status;
    var status = res.currentTarget.dataset.status;//任务状态: 0 准备状态,1 发布状态, 2 被接单状态,3 已完成状态,4 已结算状态 5 取消状态
    var identity = res.currentTarget.dataset.identity;//是否是发布者:false 接受者,true 发布者
    if (status == 1) { //发布状态
      if (identity) {
        wx.showActionSheet({
          itemList: ["取消发布", "联系客服"],
          success(res) {
            switch (res.tapIndex) {
              case 0:
                var orderNo = that.data.item.orderId
                var refundFee = that.data.item.taskReward;
                wx: wx.request({
                  url: 'http://244z00029g.zicp.vip/cancelTask',
                  data: {
                    "orderNo": orderNo,
                    "refundFee": refundFee
                  },
                  header: {
                    'content-type': 'application/x-www-form-urlencoded'
                  },
                  method: 'post',
                  dataType: 'json',
                  responseType: 'text',
                  success: function (res) {
                    console.log(res)
                    if (res.data.code == "SUCCESS") {
                      wx: wx.showToast({
                        title: '订单取消成功',
                        icon: 'success',
                        duration: 1500,
                        mask: true,
                      })
                    } else {
                      wx: wx.showToast({
                        title: '订单取消失败',
                        icon: 'none',
                        duration: 1500,
                        mask: true,
                      })
                    }
                  },
                  fail: function (res) {
                    wx: wx.showToast({
                      title: '请求异常',
                      icon: 'none',
                      duration: 1500,
                      mask: true,
                    })
                  },
                  complete: function (res) {

                  },
                });
                break;
              case 1:
                wx.showToast({
                  title: '联系客服',
                  icon: 'none'
                });
                break;
              default:
                wx.showToast({
                  title: '取消',
                  icon: 'none'
                });
                break;
            }
          },
          fail(res) {
            wx.showToast({
              title: '取消',
              icon: 'none'
            })
          },
        })
      } else {
        wx.showActionSheet({
          itemList: ["联系客服"],
          success(res) {
            if (res.tapIndex == 0) {
              wx.showToast({
                title: '联系客服',
                icon: 'none'
              });
            } else {
              wx.showToast({
                title: '取消',
                icon: 'none'
              });
            }
          }
        })
      }
    } if (status == 2) { //被接单状态
      if (identity) {
        wx.showActionSheet({
          itemList: ["取消发布", "联系客服"],
          success(res) {
            switch (res.tapIndex) {
              case 0:
                var orderNo = that.data.item.orderId
                var refundFee = that.data.item.taskReward;
                wx: wx.request({
                  url: 'http://244z00029g.zicp.vip/cancelTask',
                  data: {
                    "orderNo": orderNo,
                    "refundFee": refundFee
                  },
                  header: {
                    'content-type': 'application/x-www-form-urlencoded'
                  },
                  method: 'post',
                  dataType: 'json',
                  responseType: 'text',
                  success: function (res) {
                    console.log(res)
                    if (res.data.code == "SUCCESS") {
                      wx: wx.showToast({
                        title: '订单取消成功',
                        icon: 'success',
                        duration: 1500,
                        mask: true,
                      })
                    } else {
                      wx: wx.showToast({
                        title: '订单取消失败',
                        icon: 'none',
                        duration: 1500,
                        mask: true,
                      })
                    }
                  },
                  fail: function (res) {
                    wx: wx.showToast({
                      title: '请求异常',
                      icon: 'none',
                      duration: 1500,
                      mask: true,
                    })
                  },
                  complete: function (res) {

                  },
                });
                break;
              case 1:
                wx.showToast({
                  title: '联系客服',
                  icon: 'none'
                });
                break;
              default:
                wx.showToast({
                  title: '取消',
                  icon: 'none'
                });
                break;
            }
          },
          fail(res) {
            wx.showToast({
              title: '取消',
              icon: 'none'
            })
          },
        })
      } else {
        wx.showActionSheet({
          itemList: ["取消订单", "联系客服"],
          success(res) {
            switch (res.tapIndex) {
              case 0:
                var orderNo = that.data.item.orderId
                var refundFee = that.data.item.taskReward;
                wx: wx.request({
                  url: 'http://244z00029g.zicp.vip/cancelTask',
                  data: {
                    "orderNo": orderNo,
                    "refundFee": refundFee
                  },
                  header: {
                    'content-type': 'application/x-www-form-urlencoded'
                  },
                  method: 'post',
                  dataType: 'json',
                  responseType: 'text',
                  success: function (res) {
                    console.log(res)
                    if (res.data.code == "SUCCESS") {
                      wx: wx.showToast({
                        title: '订单取消成功',
                        icon: 'success',
                        duration: 1500,
                        mask: true,
                      })
                    } else {
                      wx: wx.showToast({
                        title: '订单取消失败',
                        icon: 'none',
                        duration: 1500,
                        mask: true,
                      })
                    }
                  },
                  fail: function (res) {
                    wx: wx.showToast({
                      title: '请求异常',
                      icon: 'none',
                      duration: 1500,
                      mask: true,
                    })
                  },
                  complete: function (res) {

                  },
                });
                break;
              case 1:
                wx.showToast({
                  title: '联系客服',
                  icon: 'none'
                });
                break;
              default:
                wx.showToast({
                  title: '取消',
                  icon: 'none'
                });
                break;
            }
          },
          fail(res) {
            wx.showToast({
              title: '取消',
              icon: 'none'
            })
          },
        })
      }

    } if (status == 3) {
      wx.showActionSheet({
        itemList: ["联系客服"],
        success(res) {
          if (res.tapIndex == 0) {
            wx.showToast({
              title: '联系客服',
              icon: 'none'
            });
          } else {
            wx.showToast({
              title: '取消',
              icon: 'none'
            });
          }
        }
      })
    } if (status == 4) { //结算状态

    } if (status == 5) {
      wx.showActionSheet({
        itemList: ["联系客服"],
        success(res) {
          if (res.tapIndex == 0) {
            wx.showToast({
              title: '联系客服',
              icon: 'none'
            });
          } else {
            wx.showToast({
              title: '取消',
              icon: 'none'
            });
          }
        }
      })
    }
  },
  finish: function (res) {
    var that = this;
    var taskid = res.currentTarget.dataset.taskid
    var status = res.currentTarget.dataset.status
    var orderId = res.currentTarget.dataset.orderid
    console.log(res)
    wx.showModal({
      title: '提交任务',
      content: '是否已经完成任务',
      success(res) {
        if (res.confirm) {
          wx: wx.request({
            url: 'http://244z00029g.zicp.vip/finishTask',
            data: {
              "taskId": taskid,
              "taskStatus": status,
              "orderId": orderId
            },
            header: {
              'content-type': 'application/x-www-form-urlencoded'
            },
            method: 'post',
            dataType: 'json',
            responseType: 'text',
            success: function (res) {
              if (res.data) {

                wx.navigateBack({
                  delta: 1,
                  success(res) {
                    wx: wx.showToast({
                      title: '提交完成',
                      icon: 'success',
                      duration: 1500,
                      mask: true,
                    })
                  }
                })
              } else {
                wx: wx.showToast({
                  title: '提交失败,请重试',
                  icon: 'none',
                  duration: 1500,
                  mask: true,
                })
              }
            },
            fail: function (res) {
              wx: wx.showToast({
                title: '请求异常,稍后再试',
                icon: '/images/Tpis.png',
                duration: 1500,
                mask: true,
              })
            },
            complete: function (res) {

            },
          })
        } else if (res.cancel) {
          wx.showToast({
            title: '取消提交!',
            icon: "none"
          })
        }
      }
    })
  },
  confirm:function(res){
    var that = this;
    var taskid = res.currentTarget.dataset.taskid
    wx.showModal({
      title: '确认完成',
      content: '是否确认完成任务',
      success(res) {
        if (res.confirm) {
          wx: wx.request({
            url: 'http://244z00029g.zicp.vip/confirm',
            data: {
              "taskId": taskid,
            },
            header: {
              'content-type': 'application/x-www-form-urlencoded'
            },
            method: 'post',
            dataType: 'json',
            responseType: 'text',
            success: function (res) {
              if (res.data) {

                wx.navigateBack({
                  delta: 1,
                  success(res) {
                    wx: wx.showToast({
                      title: '确认完成',
                      icon: 'success',
                      duration: 1500,
                      mask: true,
                    })
                  }
                })
              } else {
                wx: wx.showToast({
                  title: '确认失败,请重试',
                  icon: 'none',
                  duration: 1500,
                  mask: true,
                })
              }
            },
            fail: function (res) {
              wx: wx.showToast({
                title: '请求异常,稍后再试',
                icon: '/images/Tpis.png',
                duration: 1500,
                mask: true,
              })
            },
            complete: function (res) {

            },
          })
        } else if (res.cancel) {
          wx.showToast({
            title: '取消确认!',
            icon: "none"
          })
        }
      }
    })

  }
})