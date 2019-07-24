// Page({

//   /**
//    * 页面的初始数据
//    */
//   data: {
//     item: {}
//   },

//   /**
//    * 生命周期函数--监听页面加载
//    */
//   onLoad: function (options) {
//     var that=this;
//     if (options.isOk != null) {
//       var item=options.item;
//       that.setData({
//         item:item
//       })
//       var taskJson = JSON.parse(that.data.item);
//       console.log(taskJson)
//       wx: wx.request({
//         url: 'http://244z00029g.zicp.vip/PublishingTasks',
//         data: taskJson,
//         header: { 'content-type': 'application/x-www-form-urlencoded' },
//         method: 'post',
//         dataType: 'json',
//         responseType: 'text',
//         success: function (res) {
//           console.log(res.data)
//           var superiortaskId = res.data;
//           var expresses = that.data.item.expresses;
//           for (var i = 0; i < expresses.length; i++) {
//             expresses[i].superiortaskId = superiortaskId;
//           }
//           console.log(JSON.stringify({ "expresses": expresses }));
//           wx: wx.request({
//             url: 'http://244z00029g.zicp.vip/insertExpressList',
//             data: { "expresses": JSON.stringify({ "expresses": expresses }) },
//             header: { 'content-type': 'application/x-www-form-urlencoded' },
//             method: 'post',
//             dataType: 'json',
//             responseType: 'text',
//             success: function (res) {
//               if (res.data > 0) {
//                 wx: wx.showToast({
//                   title: '下单成功!',
//                   icon: 'success',
//                   duration: 1500,
//                   mask: true,
//                   success: function (res) { },
//                   fail: function (res) { },
//                   complete: function (res) { },
//                 })
//               }

//             },
//             fail: function (res) {

//             },
//             complete: function (res) {

//             },
//           })
//         },
//         fail: function (res) { },
//         complete: function (res) { },
//       })
//     }
//   },

//   /**
//    * 生命周期函数--监听页面初次渲染完成
//    */
//   onReady: function () {

//   },

//   /**
//    * 生命周期函数--监听页面显示
//    */
//   onShow: function () {

//   },

//   /**
//    * 生命周期函数--监听页面隐藏
//    */
//   onHide: function () {

//   },

//   /**
//    * 生命周期函数--监听页面卸载
//    */
//   onUnload: function () {

//   },

//   /**
//    * 页面相关事件处理函数--监听用户下拉动作
//    */
//   onPullDownRefresh: function () {

//   },

//   /**
//    * 页面上拉触底事件的处理函数
//    */
//   onReachBottom: function () {

//   },

//   /**
//    * 用户点击右上角分享
//    */
//   onShareAppMessage: function () {

//   },
//   publish: function () {
//     var that = this;
//     var taskJson = that.data.item;
//     console.log(taskJson)
//     wx: wx.request({
//       url: 'http://244z00029g.zicp.vip/PublishingTasks',
//       data: taskJson,
//       header: { 'content-type': 'application/x-www-form-urlencoded' },
//       method: 'post',
//       dataType: 'json',
//       responseType: 'text',
//       success: function (res) {
//         console.log(res.data)
//         var superiortaskId = res.data;
//         var expresses = that.data.item.expresses;
//         for (var i = 0; i < expresses.length; i++) {
//           expresses[i].superiortaskId = superiortaskId;
//         }
//         console.log(JSON.stringify({ "expresses": expresses }));
//         wx: wx.request({
//           url: 'http://244z00029g.zicp.vip/insertExpressList',
//           data: { "expresses": JSON.stringify({ "expresses": expresses }) },
//           header: { 'content-type': 'application/x-www-form-urlencoded' },
//           method: 'post',
//           dataType: 'json',
//           responseType: 'text',
//           success: function (res) {
//             if (res.data > 0) {
//               wx: wx.showToast({
//                 title: '下单成功!',
//                 icon: 'success',
//                 duration: 1500,
//                 mask: true,
//                 success: function (res) { },
//                 fail: function (res) { },
//                 complete: function (res) { },
//               })
//             }

//           },
//           fail: function (res) {

//           },
//           complete: function (res) {

//           },
//         })
//       },
//       fail: function (res) { },
//       complete: function (res) { },
//     })
//   }
// })