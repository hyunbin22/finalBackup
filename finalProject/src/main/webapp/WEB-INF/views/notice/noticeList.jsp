<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
   <jsp:param name="pageTitle" value=""/>
</jsp:include>
<section id="content">
	<form id="noticeList">
	<div>
		<fieldset>
			<span>
				<input id="searchText" name="searchText" class="sch_txt" type="text" value="">
			</span>
			<button type="button" class="btn sch" onclick="fnSelectInfs('1')">검색</button>
		</fieldset>
	</div>
	<table class="table">
		<tr>
			<th scope="col">번호</th>
			<th scope="col">제목</th>
			<th scope="col">담당부서</th>
			<th scope="col">첨부파일</th>
			<th scope="col">등록일</th>
			<th scope="col">조회수</th>
		</tr>

	<c:forEach items="${list}" var="notice">
		<tr>
			<td><c:out value='${notice["NNO"]}'/></td>
			<td><a href='${pageContext.request.contextPath}/notice/selectNoticeOne.do?nName=${notice["NNAME"]}&nReadCount=${notice["NNO"]}'><c:out value='${notice["NNAME"]}'/></a></td>
			<td><c:out value='${notice["NTEXT"]}'/></td>
			<td><img src="${pageContext.request.contextPath }/resources/images/btn_disk.gif" alt="첨부파일 있음"></td>
			<td><c:out value='${notice["NDATE"]}'/></td>
			<td><c:out value='${notice["NREADCOUNT"]}'/></td>
		</tr>
	</c:forEach>
		<button type="button" onclick="insert();">게시판등록</button>
		<button type="button" onclick="rsite();">관련사이트</button>
	</table>
</form>
${pageBar }
</section>
<script>
	function insert(){
		$("#noticeList").attr("action","${path}/notice/notice.do");   /* ?empNo=${loginEmp.empNo} */
		$("#noticeList").submit();
	}
	function rsite(){
		$("#noticeList").attr("action","${path}/notice/site.do");
		$("#noticeList").submit();
	}
</script>

