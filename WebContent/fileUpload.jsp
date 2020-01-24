<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>基于Bootstrup 3可预览的HTML5文件上传插件</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/default.css">
<link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />	

</head>
<body>

	<div class="htmleaf-container">
		<div class="container kv-main">
            <form enctype="multipart/form-data">      
                <div class="form-group">
                    <input id="file-1"  type="file" multiple class="file" data-overwrite-initial="false" data-min-file-count="1">
                </div>
                <hr>
            </form>
        </div>
		
	</div>
	
	<script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/fileinput.js" type="text/javascript"></script>
    <script src="js/fileinput_locale_zh.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script>
	    
	    $("#file-1").fileinput({
	        uploadUrl: '${pageContext.request.contextPath}/fileUpload', // 文件上传服务器地址
	       // allowedFileExtensions : ['jpg', 'png','gif','doc','txt','mp3','ppt','zip','mp4'],
	        overwriteInitial: false,
	        maxFileSize: 2000000,  //单位k
	        maxFilesNum: 6,
	      	//allowedFileTypes: ['image', 'video', 'flash'],
	        slugCallback: function(filename) {
	            return filename.replace('(', '_').replace(']', '_');
	        }
		});
	    
	    $(document).ready(function() {
	        $("#test-upload").fileinput({
	            'showPreview' : false,
	            'allowedFileExtensions' : ['jpg', 'png','gif','doc','txt','mp3','ppt'],
	            'elErrorContainer': '#errorBlock'
	        });
	        
	    });
		</script>
</body>
</html>