<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="style/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=pathstyle%>/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="<%=pathstyle%>/css/login.css">
<script src="<%=pathstyle%>/js/jquery-2.1.1.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="check"></div>
	<div class="content">
		<div class="login-box">
			<form id="form" action="">
				<div class="login-content">
					<div class="login">
						<span>用户名</span> <input class="ipt" type="text"
							placeholder="请输入您的用户名" value="" name="name" id="name">
					</div>
					<div class="login">
						<span>密&nbsp;&nbsp; &nbsp;码</span> <input class="ipt"
							id="password" name="pwd" type="password" placeholder="请输入您的密码"
							value="">
					</div>
					<!-- <div class="login">
						<span>身&nbsp;&nbsp; &nbsp;份</span> <select name='identype' id='identype'
							style="width: 174px;">
								<option value='admin'>admin</option>
								<option value='customer' selected="selected">customer</option>
							</select>
					</div> -->
					<div class="footer-btn">
						<%-- <a style="color: rgb(204, 204, 204); margin-right: 10px;" href="<%=path%>/register.jsp">注册</a> --%>
						<input type="submit" id="login-in" class="btn btn-primary "
							value="&nbsp;登录&nbsp;" onclick="checkInput();return false;" />
					</div>
				</div>
			</form>
		</div>
		<script type="text/javascript">
			function checkInput() {
				if (document.getElementById("name").value == '') {
					alert("请输入用户名！");
					document.getElementById("name").focus();
				} else if (document.getElementById("password").value == "") {
					alert("请输入密码！");
				} else {
					login();
				}
			}
			
			function login(){
		    	 var name=$("#name").val();
		    	 var password=$("#password").val();
		    	 var identype=$("#identype").val();
		    	 $.ajax({
		    		type:"post",
		    		url:"<%=path%>/UserController/login.do",
		    		dataType:"json",
		    		data:{"name":name,"pwd":password,"identype":2},
		    		success:function(data){
		    			if(data.result=="success"){
		    				window.location.href="<%=path%>/main.jsp";
						} else {
							$(".check").html("登录失败!").slideDown(1000).slideUp(1000);
										/* alert("登录失败！"); */
						}
					}
				});
			}
		</script>
	</div>
</body>
</html>