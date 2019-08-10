var page_ul = document.querySelector(".page > ul"); 
var uls = document.querySelectorAll(".wrapper-ul")
// 页数
var len = 0;
var index = 1;
function init(lenght) {
	len = lenght;
	play_paging(index);
	hezi(index);
}

function play_paging(index) {
	// index不可超出范围
	if (index > len || index < 0) {
		return;
	}
	// 移除li
	var ul_lis = document.querySelectorAll(".page > ul > li")
	if (ul_lis.length != 0) {
		for (var i = 0; i < ul_lis.length; i++) {
			page_ul.removeChild(ul_lis[i]);
		}
	}
	// li的布局
	if (len <= 7 && len > 0) {
		for (var i = 0; i < len; i++) {
			var para = document.createElement("li");
			var node = document.createTextNode(i + 1);
			para.appendChild(node);
			page_ul.appendChild(para);
		}
	} else if (len > 7) {
		if (index < 5) {
			for (var i = 0; i < 5; i++) {
				var para = document.createElement("li");
				var node = document.createTextNode(i + 1);
				para.appendChild(node);
				page_ul.appendChild(para);
			}
			var para = document.createElement("li");
			var node = document.createTextNode("...");
			para.appendChild(node);
			page_ul.appendChild(para);
			var para = document.createElement("li");
			var node = document.createTextNode(len);
			para.appendChild(node);
			page_ul.appendChild(para);
		} else if (index > len - 5) {
			var para = document.createElement("li");
			var node = document.createTextNode(1);
			para.appendChild(node);
			page_ul.appendChild(para);
			var para = document.createElement("li");
			var node = document.createTextNode("...");
			para.appendChild(node);
			page_ul.appendChild(para);
			var para = document.createElement("li");
			for (var i = len - 5; i < len; i++) {
				var para = document.createElement("li");
				var node = document.createTextNode(i + 1);
				para.appendChild(node);
				page_ul.appendChild(para);
			}
		} else {
			var para = document.createElement("li");
			var node = document.createTextNode(1);
			para.appendChild(node);
			page_ul.appendChild(para);
			var para = document.createElement("li");
			var node = document.createTextNode("...");
			para.appendChild(node);
			page_ul.appendChild(para);
			if (index % 2 == 0) {
				for (var i = index - 1; i < index + 2; i++) {
					var para = document.createElement("li");
					var node = document.createTextNode(i);
					para.appendChild(node);
					page_ul.appendChild(para);
				}
			} else {
				for (var i = index; i < index + 3; i++) {
					var para = document.createElement("li");
					var node = document.createTextNode(i);
					para.appendChild(node);
					page_ul.appendChild(para);
				}
			}
			var para = document.createElement("li");
			var node = document.createTextNode("...");
			para.appendChild(node);
			page_ul.appendChild(para);
			var para = document.createElement("li");
			var node = document.createTextNode(len);
			para.appendChild(node);
			page_ul.appendChild(para);
		}
	}
	var li_list = document.querySelectorAll(".page > ul > li")
	for (var i = 0; i < li_list.length; i++) {
		if (li_list[i].innerHTML == index) {
			console.log(li_list[i].style.background = "red");
		}

	}
}

var up_page = document.querySelector(".up-page");
var down_page = document.querySelector(".down-page");

// 盒子display 选择
function hezi(index) {
	for (var i = 0; i < uls.length; i++) {
		if (uls[i].getAttribute("index") == index + "") {
			for (var j = 0; j < uls.length; j++) {
				uls[j].style.display = "none";
			}
			uls[i].style.display = "block";
		}
	}
}
// index初始化为1

up_page.addEventListener("click", function() {
	if (index <= 1) {
		return;
	}
	index = index - 1;
	play_paging(index);
	hezi(index)
});
down_page.addEventListener("click", function() {
	if (index >= len) {
		return;
	}
	index = index + 1;
	play_paging(index);
	hezi(index)
});

// 点击分页进行选择
setInterval(function() {
	var ul_lis = document.querySelectorAll(".page > ul > li");
	for (var i = 0; i < ul_lis.length; i++) {
		ul_lis[i].addEventListener("click", function() {
			var num = parseInt(this.innerHTML)
			index = num;
			hezi(index)
			play_paging(num)
		});
	}
}, 100);
