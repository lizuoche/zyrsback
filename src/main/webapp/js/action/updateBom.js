var queryStr = location.href.substring(location.href.indexOf("?") + 1);
var parameters = queryStr.split("=");
var type = parameters[1].split("_")[0];
var id = parameters[1].split("_")[1];
var url = null;

$(function() {
	if(type=="suitbom"){
		url = "suit_texture/";
	}else if(type=="insidebom"){
		url = "inside_texture/";
	}else if(type=="shirtbom"){
		url = "shirt_texture/";
	}else if(type=="tiebom"){
		url = "tie_texture/";
	}else if(type=="botouyanbom"){
		url = "botouyan_texture/";
	}else if(type=="kouyanbom"){
		url = "kouyan_texture/";
	}
	doSearch();
});

$(function() {
	upload();
});

// 获取要修改的面料信息
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
						var tbody = $("#tbody");
						tbody.empty();
						var tabhtml = "";
						$("#styleName").val(res.style);
						$("#brandNameEN").val(res.english_brand_name);
						$("#brandNameCN").val(res.china_brand_name);
						$("#bomName").val(res.name);
						$("#bomCode").val(res.code);
						$("#remark").val(res.remark);
						
						tabhtml += '<tr>'
								+ '<td class="lable"><label>Small_Image：</label></td>'
								+ '<td id="abc"><img alt="Small_Image" src="Dress/data/TextureMaterial/'+url
								+ res.small_image
								+ '" style="max-width:400px "/><label class="up" for="fileToUpload" style="width: 80px;"><input id="fileToUpload" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="smallimage" style="display:none;" value="'
								+ res.small_image
								+ '" /></td>'
								+ '</tr>'
								+ '<tr>'
								+ '<td class="lable"><label>Big_Image：</label></td>'
								+ '<td><img alt="Big_Image" src="Dress/data/TextureMaterial/'+url
								+ res.big_image
								+ '" style="max-width:400px "/><label class="up" for="fileToUpload1" style="width: 80px;"><input id="fileToUpload1" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="bigimage" style="display:none;" value="'
								+ res.big_image
								+ '" /></td>'
								+ '</tr>'
								+ '<tr>'
								+ '<td class="lable"><label>Normal_Image：</label></td>'
								+ '<td><img alt="Normal_Image" src="Dress/data/TextureMaterial/'+url
								+ res.normal_image
								+ '" style="max-width:400px "/><label class="up" for="fileToUpload2" style="width: 80px;"><input id="fileToUpload2" style="" class="bg" type="file" name="upfile"><span style="float: left; margin-left: 5px">上传图片</span></label><input type="text" id="normalimage" style="display:none;" value="'
								+ res.normal_image
								+ '" /></td>'
								+ '</tr>'
						tbody.append(tabhtml);
						
						$("#smallimage").val(res.small_image);
						$("#bigimage").val(res.big_image);
						$("#normalimage").val(res.normal_image);
					}
				}
			});
}

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
	
	
	layer.confirm("确定修改吗？", function() {
		$.ajax({
			url : "parts/updateParts",
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

//验证品牌英文名是否为空
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
//	if ($("#modelName").val() != "") {
//		$("#modelNameError").html("");
//	} else {
//		$("#modelNameError").html("<font style='color:red'>请输入模型名称!</font>");
//		$("#modelName").focus();
//		return;
//	}
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
					"fileName" : $("#smallimage").val(),
					"flag"	:	"smallimage"
			},
			secureuri : false,
			fileElementId : 'fileToUpload',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#smallimage").val(data.name);
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
				"fileName" : $("#bigimage").val(),
				"flag"	:	"bigimage"
			},
			secureuri : false,
			fileElementId : 'fileToUpload1',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#bigimage").val(data.name);
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
				"fileName" : $("#normalimage").val(),
				"flag"	:	"normalimage"
			},
			secureuri : false,
			fileElementId : 'fileToUpload2',// file标签的id
			dataType : 'json',// 返回数据的类型
			success : function(data) {
				$("#normalimage").val(data.name);
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