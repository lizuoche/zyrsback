<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>中依睿昇后台管理中心</title>  
    <link rel="stylesheet"  href="css/pintuer.css">
    <link rel="stylesheet"  href="css/admin.css">
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>
    <script src="js/jquery.js"></script> 
    <script src="js/index.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />中依睿昇后台管理中心</h1>
  </div>
  <div class="head-l">
  <a class="button button-little bg-green" href="" target="_blank"><span class="icon-home"></span> 返回主页</a> &nbsp;&nbsp; 
  <a class="button button-little bg-red" href="login.jsp"><span class="icon-power-off"></span> 退出登录</a> &nbsp;&nbsp;
  <button type="button" class="button border-green" style="background-color:#5d8;" onclick='versionToTxt()'><span class="icon-check" style="color: #fff;">生成版本对比文件</span></button>
  </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>西服</h2>
  <ul style="display:block">
    <li><a href="jsp/suit/collar.jsp" target="right"><span class="icon-caret-right"></span>领子</a></li>
    <li><a href="jsp/suit/breastPocket.jsp" target="right"><span class="icon-caret-right"></span>胸袋</a></li>
    <li><a href="jsp/suit/pocket.jsp" target="right"><span class="icon-caret-right"></span>口袋</a></li>  
    <li><a href="jsp/suit/sleeve.jsp" target="right"><span class="icon-caret-right"></span>袖子</a></li>   
    <li><a href="jsp/suit/buttonNum.jsp" target="right"><span class="icon-caret-right"></span>袖扣数量</a></li> 
    <li><a href="jsp/suit/placket.jsp" target="right"><span class="icon-caret-right"></span>门襟</a></li>     
    <li><a href="jsp/suit/back.jsp" target="right"><span class="icon-caret-right"></span>后片</a></li>
    <li><a href="jsp/suit/botouyan.jsp" target="right"><span class="icon-caret-right"></span>驳头眼</a></li>
    <li><a href="jsp/suit/buttonEye.jsp" target="right"><span class="icon-caret-right"></span>扣眼</a></li>
    <li><a href="jsp/suit/suitStyle.jsp" target="right"><span class="icon-caret-right"></span>西服款式配置</a></li>
  </ul>   
  <h2><span class="icon-user"></span>裤子</h2>
  <ul>
    <li><a href="jsp/trousers/yaotou.jsp" target="right"><span class="icon-caret-right"></span>腰头</a></li>
    <li><a href="jsp/trousers/frontdart.jsp" target="right"><span class="icon-caret-right"></span>前褶</a></li>  
    <li><a href="jsp/trousers/kujiao.jsp" target="right"><span class="icon-caret-right"></span>裤脚</a></li>
    <li><a href="jsp/trousers/cekoudai.jsp" target="right"><span class="icon-caret-right"></span>侧口袋</a></li> 
    <li><a href="jsp/trousers/houkoudai.jsp" target="right"><span class="icon-caret-right"></span>后口袋</a></li>  
    <li><a href="jsp/trousers/kouyan.jsp" target="right"><span class="icon-caret-right"></span>扣眼</a></li>    
    <li><a href="jsp/trousers/trousersStyle.jsp" target="right"><span class="icon-caret-right"></span>裤子款式配置</a></li> 
  </ul>
  <h2><span class="icon-user"></span>衬衫</h2>
  <ul>
    <li><a href="jsp/shirt/collar.jsp" target="right"><span class="icon-caret-right"></span>领子</a></li>
    <li><a href="jsp/shirt/font.jsp" target="right"><span class="icon-caret-right"></span>正面</a></li>
    <li><a href="jsp/shirt/back.jsp" target="right"><span class="icon-caret-right"></span>背面</a></li> 
    <li><a href="jsp/shirt/sleeve.jsp" target="right"><span class="icon-caret-right"></span>袖子</a></li>
    <li><a href="jsp/shirt/breastPocket.jsp" target="right"><span class="icon-caret-right"></span>胸袋</a></li>  
    <li><a href="jsp/shirt/kouyan.jsp" target="right"><span class="icon-caret-right"></span>扣眼</a></li>   
    <li><a href="jsp/shirt/shirtStyle.jsp" target="right"><span class="icon-caret-right"></span>衬衫款式配置</a></li>  
  </ul> 
  <h2><span class="icon-user"></span>马甲</h2>
  <ul>
    <li><a href="jsp/vest/collar.jsp" target="right"><span class="icon-caret-right"></span>领子</a></li>
    <li><a href="jsp/vest/breastPocket.jsp" target="right"><span class="icon-caret-right"></span>胸袋</a></li>
    <li><a href="jsp/vest/pocket.jsp" target="right"><span class="icon-caret-right"></span>口袋</a></li> 
    <li><a href="jsp/vest/xiabai.jsp" target="right"><span class="icon-caret-right"></span>下摆</a></li> 
    <li><a href="jsp/vest/kouyan.jsp" target="right"><span class="icon-caret-right"></span>扣眼</a></li>  
    <li><a href="jsp/vest/vestStyle.jsp" target="right"><span class="icon-caret-right"></span>马甲款式配置</a></li>
  </ul>
   <h2><span class="icon-user"></span>大衣</h2>
  <ul>
   <li><a href="jsp/coat/collar.jsp" target="right"><span class="icon-caret-right"></span>领子</a></li>
    <li><a href="jsp/coat/breastPocket.jsp" target="right"><span class="icon-caret-right"></span>胸袋</a></li>
    <li><a href="jsp/coat/pocket.jsp" target="right"><span class="icon-caret-right"></span>口袋</a></li>  
    <li><a href="jsp/coat/sleeve.jsp" target="right"><span class="icon-caret-right"></span>袖子</a></li>   
    <li><a href="jsp/coat/placket.jsp" target="right"><span class="icon-caret-right"></span>门襟</a></li>     
    <li><a href="jsp/coat/back.jsp" target="right"><span class="icon-caret-right"></span>后片</a></li>
    <li><a href="jsp/coat/botouyan.jsp" target="right"><span class="icon-caret-right"></span>驳头眼</a></li>
    <li><a href="jsp/coat/buttonEye.jsp" target="right"><span class="icon-caret-right"></span>扣眼</a></li>
  </ul>   
  <h2><span class="icon-user"></span>布料</h2>
  <ul>
   <li><a href="jsp/bom/suitBom.jsp" target="right"><span class="icon-caret-right"></span>西服布料</a></li>
    <li><a href="jsp/bom/insideBom.jsp" target="right"><span class="icon-caret-right"></span>里料</a></li>
    <li><a href="jsp/bom/shirtBom.jsp" target="right"><span class="icon-caret-right"></span>衬衫布料</a></li>  
    <li><a href="jsp/bom/tieBom.jsp" target="right"><span class="icon-caret-right"></span>领带/领结布料</a></li> 
    <li><a href="jsp/bom/botouyanBom.jsp" target="right"><span class="icon-caret-right"></span>驳头眼布料</a></li>  
    <li><a href="jsp/bom/kouyanBom.jsp" target="right"><span class="icon-caret-right"></span>扣眼布料</a></li>     
  </ul> 
  <h2><span class="icon-user"></span>商品</h2>
  <ul>
   <li><a href="jsp/goods/lingdai.jsp" target="right"><span class="icon-caret-right"></span>领带</a></li>
    <li><a href="jsp/goods/lingjie.jsp" target="right"><span class="icon-caret-right"></span>领结</a></li>
    <li><a href="jsp/goods/shirtButton.jsp" target="right"><span class="icon-caret-right"></span>衬衫扣子</a></li>  
    <li><a href="jsp/goods/suitButton.jsp" target="right"><span class="icon-caret-right"></span>西服扣子</a></li> 
    <li><a href="jsp/goods/vestButton.jsp" target="right"><span class="icon-caret-right"></span>马甲扣</a></li>  
    <li><a href="jsp/goods/trousersButton.jsp" target="right"><span class="icon-caret-right"></span>裤扣</a></li>
  </ul> 
</div>

<ul class="bread">
  <li><a href="info.jsp" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</span>
</ul>
<div class="admin">
  <iframe scrolling="auto"  src="jsp/suit/collar.jsp" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>