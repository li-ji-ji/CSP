const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    start: 0,//开始渲染下标
    long: 10,//渲染终止下标
    taskList: [],//构造的task任务列表
    num: 0,//
    taskidList: [],
    originalData: [],
    user: {},
  },
  //得到一个taskList并更新值
  getTaskList: function () {
    var that = this;
    that.setData({
      start: 0,
      long: 10
    })
    if (that.data.originalData.length < that.data.long) {
      that.setData({
        long: that.data.originalData.length
      })
    }
    var newDate = {};
    var date = new Date();
    var taskList = [];
    var taskidList = [];
    for (var i = that.data.start; i < that.data.long; i++) {
      var task = { time: "", school: "", status: 0, title: "", express: [], remarks: "", taskReward: "", taskId: 0, taskPublisher: "" };
      newDate = JSON.parse(that.data.originalData[i].publishTime);
      task.time = newDate.year + "-" + newDate.month + "-" + newDate.date + " " + newDate.hours + ":" + newDate.minutes;
      task.school = "泉州信息工程学院2016级";
      task.status = that.data.originalData[i].taskStatus;
      task.title = that.data.originalData[i].taskTitle;
      task.taskReward = that.data.originalData[i].taskReward;
      task.remarks = that.data.originalData[i].taskRemarks;
      task.taskId = that.data.originalData[i].taskId;
      task.taskPublisher = that.data.originalData[i].taskPublisher;
      taskList = taskList.concat(task);
      taskidList = taskidList.concat(that.data.originalData[i].taskId);
      that.setData({
        taskList: taskList,
        taskidList: taskidList
      })
    }
    console.log(taskidList)
    wx: wx.request({
      url: 'http://244z00029g.zicp.vip/selectBySuperiortaskId',
      data: {
        "ids": JSON.stringify(taskidList)
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'post',
      dataType: 'json',
      responseType: 'text',
      success: function (res) {
        console.log(taskList)
        for (var i = 0; i < taskList.length; i++) {
          taskList[i].express = res.data[i]
          if (res.data[i].length > 1) {
            taskList[i].title = taskList[i].title + res.data[i].length + "件"
          }
        }
        that.setData({
          taskList: taskList
        })
      }
    })
  },
  //刷新/渲染页面
  refresh: function () {
    var that = this;
    var userID = that.data.user.userID
    wx: wx.request({
      url: 'http://244z00029g.zicp.vip/taskByReceiver',
      data: {
        "taskByReceiver":userID
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'post',
      dataType: 'json',
      responseType: 'text',
      success: function (res) {
        that.setData({
          originalData: res.data
        })
        var getTaskList = that.getTaskList();
        getTaskList;

      },
      fail: function (res) {

      },
      complete: function (res) {

      },
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    that.setData({
      user: app.globalData.user
    })
    var refresh = that.refresh();
    refresh;
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
    var refresh = that.refresh();
    refresh;
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
    var that = this;
    var refresh = that.refresh();
    refresh;
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    var that = this
    if (that.data.originalData.length <= that.data.long) {
      wx: wx.showToast({
        title: '我也是有底线的~',
        icon: 'loading',
        duration: 1500,
        mask: true,
      })
    } else {
      var taskList = that.data.taskList;
      that.setData({
        start: that.data.long,
        long: that.data.long + 10
      })
      if (that.data.originalData.length < that.data.long) {
        that.setData({
          long: that.data.originalData.length
        })
      }
      console.log(that.data.start + "," + that.data.long)
      console.log(that.data.originalData)


      var newDate = {};
      var date = new Date();
      var taskidList = [];
      for (var i = that.data.start; i < that.data.long; i++) {
        var task = { time: "", school: "", status: 0, title: "", express: [], remarks: "", taskReward: "", taskId: 0, taskPublisher: "" };
        newDate = JSON.parse(that.data.originalData[i].publishTime);
        task.time = newDate.year + "-" + newDate.month + "-" + newDate.date + " " + newDate.hours + ":" + newDate.minutes;
        task.school = "泉州信息工程学院2016级";
        task.status = that.data.originalData[i].taskStatus;
        task.title = that.data.originalData[i].taskTitle;
        task.taskReward = that.data.originalData[i].taskReward;
        task.remarks = that.data.originalData[i].taskRemarks;
        task.taskId = that.data.originalData[i].taskId;
        task.taskPublisher = that.data.originalData[i].taskPublisher;
        taskList = taskList.concat(task);
        taskidList = taskidList.concat(that.data.originalData[i].taskId);
        that.setData({
          taskList: taskList,
          taskidList: taskidList
        })
      }
      console.log(taskidList)
      wx: wx.request({
        url: 'http://244z00029g.zicp.vip/selectBySuperiortaskId',
        data: {
          "ids": JSON.stringify(taskidList)
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        method: 'post',
        dataType: 'json',
        responseType: 'text',
        success: function (res) {
          console.log(taskList)
          for (var i = that.data.start; i < that.data.long; i++) {
            var j = 0;
            taskList[i].express = res.data[j]
            if (res.data[j].length > 1) {
              taskList[i].title = taskList[i].title + res.data[j].length + "件"
            }
            j = j + 1;
          }
          that.setData({
            taskList: taskList
          })
        }
      })


    }

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  taskDetails: function (res) {
    var that = this;
    var item = JSON.stringify(res.currentTarget.dataset.task);
    wx.navigateTo({
      url: '/pages/taskDetails/taskDetails?item=' + item,
      events: {
        // 为指定事件添加一个监听器，获取被打开页面传送到当前页面的数据
        acceptDataFromOpenedPage: function (data) {
          console.log(data)
        },
        someEvent: function (data) {
          console.log(data)
        }
      },
      success: function (res) {
        // 通过eventChannel向被打开页面传送数据
      }
    })
  }
})