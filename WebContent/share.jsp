<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap完整模板</title>

<!-- 引入Bootstrap核心样式文件 -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>


<script type="text/javascript">
		
			function CancelShare(did,sharename){
				var res = confirm("只有共享该文档的用户才可以取消,你确定要取消吗");
				if(res){
				    $.post(
				    "${pageContext.request.contextPath}/CancelShare",
				    {"did":did,"sharename":sharename},
				    function(data){
				    	if(data.failInfo == "true"){
				    		alert("取消共享成功");
				    		window.location.href = "${pageContext.request.contextPath}/findAllShareDocument";
				    	}else{
				    		alert("取消共享失败!");
				    	}	    	
				    },
				    "json"		    
				    );				
				}		
			}	
			
			//改变每页显示大小时
			function changePageSize(pageSize){
				//2-提交表单
				$("#myForm").submit();	
			}
			
			//当前页改变时
			function changePage(currentPage){
				//1-从当前页码的值取出放入隐藏的标签中
				 $("#currentPageHidden").val(currentPage);
					
				//2-提交表单
				$("#myForm").submit();			
			}
			
			
			function reShow(){
				$("#PageSize option[value='${pageBean.pageSize}']").prop("selected",true);
			}
			
			
			
</script>
</head>

<body>
<body onload="reShow()">

	<div class="listBar">
		<div class="panel panel-default">
			<div class="panel-body">
				<h3>
					<B>资源社区</B>
				</h3>
				<form id="myForm" class="navbar-form navbar-left" role="search"
					style="width: 100%"
					action="${pageContext.request.contextPath}/findAllShareDocument">
					<!-- 当前页的隐藏域 -->
					<input type="hidden" name="currentPage" id="currentPageHidden"
						value="${pageBean.currentPage }" />


					<nav class="navbar navbar-default">
						<div class="container-fluid" style="padding-top: 10px">
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header">
								<button type="button" class="navbar-toggle collapsed"
									data-toggle="collapse"
									data-target="#bs-example-navbar-collapse-1"
									aria-expanded="false">
									<span class="sr-only">Toggle navigation</span> <span
										class="icon-bar"></span> <span class="icon-bar"></span> <span
										class="icon-bar"></span>
								</button>
								<a class="navbar-brand" href="jscript:;">文件名</a>
							</div>

							<!-- Collect the nav links, forms, and other content for toggling -->
							<div class="collapse navbar-collapse"
								id="bs-example-navbar-collapse-1" style="padding-top: 5px">
								<ul class="nav navbar-nav navbar-left">
									<li><div class="form-group">
											<input type="text" name="filename" class="form-control"
												placeholder="Search">
										</div> &nbsp;&nbsp;&nbsp;</li>
									<li><select class="form-control" id="" name="filetype">
											<option value="">不限</option>
											<option value=".mp3">.mp3</option>
											<option value=".jpg">.jpg</option>
											<option value=".png">.png</option>
											<option value=".gif">.gif</option>
											<option value=".doc">.doc</option>
											<option value=".txt">.txt</option>
											<option value=".ppt">.ppt</option>
											<option value=".zip">.zip</option>
											<option value=".mp4">.mp4</option>
									</select> &nbsp;&nbsp;&nbsp;</li>
									<li>
										<button type="submit" class="btn btn-default">
											<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
										</button> &nbsp;&nbsp;&nbsp;
									</li>
			
								</ul>


							</div>

						</div>

					</nav>

					<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>序号</th>
								<th>文件名</th>
								<th>文件类型</th>
								<th>文件大小</th>
								<th>上传用户</th>
								<th>上传时间</th>
								<th>下载</th>
								<th>取消分享</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pageBean.documentlist }" var="document" varStatus="i">
								<tr>
									<td>${i.count}</td>
									<td>${document.dname }</td>
									<td>${document.dtype}</td>
									<td>${document.filesize}</td>
									<td>${document.user.username}</td>
									<td>${document.uploadTime}</td>
									<td><a
										href="${pageContext.request.contextPath}/downloadDocument?downloadPath=${document.address }">
											<span class="glyphicon glyphicon-download-alt"
											aria-hidden="true"> </span>
									</a></td>
									<td><a href="jscript:;"
										onclick="CancelShare('${document.did }','${document.user.username }')">
											<span class="glyphicon glyphicon-remove" aria-hidden="true">
									</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>


					<nav aria-label="...">
						<ul class="pager">
							<li>共[${pageBean.totalFileCount }]条记录,每页显示 <select
								id="PageSize" name="pageSize" class="form-control input-sm"
								onchange="changePageSize($(this).val())">
									<option value="5">5</option>
									<option value="10">10</option>
									<option value="20">20</option>

							</select> 条记录 &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
							</li>

							<c:if test="${pageBean.currentPage == 1 }">
								<li class="disabled"><a href="jscript:;">Previous</a></li>
							</c:if>
							<c:if test="${pageBean.currentPage != 1 }">
								<li><a href="#"
									onclick="changePage(${pageBean.currentPage-1})">Previous</a></li>
							</c:if>

							<li>[ <B> ${pageBean.currentPage } </B> ]
							</li>

							<c:if test="${pageBean.currentPage == pageBean.totalPageCount }">
								<li class="disabled"><a href="jscript:;">Next</a>
									&nbsp;&nbsp;&nbsp;</li>
							</c:if>
							<c:if test="${pageBean.currentPage != pageBean.totalPageCount }">
								<li><a href="#"
									onclick="changePage(${pageBean.currentPage+1})">Next</a>
									&nbsp;&nbsp;&nbsp;</li>
							</c:if>




							<li>到 <input type="text" size="2px"
								class="form-control input-sm" id="page" value="" /> 页
							</li>
							<li><input class="btn btn-default input-sm" type="button"
								value="Go" onclick="changePage($('#page').val())">
								&nbsp;&nbsp;&nbsp;</li> 总 [${pageBean.totalPageCount }] 页
							<li></li>
						</ul>
					</nav>
				</form>

			</div>

		</div>

	</div>








	<!-- 引入jQuery核心js文件，必须放置在bootStrap.js前面！ -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<!-- 引入BootStrap核心js文件 -->
	<script src="js/bootstrap.min.js"></script>


</body>

<style>
.table-hover tbody tr:hover {
	background-color: #dab97b;
}
</style>