<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">   
	<jsp:param value="직급목록" name="tabTitle"/> 
	<jsp:param value="직급목록" name="pageTitle"/>
</jsp:include>

<section>
<!-- DataTales Example -->
	<div class="card shadow mb-4">
	    <div class="card-header py-3">
	      <h6 class="m-0 font-weight-bold text-primary">직급</h6>
	    </div>
	    <div class="card-body">
	      <div class="table-responsive">
	        <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
	        	<div class="row">
	        		<div class="col-sm-12 col-md-6">
	        			<div class="dataTables_length" id="dataTable_length">
	        				<label>Search:
	         					<input type="search" class="form-control form-control-sm" placeholder="" aria-controls="dataTable">
	          			</label>
	          			<a href="#" class="btn btn-light btn-icon-split">
	                 <span class="icon text-gray-600">
	                   <i class="fas fa-arrow-right"></i>
	                 </span>
	                 <span class="text">검색</span>
	               </a>
	        			</div>
	        		</div>
	        		<div class="col-sm-12 col-md-6">
	         		<div id="dataTable_filter" class="dataTables_filter">
	         			<div style="float:right;">
	          			<a href="${path}/empJob/insertEmpJob.do" class="btn btn-light btn-icon-split">
	                 <span class="icon text-gray-600">
	                   <i class="fas fa-arrow-right"></i>
	                 </span>
	                 <span class="text">직급등록</span>
	               </a>
	              </div>
	         		</div>
	        		</div>
	        	</div>
	        	<div class="row">
	        		<div class="col-sm-12">
	        			<table class="table table-striped table-hover" id="dataTable" width="100%" cellspacing="0" role="grid" aria-describedby="dataTable_info" style="width: 100%;">
	           <thead>
	             <tr>
	               <th>직급번호</th>
	               <th>이름</th>
	               <th>사원수</th>
	               <th>사용여부</th>
	             </tr>
	           </thead>
	           <tbody>
	           	<c:forEach var="j" items="${list}">
	              <tr>
	               	<td>
	               		<a href='${path }/empJob/updateEmpJob.do?jobNo=${j["JOBNO"]}'><c:out value='${j["JOBNO"]}'/></a>
	               	</td>
	               	<td>
	               		<a href='${path }/empJob/updateEmpJob.do?jobNo=${j["JOBNO"]}'><c:out value='${j["JOBNAME"]}'/></a>
	               	</td>
               		<td>
	               		<c:out value='${j["COUNT"]}'/>
	               	</td>
	               	<td>
	               		<c:out value='${j["JOBSTATUS"]}'/>
	               	</td>
	               	
	              </tr>
	             </c:forEach>
	           </tbody>
	         </table>
	       </div>
	     </div>
	   </div>
${pageBar }
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>