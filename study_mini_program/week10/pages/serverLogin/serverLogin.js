// pages/serverLogin/serverLogin.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userName: '',
    pwd: ''
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

  textChange: function (e) {
    const v = e.currentTarget.dataset.name;
    if (v == 'userName') {
      this.data.userName = e.detail.value;
    }
    else if (v == 'pwd') {
      this.data.pwd = e.detail.value;
    }
  },

  login: function () {
    const that = this;
    let request = wx.request({
      url: 'http://localhost:8080/doLogin',
      data: {
        username: that.data.userName,
        pwd: that.data.pwd
      },
      header: {'content-type':'application/json'},
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: (result)=>{
        console.log(result.data);
        const success = result.data.code == '200';
        wx.showToast({
          title: 'success',
          icon: 'none',
          duration: 1500,
        });
      },
      fail: ()=>{
        console.log('fail');
      },
      complete: ()=>{
        console.log('complete');
      }
    });
  }
})