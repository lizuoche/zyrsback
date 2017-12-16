var queryStr = location.href.substring(location.href.indexOf("?") + 1);
var parameters = queryStr.split("=");
var type = parameters[1];

$(function() {
	if("suit"==type){
		doSearch("collar");
		doSearch("breastpocket");
		doSearch("pocket");
		doSearch("buff");
		doSearch("buttonnum");
		doSearch("placket");
		doSearch("back");
		doSearch("botouyan");
		doSearch("buttoneye");
	}else if("trousers"==type){
		doSearch("yaotou");
		doSearch("kujiao");
		doSearch("frontdart");
		doSearch("cekoudai");
		doSearch("houkoudai");
		doSearch("kouyan");
	}else if("shirt"==type){
		doSearch("collar");
		doSearch("font");
		doSearch("back");
		doSearch("buff");
		doSearch("breastpocket");
		doSearch("kouyan");
	}else if("vest"==type){
		doSearch("collar");
		doSearch("breastpocket");
		doSearch("pocket");
		doSearch("xiabai");
		doSearch("kouyan");
	}
});

$(function() {
	upload();
});

// 查找西服配件款式
function doSearch(enName) {
	$.ajax({
		type : "post",
		url : "parts/getParts",
		data : {
			"type" : type,
			"enName" : enName
		},
		dataType : "json",
		async : false,
		success : function(data) {
			if (data.success) {
				var templateList = data.result;

				var tbody = $('#' + enName + 'body');
				tbody.empty();
				if (templateList.length > 0) {
					var tabhtml = '<tr><td class="lable" colspan="5"><label>'+enName+'</label></td></tr>'
							   +  '<tr>'
							   +	   '<td class="lable" >ID</td>'
							   +	   '<td class="lable" >中文名称</td>'
							   +	   '<td class="lable" >工坊名称</td>'
							   +	   '<td class="lable" >模型编号</td>'
							   +	   '<td class="lable" >备注</td>'
							   +  '</tr>';
					for (var i = 0; i < templateList.length; i++) {
						var template = templateList[i];
						var dssid = template.id;
						tabhtml += '<tr>' 
								+		'<td><input type="checkbox" name="'+ enName + '" value="' + dssid + '" class="'+ enName + '"/></td>'
								+ 		'<td>' + template.name+ '</td>'
								+ 		'<td>' + template.workshopname+ '</td>' 
								+ 		'<td>' + template.modelname+ '</td>'
								+ 		'<td>' + template.remark + '</td>'
								+ 	'</tr>'

					}
					tbody.append(tabhtml);
				}
			}
		}
	});
}
// 保存新增的款式配置
function save() {
	// 验证参数
	if ($("#styleName").val() == "") {
		$("#styleNameError").html("<font style='color:red'>请输入款式名!</font>");
		$("#styleName").focus();
		return false;
	}

	if ($("#styleNameError").html() != "") {
		$("#styleName").focus();
		return false;
	}

	if ($("#assetbundle").val() == "") {
		$("#assetbundleError").html("<font style='color:red'>请输入模型名!</font>");
		$("#assetbundle").focus();
		return false;
	}

	if ($("#assetbundleError").html() != "") {
		$("#assetbundle").focus();
		return false;
	}

	layer.confirm("确定新增吗？", function() {
		//获取附选信息
		var el = document.getElementsByTagName('input');
		var len = el.length;
		for (var i = 0; i < len; i++) {
			if ((el[i].type == "checkbox") && (el[i].name == 'checkbox')
					&& (el[i].checked)) {
				el[i].value = '1';
			}
		}
		
		if("suit" == type){
			// 获取选中的领子id号
			var collars = '';
//			var length = $("input[name='collar']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择领子信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'collar')
						&& (el[i].checked)) {
					collars = collars + el[i].value + ",";
				}
			}

			// 获取选中的胸袋id号
			var breastPockets = '';
//			var length = $("input[name='breastPocket']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择胸袋信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'breastPocket')
						&& (el[i].checked)) {
					breastPockets = breastPockets + el[i].value + ",";
				}
			}

			// 获取选中的口袋id号
			var pockets = '';
//			var length = $("input[name='pocket']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择口袋信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'pocket')
						&& (el[i].checked)) {
					pockets = pockets + el[i].value + ",";
				}
			}

			// 获取选中的袖子id号
			var sleeves = '';
