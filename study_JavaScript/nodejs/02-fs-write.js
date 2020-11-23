const fs  = require("fs");

fs.writeFile("fs.txt", "write test. ", function(err) {
    if (err) throw err;
    console.log('文件以写入！');
});