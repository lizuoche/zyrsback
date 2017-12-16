/*验证用户名是否为空*/
function checkName() {
	var name = document.getElementById("username").value;
	if (name == null || "" == name) {
//		 document.getElementById("nameInfo").innerHTML = "用户名不能为空!";
//		 document.getElementById("nameInfo").style.color = "red";
		return false;
	} else {
//		 document.getElementById("nameInfo").innerHTML = " ";
		return true;
	}
}
/* 验证密码是否为空 */
function checkPassword() {
	var pwd = document.getElementById("password").value;
	if (pwd == null || "" == pwd) {
//		 document.getElementById("passwordInfo").innerHTML = "密码不能为空!";
//		 document.getElementById("passwordInfo").style.color = "red";
		return false;
	} else {
//		 document.getElementById("passwordInfo").innerHTML = " ";
		return true;
	}
}
/* 改变图片路径 */
function change() {
	document.getElementById("img").src = "verifyCode.do?" + Math.random();
}
/* 验证登录信息 */
function checkAccount() {
	var result = false;
	if (checkName() && checkPassword()) {
		$.ajax({
			type : "post",
			url : "login/userLogin",
			dataType : "json",
			data : {"username":$("#username").val(),"password":$("#password").val()},
			async:false,
			success : function(data) {
				if (data.success) {
					result = true;
				} else{
					result = false;
				}
			},
			error : function(data) {
				//  alert("request error");
			}
		});
		return result;
	}
}
/* 验证码是否正确 */
/*function checkVerfy() {
	var result = false;
	$.ajax({
		type : "post",
		url : "checkVerfy.do",
		dataType : "json",
		data : {
			"verifyCode" : $("#verifyCode").val()
		},
		async:false,
		success : function(returnData) {
			if (returnData.success) {
				$("#verInfo").html("");
				result = true;
			} else {
				 document.getElementById("verInfo").style.color = "red";
				$("#verInfo").html(returnData.result);
				result = false;
			}
		},
		error : function(data) {
			//  alert("request error");
		}
	});
	return result;
}*/
function login() {
	//setCookie();
//	if (checkAccount() && checkVerfy()) {
	if (checkAccount()) {
		window.location.href = "index.jsp";
	}else{
		alert("登录失败！");
	}
}

/*function setCookie() { //设置cookie
	var loginCode = $("#username").val(); //获取用户名信息
	var pwd = $("#password").val(); //获取登陆密码信息
	if (document.getElementById("nameCheckbox").checked) { //判断是否选中了“记住账号”复选框
		$.cookie("loginName", loginCode, {
			expires : 30
		});//调用jquery.cookie.js中的方法设置cookie中的用户名
	} else {
		$.cookie("loginName", null);
	}
	if (document.getElementById("passwordCheckbox").checked) { // 判断是否选中了“记住密码”复选框
		$.cookie("password", pwd, {
			expires : 30
		});// 调用jquery.cookie.js中的方法设置cookie中的登陆密码
	} else {
		$.cookie("password", null);
	}
}*/

/*window.onload = function getCookie() { //获取cookie
	var loginCode = $.cookie("loginName"); //获取cookie中的用户名
	var pwd = $.cookie("password"); //获取cookie中的登陆密码
	if (pwd == "null") {
		pwd = null;
	}
	if (loginCode == "null") {
		loginCode = null;
	}
	if (loginCode != null) {
		$("#username").val(loginCode);
		$("#nameCheckbox").attr("checked", "true");//用户名存在的话把“记住用户名”复选框勾选住
	}
	if (pwd != null) {
		if(pwd.length<32){
			pwd=$.md5(pwd);
		}
		$("#password").val(pwd);
		$("#passwordCheckbox").attr("checked", "true");//密码存在的话把“记住密码”复选框勾选住
		$("#username").val(loginCode);
		$("#nameCheckbox").attr("checked", "true");
	}
};*/

//回车键登录
function keyLogin(event) {
	event = event || window.event;
	var keyCode = event.keyCode;
	if (keyCode == 13) { //回车键的键值为13
		login();
	}else{
	 	return;
	}
}

