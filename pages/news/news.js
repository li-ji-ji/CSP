//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    active:0,
    category:[],
    newsList:[],
    type:'',
    isBottom:false,
    currentpage:1
  },

  getCurrentNewsList:function(event){//获取当前分类新闻列表
    var that = this
    wx.showLoading({
      title: '加载中...'
    })
    wx.request({
      url: 'https://qzimp.cn/api/assist/findAllByCategoryType',
      data: {
        categoryType: event.detail.title,
        page: 1,
        size: 8
      },
      success: function (res) {
        console.log(res.data)
        that.setData({
          newsList: res.data,
          type: event.detail.title
        });
        wx.hideLoading();
      },
      fail: function (res) {
        wx.hideLoading();
        wx.showToast({
          title: '请求数据错误',
          icon: 'loading',
          image: '/images/fail.png',
        });
      }
    })
  },

  
  onChange(event) {
      this.getCurrentNewsList(event);
  },

  getCategoriesList:function(){//获取导航列表，成功后请求第一个导航的新闻列表
    var that = this
    wx.showLoading({
      title: '加载中...'
    })
    wx.request({
      url: 'https://qzimp.cn/api/assist/allcategoryIsleaf',
      method: 'GET',
      success: function (res) {
        console.log(res)
        if (res.statusCode == 200) {
          that.setData({
            category: res.data,
            type: res.data[0].categorytype
          });
          wx.hideLoading();
          wx.showLoading({
            title: '加载中...'
          });
          wx.request({
            url: 'https://qzimp.cn/api/assist/findAllByCategoryType',
            data: {
              categoryType: that.data.type,
              page: 1,
              size: 8
            },
            success: function (res) {
              console.log(res.data)
              that.setData({
                newsList: res.data,
              });
              wx.hideLoading();
            },
            fail: function (res) {
              wx.hideLoading();
              wx.showToast({
                title: '请求数据错误',
                icon: 'loading',
                image: '/images/fail.png',
              });
            }
          })
        }
        else {
          wx.hideLoading();
          wx.showToast({
            title: '请求数据错误',
            icon: 'loading',
            image: '/images/fail.png',
          });
        }
      },

      fail: function (res) {
        wx.hideLoading();
        wx.showToast({
          title: '请求失败',
          icon: 'loading',
          image: '/images/fail.png',
        });
      }
    })
  },

  onLoad: function () {
    this.getCategoriesList();
    
  },

  refreshNewsList:function(){//下拉刷新
    var currenttype=this.data.type;
    var that = this
    wx.request({
      url: 'https://qzimp.cn/api/assist/findAllByCategoryType',
      data: {
        categoryType: currenttype,
        page: 1,
        size: 8
      },
      success: function (res) {
        that.setData({
          newsList: res.data,
          currentpage:1
        });
        wx.showToast({
          title: '刷新成功',
          icon: 'success',
          image:'/images/success.png'
        });
      },
      fail: function (res) {
        that.setData({
          newsList: res.data,
        });
        wx.showToast({
          title: '刷新失败',
          icon: 'loading',
          image: '/images/fail.png',
        });
      }
    })
  },

  onPullDownRefresh: function () {

    // 用户触发了下拉刷新操作
    this.refreshNewsList();
    
    wx.stopPullDownRefresh() // 可以停止当前页面的下拉刷新。

  },


  uploadNewsList:function(){//上拉加载
    var that = this
    wx.showLoading({
      title: '加载中...'
    })
    wx.request({
      url: 'https://qzimp.cn/api/assist/findAllByCategoryType',
      data: {
        categoryType: that.data.type,
        page: parseInt(that.data.newsList.length/8)+1,
        size: 8
      },
      success: function (res) {
        var uppage = parseInt(that.data.newsList.length / 8) + 1
        if (res.data.length > 0 && that.data.currentpage < uppage){
          that.setData({
            newsList: that.data.newsList.concat(res.data),
            currentpage: uppage
          });
        }
        else{
          that.setData({
            isBottom: true
          });
        }
        wx.hideLoading();
      },
      fail: function (res) {
        wx.hideLoading();
        wx.showToast({
          title: '请求失败',
          icon: 'loading',
          image: '/images/fail.png',
        });
      }
    })
  },

  onReachBottom:function(){
      this.uploadNewsList();
  },
  item:function(res){
    var newContent = res.currentTarget.dataset.newsitem;
    if (newContent != "") {
      wx.setStorage({
        key: 'newsContent',
        data: newContent,
        success(res) {
          wx.navigateTo({
            url: '/pages/newContent/newContent',
          })
        }
      })
    }
  }

})