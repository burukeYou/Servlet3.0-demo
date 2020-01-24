<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap</title>

    <!-- 引入Bootstrap核心样式文件 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
<!--==================================================================================== -->

    <div class="container-fluid">
        <div class="row">
            <!--左边 -->
            <div class="col-md-2" >
                <ul class="nav nav-pills nav-stacked" id="leftBar">
                    <li role="presentation">
                        <a href="${pageContext.request.contextPath }/findAllMyDocument" target="Center" >
                            <span class="glyphicon glyphicon-folder-open" aria-hidden="true" ></span>&nbsp;
                            我的文档

                        </a>
                    </li>
                    <li role="presentation" >
                        <a href="${pageContext.request.contextPath }/findAllShareDocument" target="Center" >
                            <span class="glyphicon glyphicon-share" aria-hidden="true" ></span>&nbsp;
                         网友分享

                        </a>
                    </li>
                   
                </ul>
            </div>
            <!--右边 -->
            <div class="col-md-10">
                <!--顶部导航 -->
                <div class="row" >
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand" href="#">Document</a>
                            </div>

                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                <ul class="nav navbar-nav navbar-right">
                                    <li><img src="img/user.jpeg" class="img-responsive img-circle" width="35px"  style="padding-top: 8px" alt="Responsive image"></li>
                                    
                                    
                                    <c:if test="${empty user}">
                                    	<li><a href="login.jsp" target="Center" style="color: #0003bf">请先登陆</a></li>
                                    </c:if>
                                    <c:if test="${!empty user }">
                                    	<li><a href="jscript:;" target="Center" style="color: #0003bf">${user.username }</a></li>
                                    </c:if>
                                  
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                            <span class="glyphicon glyphicon-user" aria-hidden="true" ></span>
                                            <span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">个人信息</a></li>
                                            <li><a href="#">消息</a></li>
                                             <li><a href="register.jsp" target="Center">注册</a></li>
                                            <li role="separator" class="divider"></li>
                                            <li><a href="${pageContext.request.contextPath}/logoutUser" target="_top">注销</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>

                <!--中心显示区域-->
                <div class="row">
                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe name="Center" class="embed-responsive-item" src="error.jsp" width="100%"></iframe>
                    </div>
                </div>
                
                <!-- 底部 -->
                 <div class="row" >
        	 		<span style="left: 50%">Copyright © 2019 adminor. Designed by CZH All rights reserved.</span>
        		</div>
            </div>
           
        </div>
        
        
        
    </div>




<!--==================================================================================== -->

<!-- 引入jQuery核心js文件，必须放置在bootStrap.js前面！ -->
<script src="js/jquery-1.11.3.min.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="js/bootstrap.min.js"></script>
</body>

    <script>



    </script>


    <style>
        #leftBar {
            position: fixed;
            height: 100%;
            left: 0px;
            width: 15%;

            padding-top: 50px;
            padding-left: 20px;
            padding-right: 50px;

            background-color: #1c2b36;
        }
        #leftBar a{
            color: #dadada;
        }
        #leftBar li a:focus{
            color: black;
            background-color: #dace6d;
        }

        #leftBar li a:hover{
            color: black;
        }
    </style>
</html>