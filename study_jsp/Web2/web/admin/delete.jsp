<%@ page import="com.ntvu.web2.service.LoginService" %><%--
  Created by IntelliJ IDEA.
  User: alin
  Date: 2020/11/6
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String loginName = request.getParameter("loginName");
    boolean success = new LoginService().delete(loginName);
%>
<script type="text/javascript">
    alert('<%=success ? "操作成功" : "操作失败"%>');
    window.location.href = "/admin/main.jsp";
</script>