<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/template/top.jsp" %>
<style>

.menulist{
	width: 200px;
}

.category{
	padding: 5px 10px;
	cursor: pointer;
	position: relative;
	font-weight: bold;
	text-align: left;
	background-color: #cc99ff;
}

.menu{
	display: none;
	text-align: left;
}

.menu a{
	display: block;
	color: #000000;
	background-color: #ffffcc;
	padding: 10px;
	text-decoration: none;
}

.menu a:hover{
	color: #0000ff;
	text-decoration: underline;
}


</style>
<script>
$(document).ready(function() {
	$("#boardmenu p.category").click(function () {
		$(this).next("div.menu").slideDown(500).siblings("div.menu").slideUp("slow");
	});
});
</script>

<!-- 카테고리가 바뀌는 한번만 찍히게 만들기 -->
<div class="menulist" id="boardmenu">
	<c:set var="idx" value="0"/>
	<c:forEach varStatus="i" var="board" items="${boardmenu}">
		<c:if test="${idx != board.ccode}">
		<p class="category">${board.cname}</p>
		<c:set var="idx" value="${board.ccode}"/>
		<div class="menu">
		</c:if>
		<a href="${root}/${board.control}/write?bcode=${board.bcode}&pg=1&key=&word=">
		${board.bname}
		</a>
		<c:if test="${i.index < boardmenu.size() - 1}">
			<c:if test="${idx != boardmenu.get(i.index+1).ccode}"> <!-- 현재랑 다음이랑 다를때 닫아라?  -->
			</div>
			</c:if>
		</c:if>
	</c:forEach>
	</div>
</div>
<%@ include file="/WEB-INF/views/commons/template/bottom.jsp" %>


