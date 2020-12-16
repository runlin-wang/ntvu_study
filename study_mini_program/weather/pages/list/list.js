// pages/list/list.js

const config  = require("../../config");

function formatSeconds(value) {
  const time = parseFloat(value);
  const m = Math.floor(time/60);
  const s = time - m * 60;

  return [m, s].map(formatNumber).join(':');

  function formatNumber(n) {
    n = n.toString();
    return n[1] ? n : '0' + n;
  }
}

//Page Object
Page({
  data: {
    board:'',       // 顶部图片
    songlist:[],    // 音乐列表
    loading:false,  //加载标志 
  },
  // 页面加载事件
  onLoad: function(options){
    const self = this;
    const topid = this;

    this.setData({loading:true});   // 获取页面跳转传过来的参数

    let request = wx.request({
      url: config.config.hotUrl,
      data: {topid:topid},

      success: (e)=>{
        if (e.statusCode == 200) {
          // TODO delete
          const songlist = e.data.show;
          // 将时长转换为分秒的表示形式
          for (let i = 0; i < songlist.length; i++) {
            songlist[i].seconds = formatSeconds(songlist[i].seconds);
          }
          self.setData({
            // TODO delete
            // 获取第一首歌曲的图片作为该页顶部图片
            board: e.data.t,
            songlist: songlist,
            loading:false       // 隐藏加载提示信息
          });

          // 将歌曲列表保存到本地缓存中
          wx.setStorageSync('songlist', songlist);
        }
      },
    });
  },
  onReady: function(){
    
  },
  onShow: function(){
    
  },
  onHide: function(){

  },
  onUnload: function(){

  },
  onPullDownRefresh: function(){

  },
  onReachBottom: function(){

  },
  onShareAppMessage: function(){

  },
  onPageScroll: function(){

  },
  //item(index,pagePath,text)
  onTabItemTap:function(item){

  }
});
