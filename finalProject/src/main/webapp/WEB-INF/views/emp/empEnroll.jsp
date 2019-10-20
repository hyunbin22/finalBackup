<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">   
	<jsp:param value="사원등록" name="tabTitle"/> 
	<jsp:param value="사원등록" name="pageTitle"/>
</jsp:include>

<section>
<div class="col-12 grid-margin">
   <div class="card">
     <div class="card-body">
       <form class="form-sample" id="empFrm" method="post" enctype="multipart/form-data">
         <p class="card-description"> Personal info </p>
         <div class="row">
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">이름</label>
               <div class="col-sm-9">
                 <input type="text" class="form-control" name="empName" required>
               </div>
             </div>
           </div>
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">부서</label>
               <div class="col-sm-9">
                  <select name = "deptNo" id = "deptNo" class="form-control">
                        <option value = "0">해당 부서를 선택하세요</option>
                        <c:forEach items="${dept}" var="dept">
                           <option value = "<c:out value='${dept["DEPTNO"]}'/>"><c:out value='${dept["DEPTNAME"]}'/></option>
                        </c:forEach>
                     </select>
            	</div>
             </div>
           </div>
         </div>
         <div class="row">
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">아이디</label>
               <div class="col-sm-9">
                 <div id = "userId-container">
					<input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="empId" id="empId" required>
					<span class="guide ok" style="display:none;">이 아이디는 사용할 수 있음</span>
					<span class="guide error" style="display:none;">이 아이디는 사용할 수 없음</span>
				</div>
               </div>
             </div>
           </div>
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">직급</label>
               <div class="col-sm-9">
                  <select name = "jobNo" id = "jobNo" class="form-control">
                        <option value = "0">해당 직급을 선택하세요</option>
                        <c:forEach items="${job}" var="j">
                           <option value = "<c:out value='${j["JOBNO"]}'/>"><c:out value='${j["JOBNAME"]}'/></option>
                        </c:forEach>
                     </select>
            	</div>
             </div>
           </div>
         </div>
         <div class="row">
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">비밀번호</label>
               <div class="col-sm-9">
                 <input type="password" class="form-control" name="password" required>
               </div>
             </div>
           </div>
           <div class="col-md-6">
            <div class="form-group row">
              <label class="col-sm-3 col-form-label">연봉</label>
              <div class="col-sm-9">
                <input type="number" class="form-control" name="empSal" required>
              </div>
            </div>
          </div>
         </div>
         <div class="row">
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">비밀번호확인</label>
               <div class="col-sm-9">
                 <input type="password" class="form-control" name="pw2" required>
               </div>
             </div>
           </div>
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">은행</label>
               <div class="col-sm-9">
                  <select name = "empBank" id = "empBank" class="form-control">
                        <option value = "0">은행을 선택하세요</option>
                        <option value = "국민은행">국민은행</option>
                        <option value = "농협은행">농협은행</option>
                        <option value = "새마을금고">새마을금고</option>
                        <option value = "신한은행">신한은행</option>
                        <option value = "우리은행">우리은행</option>
                        <option value = "카카오뱅크">카카오뱅크</option>
                        <option value = "하나은행">하나은행</option>
                     </select>
            	</div>
             </div>
           </div>
         </div>
         <div class="row">
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">성별</label>
               <div class="col-sm-9">
                 <select class="form-control">
                   <option>Male</option>
                   <option>Female</option>
                 </select>
               </div>
             </div>
           </div>
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">계좌번호</label>
               <div class="col-sm-9">
                 <input type="text" class="form-control" name="empBankNum" required>
               </div>
             </div>
           </div>
         </div>
         <div class="row">
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">전화번호</label>
               <div class="col-sm-9" style="">
                 <input type="text" class="form-control" name="empPhone" placeholder="-없이 입력하세요" required>
               </div>
             </div>
           </div>
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">주민등록번호</label>
               <div class="col-sm-9">
                 <input type="text" class="form-control" name="empSSN" placeholder="123456-1234567" required>
               </div>
             </div>
           </div>
         </div>
         <div class="row">
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">이메일</label>
               <div class="col-sm-9" style="">
                 <input type="email" class="form-control" name="empEmail" placeholder="abc@abc.com" required>
               </div>
             </div>
           </div>
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">주소</label>
               <div class="col-sm-9">
                 	<input type="text" id="sample6_postcode" placeholder="우편번호" style="width:350px;">
					<input type="button" class="btn-light btn-icon-split" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
					<input type="text" id="sample6_address" placeholder="주소" style="width:350px;"><br>
					<input type="text" id="sample6_detailAddress" placeholder="상세주소" style="width:172.5px;">
					<input type="text" id="sample6_extraAddress" placeholder="참고항목" style="width:172.5px;">
					<input type="hidden" name="empAddr" id="empAddr"/>
					<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
					<script>
					    function sample6_execDaumPostcode() {
					        new daum.Postcode({
					            oncomplete: function(data) {
					                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
					
					                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
					                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					                var addr = ''; // 주소 변수
					                var extraAddr = ''; // 참고항목 변수
					
					                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					                    addr = data.roadAddress;
					                } else { // 사용자가 지번 주소를 선택했을 경우(J)
					                    addr = data.jibunAddress;
					                }
					
					                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
					                if(data.userSelectedType === 'R'){
					                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
					                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
					                        extraAddr += data.bname;
					                    }
					                    // 건물명이 있고, 공동주택일 경우 추가한다.
					                    if(data.buildingName !== '' && data.apartment === 'Y'){
					                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
					                    }
					                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
					                    if(extraAddr !== ''){
					                        extraAddr = ' (' + extraAddr + ')';
					                    }
					                    // 조합된 참고항목을 해당 필드에 넣는다.
					                    document.getElementById("sample6_extraAddress").value = extraAddr;
					                
					                } else {
					                    document.getElementById("sample6_extraAddress").value = '';
					                }
					
					                // 우편번호와 주소 정보를 해당 필드에 넣는다.
					                document.getElementById('sample6_postcode').value = data.zonecode;
					                document.getElementById("sample6_address").value = addr;
					                // 커서를 상세주소 필드로 이동한다.
					                document.getElementById("sample6_detailAddress").focus();
					            }
					        }).open();
					    }
					</script>
               </div>
             </div>
         </div>
         </div>
         <div class="row">
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">사원사진</label>
               <div class="custom-file">
                    <input type="file" class="custom-file-input" name="proImg" id="upFile1">
                    <label class="custom-file-label" for="upFile1">파일을 선택하세요</label>
                </div>
             </div>
           </div>
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">결재도장등록</label>
               <div class="custom-file">
                    <input type="file" class="custom-file-input" name="stampImg" id="upFile3">
                    <label class="custom-file-label" for="upFile3">파일을 선택하세요</label>
                </div>
             </div>
           </div>
         </div>
         <div class="row">
           <div class="col-md-6">
             <div class="form-group row">
               <label class="col-sm-3 col-form-label">자격증사진 </label>
	       			<button class="btn btn-light btn-icon-split" style="position:absolute; right:0;" id="addFile">
	              		<span class="text">추가</span>
            		</button>
               <div class="custom-file">
               		<div id="fileBox">
	                    <input type="file" class="custom-file-input" name="upFile" id="upFile2">
	                    <label class="custom-file-label" for="upFile2">파일을 선택하세요</label>
                    </div>
                </div>
             </div>
           </div>
           <div class="col-md-6">
             <div class="form-group row" id="setHeight" style="height:40px;">
             </div>
           </div>
         </div>
         <div style="margin:0 auto; width:fit-content;">
         	<input type="button" class="btn btn-success mr-2" value="등록" onclick="return validate();" style="width:150px;">
         </div>
       </form>
     </div>
 
   </div>
 </div>
