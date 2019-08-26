//index.js
//获取应用实例
const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    active1: "activeNavbar",
    active2: "",
    sliderOffset: 0,
    sliderLeft: 0,
    formMain: [0],
    upImages: '/images/up-images.png',
    chooseImages: [],
    newTime: "1",
    expresses: [],
    user: {
    },
    isLocation:""
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
    var app = getApp();
    var that = this;
    var user = app.globalData.user
    if (user.id > 0) {
      that.setData({
        user: user
      })
      console.log(that.data.user);
    } else {
      wx.reLaunch({
        url: '/pages/binding/binding',
      })
    }
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
  activeNavBar: function (event) {
    console.log(event.target);
    var target = event.target;
    console.log(target.id);
    var that = this;
    if (target.id == "active1") {
      that.setData({
        active1: 'activeNavbar',
        active2: '',
        sliderOffset: 0,
        sliderLeft: 0
      })
    }
    if (target.id == "active2") {
      that.setData({
        active2: 'activeNavbar',
        active1: '',
        sliderOffset: 70,
        sliderLeft: 140
      })
    }
  },
  addItem: function () {
    var that = this;
    var number = that.data.formMain.length
    number = number + 1;
    var item = [];
    for (var i = 0; i < number; i++) {
      item[i] = i;
      console.log(item[i]);
    }
    that.setData({
      formMain: item
    })
    console.log(number);
  },
  deleteItem: function () {
    var that = this;
    var number = that.data.formMain.length
    if (number > 1) {
      number = number - 1;

      var item = [];
      for (var i = 0; i < number; i++) {
        item[i] = i;
        console.log(item[i]);
      }
      that.setData({
        formMain: item
      })
      console.log(number);
    }
  },
  touchUpImages: function () {
    var that = this;
    that.setData({
      upImages: '/images/up-imagesh.png'
    })
    setTimeout(function () {
      that.setData({
        upImages: '/images/up-images.png'
      })
    }, 500)
  },
  chooseImages: function () {
    var that = this;
    wx.chooseImage({
      success: function (res) {
        that.setData({
          chooseImages: res.tempFilePaths
        })
      },
    })
  },
  preview: function () {
    var that = this;
    wx.previewImage({
      urls: that.data.chooseImages,
    })
  },
  expressForm: function (e) {
    var that = this;
    var task = e.detail.value;
    var name = task.name;
    var title = task.title;
    var number = task.number;
    var taskPublisher = that.data.user.id;
    console.log(taskPublisher)
    var taskStatus = task.taskStatus;
    var taskType = task.taskType;
    var textContent = task.textContent0;
    var publishTime = task.publishTime;
    var taskReward = task.taskReward*100;
    var getNewdate = that.getNewDate();
    var num = that.data.formMain.length;
    var expresses = [];
    var superiortaskId = 0;
    if (number != "" && name != "" && taskPublisher != "" && title != "" && taskStatus != "" && textContent != "") {
      getNewdate;
      publishTime = that.data.newTime;
      for (var i = 0; i < num; i++) {
        var item = { "targetaddress": "", "takeaddress": "", "textcontent": "", "superiortaskId": 0 };
        item.takeaddress = task["takeAddress" + i];
        item.targetaddress = task["targetAddress" + i];
        item.textcontent = task["textContent" + i];
        item.superiortaskId = superiortaskId;
        expresses = expresses.concat(item);
      }
      var taskJson = {
        "publisherName": name,
        "publisherNumber": number,
        "publishTime": publishTime,
        "taskReward": taskReward,
        "taskPublisher": taskPublisher,
        "taskStatus": "0",
        "taskTitle": "取快递",
        "taskRemarks": "",
        "taskType": taskType,
        "taskContext": textContent,
        "expresses": expresses
      };
      taskJson = taskJson;
      console.log(taskJson);
      taskJson = JSON.stringify(taskJson);
      wx.navigateTo({
        url: '/pages/Settlement/Settlement?taskJson=' + taskJson,
      })
      // wx: wx.request({
      //   url: 'https://qzimp.cn/api/task/PublishingTasks',
      //   data: taskJson,
      //   header: { 'content-type': 'application/x-www-form-urlencoded' },
      //   method: 'post',
      //   dataType: 'json',
      //   responseType: 'text',
      //   success: function (res) {
      //     console.log(res.data)
      //     superiortaskId = res.data;
      //     var expresses = [];
      //     for (var i = 0; i < num; i++) {
      //       var item = { "targetaddress": "", "takeaddress": "", "textcontent": "", "superiortaskId": 0 };
      //       item.takeaddress = task["takeAddress" + i];
      //       item.targetaddress = task["targetAddress" + i];
      //       item.textcontent = task["textContent" + i];
      //       item.superiortaskId = superiortaskId;
      //       expresses = expresses.concat(item);
      //     }
      //     console.log(JSON.stringify({ "expresses": expresses }));
      //     wx: wx.request({
      //       url: 'https://qzimp.cn/api/task/insertExpressList',
      //       data: { "expresses": JSON.stringify({ "expresses": expresses }) },
      //       header: { 'content-type': 'application/x-www-form-urlencoded' },
      //       method: 'post',
      //       dataType: 'json',
      //       responseType: 'text',
      //       success: function (res) {
      //         if (res.data > 0) {
      //           wx: wx.showToast({
      //             title: '下单成功!',
      //             icon: 'success',
      //             duration: 1500,
      //             mask: true,
      //             success: function (res) { },
      //             fail: function (res) { },
      //             complete: function (res) { },
      //           })
      //         }

      //       },
      //       fail: function (res) {

      //       },
      //       complete: function (res) {

      //       },
      //     })
      //   },
      //   fail: function (res) { },
      //   complete: function (res) { },
      // })

    }
    console.log(task);
    console.log(that.data)
  },
  taskForm: function (e) {
    var that = this;
    var images = that.data.chooseImages
    var task = e.detail.value;
    console.log(task)
    var name = task.name;
    var title = task.taskTitle;
    var number = task.number;
    var taskPublisher = that.data.user.id;
    var taskStatus = task.taskStatus;
    var taskType = task.taskType;
    var textContent = task.taskContext;
    var publishTime = task.publishTime;
    var taskReward = task.taskReward*100;
    var getNewdate = that.getNewDate();
    var num = that.data.formMain.length;
    console.log(images.length)
    var superiortaskId = 0;
    if (number != "" && name != "" && taskPublisher != "" && title != "" && taskStatus != "" && textContent != "") {
      getNewdate;
      publishTime = that.data.newTime;
      var taskJson = {
        "images":images,
        "publisherName": name,
        "publisherNumber": number,
        "publishTime": publishTime,
        "taskReward": taskReward,
        "taskPublisher": taskPublisher,
        "taskRemarks":"",
        "taskStatus": "0",
        "taskTitle": title,
        "taskType": taskType,
        "taskContext": textContent      
      };
      console.log(taskJson);
      taskJson = JSON.stringify(taskJson);
      wx.navigateTo({
        url: '/pages/Settlement/Settlement?taskJson=' + taskJson,
      })
      // if (images.length > 0) {
      //   var uploadImage=[];
      //   var imageList=[];
      //   for (var i = 0; i < images.length; i++) {
      //     uploadImage[i] = new Promise(resolve =>{
      //        wx.uploadFile({
      //         url: 'https://qzimp.cn/api/file/file/upload', //仅为示例，非真实的接口地址
      //         filePath: images[i],
      //         name: 'file',
      //         success(res) {
      //           // console.log(res);
      //           var objImages = JSON.parse(res.data).data;
      //           // console.log(objImages.src);
      //           resolve(objImages.src);
      //         }
      //       })
      //     })
      //   }
      //   Promise.all(uploadImage).then(function (res) { 
      //     taskJson.images='"'+JSON.stringify(res)+'"';
      //     var taskJsonStr = JSON.stringify(taskJson);
      //     wx: wx.request({
      //       url: 'https://qzimp.cn/api/task/PublishingTasks',
      //       data: taskJsonStr,
      //       header: { 'content-type': 'application/json' },
      //       method: 'post',
      //       dataType: 'json',
      //       responseType: 'text',
      //       success: function (res) {
      //         if (res.data > 0) {
      //           wx: wx.showToast({
      //             title: '下单成功!',
      //             icon: 'success',
      //             duration: 1500,
      //             mask: true,
      //             success: function (res) { },
      //             fail: function (res) { },
      //             complete: function (res) { },
      //           })
      //         }
      //       },
      //       fail: function (res) { },
      //       complete: function (res) { },
      //     })
      //     });
      // }else{
      //   var taskJsonStr = JSON.stringify(taskJson);
      //   wx: wx.request({
      //     url: 'https://qzimp.cn/api/task/PublishingTasks',
      //     data: taskJsonStr,
      //     header: { 'content-type': 'application/json' },
      //     method: 'post',
      //     dataType: 'json',
      //     responseType: 'text',
      //     success: function (res) {
      //       if (res.data > 0) {
      //         wx: wx.showToast({
      //           title: '下单成功!',
      //           icon: 'success',
      //           duration: 1500,
      //           mask: true,
      //           success: function (res) { },
      //           fail: function (res) { },
      //           complete: function (res) { },
      //         })
      //       }
      //     },
      //     fail: function (res) { },
      //     complete: function (res) { },
      //   })
      // }
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
      newTime: '{"year":' + y + ',"month": ' + m + ',"date": ' + d + ',"hours": ' + h + ',"minutes": ' + min + ',"seconds":' + s + '}'
    })
  },
  chooseLocation:function(){
    var that=this;
    wx.chooseLocation({
      success: function(res) {
        console.log(res.name)
        that.setData({
          isLocation:res.name
        })
      },
    })
  }
})