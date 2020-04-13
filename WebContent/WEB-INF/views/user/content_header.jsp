<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(function(){
	
	var urlz = $(location).attr('href').split('?', 1)[0];
	var dep2 = urlz.split('/')[4];
	var dep3 = urlz.split('/')[5]; 
	
	console.log(urlz);
	
	switch(dep2){
	case('member') :
		dep2 = '회원';
		break;
	case('nboard') :
		dep2 = '공지사항';
		break;
	case('freeboard') :
		dep2 = '자유게시판';
		break;
	case('rboard') :
		dep2 = '자료실';
		break;
	case('qboard') :
		dep2 = 'Q&A 게시판';
		break;
	case('iboard') :
		dep2 = '썸네일게시판';
		break;
	}
	
	if(dep3.includes('Form')){
		dep3 = '게시글 등록'
	} else if(dep3.includes('List')){
		dep3 = '게시글 목록'
	} else if(dep3.includes('View')){
		dep3 = '게시글 상세보기'
	}
	
	$('#2depth').text(dep2);
	$('#3depth').text(dep3);
	
});
</script>
<body>
<div class="page-title-breadcrumb">
	<ol class="breadcrumb">
		<li><i class="fa fa-home"></i>&nbsp;<a href="index.html">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li><a href="#" id="2depth">자유게시판</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
		<li class="active" id="3depth">목록</li>
	</ol>
	<div class="clearfix"></div>
</div>
</body>
</html>