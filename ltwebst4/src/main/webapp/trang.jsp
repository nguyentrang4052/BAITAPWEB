<%@page import="vn.iostar.services.impl.CategoryServiceimpl"%>
<%@page import="vn.iostar.services.ICategoryService"%>
<%@page import="vn.iostar.models.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%
ICategoryService service = new CategoryServiceimpl();
List<CategoryModel> list = service.findAll();
request.setAttribute("listcate", list);
%>
<jsp:forward page="/views/topbar.jsp" />
<!--<c:redirect url="/views/topbar.jsp"/>-->