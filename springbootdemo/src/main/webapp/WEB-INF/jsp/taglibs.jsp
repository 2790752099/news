<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--  system values--%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="jquery_js" value="<script type='text/javascript' src='${ctx}/js/jquery-1.7.js'></script>"  />
<c:set var="jquery_validate_js" value="<script type='text/javascript' src='${ctx}/js/jquery.validate.js'></script>"  />
<c:set var="jquery_form_js" value="<script type='text/javascript' src='${ctx}/js/jquery.form.js'></script>"  />