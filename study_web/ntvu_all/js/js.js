//公告信息与招标公告的轮换
function showhide(obj){
	var parent=obj.parentElement;
	var children=parent.children;
	if(obj==children[0]){
		parent.parentElement.children[1].style.display="block";
		parent.parentElement.children[2].style.display="none";
		children[0].style.color="#163168";
		children[1].style.color="orange";
	}else{
		parent.parentElement.children[1].style.display="none";
		parent.parentElement.children[2].style.display="block";
		children[0].style.color="orange";
		children[1].style.color="#163168";
	}
}

//实现动态图片
var IMG_COUNT=6;
var INTERVAL=5000;

function nextImage(){
	n+=1;
	if(n>IMG_COUNT)
		n=1;
	imgEle.src="img/dm"+n+((n==6)?".png":".jpg");
}

function preImage(){
	n-=1;
	if(n==0)
		n=IMG_COUNT;
	imgEle.src="img/dm"+n+((n==6)?".png":".jpg");
}

function rightBtnChangeImg(){
	clearInterval(intervalObj);
	nextImage();
	intervalObj=setInterval("nextImage()",INTERVAL);
}

function leftBtnChangeImg(){
	clearInterval(intervalObj);
	preImage();
	intervalObj=setInterval("nextImage()",INTERVAL);
}
