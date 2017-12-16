<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript" src="<%=path%>/js/coat/suitStyle.js"></script>
<script type="text/javascript" src="<%=path%>/js/layer/layer.js"></script>
</head>
<body>
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 大衣&nbsp;●&nbsp;款式配置</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						<button type="button" class="button border-green" id="add" onclick='add()'>
							<span class="icon-check"></span> 新增
						</button>
						
						<button type="button" class="button border-red" id="del" onclick='del()'>
							<span class="icon-trash-o"></span> 批量删除
						</button> 
						
						<button type="button" class="button border-green" id="toJson" onclick='styleToJson()'>
							<span class="icon-check"></span> 生成JSON
						</button>
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="120">ID</th>
					<th>款式名称</th>
					<th>模型名称</th>
					<th>领子</th>
					<th>胸袋</th>
					<th>口袋</th>
					<th>袖子</th>
					<th>袖扣数量</th>
					<th>门襟</th>
					<th>后片</th>
					<th>驳头眼</th>
					<th>扣眼</th>
					<th>小图</th>
					<th>大图</th>
					<th>JSON文件名称</th>
					<!-- <th>可售</th> -->
					<th>操作</th>
				</tr>

				<tbody id="tbody"></tbody>
				
				<tr>
					<td colspan="16"><div class="pagelist">
							<a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
								href="">3</a><a href="">下一页</a><a href="">尾页</a>
						</div></td>
				</tr>
			</table>
		</div>
		
</body>
</html>