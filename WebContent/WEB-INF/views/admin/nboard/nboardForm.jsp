<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항게시물 보기</title>
<script type="text/javascript">
$(function(){
	$('#bo_cont').summernote({
		height: 150,
		codemirror: {
		theme: 'monokai'
		}
	});
	$('#goListBTN').click(function(){
		location.href='/admin/nboard/nboardList.do';
	});
	 
	$('form[name=notifyForm]').submit(function(){
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
		
		var isReturn = false;
		
		$('input[type=file]').each(function(){
			if(/\.(jpg|jpeg|gif|png)/.test($(this).val())){
				isReturn = true;
				alert('이미지 파일을 등록 할 수 없습니다.');
				return false;
			}	
		});
		
		if(isReturn){
			return false;
		}
		
		$(this).attr('action','/admin/nboard/insertnboard.do');
		var bo_cont = $('#bo_cont').summernote('code');
		$(this).append('<input type="hidden" name="bo_cont" value="'+bo_cont+'"/>');
		$(this).append('<input type="hidden" name="bo_writer" value="${LOGIN_ADMININFO.admin_id}"/>');
		$(this).append('<input type="hidden" name="bo_pass" value="${LOGIN_ADMININFO.admin_pass}"/>');
		$(this).append('<input type="hidden" name="bo_ip" value="${pageContext.request.remoteAddr}"/>');
		
	});
});
</script>
</head>
<body>
<form name="notifyForm" class="form-horizontal" role="form" action="" method="post" enctype="multipart/form-data">
<div class="wrap">
	<table width="1000" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td width="30">&nbsp;</td>
			<td width="790"> 
				<div id="container">
					<div class="title">공지사항</div>
					<table border="0" cellspacing="1" cellpadding="1">
						<tr>
						  <th>제목</th>
						  <td><input type="text" id="bo_title" name="bo_title" placeholder="제목 입력..."></td>
						</tr>
						<tr>
						  <th>작성자</th>
						  <td><input type="text" class="bo_nick" name="bo_nick" value="${LOGIN_ADMININFO.admin_id}"></td>
						</tr>
						<tr>
							<div>
							<th>내용:</th>
							<td class="col-sm-10"> 
								<div id="bo_cont"></div>
							</td>
						</div>
						</tr>
					</table>
						<div class="form-group">
						<label class="control-label col-sm-2" for="files">첨부파일1:</label>
						<div class="col-sm-10">
						 <input type="file" class="filestyle" id="files" name="files" data-buttonName="btn-primary">
						</div>
						</div>
						<div class="form-group">
						<label class="control-label col-sm-2" for="files">첨부파일2:</label>
						<div class="col-sm-10">
						 <input type="file" class="filestyle" id="files" name="files" data-buttonName="btn-primary">
						</div>
						</div>
					<div style="text-align:right">
						<button type="submit" class="btn btn-info">등록</button> 
						<button type="button" class="btn btn-primary" style="float: right" id="goListBTN">목록</button>
					</div>
				</div>
			</td>
		</tr>
	</table>
</div>
</form>
</body>
</html>