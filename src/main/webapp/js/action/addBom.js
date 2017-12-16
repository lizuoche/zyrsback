var queryStr = location.href.substring(location.href.indexOf("?") + 1);
var parameters = queryStr.split("=");
var type = parameters[1].split("_")[0];
var enName = parameters[1].split("_")[1];
$(function() {
	upload();
	$("#styleName").val(enName);
});

// 保存
function save() {
	
	// 验证参数
	if ($("#brandNameEN").val() == "") {
		$("#brandNameENError").html("<font style='color:red'>请输入品牌英文名!</font>");
		$("#brandNameEN").focus();
		return false;
	}
	if ($("#brandNameCN").val() == "") {
		$("#brandNameCNError").html("<font style='color:red'>请输入品牌中文名!</font>");
		$("#brandNameCN").focus();
		return false;
	}
	if ($("#bomName").val() == "") {
		$("#bomNameError").html("<font style='color:red'>请输入面料名称!</font>");
		$("#bomName").focus();
		return false;
	}
	if ($("#bomCode").val() == "") {
		$("#bomCodeError").html("<font style='color:red'>请输入面料编码!</font>");
		$("#bomCode").focus();
		return false;
	}
	
	if ($("#brandNameENError").html() != "") {
		$("#brandNameEN").focus();
		return false;
	}
	if ($("#brandNameCNError").html() != "") {
		$("#brandNameCN").focus();
		return false;
	}
	if ($("#bomNameError").html() != "") {
		$("#bomName").focus();
		return false;
	}
	if ($("#bomCodeError").html() != "") {
		$("#bomCode").focus();
		return false;
	}
	
	
	layer.confirm("确定新增吗？", function() {
		var id = null;
		
//		//获取单选框的值
//		var issell=null;
//		var el = document.getElementsByTagName('input');
//		var len = el.length;
//		for (var i = 0; i < len; i++) {
//			if ((el[i].type == "radio") && (el[i].name == 'issell')
//					&& (el[i].checked)) {
//				issell = el[i].value;
//			}
//		}
		$.ajax({
			url : "parts/addParts",
			type : "post",
			dataType : "json",
			data : {
				"type" : type,
				"id" : id,
				"style" : $("#styleName").val(),
				"brandNameEN" : $("#brandNameEN").val(),
				"brandNameCN" : $("#brandNameCN").val(),
				"bomName" : $("#bomName").val(),
				"bomCode" : $("#bomCode").val(),
				"remark" : $("#remark").val(),
				"smallimage" : $("#smallimage").val(),
				"bigimage" : $("#bigimage").val(),
				"normalimage" : $("#normalimage").val()
			},
			async : false,
			success : function(data) {
				if (data.success) {
					layer.alert("新增信息成功!", {
						icon : 1
					});
				} else {
					layer.alert("新增信息失败!", {
					});
				}
				parent.location.reload();
			},
			error : function(data) {
			}
		});
	});
	
}

// 验证品牌英文名是否为空
function checkBrandNameEN() {
	if ($("#brandNameEN").val() != "") {
		$("#brandNameENError").html("");
	} else {
		$("#brandNameENError").html("<font style='color:red'>请输入品牌英文名!</font>");
		$("#brandNameEN").focus();
	}
}

// 验证品牌中文名是否为空
function checkBrandNameCN() {
	if ($("#brandNameCN").val() != "") {
		$("#brandNameCNError").html("");
	} else {
		$("#brandNameCNError").html("<font style='color:red'>请输入品牌中文名!</font>");
		$("#brandNameCN").focus();
	}
}

//验证面料名称是否为空
function checkBomName() {
	if ($("#bomName").val() != "") {
		$("#bomNameError").html("");
	} else {
		$("#bomNameError").html("<font style='color:red'>请输入面料名称!</font>");
		$("#bomName").focus();
	}
}

// 验证面料编码是否已存在
function checkBomCode() {
	if ($("#bomCode").val() != "") {
		$("#bomCodeError").html("");
	} else {
		$("#bomCodeError").html("<font style='color:red'>请输入面料编码名称!</font>");
		$("#bomCode").focus();
		return;
	}
	
	$.ajax({
		type : "post",
		url : "parts/checkBomCode",
		data : {
//			"type" : type,
			"bomcode" : $("#bomCode").val()
		},
		dataType : "json",
		async : false,
		success : function(data) {
			if (data.success) {
				$("#bomCodeError").html("");
				return true;
			} else {
				$("#bomCodeError").html(
						"<font style='color:red'>面料编码已存在，请重新输入!</font>");
				$("#bomCode").focus();
				return false;
			}
		}
	});
}

function del(id) {
	if (confirm("您确定要删除吗?")) {

	}
}

$("#checkall").click(function() {
	$("input[name='id[]']").each(function() {
		if (this.checked) {
			this.checked = false;
		} else {
			this.checked = true;
		}
	});
})


// 上传文件
function upload() {
	// 选择文件之后执行上传
	$('#fileToUpload1').on('change', function() {
		$.ajaxFileUpload({
			url : 'parts/upload',
			type : 'post',
			data : {
				"type" : enName
			},
			secureuri : false,
			fileElementId : 'fileToUpload1',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#smallimage").val(data.name);
			},
			error : function(data, status, e) {
				layer.alert(e, {
					icon : 2
				});
			}
		});
	});

	

	// 选择文件之后执行上传
	$('#fileToUpload2').on('change', function() {
		$.ajaxFileUpload({
			url : 'parts/upload',
			type : 'post',
			data : {
				"type" : enName
			},
			secureuri : false,
			fileElementId : 'fileToUpload2',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#bigimage").val(data.name);
			},
			error : function(data, status, e) {
				layer.alert(e, {
					icon : 2
				});
			}
		});
	});
	
	
	// 选择文件之后执行上传
	$('#fileToUpload3').on('change', function() {
		$.ajaxFileUpload({
			url : 'parts/upload',
			type : 'post',
			data : {
				"type" : enName
			},
			secureuri : false,
			fileElementId : 'fileToUpload3',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#normalimage").val(data.name);
			},
			error : function(data, status, e) {
				layer.alert(e, {
					icon : 2
				});
			}
		});
	});

}