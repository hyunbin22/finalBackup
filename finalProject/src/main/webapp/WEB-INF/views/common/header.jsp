<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.pageTitle }</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<!-- 부트스트랩관련 라이브러리 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<!-- 사용자작성 css -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css" />

</head>
<body>
<div id="container">
	<header>
		<div id="header-container">
			<h2>${param.pageTitle }</h2>
		</div>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">
				<img src="${pageContext.request.contextPath }/resources/images/logo-spring.png" alt="스프링로고" width="50px" />
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
		  	</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
			      <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}">Home</a></li>
			      <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/board/boardList.do">게시판</a></li>
			      <%-- <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/demo/demo.do">Demo</a></li> --%>
			      	<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Demo
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="${pageContext.request.contextPath}/demo/demo.do">Dev 등록</a>
							<a class="dropdown-item" href="${pageContext.request.contextPath}/demo/selectDevList.do">Dev 목록</a>
						</div>
					</li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/memo/memo.do">메모</a></li>
			    </ul>
			    <c:if test="${empty loginMember }">
		    		<button class="btn btn-outline-success my-2 my-sm-0" type="button" data-toggle="modal" 
					data-target="#loginModal">로그인</button>
					&nbsp;
					<button class="btn btn-outline-success my-2 my-sm-0" type="button" 
					onclick="location.href='${pageContext.request.contextPath}/member/memberEnroll.do'">회원가입</button>
				</c:if>
				<c:if test="${not empty loginMember }">
					<span><a href="#">${loginMember.userName}</a> 님, 안녕하세요</span>
			        &nbsp;
			        <button class="btn btn-outline-success my-2 my-sm-0" type="button" 
			        onclick="location.href='${pageContext.request.contextPath }/member/memberLogout.do'">로그아웃</button>
				</c:if>
			 </div>
		</nav>
		<!-- 로그인 모달 -->
		<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" 
		aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">로그인</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	  
          <form action="${pageContext.request.contextPath}/member/memberLogin.do" method="post">
	      <div class="modal-body">
			    <input type="text" class="form-control" name="userId" placeholder="아이디" required>
			    <br />
			    <input type="password" class="form-control" name="password" placeholder="비밀번호" required>
	      </div>
	      <div class="modal-footer">
	        <button type="submit" class="btn btn-outline-success" >로그인</button>
	        <button type="button" class="btn btn-outline-success" data-dismiss="modal">취소</button>
	      </div>
		  </form>
	    </div>
	  </div>
	</div>
		
	</header>
	
	
	
	
	
	
	
	