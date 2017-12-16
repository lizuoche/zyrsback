$(function() {
	doSearch();
});

// 截取字符串显示
function getInterceptedStr(sSource, iLen) {
	if (sSource.replace(/[^x00-xff]/g, "xx").length <= iLen) {
		return sSource;
	}
	var ELIDED = "...";

	var str = "";
	var l = 0;
	var schar;
	for (var i = 0; schar = sSource.charAt(i); i++) {
		str += schar;
		l += (schar.match(/[^x00-xff]/) != null ? 2 : 1);
		if (l >= iLen - ELIDED.length) {
			break;
		}
	}
	str += ELIDED;

	return str;
}

function doSearch() {
	$
			.ajax({
				type : "post",
				url : "../../parts/getParts",
				data : {
					"type" : "trousers",
					"enName" : "cekoudai"
				},
				dataType : "json",
				async : false,
				success : function(data) {
					if (data.success) {
						var templateList = data.result;

						var tbody = $("#tbody");
						tbody.empty();
						if (templateList.length > 0) {
							var tabhtml = "";
							for (var i = 0; i < templateList.length; i++) {
								var template = templateList[i];
								var dssid = template.id;
								var test = 111;
								tabhtml += "<tr>"
										+ "<td><input type='checkbox' name='check' value='"
										+ dssid
										+ "'/></td>"
										+ "<td>"
										+ template.style
										+ "</td>"
										+ "<td>"
										+ template.type
										+ "</td>"
										+ "<td>"
										+ template.name
										+ "</td>"
										+ "<td>"
										+ template.workshopname
										+ "</td>"
										+ "<td>"
										+ template.modelname
										+ "</td>"
										+ "<td>"
										+ template.remark
										+ "</td>"
										+ "<td>"
										+ getInterceptedStr(template.image, 20)
										+ "</td>"
										+ "<td>"
										+ getInterceptedStr(template.image1, 20)
										+ "</td>"
										+ "<td>"
										+ getInterceptedStr(template.image2, 20)
										+ "</td>"
										+ "<td>"
										+ getInterceptedStr(template.image3, 20)
										+ "</td>"
										+ "<td>"
										+ "<div class='button-group'><a class='button border-red' onclick='del("+ '"trousers_'+ dssid+ '"'+ ")'><span class='icon-trash-o'></span>删除</a></div>"
										+ "<div class='button-group'><a class='button border-red' onclick='update("+'"trousers_'+dssid+'"'+")'><span class='icon-trash-o'></span>修改</a></div>"
										+ "</td>" + "</tr>"

							}
							tbody.append(tabhtml);
						}
					}
				}
			});
}


// 新增
function add(enName) {
	layer.open({
		type : 2,
		area : [ '950px', '630px' ],
		title : "新增裤子侧口袋",
		shadeClose : false, // 点击遮罩关闭
		content : '../action/add.jsp?enName='+enName
	});
}


//修改
function update(id) {
	layer.open({
		type : 2,
		area : [ '1000px', '700px' ],
		title : "修改裤子侧口袋",
		shadeClose : false, // 点击遮罩关闭
		content : '../action/update.jsp?id='+id
	});
}

//删除
function del(ids) {
	// 获取选中的id号
	if (ids==null||ids==''){
		ids='';
		var length = $("input[name='check']:checked").length;
		if (length < 1) {
			layer.alert("请选择信息!", {
				icon : 2
			});
			return false;
		}
		 var el = document.getElementsByTagName('input');
		 var len = el.length;
		 for (var i = 0; i < len; i++) {
			 if ((el[i].type == "checkbox") && (el[i].name == 'check') && (el[i].checked)){
				 ids =ids + el[i].value+",";
			 }
		 }
	}else{
		ids=ids.split('_')[1];
	}
	layer.confirm("确定要删除吗？", {
		btn : [ '确定','取消' ],// 可以无限个按钮

	}, function() {
		deldteSpare(ids);
	});

}

//批量删除
function deldteSpare(ids) {
    	 $.ajax({
 			url : "../../parts/deleteParts",
 			type : "post",
 			dataType : "json",
 			data : {
 				"type" : "trousers",
 				"ids" : ids
 			},
 			async : false,
 			success : function(data) {
 				if (data.success) {
 					layer.alert("删除信息成功！", {
 						icon : 1
 					});
 					window.location.reload();
 				} else {
 					layer. alert("删除信息失败！",{
 						icon :2
 					});
 				}
 			},
 		});
}