<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">   
	<jsp:param value="부서목록" name="tabTitle"/> 
	<jsp:param value="부서목록" name="pageTitle"/>
</jsp:include>

<section>
<!-- DataTales Example -->
	<div class="card shadow mb-4">
	    <div class="card-header py-3">
	      <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
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
	          			<a href="${path}/dept/insertDept.do" class="btn btn-light btn-icon-split">
	                 <span class="icon text-gray-600">
	                   <i class="fas fa-arrow-right"></i>
	                 </span>
	                 <span class="text">부서등록</span>
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
	               <th>부서번호</th>
	               <th>이름</th>
	               <th>사원수</th>
	               <th>사용여부</th>
	             </tr>
	           </thead>
	           <tbody>
	           	<c:forEach var="d" items="${list}">
	              <tr>
	               	<td>
	               		<a href='${path }/dept/updateDept.do?deptNo=${d["DEPTNO"]}'><c:out value='${d["DEPTNO"]}'/></a>
	               	</td>
	               	<td>
	               		<a href='${path }/dept/updateDept.do?deptNo=${d["DEPTNO"]}'><c:out value='${d["DEPTNAME"]}'/></a>
	               	</td>
               		<td>
	               		<c:out value='${d["COUNT"]}'/>
	               	</td>
	               	<td>
	               		<c:out value='${d["DEPTSTATUS"]}'/>
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