//			var length = $("input[name='sleeve']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择袖子信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'buff')
						&& (el[i].checked)) {
					sleeves = sleeves + el[i].value + ",";
				}
			}

			// 获取选中的袖扣数量id号
			var buttonNums = '';
//			var length = $("input[name='buttonNum']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择袖扣数量信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'buttonNum')
						&& (el[i].checked)) {
					buttonNums = buttonNums + el[i].value + ",";
				}
			}

			// 获取选中的门襟id号
			var plackets = '';
//			var length = $("input[name='placket']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择门襟信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'placket')
						&& (el[i].checked)) {
					plackets = plackets + el[i].value + ",";
				}
			}

			// 获取选中的后片id号
			var backs = '';
//			var length = $("input[name='back']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择后片信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'back')
						&& (el[i].checked)) {
					backs = backs + el[i].value + ",";
				}
			}
			
			// 获取选中的驳头眼id号
			var botouyans = '';
//			var length = $("input[name='back']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择驳头眼信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'botouyan')
						&& (el[i].checked)) {
					botouyans = botouyans + el[i].value + ",";
				}
			}
			
			// 获取选中的扣眼id号
			var buttonEyes = '';
//			var length = $("input[name='buttonEye']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择扣眼信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'buttonEye')
						&& (el[i].checked)) {
					buttonEyes = buttonEyes + el[i].value + ",";
				}
			}
			$.ajax({
				url : "parts/addStyle",
				type : "post",
				dataType : "json",
				data : {
					"type" : type,
					"styleName" :$("#styleName").val(),
					"assetbundle" :$("#assetbundle").val(),
					"collar" : collars,
					"breastPocket" : breastPockets,
					"pocket" : pockets,
					"sleeve" : sleeves,
					"buttonNum" :buttonNums,
					"placket" : plackets,
					"back" : backs,
					"botouyan" : botouyans,
					"buttonEye" : buttonEyes,
					"smallimage" : $("#smallimage").val(),
					"bigimage" : $("#bigimage").val(),
					"suitbom" : $("#suitBom").val(),
					"shirtbom" : $("#shirtBom").val(),
					"insidebom" : $("#insideBom").val(),
					"kouyanbom" : $("#kouyanBom").val(),
					"botouyanbom" : $("#botouyanBom").val(),
					"tiebom" : $("#tieBom").val(),
					"suitbutton" : $("#suitButton").val(),
					"shirtbutton" : $("#shirtButton").val(),
					"vestbutton" : $("#vestButton").val(),
					"trousersbutton" : $("#trousersButton").val(),
					"tie" : $("#tie").val(),
					"cravat" : $("#cravat").val()
				},
				async : false,
				success : function(data) {
					if (data.success) {
						layer.alert("新增信息成功!", {
							icon : 1
						});
					} else {
						layer.alert("新增信息失败!", {});
					}
					parent.location.reload();
				},
				error : function(data) {
				}
			});
		}else if("trousers" == type){

			// 获取选中的腰头id号
			var yaotous = '';
//			var length = $("input[name='yaotou']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择腰头信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'yaotou')
						&& (el[i].checked)) {
					yaotous = yaotous + el[i].value + ",";
				}
			}

			// 获取选中的裤脚id号
			var kujiaos = '';
//			var length = $("input[name='kujiao']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择裤脚信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'kujiao')
						&& (el[i].checked)) {
					kujiaos = kujiaos + el[i].value + ",";
				}
			}
			
			// 获取选中的前褶id号
			var frontdarts = '';
//			var length = $("input[name='kujiao']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择裤脚信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'frontdart')
						&& (el[i].checked)) {
					frontdarts = frontdarts + el[i].value + ",";
				}
			}

			// 获取选中的侧口袋id号
			var cekoudais = '';
//			var length = $("input[name='cekoudai']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择侧口袋信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'cekoudai')
						&& (el[i].checked)) {
					cekoudais = cekoudais + el[i].value + ",";
				}
			}

			// 获取选中的后口袋id号
			var houkoudais = '';
