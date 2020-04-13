<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 정보</title>
<!-- 이미지 슬라이드 사이즈 조정 -->
<style type="text/css">
.carousel{
	width:200px;
    height:150px;
    margin-left: 200px;
}
.carousel-inner > .item > img{
    width:200px;
    height:150px;
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
var isFileChange = false;
$(function(){
	$('#listBTN').click(function(){
		location.href="=/user/iboard/iboardList.do";
	});
	 $('#bo_content').summernote({
		lang: 'ko-KR',
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
	});

	
	
	$('.panel-body').html('${boardInfo.bo_cont}');
	// 수정
	$('form[name=iboardForm]').submit(function(){
		var isReturn = false;
		
		if($('#bo_title').val() == '') {
			alert('제목을 입력하지 않았습니다.');
			$('#bo_title').focus();
			return false;
		}
		if($('#bo_nick').val() == '') {
			alert('대화명을 입력하지 않았습니다.');
			$('#bo_nick').focus();
			return false;
		}
		var bo_cont = $('.panel-body').html();
		$(this).append('<input type="hidden" name="bo_no" value="${boardInfo.bo_no}"/>');
		$(this).append('<input type="hidden" name="bo_cont" value="' + bo_cont + '"/>');
		$(this).append('<input type="hidden" name="bo_writer" value="${LOGIN_MEMBERINFO.mem_id}"/>');
		$(this).append('<input type="hidden" name="bo_ip" value="${pageContext.request.remoteAddr}"/>');
		
		return true;
	});
	
	$('#deleteBTN').click(function(){
		
		if('${LOGIN_MEMBERINFO.mem_id}' != '${boardInfo.bo_writer}') {
			alert('권한이 없습니다.');
			return false;
		}
	
		if(!confirm('정말 삭제하시겠습니까?')){
			return false;
		}
		location.href = '/user/iboard/deleteIboard.do?bo_no=${boardInfo.bo_no}';
	});
	
	
	$('#ThumbNail-img').click(function(){
		var imgsource = $(this).attr('src');
		if(imgsource == '' && imgsource == '/files/noImageFile.jpg') {
			alert('이미지 파일이 없습니다.');
			return false;
		}
		
	});
});

</script>
</head>
<body>
<form class="form-horizontal" name="iboardForm" role="form" action="/user/iboard/updateIboard.do" method="post" enctype="multipart/form-data">
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="bo_title" name="bo_title" placeholder="제목 입력..." value="${boardInfo.bo_title }">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_nick">작성자명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="bo_nick" name="bo_nick" placeholder="작성자명 입력..." value="${boardInfo.bo_nick }">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="file">썸네일:</label>
		<div class="col-sm-10">
			<img src="/files/${boardInfo.file_save_name }" alt="Thumbnail Image" id="ThumbNail-img" style="width:200px; height:200px;"
			onclick="javascript:location.href='/user/iboard/iboardDownload.do?fileSEQ=${fileitem.file_no}';" > 
			 <input type="file" class="filestyle" id="file" name="files" data-buttonName="btn-primary" 
			 value="/files/${fileitem.file_name}"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="bo_content"><p></p></div>
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-danger" id="deleteBTN">삭제</button>
			<button type="button" class="btn btn-info" id="listBTN">목록</button>
			<button type="submit" class="btn btn-default" style="float: right">수정</button>
		</div>
	</div>
</form>
</body>
</html>