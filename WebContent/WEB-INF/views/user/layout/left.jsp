<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

$(function(){
	
	var urlz = $(location).attr('href').split('?', 1)[0];
	var dep2 = urlz.split('/')[4];
	
	$('#side-menu').find('li').each(function(){
		if($(this).attr('id') == dep2){
			$(this).attr('class', 'active');
		} else {
			$(this).attr('class', '');
		}
	});
	
});

</script>
</head>
<body>
<!--BEGIN SIDEBAR MENU-->
<nav id="sidebar" role="navigation" data-step="2"
	data-intro="Template has &lt;b&gt;many navigation styles&lt;/b&gt;"
	data-position="right" class="navbar-default navbar-static-side">
	<div class="sidebar-collapse menu-scroll">
		<ul id="side-menu" class="nav">
			<div class="clearfix"></div>
			<li id="nboard">
				<a href="/user/nboard/nboardList.do">
					<i class="fa fa-tachometer fa-fw"><div class="icon-bg bg-orange"></div></i>
					<span class="menu-title">공지사항</span>
				</a>
			</li>
			<li id="freeboard" >
				<a href="/user/freeboard/freeboardList.do">
					<i class="fa fa-desktop fa-fw"><div class="icon-bg bg-pink"></div></i>
					<span class="menu-title">자유게시판</span>
				</a>
			</li>
			<li id="rboard" >
				<a href="/user/rboard/rboardList.do">
					<i class="fa fa-send-o fa-fw"><div class="icon-bg bg-green"></div></i>
					<span class="menu-title">자료실</span>
				</a>
			</li>
			<li id="qboard" >
				<a href="/user/qboard/qboardList.do">
					<i class="fa fa-edit fa-fw"><div class="icon-bg bg-violet"></div></i>
					<span class="menu-title">Q&A게시판</span>
				</a>
			</li>
			<li id="iboard" >
				<a href="/user/iboard/iboardList.do">
					<i class="fa fa-edit fa-fw"><div class="icon-bg bg-violet"></div></i>
					<span class="menu-title">썸네일 게시판</span>
				</a>
			</li>
		</ul>
	</div>
</nav>
</body>
</html>