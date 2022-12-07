<%@page import="model.entity.Route"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.servlet.ServletConfig.ReqVars"%>
<%@page import="model.entity.City"%>
<%@page import="controller.servlet.ServletConfig.SessVars"%>
<%@page import="controller.servlet.Root.RootOptions"%>
<%@page import="view.PageUtils"%>
<%@page import="model.entity.Page"%>
<%@page import="controller.servlet.ServletConfig"%>

<%@page
     language="java"
     contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"
%>

<%
RootOptions option = RootOptions.valueOf((String) session.getAttribute(SessVars.ROOT_OPTION.name()));
%>

<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="utils/setupHead.html"></jsp:include>
    <title><%=PageUtils.pageName%></title>
  </head>
  <body <%=PageUtils.mainBodySetup%>>
    <jsp:include page="utils/navbar/navbar.jsp">
      <jsp:param name="additionalItemsFile" value="root.jsp" />
    </jsp:include>
    <div <%=PageUtils.mainDivSetup%>>
      <% if (option == RootOptions.CITIES) { %>
        <jsp:include page="cities.jsp"></jsp:include>
      <% } else if (option == RootOptions.ROUTES) { %>
        <jsp:include page="routes.jsp"></jsp:include>
      <% } else { %>
        <p>Error</p>
      <% } %>
    </div>
    <jsp:include page="utils/footer.html"></jsp:include>
    <jsp:include page="utils/setupBodyEnd.html"></jsp:include>
  </body>
</html>
