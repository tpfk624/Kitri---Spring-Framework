<%@page import="com.kitri.util.MoveUrl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp" %> 
<c:if test="${userInfo != null}">
<script type ="text/javascript">
function deleteMember(){
	if(confirm("정말로 탈퇴???")){
		document.location.href = "${root}/user?act=deletemember";	
	}
}

</script>
<strong>${userInfo.name}(${userInfo.id})</strong>님 안녕하세요.<br>
<a href="${root}/user?act=logout">로그아웃</a>
<a href="${root}/user?act=mvmodify">정보수정</a>
<a href="#" onclick="javascript:deleteMember();">회원탈퇴</a>
	<c:if test="${'java2' == userInfo.id }">
<a href="${root}/admin?act=memberlist">관리자</a>
	</c:if>
</c:if>
<c:if test="${userInfo == null}">
	<c:redirect url="/user?act=mvlogin"/>
</c:if>
<%@ include file="/template/footer.jsp" %> 





















<!-- 
회원탈퇴
t{
	conn = ...;
	conn.setAC(false);
	
	d
	pstmt.exc...();
	pstmt.close...();
	
	
	
	d
	pstmt.conn.pr...
	pstmt.e..
	conn.commit();
}c {
	conn.rollback();

}

 -->