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
	    
	    // 목록으로
		$('#btnback').click(function() {
			location.href = '/admin/nboard/nboardList.do';
		});
		
		$('.panel-body').html('${nboardInfo.bo_cont}');
		// 수정
		$('form[name=nboardForm]').submit(function(){
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
			$(this).append('<input type="hidden" name="bo_title" value="${nboardInfo.bo_title}"/>');
			$(this).append('<input type="hidden" name="bo_writer" value="${nboardInfo.bo_writer}"/>');
			$(this).append('<input type="hidden" name="bo_nick" value="${nboardInfo.bo_nick}"/>');
// 			$(this).append('<input type="hidden" name="bo_writer" value="${LOGIN_MEMBERINFO.admin_id}"/>');
			$(this).append('<input type="hidden" name="bo_no" value="${nboardInfo.bo_no}"/>');
			$(this).append('<input type="hidden" name="bo_cont" value="' + bo_cont + '"/>');
			$(this).append('<input type="hidden" name="bo_ip" value="${pageContext.request.remoteAddr}"/>');
			
			return true;
		});
		$('#deleteBTN').click(function(){
			location.href = '/admin/nboard/deleteNboard.do?bo_no=${nboardInfo.bo_no}';
		});
		
	});
</script>
</head>
<body>
	<form class="form-horizontal" name="nboardForm" role="form" action="/admin/nboard/updateNboard.do" 
			method="post" enctype="multipart/form-data">
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
<!-- 		첨부파일 -->
		<c:forEach items="${nboardInfo.items}" var="fileitem">
	         <div class="form-group">
	            <label class="control-label col-sm-2" for="bo_cont">첨부파일1:</label>
	            <div class="col-sm-10">
	                <input type="button" class="filestyle" id="file01" name="files" value="/files/${fileitem.file_name}" 
	                onclick="javascript:location.href='/admin/nboard/nboardDownload.do?fileSEQ=${fileitem.file_no}';"/>
	            </div>
	         </div>
		</c:forEach>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="button" class="btn btn-danger" id="deleteBTN">삭제</button>
				<button type="button" class="btn btn-info" id="btnback">목록</button>
				<button type="submit" class="btn btn-default" style="float: right">수정</button>
			</div>
		</div>
	</form>
</body>
</html>