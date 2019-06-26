<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.cafe.member.model.MemberDto"%>
<%
response.sendRedirect(request.getContextPath() + "/boardadmin/boardmenu");

MemberDto memberDto = new MemberDto();
memberDto.setId("tpfk624");
memberDto.setName("고세라");
memberDto.setEmail("tpfk624@naver.com");

session.setAttribute("userInfo", memberDto);

%>