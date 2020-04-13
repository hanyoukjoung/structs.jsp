<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 정보</title>
<style type="text/css">
.carousel {
	width: 200px;
	height: 150px;
	margin-left: 200px;
}

.carousel-inner>.item>img {
	width: 200px;
	height: 150px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<script type="text/javascript">
	$(function() {
		$('#bo_cont').summernote({
				height: 150,
				codemirror: {
				theme: 'monokai'
			}
	    });
	    $('#bo_cont').summernote('code', '${nboardInfo.bo_cont}');
	    
	    $('input[name=bo_title]').val('${nboardInfo.bo_title}');
	    $('input[name=bo_nick]').val('${nboardInfo.bo_nick}');
	    $('input[name=bo_pass]').val('${nboardInfo.bo_pass}');
	    
	    
		$('#btnback').click(function() {
			location.href = '/user/nboard/nboardList.do';
		});

	});
</script>
</head>
<body>
	<form class="form-horizontal" role="form" action="" method="post">
		<div class="form-group">
			<label class="control-label col-sm-2" for="bo_title">제목:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="bo_title"
					disabled="disabled" name="bo_title" value="${nboardInfo.bo_title }">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="bo_nick">닉네임:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="bo_nick" name="bo_nick"
					disabled="disabled" value="${nboardInfo.bo_nick }">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="bo_cont">내용:</label>
			<div class="col-sm-10"> 
				<div id="bo_cont"><p></p></div>
			</div>
		</div>
<!-- 	첨부파일 -->
		<c:forEach items="${nboardInfo.items}" var="fileitem">
	         <div class="form-group">
	            <label class="control-label col-sm-2" for="bo_cont">첨부파일1:</label>
	            <div class="col-sm-10">
	                <input type="button" class="filestyle" id="file01" name="files" value="/files/${fileitem.file_name}"
	                onclick="javascript:location.href='/user/nboard/nboardDownload.do?fileSEQ=${fileitem.file_no}';"/ >
	            </div>
	         </div>
		</c:forEach>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="button" class="btn btn-info" id="btnback">목록</button>
			</div>
		</div>
	</form>
</body>
</html>