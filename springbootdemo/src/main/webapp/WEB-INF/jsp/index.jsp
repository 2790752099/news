<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>


  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>

  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
  <script type="text/javascript">
         function delet() {
             var id=$(".a").attr("rel");
             alert(id);
             $.ajax({
                 type:"POST",
                 url:'user/delete',
                 data:{
                     "num":id
                 },
                 dataType:"json",
                 success:function(mav){
                    alert(mav.message);
                 }
             });
         }
  </script>
  <body>

     <table align="center" border="2" width="800">
 <tr align="center">
     <td>id</td>
     <td>用户名</td>
     <td>操作</td>
 </tr>
 <c:forEach var="list" items="${list}" >
   <tr align="center">

   <td>${list.id}</td>
   <td>${list.username}</td>
       <td><a onclick="delet()" class="a"  rel="${list.id}" href="javascript:void(0)">删除</a>${list.username}</td>

   </tr></c:forEach>
 </table>
  </body>
</html>
