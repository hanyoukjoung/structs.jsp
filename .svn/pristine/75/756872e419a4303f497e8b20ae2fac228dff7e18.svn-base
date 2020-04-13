 <%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 등록</title>
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
    $('#bo_cont').summernote({
       lang: 'ko-KR', 
         height: 150,
         codemirror: {
         theme: 'monokai'
      }
   });
   $('form[name=qboardForm]').submit(function(){
	   if($('input[name=bo_title]').val()==""){
			alert('제목을 입력해주세요.');
		return false; 
		}
		
		if($('input[name=bo_nick]').val()==""){
			alert('닉네임을 입력해주세요.');
			return false;
		}
		
		if($('input[name=bo_pass]').val()==""){
			alert('비밀번호를 입력해주세요.');
			return false; 
		}
		
		if('${LOGIN_MEMBERINFO.mem_pass}'!= $('input[name=bo_pass]').val()){
			alert("비밀번호가 일치하지 않습니다."); 
			return false;
		}
	   
      $(this).append('<input type="hidden" name="bo_cont" value="' + $('.panel-body').html() + '"/>');
      $(this).append('<input type="hidden" name="bo_writer" value="${LOGIN_MEMBERINFO.mem_id}"/>');
      $(this).append('<input type="hidden" name="bo_ip" value="${pageContext.request.remoteAddr}"/>');
      
      return true;
   });
   
   $('#cancelBTN').click(function(){
	   if(!confirm('정말 되돌리시겠습니까? 작업내용이 사라집니다.')){
		   return false;
	   }
   });
   
   $('#goListBTN').click(function(){
	   if(confirm('정말 목록으로 돌아가시겠습니까? 작업내용이 사라집니다.')){
	      location.href='/user/qboard/qboardList.do';
	   }
   });
});

</script>
</head>
<body>
<form class="form-horizontal" name="qboardForm" action="/user/qboard/insertQboard.do" method="post">
   <div class="form-group">
      <label class="control-label col-sm-2" for="bo_title">제목:</label>
      <div class="col-sm-10">
         <input type="text" class="form-control" id="bo_title" name="bo_title" placeholder="제목 입력...">
      </div>
   </div>
   <div class="form-group">
      <label class="control-label col-sm-2" for="bo_nick">작성자 대화명:</label>
      <div class="col-sm-10"> 
         <input type="text" class="form-control" id="bo_nick" name="bo_nick" placeholder="대화명 입력...">
      </div>
   </div>
   <div class="form-group">
      <label class="control-label col-sm-2" for="bo_pass">패스워드:</label>
      <div class="col-sm-10"> 
         <input type="password" class="form-control" id="bo_pass" name="bo_pass" placeholder="패스워드 입력...">
      </div>
   </div>
   <div class="form-group">
      <label class="control-label col-sm-2" for="bo_cont">내용:</label>
      <div class="col-sm-10"> 
         <div id="bo_cont"><p>내용을 입력해주세요...</p></div>
      </div>
   </div>
   <div class="form-group"> 
      <div class="col-sm-offset-2 col-sm-10">
         <button type="submit" class="btn btn-info" style="float: right">등록</button>
         <button type="reset" class="btn btn-danger" style="float: right" id="cancelBTN">취소</button>
         <button type="button" class="btn btn-primary" style="float: right" id="goListBTN">목록</button>
      </div>
   </div>
</form>
</body>
</html>