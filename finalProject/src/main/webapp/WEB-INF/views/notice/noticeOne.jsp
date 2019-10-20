<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
   <jsp:param name="pageTitle" value="게시판상세"/>
</jsp:include>
<section id="content">
	<div id="container">
		<div id="content">
			<div class="sub_title">
				<h3>부서별자료실</h3>
				<p>각 부서의 노동 정책 및 행정업무에 대한 자료를 보실 수 있습니다.</p>
				<div id="text">
					<div class="board_view">
						<dl class="b_title">
							<dt>제목</dt>
							<dd>${nt.NName}</dd>
						</dl>
						<dl class="b_date">
							<dt>등록일</dt>
							<dd>${nt.NDate}</dd>
						</dl>
						<dl class="b_team">
							<dt>담당부서</dt>
							<dd>물품관리팀</dd>
						</dl>
						<dl class="b_writer">
							<dt>작성자</dt>
							<dd></dd>
						</dl>
						<dl class="b_tel">
							<dt>전화번호</dt>
							<dd></dd>
						</dl>
						<div class="b_content">
							내용
						</div>
						<dl class="b_file">
							<dt>첨부파일</dt>
							<dd>
								<ul>
									<li>
										<span>첨부파일이름</span>
										<a href="#" class="" title="다운로드">
											<img src="${pageContext.request.contextPath }/resources/images/btn_down.gif" alt="다운로드">
										</a>
									</li>
								</ul>
							</dd>
						</dl>
					</div>
					<div class="">
						<a href="${pageContext.request.contextPath}/notice/selectNoticeList.do">목록</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</section>
