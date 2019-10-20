<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param name="pageTitle" value="파라미터테스트" />
</jsp:include>
<style>
div#demo-container {
	width: 40%;
	padding: 15px;
	margin: 0 auto;
	border: 1px solid lightgray;
	border-radius: 10px;
}
</style>
<section id="content">
	<div id="demo-container">
		<form id="devFrm" enctype="multipart/form-data">
		<caption>게시글 작성</caption>
		<hr>
			<div class="form-group row">
				<label for="nName" class="col-sm-2 col-form-label">제목</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="nName" name="nName" />
				</div>
			</div>
			<div class="form-group row">
			<label for="deptNo" class="col-sm-2 col-form-label">부서</label>
				<div class="col-sm-10">
					
					   <select name = "deptNo" id = "deptNo" class="form-control">
		                  <option value = "0">해당 부서를 선택하세요</option>
		                  <c:forEach items="${deptList}" var="dept">
		                     <option value = "<c:out value='${dept["DEPTNAME"]}'/>"><c:out value='${dept["DEPTNAME"]}'/></option>
		                  </c:forEach>
		               </select>
					
				</div>
			</div>
			<div class="form-group row">
				<label for="empName" class="col-sm-2 col-form-label">작성자<%-- ${empOne.empName } --%></label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="empName" name="empName" />
				</div>
			</div>
			<div class="form-group row">
				<label for="empPhone" class="col-sm-2 col-form-label">전화번호<%-- ${empOne.empPhone } --%></label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="empPhone" name="empPhone" />
				</div>
			</div>
			<div class="form-group row">
				<label for="nText" class="col-sm-2 col-form-label">내용</label>
				<div class="col-sm-10">
					<textarea rows="20" cols="100" class="form-control" id="nText" name="nText"></textarea>
				</div>
			</div>
			<div class="form-group row">
			<label for="upFile" class="col-sm-2 col-form-label">첨부파일</label>
				<div class="col-sm-10">
					<input type="file" name="upFile">
				</div>
			</div>
			<div class="list-group">
				<button type="button" onclick="insertNotice();" class="list-group-item list-group-item-action">
					게시판등록
				</button>
			</div>
			 <br/><br/>
			   <a href="#this" class="btn" id="list">목록으로</a>
		
				</form>
			</div>

</section>
	<script>
		function insertNotice(){
			$("#devFrm").attr("action","${path }/notice/insertNotice.do");
			$("#devFrm").submit();
		}
	</script>
