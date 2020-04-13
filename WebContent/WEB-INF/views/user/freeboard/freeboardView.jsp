<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
$(function(){
	
	if('${LOGIN_MEMBERINFO.mem_id}' != '${boardInfo.bo_writer}'){
		$('#deleteBTN').hide();
		$('#updateBTN').hide();
	}
	
	// 섬머노트를 div를 활용한 textarea에 추가.
	// http://summernote.org 활용
    $('#bo_content').summernote({
			height: 150,
			codemirror: {
			theme: 'monokai'
		}
    });
    
    $('#bo_title').val('${boardInfo.bo_title}');
    $('#bo_nick').val('${boardInfo.bo_nick}');
    $('#bo_no').val('${boardInfo.bo_no }');
    $('.panel-body').html('${boardInfo.bo_cont}');
    
    $('#deleteBTN').click(function(){
    	if('${LOGIN_MEMBERINFO.mem_id}' != '${boardInfo.bo_writer}'){
    		alert('권한이 없습니다.');
    		return false;
    	}
    	
    	if('${boardInfo.bo_pass}' != $('#bo_pass').val()){
    		alert('비밀번호가 일치하지 않습니다.');
    		return false;
    	}
    	
    	if(confirm('정말 삭제하시겠습니까?')){
	    	$(location).attr('href', '/user/freeboard/deleteFreeboard.do?bo_no=${boardInfo.bo_no}');
    	}
    });
    
    $('form[name=updateForm]').submit(function(){
    	if('${LOGIN_MEMBERINFO.mem_id}' != '${boardInfo.bo_writer}'){
    		alert('권한이 없습니다.');
    		return false;
    	}
    	
    	if('${boardInfo.bo_pass}' != $('#bo_pass').val()){
    		alert('비밀번호가 일치하지 않습니다.');
    		return false;
    	}
    	
    	if(!confirm('정말 수정하시겠습니까?')){
    		return false;
    	}
    	
    	$(this).append($('<input type="hidden" name="bo_cont" value="' + $('.panel-body').html() +'" />'));
    	
    	return true;
    });
    
    $('#replyBTN').click(function(){
    	location.href = '/user/freeboard/freeboardReplyForm.do?bo_no=${boardInfo.bo_no}';	
    });
    
    $('#listBTN').click(function(){
    	if(!confirm('정말 목록으로 돌아가시겠습니까?')){
    		return false;
    	}
    	
    	location.href = 'user/freeboard/freeboardList.do';
    });
});

function download(file_no){
	location.href = '/user/freeboard/downloadFile.do?bo_no=${boardInfo.bo_no}&file_no=' + file_no;
}
</script>
</head>
<body>
<form name="updateForm" class="form-horizontal" role="form" action="/user/freeboard/updateFreeboard.do" method="post">
	<input type="hidden" name="bo_no" id="bo_no" value="" />
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_title">제목:</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="bo_title" name="bo_title" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_nick">작성자 대화명:</label>
		<div class="col-sm-10"> 
			<input type="text" class="form-control" id="bo_nick" name="bo_nick" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_pass">패스워드:</label>
		<div class="col-sm-10"> 
			<input type="password" class="form-control" id="bo_pass" name="bo_pass" >
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_content">내용:</label>
		<div class="col-sm-10"> 
			<div id="bo_content"><p></p></div>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="bo_content">첨부파일:</label>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
	
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox" style="height: 200px;">
				<c:forEach items="${boardInfo.items}" var="item" varStatus="stat">
					<c:if test="${stat.first }" >
						<div class="item active">
					</c:if>
					<c:if test="${!stat.first }">
						<div class="item">
					</c:if>
						<img src="/files/${item.file_save_name }" alt="pic${stat.count}" onclick="download('${item.file_no}');">
					</div>
				</c:forEach>
			</div>
			<!-- Left and right controls -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" id="deleteBTN" class="btn btn-danger">삭제</button>
			<button type="button" id="replyBTN" class="btn btn-primary">답글</button>
			<button type="button" id="listBTN" class="btn btn-info">목록</button>
			<button type="submit" id="updateBTN" class="btn btn-default" style="float: right">수정</button>
		</div>
	</div>
</form>
</body>
</html>