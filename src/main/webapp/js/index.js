$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});


function versionToTxt(){
	
	layer.confirm("确定新增吗？", function() {
		$.ajax({
		url : "json/versionToTxt",
		type : "post",
		dataType : "json",
		data : {
//			"rootPath":rootPath
		},
		async : false,
		success : function(data) {
			if (data.success) {
				layer.alert("版本对比文件生成成功!", {
					icon : 1
				});
			} else {
				layer.alert("版本对比文件生成失败!", {
				});
			}
		},
		error : function(data) {
		}
	});
	
});
	
	
}