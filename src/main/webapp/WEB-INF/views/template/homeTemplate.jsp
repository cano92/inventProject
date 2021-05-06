<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid"%>


<rapid:override name="body-content">

	<%@ include file="../template-parts/header.jsp"%>
	<%@ include file="../template-parts/navBar.jsp"%>
	
	<!-- 	sideBar barra lateral opcional -->
	
	<rapid:block name="page-content">
 		Here is the content
	</rapid:block>

	<%@ include file="../template-parts/footer.jsp"%>

</rapid:override>

<!-- ... reescribe el baseTemplate ...  -->
<%@ include file="baseTemplate.jsp"%>