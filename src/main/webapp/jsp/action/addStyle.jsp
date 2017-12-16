<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>css/zhome.css" />
<link rel="stylesheet" href="<%=basePath%>css/zpop.css" />
<link rel="stylesheet" href="<%=basePath%>css/table.css" />
<link rel="stylesheet" href="<%=basePath%>css/style.css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/ajaxfileupload.js"></script>
<script type="text/javascript" src="<%=basePath%>js/action/addStyle.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>
<style type="text/css">
.up {
	background-image: url("images/button_small.png");
	height: 28px;
	border: 1px;
	color: white;
	padding-top: 5px;
	cursor: pointer;
	display: block;
}

.bg {
	loat: left;
	width: 80px;
	height: 28px;
	z-index: 2999;
	top: 150px;
	left: 570px;
	background-color: #FFF;
	filter: alpha(opacity = 0);
	-moz-opacity: 0.0;
	-khtml-opacity: 0.0;
	opacity: 0.0;
	position: absolute;
	cursor: pointer;
	background-color: #FFF;
	cursor: pointer;
}

.bodyPop label {
	width: 110px;
}

td {
	text-align: center;
	}
</style>
</head>

<body>
	<div class="bodyPop">
			<table class="table">
				<tr>
					<td class="lable" colspan="2"><span>款式名称：</span></td>
					<td colspan="3">
						<input type="text" required="required" id="styleName" name="styleName" onblur="checkStyleName();" /> 
						<label id="styleNameError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable" colspan="2"><span>模型名称：</span></td>
					<td colspan="3">
						<input type="text" required="required" id="assetbundle" name="assetbundle" onblur="checkAssetBundle();" /> 
						<label id="assetbundleError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<!-- 西服款式 -->
				<tbody id="collarbody"></tbody>
				<tbody id="breastpocketbody"></tbody>
				<tbody id="pocketbody"></tbody>
				<tbody id="buffbody"></tbody>
				<tbody id="buttonnumbody"></tbody>
				<tbody id="placketbody"></tbody>
				<tbody id="backbody"></tbody>
				<tbody id="botouyanbody"></tbody>
				<tbody id="buttoneyebody"></tbody>
				<!-- 裤子款式 -->
				<tbody id="yaotoubody"></tbody>
				<tbody id="frontdartbody"></tbody>
				<tbody id="kujiaobody"></tbody>
				<tbody id="cekoudaibody"></tbody>
				<tbody id="houkoudaibody"></tbody>
				<tbody id="kouyanbody"></tbody>
				<!-- 衬衫款式 -->
				<tbody id="collarbody"></tbody>
				<tbody id="fontbody"></tbody>
				<tbody id="backbody"></tbody>
				<tbody id="buffbody"></tbody>
				<tbody id="breastpocketbody"></tbody>
				<tbody id="kouyanbody"></tbody>
				<!-- 马甲款式 -->
				<tbody id="collarbody"></tbody>
				<tbody id="breastpocketbody"></tbody>
				<tbody id="pocketbody"></tbody>
				<tbody id="xiabaibody"></tbody>
				<tbody id="kouyanbody"></tbody>
				<!-- 附选信息 -->
				<tr>
					<td class="lable" colspan="2"><label>附选条件：</label></td>
					<td colspan="3" style="text-align: left;">
						<input type="checkbox" name = "checkbox" id="suitBom" value="0"/>
						<label for="suitBom" style="text-align: left;width:80px;margin-left: 5px;">西服布料</label>
						
						<input type="checkbox" name = "checkbox" id="insideBom" value="0"/>
						<label for="insideBom" style="text-align: left;width:40px;margin-left: 5px;">里料</label>
						
						<input type="checkbox" name = "checkbox" id="shirtBom" value="0"/>
						<label for="shirtBom" style="text-align: left;width:80px;margin-left: 5px;">衬衫布料</label>
						
						<input type="checkbox" name = "checkbox" id="tieBom" value="0"/>
						<label for="tie_Bom" style="text-align: left;width:120px;margin-left: 5px;">领带/领结布料</label>
						
						<input type="checkbox" name = "checkbox" id="kouyanBom" value="0"/>
						<label for="suit_button" style="text-align: left;width:80px;margin-left: 5px;">扣眼布料</label>
						
						<input type="checkbox" name = "checkbox" id="botouyanBom" value="0"/>
						<label for="suit_button" style="text-align: left;width:100px;margin-left: 5px;">驳头眼布料</label>
						
						<input type="checkbox" name = "checkbox" id="suitButton" value="0"/>
						<label for="suit_button" style="text-align: left;width:80px;margin-left: 5px;">西服扣</label>
						
						<input type="checkbox" name = "checkbox" id="shirtButton" value="0"/>
						<label for="shirtButton" style="text-align: left;width:60px;margin-left: 5px;">衬衫扣</label>
						
						<input type="checkbox" name = "checkbox" id="vestButton" value="0"/>
						<label for="vestButton" style="text-align: left;width:60px;margin-left: 5px;">马甲扣</label>
						
						<input type="checkbox" name = "checkbox" id="trousersButton" value="0"/>
						<label for="trousersButton" style="text-align: left;width:120px;margin-left: 5px;">裤扣</label>
						
						<input type="checkbox" name = "checkbox" id="tie" value="0"/>
						<label for="tie" style="text-align: left;width:80px;margin-left: 5px;">领带</label>
						
						<input type="checkbox" name = "checkbox" id="cravat" value="0"/>
						<label for="cravat" style="text-align: left;width:100px;margin-left: 5px;">领结</label>
					</td>
				</tr>
				<tr>
					<td class="lable" colspan="2"><label>SmallImage：</label></td>
					<td colspan="3"><input type="text" readonly="readonly" id="smallimage" style="width: 400px" value=""/>
						<label class="up" for="fileToUpload1" style="width: 80px;">
							<input id="fileToUpload1" style="" class="bg" type="file" name="upfile"> 
							<span style="float: left; margin-left: 5px">上传图片</span>
						</label>
					</td>
				</tr>
				<tr>
					<td class="lable" colspan="2"><label>BigImage：</label></td>
					<td colspan="3"><input type="text" readonly="readonly" id="bigimage" style="width: 400px" value=""/>
						<label class="up" for="fileToUpload2" style="width: 80px;">
							<input id="fileToUpload2" style="" class="bg" type="file" name="upfile"> 
							<span style="float: left; margin-left: 5px">上传图片</span>
						</label>
					</td>
				</tr>
			</table>

			<div align="center">
				<input type="button" onclick="save()" value="保存" />
			</div>
	</div>

</body>
</html>