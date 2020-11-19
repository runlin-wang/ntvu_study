// pages/calc/calc.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    result: 0
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

  clickBtn: function (e) {
    let data = this.data.result;
    const value = e.currentTarget.dataset.value;
    console.log(value > 0 && value <= 9);
    
    if (value >= 0 && value <= 9) {
      if (data == '0') {
        data = value;
      }
      else {
        data += '' + value;
      }
    } else {
      //TODO 具体实现 加减乘除小数点和其他的 运算符
      console.log(value);
    }

    this.setData({result:data});
  }
})