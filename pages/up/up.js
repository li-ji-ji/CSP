// pages/up/up.js
Page({
	handleGetMessage: function(e) {
		var that = this

		// 数据信息获取，处理，拼接
		//原始数据
		var fileName = String(e.detail.data[0].fileName[0].fileName)
		var path = String(e.detail.data[0].fileName[0].path)
		var time = String(e.detail.data[0].fileName[0].time)
		var page = String(e.detail.data[0].fileName[0].page)
		var status = String(e.detail.data[0].fileName[0].status)
		// 拼接文件默认的打印设置
		var demand = {
			color: "黑白",
			paper: "A4",
			use: "单面",
			number: 1,
			userPage: page
		}

		// 文件在小程序中图片的显示
		var suffix = fileName.split(".")
		suffix = suffix[suffix.length - 1]
		// console.log(suffix)
		if (suffix == 'ppt' || suffix == 'pptx') {
			var suffix = "../../image/ppt.png"
		} else if (suffix == 'xlsx' || suffix == 'xls') {
			var suffix = "../../image/xls.png"
		} else if (suffix == 'doc' || suffix == 'docx') {
			var suffix = "../../image/doc.png"
		} else if (suffix == 'pdf' || suffix == 'pdfx') {
			var suffix = "../../image/pdf.png"
		} else {
			var suffix = "../../image/im.png"
		}
		var fileSize = String(e.detail.data[0].fileName[0].fileSize)

		var array = {
			"fileName": fileName,
			"path": path,
			"time": time,
			"fileSize": fileSize,
			"page": page,
			"status": status,
			"demand": demand,
			"suffix": suffix
		}
		// 图片信息上传
		wx.setStorage({
			key: "array",
			data: array
		})
		// 给homepage标记  告诉它可以运行
		wx.setStorage({
			key: "ican",
			data: "yes"
		})
	},
})
