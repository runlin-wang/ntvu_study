// pages/play/play.js

const config  = require("../../config");    // 导入配置文件

Page({

  /**
   * 页面的初始数据
   */
  data: {
    song: {},     // 传入的歌曲信息
    isPlaying: false, // 播放状态
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const self = this;
    const songid = options.songid;    // 获取页面跳转传过来的参数（歌曲对象）

    if (songid === undefined) {       // 未传入歌曲 ID
      const curSong = wx.getStorageSync('curSong') || {};  // 从缓存中获取歌曲

      if (curSong === undefined) {    // 缓存中无歌曲
        const song = {songname: '未选择歌曲'};  // 显示未选择歌曲
        this.setData({song:song});
      } else {
        this.setData({song:curSong});
      }
    } else {
      const songlist = wx.getStorageSync('songlist') || []; // 从缓存中取出歌曲列表
      // 在歌曲列表中查找 songid 指定的歌曲
      for (let i = 0; i < songlist.length; i++) {
        if (songlist[i].songid == songid) {
          this.setData({song:songlist[i]});
          break;
        }
      }
      // 缓存正在播放的歌曲
      wx.setStorageSync('curSong', this.data.song);
    }
  },

  playToggle: function () {
    const self = this;
    // 没有歌曲要播放，直接退出
    if (this.data.song.songname == '未选择歌曲') return;

    if (this.data.isPlaying) {  // 正在播放
      wx.stopBackgroundAudio(); // 停止播放歌曲
    } else {                    // 未播放，则开始播放
      // 播放歌曲
      wx.playBackgroundAudio({
        dataUrl: this.data.song.url || this.data.song.m4a,
        success: (result) => {
          // 更新播放状态
          this.setData({isPlaying:!this.data.isPlaying});
        },
      });
        

    }
  }
})