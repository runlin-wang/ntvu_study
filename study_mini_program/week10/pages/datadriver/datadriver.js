// pages/datadriver/datadriver.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isOdd: true
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
    //TODO 定时器作业
    setTimeout(
      function () {
        // var isOdd = this.data.isOdd;
        const page = miniProgram.currentPage()
        // const page = await miniProgram.currentPage();
        console.log(page.data);
        // this.setData({isOdd: });
      }, 2000);
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

  setParam: function (e) {
    const isOdd = e.currentTarget.dataset.param == 'odd';
    this.setData({isOdd: isOdd});
  }
})