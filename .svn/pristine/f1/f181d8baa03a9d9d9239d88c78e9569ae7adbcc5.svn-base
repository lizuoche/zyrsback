<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String basePath = request.getContextPath();
	String path = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + basePath;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=path%>/css/pintuer.css">
<link rel="stylesheet" href="<%=path%>/css/admin.css">
<script type="text/javascript" src="<%=path%>/js/jquery-1.11.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/pintuer.js"></script>
<script type="text/javascript" src="<%=path%>/js/trousers/kujiao.js"></script>
<script type="text/javascript" src="<%=path%>/js/layer/layer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder"> 裤子&nbsp;●&nbsp;裤脚</strong>
		</div>
		<div class="padding border-bottom">
			<ul class="search">
				<li>
					<button type="button" class="button border-green" id="add"
						onclick='add("trousers_kujiao")'>
						<span class="icon-check"></span> 新增
					</button>
					<button type="button" class="button border-red" id="del" onclick='del()'><span class="icon-trash-o"></span> 批量删除</button>
				</li>
			</ul>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<th width="120">ID</th>
				<th>英文名</th>
				<th>款式</th>
				<th>中文名</th>
				<th>工坊名称</th>
				<th>模型名称</th>
				<th>备注说明</th>
				<th>平面图</th>
				<th>Unity缩略图</th>
				<th>PC版缩略图</th>
				<th>备用图</th>
				<!-- <th>可售</th> -->
				<th>操作</th>
			</tr>

			<tbody id="tbody"></tbody>

			<tr>
				<td colspan="13"><div class="pagelist">
						<a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
							href="">3</a><a href="">下一页</a><a href="">尾页</a>
					</div></td>
			</tr>
		</table>
	</div>
</body>
</html>