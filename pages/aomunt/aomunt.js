// pages/aomunt/aomunt.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    choose: [],
	// 选择操作可视化  选中项数组
    Index: null
  },
  choose_img: function() {
    // 初始化选中文件的选中项数组(默认不显示)
	// 给每一个文件制作一个选择操作默认值
    this.setData({
		// 初始化选中项数组
      choose: []
    })
    var x = this.data.upArray.length
    // console.log(x)
    var y = {
      "choose": "none",
      "dis": "none"
    }
	// 使选中项数组的长度与文件数组的长度一致
    for (var i = 0; i < x; i++) {
      this.setData({
        choose: this.data.choose.concat(y)
      })
    }
  },
  choose: function(e) {
    // 文件被选中时触发事件,并显示选中图片变化
	// 获得被选中的文件的序号
    var x = Number(e.currentTarget.dataset.type)
    // console.log(x)
	// 获得已经制作好的选中项数组
    var y = this.data.choose
    // console.log(y)
	// 选择炒作以及取消选择
    if (y[x].dis == "none") {
      y[x] = {
        choose: "in",
        dis: "block"
      }
    } else {
      y[x] = {
        choose: "none",
        dis: "none"
      }
    }
    // console.log(y)
    this.setData({
      choose: y
    })
  },
  remove: function() {
    // 删除所选项
    // console.log(this.data.upArray)
	// 获取文件数组长度
    var x = this.data.choose.length;
	// 获取文件
    var z = this.data.upArray
	// 获取选中项数组
    var y = this.data.choose
	// 文件减少变量
    var p = 0;
    // console.log(z)
    // 删除选择的文件数组
    for (var i = 0; i < x; i++) {
      if (y[i].choose == "in") {
        // console.log("....")
        // console.log(i)
        p++
        z.splice((i - p), 1)
        // console.log("删除中")
        // console.log(p)
      }
      // console.log(z)
    }
    // console.log(".......")
	// 重新制作选择数组
    var q = []
    var u = {
      choose: "none",
      dis: "none"
    }
    for (var i = 0; i < (x - p); i++) {
      q[q.length] = u
    }
    console.log(q)
    this.setData({
      upArray: z,
      choose: q
    })
  },
  order: function() {
	  // 制作订单数组
    var that = this
	// 获取文件信息
    var x = this.data.choose.length;
    var y = this.data.choose
    var z = this.data.upArray
    var p = []
	// 制作订单
    for (var i = 0; i < x; i++) {
      if (y[i].choose == "in") {
        // console.log("....")
        // console.log(i)
        p[p.length] = z[i]
      }
    }
    // console.log(p)
	// 删除选择的文件订单
    that.remove()
	// 传输订单到订单页面
    wx.navigateTo({
      url: '../orderList/orderList?order=' + JSON.stringify(p) + "&Index=" + that.data.Index + "&printIndex=" + that.data.printIndex,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    //获得从homepage中获得的数据
    var upArray = JSON.parse(options.upArray)
    this.setData({
      upArray: upArray,
      Index: options.Index,
      printIndex: options.printIndex
    })
    this.choose_img()

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {},

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