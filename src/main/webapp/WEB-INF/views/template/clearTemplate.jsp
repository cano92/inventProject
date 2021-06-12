<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid"%>


<rapid:override name="body-content">

	<%@ include file="../template-parts/header.jsp"%>	

	<rapid:block name="page-content">
 		Here is the content
	</rapid:block>


</rapid:override>

<!-- ... reescribe el baseTemplate ...  -->
<%@ include file="baseTemplate.jsp"%>