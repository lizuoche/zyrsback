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
<%-- <script type="text/javascript" src="<%=path%>/js/jquery.js"></script> --%>
<script type="text/javascript" src="<%=path%>/js/jquery-1.11.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/pintuer.js"></script>  
</head>
<body>
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 大衣&nbsp;●&nbsp;门襟</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120">ID</th>
        <th>英文名</th>       
        <th>中文名</th>
        <th>工坊名称</th>
        <th>模型名称</th>
        <th>备注说明</th>       
        <th>Unity缩略图</th>
        <th>PC版缩略图</th>
        <th>备用图</th>
        <!-- <th>备用图</th> -->
        <!-- <th>可售</th> -->
        
        <!-- <th width="25%">内容</th>
         <th width="120">留言时间</th> -->
        <th>操作</th>       
      </tr>      
        
          <tr>
          <td><input type="checkbox" name="id[]" value="1" />
            1</td>
          <td>placket</td>
          <td>门襟1号</td>
          <td>门襟1号</td>  
           <td>placket_001</td>         
          <td>这是一套后台UI……</td>
          <td>1.jpg</td>
          <td>2.jpg</td>
          <td>3.jpg</td>
          <td><div class="button-group"> <a class="button border-red" href="javascript:void(0)" onclick="return del(1)"><span class="icon-trash-o"></span> 删除</a> </div>
          <div class="button-group"> <a class="button border-red" href="javascript:void(0)" onclick="return del(1)"><span class="icon-trash-o"></span> 修改</a> </div></td>
        </tr>
      <tr>
        <td colspan="13"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">

function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}

$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false; 		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

</script>
</body></html>