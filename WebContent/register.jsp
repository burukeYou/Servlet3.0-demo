<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<!-- 引入表单校验jquery插件 -->
<script src="js/jquery.validate.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}

.error{          
   color:red;
}

</style>
<script type="text/javascript">

	//1-为输入框绑定失去焦点事件
	  $(function(){
    	  //1-为输入框绑定失去焦点事件
          $("#username").blur(function(){
        	  //2-获得输入框的内容
        	  var usernameInput = $(this).val();
        	
        	 //3-去服务器校验该用户名是否存在
        	  $.post(
       			  "checkUserName",   //要提交服务器的地址
       			  {"username":usernameInput},    //提交的数据
       			  function(data){
       				  var rs = data.isExist;  //servlet返回的json格式数据
       				  
       				  //4-根据返回结果动态显示信息
       				  var isExit = "";
       				  if(rs){
       					isExit ="用户名已经存在!";
       				    $("#usernameInfo").css("color","red");
       				  }else{
       					isExit ="用户名可用";
       				    $("#usernameInfo").css("color","green");
       				  }
       				 $("#usernameInfo").html(isExit);
       				  
       			  },
       			  "json"  //返回类型
        	  );               	  
          });  
      });
 
	//2-表单校验
	 $(function(){
			 $("#myform").validate({
				 rules:{
						"username":{
							"required":true,	  //规则	
							
						},
						"password":{
							"required":true,
							"rangelength":[6,12]
						},
						"repassword":{
							"required":true,
							"rangelength":[6,12],
							"equalTo":"#password"
						},
						"email":{
							"required":true,
							"email":true
						},
						"sex":{
							"required":true
						}							
				 },
				messages:{   //错误提示
					"username":{
						"required":"用户名不能为空",
					},
					"password":{
						"required":"密码不能为空",
						"rangelength":"密码长度6-12位"
					},
					"repassword":{
						"required":"密码不能为空",
						"rangelength":"密码长度6-12位",
						"equalTo":"两次密码不一致"
					},
					"email":{
						"required":"邮箱不能为空",
						"email":"邮箱格式不正确"
					}
				}
			 });
	 });
</script>






</head>
<body>

	<div class="container"
		style="width: 100%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>用户注册</font>USER REGISTER
				<form id="myform" class="form-horizontal" action="${pageContext.request.contextPath }/register" method="post" target="Center" style="margin-top: 5px;">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username" name="username"
								placeholder="请输入用户名">
							<span id="usernameInfo"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password" name="password"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="repassword" name="repassword"
								placeholder="请输入确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="email" name="email"
								placeholder="Email">
						</div>
					</div>
					
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="sex1" value="male">
								男
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="sex2" value="fmale">
								女
							</label>
							<label class="error" for="sex" style="display:none">请选择性别</label>
						</div>
					</div>
					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input type="date" class="form-control" name="birthday">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit"
								style="background: url('./img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>


</body>
</html>




