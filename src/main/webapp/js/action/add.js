var queryStr = location.href.substring(location.href.indexOf("?") + 1);
var parameters = queryStr.split("=");
var type = parameters[1].split("_")[0];
var enName = parameters[1].split("_")[1];

$(function() {
	upload();
	$("#enName").val(enName);
	if(type!='bom'&& type!="goods"){
		$("#tbody").empty();
	}
});

// 保存
function save() {
	// 验证参数
	if ($("#enName").val() == "") {
		$("#enNameError").html("<font style='color:red'>请输入英文名!</font>");
		$("#enName").focus();
		return false;
	}
	if ($("#cnName").val() == "") {
		$("#cnNameError").html("<font style='color:red'>请输入中文名!</font>");
		$("#cnName").focus();
		return false;
	}
	if ($("#wsName").val() == "") {
		$("#wsNameError").html("<font style='color:red'>请输入工坊名称!</font>");
		$("#wsName").focus();
		return false;
	}
	
	if ($("#enNameError").html() != "") {
		$("#enName").focus();
		return false;
	}
	if ($("#cnNameError").html() != "") {
		$("#cnName").focus();
		return false;
	}
	if ($("#wsNameError").html() != "") {
		$("#wsName").focus();
		return false;
	}
	if ($("#modelNameError").html() != "") {
		$("#modelName").focus();
		return false;
	}
	
	layer.confirm("确定新增吗？", function() {
		var id = null;
		if($("#fileName").val()!=null||$("#fileName").val()!=""){
			id = $("#fileName").val().substring(0,$("#fileName").val().length-4);
		}
		//获取单选框的值
		var issell=null;
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "radio") && (el[i].name == 'issell')
					&& (el[i].checked)) {
				issell = el[i].value;
			}
		}
		$.ajax({
			url : "parts/addParts",
			type : "post",
			dataType : "json",
			data : {
				"type" : type,
				"id" : id,
				"enName" : $("#enName").val(),
				"productStyle" : $("#type").val(),
				"cnName" : $("#cnName").val(),
				"wsName" : $("#wsName").val(),
				"modelName" : $("#modelName").val(),
				"remark" : $("#remark").val(),
				"image" : $("#fileName").val(),
				"image1" : $("#fileName1").val(),
				"image2" : $("#fileName2").val(),
				"image3" : $("#fileName3").val(),
				"issell" : issell
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

// 验证英文名是否为空
function checkEnName() {
	if ($("#enName").val() != "") {
		$("#enNameError").html("");
	} else {
		$("#enNameError").html("<font style='color:red'>请输入英文名!</font>");
		$("#enName").focus();
	}
}

// 验证中文名是否为空
function checkCnName() {
	if ($("#cnName").val() != "") {
		$("#cnNameError").html("");
	} else {
		$("#cnNameError").html("<font style='color:red'>请输入中文名!</font>");
		$("#cnName").focus();
	}
}

function checkWsName() {
	if ($("#wsName").val() != "") {
		$("#wsNameError").html("");
	} else {
		$("#wsNameError").html("<font style='color:red'>请输入工坊名称!</font>");
		$("#wsName").focus();
	}
}

// 验证模型名称
function checkModelName() {
//	if ($("#modelName").val() != "") {
//		$("#modelNameError").html("");
//	} else {
//		$("#modelNameError").html("<font style='color:red'>请输入模型名称!</font>");
//		$("#modelName").focus();
//		return;
//	}
	$.ajax({
		type : "post",
		url : "parts/checkModelName",
		data : {
			"type" : type,
			"modelName" : $("#modelName").val()
		},
		dataType : "json",
		async : false,
		success : function(data) {
			if (data.success) {
				$("#modelNameError").html("");
				return true;
			} else {
				$("#modelNameError").html(
						"<font style='color:red'>模型已存在，请重新输入!</font>");
				$("#modelName").focus();
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
	$('#fileToUpload').on('change', function() {
		$.ajaxFileUpload({
			url : 'parts/upload',
			type : 'post',
			data : {
				"type" : "平面图"
			},
			secureuri : false,
			fileElementId : 'fileToUpload',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#fileName").val(data.name);
			},
			error : function(data, status, e) {
				layer.alert(e, {
					icon : 2
				});
			}
		});
	});

	// 选择文件之后执行上传
	$('#fileToUpload1').on('change', function() {
		$.ajaxFileUpload({
			url : 'parts/upload',
			type : 'post',
			data : {
				"type" : "Unity缩略图"
			},
			secureuri : false,
			fileElementId : 'fileToUpload1',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#fileName1").val(data.name);
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
				"type" : "PC版缩略图"
			},
			secureuri : false,
			fileElementId : 'fileToUpload2',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#fileName2").val(data.name);
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
				"type" : "备用图"
			},
			secureuri : false,
			fileElementId : 'fileToUpload3',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#fileName3").val(data.name);
			},
			error : function(data, status, e) {
				layer.alert(e, {
					icon : 2
				});
			}
		});
	});
}