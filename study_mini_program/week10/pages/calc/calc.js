// pages/calc/calc.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    result: "0",
    temp: "0", 
    op: "",
    flag: true
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
    var calculate = function(num1, op, num2) {
      let data;
      num1 = parseFloat(num1);
      num2 = parseFloat(num2);
  
      switch (op) {
        case "+":
          data = num1 + num2;
          break;
        case "-":
          data = num1 - num2;
          break;
        case "*":
          data = num1 * num2;
          break;
        case "/":
          if (num2 !== 0)
            data = num1 / num2;
          else {
            data = 0;
            wx.wx.showToast({
              title: '❌，除数不能为 0 ！',
              duration: 1500,
            });
          }
          break;
      }

      return data;
    }

    let data = this.data.result;
    
    let tmp = this.data.temp;
    let op = this.data.op;
    let noNumFlag = this.data.flag;
    const value = e.currentTarget.dataset.value;
    
    // console.log("value: " + value +", data: " + data + ", tmp: " + tmp + ", op: " + op);

    if (value >= 0 && value <= 9) {
      if (data == '0' || noNumFlag) {
        data = value;
      }
      else {
        data += '' + value;
      }
      noNumFlag = false;
    } else {
      noNumFlag = true;
      //TODO 具体实现 加减乘除小数点和其他的 运算符
      console.log(value);

      switch (value) {
        case "dot":
          // 输入的值中不包含小数点
          if (data.toString().indexOf(".") == -1)
            data += ".";
          break;
        case "clear":
          data = 0;
          tmp = 0;
          op = "+";
          break;
        case "negative":
          data = -1 * data;
          break;
        case "back":
          if (data.length > 1)
            data.substr(0, data.length - 1);
          else
            data = 0;
          break;
        case "div":
          data = calculate(tmp, op, data);
          tmp = data;
          op = "/";
          break;
        case "mul":
          data = calculate(tmp, op, data);
          tmp = data;
          op = "*";
          break;
        case "add":
          data = calculate(tmp, op, data);
          tmp = data;
          op = "+";
          break;
        case "sub":
          data = calculate(tmp, op, data);
          tmp = data;
          op = "-";
          break;
        case "equ":
          data = calculate(tmp, op, data);
          tmp = 0;
          op = "+";
          break;
      }
    }

    this.setData({
      result:data,
      op:op,
      temp:tmp,
      flag:noNumFlag
    });
  }
})