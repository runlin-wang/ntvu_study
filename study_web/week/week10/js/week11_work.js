const cl = console.log.bind(console);

// 1. 动态图片区的<img>

// 2. <img>两侧的两个小按钮

// 3. 新闻区和公告区所有的<a>

// 4. 公告区的两个用作导航的<li>，即包含：公告信息、招标公告的<li>

// JavaScript 实现

// const dm = document.getElementsByClassName('dm')[0];
// const img = dm.children[0];
// console.log(img.src);
// const img = document.querySelector('.dm>img');
// cl(img);

// const left_arrow = document.getElementsByClassName('left-arrow')[0];
// const left_arrow = document.querySelector('.left-arrow');
// cl(left_arrow);
// const right_arrow = document.getElementsByClassName('right-arrow')[0];
// const right_arrow = document.querySelector('.right-arrow');
// cl(right_arrow);

// const a = document.querySelectorAll('.main-content a');
// a.forEach(function(current) {
// 	cl(current.innerHTML);
// });

// const li = document.querySelectorAll('.notice-content>ul>li');
// cl(li);


// jquery 实现

// const img = $('.dm>img')[0];
// cl(img);

// const btn = $('.dm>div');
// cl(btn[0].outerHTML);

// const a = jQuery('.main-content a');
// a.each(function() {
// 	cl(this.innerText);
// });

// const li = jQuery('.notice-content>ul>li');
// cl(li[0].innerText);
