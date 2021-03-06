// pages/my/index/index.js

const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    memberInfo:null,
    username: null,
    telephone: null
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
    // console.log(typeof app.globalData.userInfo);
    // 判断是否登录
    // console.log(typeof app.globalData.memberInfo);
    if (app.globalData.memberInfo == null || typeof app.globalData.memberInfo == 'undefined') {
      wx.navigateTo({
        url: '/pages/serverLogin/serverLogin',
      })
    } else {
      console.log(app.globalData.memberInfo);
      this.setData({
        memberInfo: app.globalData.memberInfo
      });
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

  }
})