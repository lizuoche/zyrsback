var queryStr = location.href.substring(location.href.indexOf("?") + 1);
var parameters = queryStr.split("=");
var type = parameters[1].split("_")[0];
var id = parameters[1].split("_")[1];

$(function() {
	if(type!='bom'&&type!='goods'){
		$("#issellbody").empty();
	}
	doSearch();
});

$(function() {
	upload();
});

// 获取要修改的领子信息
function doSearch() {
	$
			.ajax({
				type : "post",
				url : "parts/getParts",
				data : {
					"id" : id,
					"type": type
				},
				dataType : "json",
				async : false,
				success : function(data) {
					if (data.success) {
						var res = data.result[0];
						image = res.image;
						var tbody = $("#tbody");
						tbody.empty();
						var tabhtml = "";
						$("#enName").val(res.style);
						$("#type").val(res.type);
						$("#cnName").val(res.name);
						$("#wsName").val(res.workshopname);
						$("#modelName").val(res.modelname);
						$("#remark").val(res.remark);
						if(type=="bom"||type=="goods"){
							if(res.issell=="1"){
								$("#issell").attr("checked","checked");
							}else if(res.issell=="0"){
								$("#nosell").attr("checked","checked");
							}
						}
						
						
						tabhtml += '<tr>'
								+ '<td class="lable"><label>平面图：</label></td>'
								+ '<td id="abc"><img alt="平面图" src="upload/平面图/'
								+ res.image
								+ '" style="width:400px;height:200px;"/><label class="up" for="fileToUpload" style="width: 80px;"><input id="fileToUpload" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="fileName" style="display:none;" value="'
								+ res.image
								+ '" /></td>'
								+ '</tr>'
								+ '<tr>'
								+ '<td class="lable"><label>Unity缩略图：</label></td>'
								+ '<td><img alt="Unity缩略图" src="Dress/data/json/'+type+'/image/'
								+ res.image1
								+ '" style="width:400px;height:200px;"/><label class="up" for="fileToUpload1" style="width: 80px;"><input id="fileToUpload1" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="fileName1" style="display:none;" value="'
								+ res.image1
								+ '" /></td>'
								+ '</tr>'
								+ '<tr>'
								+ '<td class="lable"><label>PC版缩略图：</label></td>'
								+ '<td><img alt="PC版缩略图" src="Dress/data/json/'+type+'/image/'
								+ res.image2
								+ '" style="width:400px;height:200px;"/><label class="up" for="fileToUpload2" style="width: 80px;"><input id="fileToUpload2" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="fileName2" style="display:none;" value="'
								+ res.image2
								+ '" /></td>'
								+ '</tr>'
								+ '<tr>'
								+ '<td class="lable"><label>备用图：</label></td>'
								+ '<td><img alt="备用图" src="Dress/data/json/'+type+'/image/'
								+ res.image3
								+ '" style="width:400px;height:200px;"/><label class="up" for="fileToUpload3" style="width: 80px;"><input id="fileToUpload3" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="fileName3" style="display:none;" value="'
								+ res.image3 + '" /></td>' + '</tr>'
						tbody.append(tabhtml);
					}
				}
			});
}

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
	// if ($("#modelName").val() == "") {
	// $("#modelNameError").html("<font style='color:red'>请输入模型名称!</font>");
	// $("#modelName").focus();
	// return false;
	// }
	// if ($("#fileName").val() == "") {
	// layer.alert('平面图尚未上传!', {
	// icon : 2
	// })
	// $("#fileToUpload").focus();
	// return false;
	// }
	// if ($("#fileName1").val() == "") {
	// layer.alert('Unity缩略图尚未上传!', {
	// icon : 2
	// })
	// $("#fileToUpload1").focus();
	// return false;
	// }
	// if ($("#fileName2").val() == "") {
	// layer.alert('PC版缩略图尚未上传!', {
	// icon : 2
	// })
	// $("#fileToUpload2").focus();
	// return false;
	// }

	layer.confirm("确定修改吗？", function() {
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
			url : "parts/updateParts",
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
					layer.alert("修改信息成功!", {
						icon : 1
					});
				} else {
					layer.alert("修改信息失败!", {
						icon : 2
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
		$("#enName").val($("#enName").val());
		$("#enNameError").html("");
	} else {
		$("#enNameError").html("<font style='color:red'>请输入英文名!</font>");
		$("#enName").focus();
	}
}

// 验证中文名是否为空
function checkCnName() {
	if ($("#cnName").val() != "") {
		$("#cnName").val($("#cnName").val());
		$("#cnNameError").html("");
	} else {
		$("#cnNameError").html("<font style='color:red'>请输入中文名!</font>");
		$("#cnName").focus();
	}
}

function checkWsName() {
	if ($("#wsName").val() != "") {
		$("#wsName").val($("#wsName").val());
		$("#wsNameError").html("");
	} else {
		$("#wsNameError").html("<font style='color:red'>请输入工坊名称!</font>");
		$("#wsName").focus();
	}
}

function checkRemark() {
	if ($("#remark").val() != "") {
		$("#remark").val($("#remark").val());
		$("#remarkError").html("");
	}
}

// 验证模型名称
function checkModelName() {
	if ($("#modelName").val() != "") {
		$("#modelName").val($("#modelName").val());
		$("#modelNameError").html("");
	}
	// else {
	// $("#modelNameError").html("<font style='color:red'>请输入模型名称!</font>");
	// $("#modelName").focus();
	// return;
	// }

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
				return;
			} else {
				$("#modelNameError").html(
						"<font style='color:red'>模型已存在，请重新输入!</font>");
				$("#modelName").focus();
				return;
			}
		}
	});
}

// 上传文件
function upload() {
	// 选择文件之后执行上传
	$('#fileToUpload').on('change', function() {
		$.ajaxFileUpload({
			url : 'parts/upload1',
			type : 'post',
			data : {
				"type" : type,
				"id"   : id,
				"fileName" : $("#fileName").val(),
				"flag"	:	"平面图"
			},
			secureuri : false,
			fileElementId : 'fileToUpload',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#fileName").val(data.name);
				
				setTimeout(function() {
					window.location.reload();
				}, 1500);
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
			url : 'parts/upload1',
			type : 'post',
			data : {
				"type" : type,
				"id"   : id,
				"fileName" : $("#fileName").val(),
				"flag"	:	"Unity缩略图"
			},
			secureuri : false,
			fileElementId : 'fileToUpload1',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#fileName1").val(data.name);
				setTimeout(function() {
					window.location.reload();
				}, 1500);
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
			url : 'parts/upload1',
			type : 'post',
			data : {
				"type" : type,
				"id"   : id,
				"fileName" : $("#fileName").val(),
				"flag"	:	"PC版缩略图",
			},
			secureuri : false,
			fileElementId : 'fileToUpload2',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#fileName2").val(data.name);
				setTimeout(function() {
					window.location.reload();
				}, 1500);
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
			url : 'parts/upload1',
			type : 'post',
			data : {
				"type" : type,
				"id"   : id,
				"fileName" : $("#fileName").val(),
				"flag"	:	"备用图",
			},
			secureuri : false,
			fileElementId : 'fileToUpload3',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#fileName3").val(data.name);
				setTimeout(function() {
					window.location.reload();
				}, 1500);
			},
			error : function(data, status, e) {
				layer.alert(e, {
					icon : 2
				});
			}
		});
	});
}