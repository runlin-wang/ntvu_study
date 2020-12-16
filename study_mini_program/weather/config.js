(function (module) {
  const exports = module.exports = {};

  const param = "?show";

  // http://tingapi.ting.baidu.com/v1/restserver/ting?format=json&calback=&from=webapp_music&method=baidu.ting.billboard.billList&type=2&size=10&offset=0
  
  const hotUrl = "http://tingapi.ting.baidu.com/v1/restserver/ting?format=json&calback=&from=webapp_music&method=baidu.ting.billboard.billList&size=10&offset=0&type=2";

  const searchByNameUrl = "";

  const searchByIdUrl = "";

  module.exports = {
    config: {
      hotUrl: hotUrl,
      searchByNameUrl: searchByNameUrl,
      searchByIdUrl: searchByIdUrl
    }
  }
})(module);