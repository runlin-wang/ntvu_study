const fs  = require("fs");

fs.readFile("fs.txt", "utf-8", function(err, data) {
    data += '\nwrite add test';
    fs.writeFile("fs.txt", data, function(err) {
        if (err) throw err;
        console.log("追加写入成功");
    })
});

