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
	// console.log(target.id);
	// console.log(target.children[0].className);
	switch (target.id) {
		case "head-notice-left":
			document.querySelector('#head-notice-left>ol').style.display = 'block';
			document.querySelector('#head-notice-right>ol').style.display = 'none';
			break;
		case "head-notice-right":
			document.querySelector('#head-notice-left>ol').style.display = 'none';
			document.querySelector('#head-notice-right>ol').style.display = 'block';
	}
}

// 切换图片
const imgArr = ['dm1.jpg', 'dm2.jpg', 'dm3.jpg', 'dm4.jpg', 'dm5.jpg', 'dm6.png'];
let index = 0;

function nextImage() {
	clearTimeout(timeoutId);
	index++;
	index %= 6;
	document.querySelector('.dm>img').src = 'img/' + imgArr[index];
}

function preImage() {
	if (--index == -1)
		index = 5;
	document.querySelector('.dm>img').src = 'img/' + imgArr[index];
}

document.querySelector('.right-arrow').onclick = nextImage;
document.querySelector('.left-arrow').onclick = preImage;

// 自动切换图片
function autoSwitchImg() {
	nextImage();
	clearTimeout(timeoutId);
	var timeoutId = setTimeout(autoSwitchImg, 3000);
}

var timeoutId = setTimeout(autoSwitchImg, 3000);
