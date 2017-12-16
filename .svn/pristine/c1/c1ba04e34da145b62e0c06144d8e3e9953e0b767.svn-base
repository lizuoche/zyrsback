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
<script type="text/javascript" src="<%=basePath%>js/action/updateBom.js"></script>
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
					<td class="lable" ><span>面料类型：</span></td>
					<td >
						<input type="text" required="required" id="styleName" name="styleName" readonly="readonly" /> 
						<label id="styleNameError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable" ><span>品牌英文名：</span></td>
					<td >
						<input type="text" required="required" id="brandNameEN" name="brandNameEN" /> 
						<label id="brandNameENError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable"><label>品牌中文名：</label></td>
					<td >
						<input type="text" required="required" id="brandNameCN"	name="brandNameCN" /> 
						<label id="brandNameCNError" style="width: 200px; text-align: left;"></label></td>
				</tr>
				<tr>
					<td class="lable" ><label>面料名称：</label></td>
					<td >
						<input type="text" required="required" id="bomName" name="bomName" onblur="checkBomName();" /> 
						<label id="bomNameError"	style="width: 200px; text-align: left;"></label></td>
				</tr>
				<tr>
					<td class="lable" ><label>面料编码：</label></td>
					<td >
						<input type="text" required="required" id="bomCode" name="bomCode" onblur="checkBomCode();" /> 
						<label id="bomCodeError" style="width: 200px; text-align: left;"></label></td>
				</tr>
				<tr>
					<td class="lable"><label>备注说明：</label></td>
					<td >
						<input type="text" required="required" id="remark" name="remark" />
						<label id="remarkNameError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tbody id="tbody"></tbody>
			</table>

			<div align="center">
				<input type="button" onclick="save()" value="保存" />
			</div>
	</div>

</body>
</html>