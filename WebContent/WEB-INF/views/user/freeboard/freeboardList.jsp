<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시글 목록</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

$(function(){
	if(eval('${!empty param.message}')){
		alert('${param.message}');
	}
	if(eval('${!empty param.search_keycode}')){
		$('#search_keycode').val('${param.search_keycode}');
	}
	if(eval('${!empty param.search_keyword}')){
		$('#search_keyword').val('${param.search_keyword}');
	}
});
</script>
</head>
<body>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

$(function(){
	
	if(eval('${empty LOGIN_MEMBERINFO}')){
		$('#insertBTN').hide();
	}
	
	$('.TBodyTr').click(function(){
		$(location).attr('href', '/user/freeboard/freeboardView.do?bo_no=' + $(this).find('input[name=bo_no]').val());
	});
	
	$('#insertBTN').click(function(){
		location.href = '/user/freeboard/freeboardForm.do';
	});
});

</script>
<div id="freeboardList_content">
	<div class="panel panel-blue">
    	<div class="panel-heading">자유게시판 목록</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th scope="col" width="5%">No</th>
					<th scope="col" width="65%">제목</th>
					<th scope="col" width="10%">작성자</th>
					<th scope="col" width="10%">작성일</th>
					<th scope="col" width="10%">조회수</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${boardList }" var="boardInfo">
				<tr class="TBodyTr">
					<input type="hidden" name="bo_no" value="${boardInfo.bo_no }" />
					<td>${boardInfo.rnum }</td>
					<td>
						<c:forEach begin="1" end="${boardInfo.bo_depth }" varStatus="stat">
							&nbsp;&nbsp;&nbsp;&nbsp;
							<c:if test="${stat.last }">
								└>
							</c:if>
						</c:forEach>
						${boardInfo.bo_title }
					</td>
					<td>${boardInfo.bo_nick }</td>
					<td>${boardInfo.bo_reg_date }</td>
					<td>${boardInfo.bo_hit }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
	${paginationHTML}
<div >
<form name="serarchForm" action="/user/freeboard/freeboardList.do" method="post" class="form-inline pull-right">
		<input id="search_keyword" name="search_keyword" type="text" placeholder="검색어 입력..." class="form-control" />
		<select id="search_keycode" class="form-control" name="search_keycode" >
			<option value="">검색조건</option>
			<option value="TOTAL">전체</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="WRITER">작성자</option>
		</select>
	    <button type="submit" class="btn btn-primary form-control">검색</button>
	    <button type="button" id="insertBTN" class="btn btn-info form-control">게시글 등록</button>
</form>
</div>	
</body>
</html>