//			var length = $("input[name='houkoudai']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择后口袋信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'houkoudai')
						&& (el[i].checked)) {
					houkoudais = houkoudais + el[i].value + ",";
				}
			}

			// 获取选中的扣眼id号
			var kouyans = '';
//			var length = $("input[name='kouyan']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择扣眼信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'kouyan')
						&& (el[i].checked)) {
					kouyans = kouyans + el[i].value + ",";
				}
			}

			$.ajax({
				url : "parts/addStyle",
				type : "post",
				dataType : "json",
				data : {
					"type" : type,
					"styleName" :$("#styleName").val(),
					"assetbundle" :$("#assetbundle").val(),
					"yaotou" : yaotous,
					"kujiao" : kujiaos,
					"frontdart" : frontdarts,
					"cekoudai" : cekoudais,
					"houkoudai" : houkoudais,
					"kouyan" : kouyans,
					"smallimage" : $("#smallimage").val(),
					"bigimage" : $("#bigimage").val(),
					"suitbom" : $("#suitBom").val(),
					"shirtbom" : $("#shirtBom").val(),
					"insidebom" : $("#insideBom").val(),
					"kouyanbom" : $("#kouyanBom").val(),
					"botouyanbom" : $("#botouyanBom").val(),
					"tiebom" : $("#tieBom").val(),
					"suitbutton" : $("#suitButton").val(),
					"shirtbutton" : $("#shirtButton").val(),
					"vestbutton" : $("#vestButton").val(),
					"trousersbutton" : $("#trousersButton").val(),
					"tie" : $("#tie").val(),
					"cravat" : $("#cravat").val()
				},
				async : false,
				success : function(data) {
					if (data.success) {
						layer.alert("新增信息成功!", {
							icon : 1
						});
					} else {
						layer.alert("新增信息失败!", {});
					}
					parent.location.reload();
				},
				error : function(data) {
				}
			});
		}else if("shirt" == type){
			// 获取选中的领子id号
//			var collars = '';
//			var length = $("input[name='collar']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择领子信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'collar')
						&& (el[i].checked)) {
					collars = collars + el[i].value + ",";
				}
			}

			// 获取选中的正面id号
			var fonts = '';
//			var length = $("input[name='font']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择正面信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'font')
						&& (el[i].checked)) {
					fonts = fonts + el[i].value + ",";
				}
			}

			// 获取选中的背面id号
			var backs = '';
//			var length = $("input[name='back']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择背面信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'back')
						&& (el[i].checked)) {
					backs = backs + el[i].value + ",";
				}
			}

			// 获取选中的袖子id号
			var sleeves = '';
//			var length = $("input[name='sleeve']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择胸袋信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'buff')
						&& (el[i].checked)) {
					sleeves = sleeves + el[i].value + ",";
				}
			}

			// 获取选中的胸袋id号
			var breastPockets = '';
//			var length = $("input[name='breastPocket']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择胸袋信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'breastPocket')
						&& (el[i].checked)) {
					breastPockets = breastPockets + el[i].value + ",";
				}
			}
			
			// 获取选中的扣眼id号
			var kouyans = '';
//			var length = $("input[name='kouyan']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择扣眼信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'kouyan')
						&& (el[i].checked)) {
					kouyans = kouyans + el[i].value + ",";
				}
			}
			$.ajax({
				url : "parts/addStyle",
				type : "post",
				dataType : "json",
				data : {
					"type" : type,
					"styleName" :$("#styleName").val(),
					"assetbundle" :$("#assetbundle").val(),
					"collar" : collars,
					"font" : fonts,
					"back" : backs,
					"sleeve" : sleeves,
					"breastPocket" : breastPockets,
					"kouyan" : kouyans,
					"smallimage" : $("#smallimage").val(),
					"bigimage" : $("#bigimage").val(),
					"suitbom" : $("#suitBom").val(),
					"shirtbom" : $("#shirtBom").val(),
					"insidebom" : $("#insideBom").val(),
					"kouyanbom" : $("#kouyanBom").val(),
					"botouyanbom" : $("#botouyanBom").val(),
					"tiebom" : $("#tieBom").val(),
					"suitbutton" : $("#suitButton").val(),
					"shirtbutton" : $("#shirtButton").val(),
					"vestbutton" : $("#vestButton").val(),
					"trousersbutton" : $("#trousersButton").val(),
					"tie" : $("#tie").val(),
					"cravat" : $("#cravat").val()
				},
				async : false,
				success : function(data) {
					if (data.success) {
						layer.alert("新增信息成功!", {
							icon : 1
						});
					} else {
						layer.alert("新增信息失败!", {});
					}
					parent.location.reload();
				},
				error : function(data) {
				}
			});
		}else if("vest" == type){
			// 获取选中的领子id号
			var collars = '';
//			var length = $("input[name='collar']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择领子信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'collar')
						&& (el[i].checked)) {
					collars = collars + el[i].value + ",";
				}
			}

			// 获取选中的胸袋id号
			var breastPockets = '';
