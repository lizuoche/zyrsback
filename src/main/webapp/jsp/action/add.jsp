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
<script type="text/javascript" src="<%=basePath%>js/action/add.js"></script>
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
</style>
</head>

<body>
	<div class="bodyPop">
			<table class="table">
				<tr>
					<td class="lable"><label>英文名：</label></td>
					<td><input type="text" required="required" readonly="readonly" id="enName"
						name="enName" value="" onblur="checkEnName();" /> <label id="enNameError"
						style="width: 200px; text-align: left;"></label></td>
				</tr>
				<tr>
					<td class="lable"><label>款式类型：</label></td>
					<td><input type="text" required="required" id="type"
						name="type" value="" /> <label id="typeError"
						style="width: 200px; text-align: left;"></label></td>
				</tr>
				<tr>
					<td class="lable"><label>中文名：</label></td>
					<td><input type="text" required="required" id="cnName"
						name="cnName" onblur="checkCnName();" /> <label id="cnNameError"
						style="width: 200px; text-align: left;"></label></td>
				</tr>
				<tr>
					<td class="lable"><label>工坊名称：</label></td>
					<td><input type="text" required="required" id="wsName"
						name="wsName" onblur="checkWsName();" /> <label id="wsNameError"
						style="width: 200px; text-align: left;"></label></td>
				</tr>
				<tr>
					<td class="lable"><label>模型名称：</label></td>
					<td><input type="text" required="required" id="modelName"
						name="modelName" onblur="checkModelName();" /> <label
						id="modelNameError" style="width: 200px; text-align: left;"></label></td>
				</tr>
				<tr>
					<td class="lable"><label>备注说明：</label></td>
					<td><input type="text" required="required" id="remark"
						name="remark" /></td>
				</tr>
				
				<tr>
					<td class="lable"><label>平面图：</label></td>
					<td><input type="text" readonly="readonly" id="fileName" style="width: 400px" value=""/>
						<label class="up" for="fileToUpload" style="width: 80px;">
							<input id="fileToUpload" style="" class="bg" type="file" name="upfile"> 
							<span style="float: left; margin-left: 5px">上传图片</span>
						</label>
					</td>
				</tr>
				<tr>
					<td class="lable"><label>Unity缩略图：</label></td>
					<td><input type="text" readonly="readonly" id="fileName1" style="width: 400px" value=""/>
						<label class="up" for="fileToUpload1" style="width: 80px;">
							<input id="fileToUpload1" style="" class="bg" type="file" name="upfile"> 
							<span style="float: left; margin-left: 5px">上传图片</span>
						</label>
					</td>
				</tr>
				<tr>
					<td class="lable"><label>PC版缩略图：</label></td>
					<td><input type="text" readonly="readonly" id="fileName2" style="width: 400px" value=""/>
						<label class="up" for="fileToUpload2" style="width: 80px;">
							<input id="fileToUpload2" style="" class="bg" type="file" name="upfile"> 
							<span style="float: left; margin-left: 5px">上传图片</span>
						</label>
					</td>
				</tr>
				<tr>
					<td class="lable"><label>备用图：</label></td>
					<td><input type="text" readonly="readonly" id="fileName3" style="width: 400px" value=""/>
						<label class="up" for="fileToUpload3" style="width: 80px;">
							<input id="fileToUpload3" style="" class="bg" type="file" name="upfile"> 
							<span style="float: left; margin-left: 5px">上传图片</span>
						</label>
					</td>
				</tr>
				<tbody id="tbody">
				<tr>
					<td class="lable"><label>是否可售：</label></td>
					<td><input type="radio" required="required" name="issell" value="1" checked="checked"/><label style="text-align: left;width:80px;margin-left: 5px;"> 是 </label>
						<input type="radio" required="required" name="issell" value="0" /><label style="text-align: left;width:80px;margin-left: 5px;"> 否 </label>
					</td>
				</tr>
				</tbody>
			</table>

			<div align="center">
				<input type="button" onclick="save()" value="保存" />
			</div>
	</div>

</body>
</html>