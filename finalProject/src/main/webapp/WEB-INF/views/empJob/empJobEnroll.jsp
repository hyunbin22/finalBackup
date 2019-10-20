<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">   
	<jsp:param value="직급등록/수정" name="tabTitle"/> 
	<jsp:param value="직급등록/수정" name="pageTitle"/>
</jsp:include>

<section>
	<div class="col-12 stretch-card">
       <div class="card">
         <div class="card-body">
         	<c:if test="${temp eq '등록' }">
           		<h4 class="card-title">직급등록</h4>
           	</c:if>
           	<c:if test="${temp eq '수정' }">
           		<h4 class="card-title">직급수정</h4>
           	</c:if>
           <form class="forms-sample" method="post" id="jobFrm">
           		<input type="hidden" name="jobNo" value="${job['JOBNO']}"/>
             <div class="form-group row">
               <label for="exampleInputEmail2" class="col-sm-3 col-form-label">직급명</label>
               <div class="col-sm-9">
               	 <c:if test="${temp eq '등록'}">
                 	<input type="text" name="jobName" class="form-control" placeholder="직급명을 입력하세요.">
                 </c:if>
                 <c:if test='${temp eq "수정"}'>
                 	<input type="text" name="jobName" class="form-control" value='${job["JOBNAME"] }'>
                 </c:if>
               </div>
             </div>
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">사용여부</label>
               <div class="col-sm-9">
                 <select name = "jobStatus" id = "status" class="form-control">
                 <c:if test="${temp eq '등록'}">
                 	<option value = "0">사용여부를 선택하세요</option>
                   	<option value = "Y">사용</option>
                   	<option value = "N">중지</option>
                 </c:if>
                 <c:if test='${temp eq "수정"}'>	
                 	<c:if test="${fn:trim(job['JOBSTATUS']) eq 'Y'}">
                 		<option value = "Y" selected>사용</option>
                   		<option value = "N">중지</option>
                 	</c:if>
                 	<c:if test='${fn:trim(job["JOBSTATUS"]) eq "N"}'>
                 		<option value = "Y">사용</option>
                   		<option value = "N" selected>중지</option>
                 	</c:if>
                 </c:if>   
                 </select>
               </div>
             </div>
             <div>
             	<div>
		             <button type="button" class="btn btn-success mr-2" id="jobInsert">등록</button>
		             <button type="button" class="btn btn-success mr-2" id="jobUpdate">수정</button>
	             </div>
             </div>
           </form>
         </div>
       </div>
     </div>
</section>
<script>
	$(function(){
		$('#jobInsert').on('click',function(){
			$('#jobFrm').attr("action","${path}/empJob/insertEmpJobEnd.do");
			$('#jobFrm').submit();
		});
		
		$('#jobUpdate').on('click',function(){
			$('#jobFrm').attr("action","${path}/empJob/updateEmpJobEnd.do");
			$('#jobFrm').submit();
		});
		
	});

</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>