//			var length = $("input[name='breastPocket']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择胸袋信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'breastPocket')
						&& (el[i].checked)) {
					breastPockets = breastPockets + el[i].value + ",";
				}
			}

			// 获取选中的口袋id号
			var pockets = '';
//			var length = $("input[name='pocket']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择口袋信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'pocket')
						&& (el[i].checked)) {
					pockets = pockets + el[i].value + ",";
				}
			}

			// 获取选中的下摆id号
			var xiabais = '';
//			var length = $("input[name='xiabai']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择下摆信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'xiabai')
						&& (el[i].checked)) {
					xiabais = xiabais + el[i].value + ",";
				}
			}

			// 获取选中的扣眼id号
			var kouyans = '';
//			var length = $("input[name='kouyan']:checked").length;
//			if (length < 1) {
//				layer.alert("请选择扣眼信息!", {
//					icon : 2
//				});
//				return false;
//			}
			var el = document.getElementsByTagName('input');
			var len = el.length;
			for (var i = 0; i < len; i++) {
				if ((el[i].type == "checkbox") && (el[i].name == 'kouyan')
						&& (el[i].checked)) {
					kouyans = kouyans + el[i].value + ",";
				}
			}
			
			$.ajax({
				url : "parts/addStyle",
				type : "post",
				dataType : "json",
				data : {
					"type" : type,
					"styleName" :$("#styleName").val(),
					"assetbundle" :$("#assetbundle").val(),
					"collar" : collars,
					"breastPocket" : breastPockets,
					"pocket" : pockets,
					"xiabai" : xiabais,
					"kouyan" : kouyans,
					"smallimage" : $("#smallimage").val(),
					"bigimage" : $("#bigimage").val(),
					"suitbom" : $("#suitBom").val(),
					"shirtbom" : $("#shirtBom").val(),
					"insidebom" : $("#insideBom").val(),
					"kouyanbom" : $("#kouyanBom").val(),
					"botouyanbom" : $("#botouyanBom").val(),
					"tiebom" : $("#tieBom").val(),
					"suitbutton" : $("#suitButton").val(),
					"shirtbutton" : $("#shirtButton").val(),
					"vestbutton" : $("#vestButton").val(),
					"trousersbutton" : $("#trousersButton").val(),
					"tie" : $("#tie").val(),
					"cravat" : $("#cravat").val()
				},
				async : false,
				success : function(data) {
					if (data.success) {
						layer.alert("新增信息成功!", {
							icon : 1
						});
					} else {
						layer.alert("新增信息失败!", {});
					}
					parent.location.reload();
				},
				error : function(data) {
				}
			});
		}
		
		
	});

}

// 验证款式名是否为空
function checkStyleName() {
	if ($("#styleName").val() != "") {
		$("#styleNameError").html("");
	} else {
		$("#styleNameError").html("<font style='color:red'>请输入款式名称!</font>");
		$("#styleName").focus();
	}
}

// 验证模型名称是否为空
function checkAssetBundle() {
	if ($("#assetbundle").val() != "") {
		$("#assetbundleError").html("");
	} else {
		$("#assetbundleError").html("<font style='color:red'>请输入模型名称!</font>");
		$("#assetbundle").focus();
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
	// if ($("#modelName").val() != "") {
	// $("#modelNameError").html("");
	// } else {
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

// 上传文件
function upload() {
	// 选择文件之后执行上传
	$('#fileToUpload1').on('change', function() {
		$.ajaxFileUpload({
			url : 'parts/upload',
			type : 'post',
			data : {
				"type" : "smallimage"
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
				"type" : "bigimage"
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