</section>
<script>
	var setHeight = $('#setHeight').height();
	
	/* 아이디 중복검사 */
	$(function(){
		$('#empId').keyup(function(){
			var userId = $(this).val().trim();
			if(userId.length<4) {
				$(".guide").hide();
				return;
			}
			$.ajax({
				url:"${path}/emp/checkId.do",
				data:{"userId":userId},
				success:function(data){
					console.log(data);
					if(data.isUsable == true) {
						$("span.ok").show();
						$("span.error").hide();
					} else {
						$("span.ok").hide();
						$("span.error").show();
					}
				}
			});
		});
	});
	//파일등록시 
	$(function(){
		$('[name=upFile]').on('change', function(event){
			var fileName=this.files[0].name;
			$(this).next('.custom-file-label').html(fileName);
		});
		$('[name=proImg]').on('change', function(event){
			var fileName=this.files[0].name;
			$(this).next('.custom-file-label').html(fileName);
		});
		$('[name=stampImg]').on('change', function(event){
			var fileName=this.files[0].name;
			$(this).next('.custom-file-label').html(fileName);
		});
	});
	var count = 4;
	
	//파일추가
	$(function(){
		$('#addFile').click(function(){
			setHeight = setHeight + 80;
			$('#setHeight').css("height",setHeight + "px");
			var addWrap = '<div class="fileWrap">'; 
    		addWrap += '<input type="file" class="custom-file-input" name="upFile" id="upFile' + count + '"'
    		addWrap += '>';
    		addWrap += '<label class="custom-file-label" for="upFile' + count + '"';
    		addWrap += '>';
    		addWrap += "파일을 선택하세요";
    		addWrap += "</label>";
	        addWrap += '<input type="button" name="removeFile" class="btn" id="btnRemove" value="삭제">';
	        addWrap += '</div>'; 
            $('#fileBox').append(addWrap);
            count++;
		}); 
	});
	
	//유효성검사
	$(function(){
   		$(document).on("click","#btnRemove",function(event){
   			setHeight = setHeight - 80;
			$('#setHeight').css("height",setHeight + "px");
   			var pa = $(this).parent();
        		pa.remove();
   		});
   		
   		//확장자, 정규식 검사
   		$(document).on("change","input[name='upFile']",function(event) {
   			var ext = $(this).val().split('.').pop().toLowerCase();
   			var fileSize = (this).files[0].size;
   			var maxSize = 1024*1024*1024;
   			
   			if($.inArray(ext, ['gif','png','jpg','jpeg','doc','docx','xls','xlsx','hwp']) == -1) {
   				alert("등록할 수 없는 확장자입니다.");
   				$(this).val("");
   				return;
   			} 
   			
   			if(fileSize > maxSize) {
   				alert("첨부파일 크기는 1GB 이내로 등록 가능합니다.");
   				$(this).val("");
   				return;
   			}
   		});
   	});
	
	function validate() {
		var empAddr = $('#sample6_postcode').val();
		empAddr += "|" + $('#sample6_address').val();
		empAddr += "|" + $('#sample6_detailAddress').val();
		empAddr += "|" + $('#sample6_extraAddress').val();
		$('#empAddr').val(empAddr);
		$('#empFrm').attr("action","${pageContext.request.contextPath}/emp/insertEmpEnd.do");
		$('#empFrm').submit();
	}
	
	
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
