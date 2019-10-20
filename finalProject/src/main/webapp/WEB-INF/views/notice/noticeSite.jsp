<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
li > div {
    border: 1px solid #5a6f89;
    border-radius: 3px;
    overflow: hidden;
    list-style-type: none;
    text-decoration: none;
    
}

.b-related {
    display: block;
    float: left;
    padding: 7px 35px 7px 13px;
    width: 100%;
    background: #fff url(/_res/research/img/common/ico-link.png) no-repeat right 12px center;
    font-size: 16px;
    line-height: 21px;
    color: #5a6f89;
    font-weight: 400;
    box-sizing: border-box;
    text-decoration: none;
    
}

li {
    display: inline-block;
    position: relative;
    padding: 0 10px 10px 0;
    width: calc(25% - 11px);
    vertical-align: top;
}

*{
	text-decoration: none;
    list-style-type: none;
    margin: 0;
    padding: 0;
}

</style>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
   <jsp:param name="pageTitle" value=""/>
</jsp:include>
<section id="content">
 <div class="content">
	   <div class="title">
	   		<h3>관련사이트</h3>
	   </div>
	   <div>
	   	<ul>
	   		<li>
	   			<div>
	   				<a class="b-related btn btn-outline-success my-2 my-sm-0" href="#"><span>사이트연결</span></a>
	   			</div>
	   		</li>
	   		<li>
	   			<div>
	   				<a class="b-related" href="#"><span>사이트연결</span></a>
	   			</div>
	   		</li>
	   		<li>
	   			<div>
	   				<a class="b-related" href="#"><span>사이트연결</span></a>
	   			</div>
	   		<li>
	   			<div>
	   				<a class="b-related" href="#"><span>사이트연결</span></a>
	   			</div>
	   		</li>
	   		<li>
	   			<div>
	   				<a class="b-related" href="#"><span>사이트연결</span></a>
	   			</div>
	   		</li>
	   		<li>
	   			<div>
	   				<a class="b-related" href="#"><span>사이트연결</span></a>
	   			</div>
	   		</li>
	   		<li>
	   			<div>
	   				<a class="b-related" href="#"><span>사이트연결</span></a>
	   			</div>
	   		</li>
	   		<li>
	   			<div>
	   				<a class="b-related" href="#"><span>사이트연결</span></a>
	   			</div>
	   		</li>
	   		<li>
	   			<div>
	   				<a class="b-related" href="#"><span>사이트연결</span></a>
	   			</div>
	   		</li>
	   	</ul>
	   </div>
   </div>
</section>

