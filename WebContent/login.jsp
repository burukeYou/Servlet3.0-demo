<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>登录</title>
<link rel="stylesheet" href="css/login.css" />
</head>

<body>
	<div class="content">
		<div class="login">
			<div class="title">有缘人</div>
			  <!-- 回显登录失败信息 -->
			   <span style="color:red;">
						  ${loginError == null ? "":loginError}	 								
				</span>
			<div class="locon">
				<form action="${pageContext.request.contextPath }/login" target="_top" method="post">
					<div class="line">
						<img class="smallImg" src="img/icon3.png" /> 
						<input name="username"
							placeholder="请输入账号" type="text" />
					</div>
							
					<div class="line">
						<img class="smallImg" src="img/icon4.png" /> 
						<input  name="password"
							placeholder="请输入密码" type="password" />
					</div>
					<input type="checkbox" name="autoLogin" value="autoLogin" ><font color="#e4e4e4">自动登录</font>  &nbsp; &nbsp; &nbsp;
					<button type="submit" class="logBut">登&nbsp;&nbsp;录</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>