// pages/weather/weather.js

const util  = require("../../utils/util");

Page({

  /**
   * 页面的初始数据
   */
  data: {
    weather: {
      // wendu: 18,
      // // ganmao: '昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。',
      // yesterday: {
      //   date: '17 日 星期四',
      //   type: '阴',
      //   fx: '南风',
      //   fl: '微风级',
      //   low: '低温 8℃',
      //   high: '高温 16℃'
      // },
      // forecast: [
      //   {
      //     date: '18 日 星期五',
      //     type: '阴',
      //     high: '高温 16℃',
      //     low: '低温 8℃',
      //     fengxiang: '南风',
      //     fengli: '微风级'
      //   }, {
      //     date: '18 日 星期五',
      //     type: '阴',
      //     high: '高温 16℃',
      //     low: '低温 8℃',
      //     fengxiang: '南风',
      //     fengli: '微风级'
      //   }, {
      //     date: '18 日 星期五',
      //     type: '阴',
      //     high: '高温 16℃',
      //     low: '低温 8℃',
      //     fengxiang: '南风',
      //     fengli: '微风级'
      //   }, {
      //     date: '18 日 星期五',
      //     type: '阴',
      //     high: '高温 16℃',
      //     low: '低温 8℃',
      //     fengxiang: '南风',
      //     fengli: '微风级'
      //   }, {
      //     date: '18 日 星期五',
      //     type: '阴',
      //     high: '高温 16℃',
      //     low: '低温 8℃',
      //     fengxiang: '南风',
      //     fengli: '微风级'
      //   }
      // ]
    },
    today: '2000-01-01',
    city: '',           // 城市名称
    inputCity: '',         // 输入查询的城市名称
  }, 

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
    this.setData({
      today: util.formatTime(new Date()).split(' ')[0]    // 更新当前日期
    });
    const self = this;
    wx.getLocation({
      type: 'wgs84',
      altitude: false,
      success: (result) => {
        console.log(result);
        wx.request({
          url: 'https://api.map.baidu.com/geocoder/v2/' +
            '?ak=WQpBGrUcRiuiioZnXIuWpLggZW8oCSgL&location=' +
            result.latitude + ',' + result.longitude + '&output=json&pois=0',
          data: {},
          header: {
            'Content-Type': 'application/json'
          },
          success: function (res) {
            
            if (typeof res.data != "undefined" && res.data.status != 240) {
              const city = res.addressComponent.city.replace('市', '');   // 城市名称
              self.searchWeather(city);                                   // 查询指定城市的天气信息
            }
          }
        })
      },
      fail: () => { },
      complete: () => { }
    });
  },

  searchWeather: function (cityName) {
    const self = this;
    let request = wx.request({
      url: 'http://wthrcdn.etouch.cn/weather_mini?city=' + cityName,
      data: {},
      header: { 'content-type': 'application/json' },
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: (result) => {
        console.log(result);
        if (result.data.status == 1002) {   // 无此城市
          wx.showModal({
            title: '提示',
            content: '输入的城市名称有误，请重新输入！',
            showCancel: false,
            success: (result) => {
              self.setData({ inputCity: '' });
            },
            fail: () => { },
            complete: () => { }
          });
        } else {
          const weather = result.data.data;        // 获取天气数据

          for (let i = 0; i < weather.forecast.length; i++) {
            let element = weather.forecast[i];
            console.log(element);
            element.date = '  ' + element.date.replace('星期', '  星期');
            element.fengli = element.fengli.match(/[0-9]./);
          }
          weather.yesterday.fl = weather.yesterday.fl.match(/[0-9]./);
          self.setData({
            city: cityName,     // 更新显示天气城市名称
            weather: weather,   // 更新天气信息
            inputCity: ''       // 清空查询输入框
          });
        }
      },
      fail: () => { },
      complete: () => { }
    });
  },

  // 输入事件
  inputing: function (e) {
    this.setData({ inputCity: e.detail.value });
  },
  // 搜索按钮
  bindSearch: function () {
    this.searchWeather(this.data.inputCity);
  }
})