// document.querySelectorAll('.main-content a').forEach(function(current) {
// 	current.title = current.innerText;
// });

// jQuery 实现
// $('.main-content a').mouseover(function() {
// 	$(this).prop('title', $(this).text());
// });


// 通过冒泡流实现事件委托
document.querySelector('.main-content').onmouseover = function(event) {
	const target = event.target;
	if (target.tagName == 'A')
		target.title = target.innerText;
}

// 切换公告
document.querySelector('.notice-content>ul').onmouseover = function(event) {
	const target = event.target;
	// console.log(target.children[0].className);
	switch (target.children[0].className) {
		case "notice-left":
			break;
		case "notice-right":
			
	}
}

// 切换图片

// 自动切换图片



