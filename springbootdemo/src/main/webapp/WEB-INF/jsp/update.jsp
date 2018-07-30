<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="taglibs.jsp"%>
${jquery_js} ${jquery_validate_js} ${jquery_form_js }
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateStandard.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  
  </head>
  
  <body>
   <h1>修改信息</h1>
    	<form  action="" method="post" id="myform" >
    		<table border="1">
    			<tr>
    				<td>编号</td>
    				<td><input type="text" name="id" value="${list.id }"></td>
    			</tr>
    			<tr>
    				<td>中文名称</td>
    				<td><input type="text" name="username" value="${list.username }"></td>
    			</tr>

    			<tr>
    				<td><input type="button" value="保存" id="btn"/> <input type="reset" value="重置" /></td>
    			</tr>
    		</table>
    	</form>
    	    <script type="text/javascript">

      $(function() 
      {
      
      $("#btn").click(function() {
			var url = "${ctx}/user/update";
			//异步提交表单
			var options = {
				url : url,
				success : callback,
				type : 'post',
				dataType : 'json'
			};
			$("#myform").ajaxSubmit(options);

      });  });
      
      	function callback(data) {
		if (data.retcode == true) {
			window.location.href = "${ctx}/user/index";

		} else {
			alert(data.retmsg);
		}
	}
      </script>
  </body>
</html>
