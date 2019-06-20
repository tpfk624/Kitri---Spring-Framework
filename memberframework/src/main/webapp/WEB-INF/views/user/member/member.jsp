<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/template/header.jsp"%>
<!-- include는 자기 프로젝트내에서만 파일을 가져올 수 있어서 파일경로는 안써준다 -->

<script type="text/javascript">
var cnt = 1;
$(document).ready(function() {
	
	$("#id").keyup(function() {
		var id = $("#id").val();
		if (id.length < 5 || id.length > 16) {
			cnt = 1;
			$("#idresult").css("color", "gray");
			$("#idresult").text("아이디는 5자이상 16자 이하입니다.");
		}else{
			$.ajax({
				type: "GET",
				url: "${root}/user/idcheck.kitri",
				dataType: "json",
				data: {"checkid" : id}, /* 넘어오는 파라미터의 이름하고 컨트롤러 변수 이름하고 같으면 설정필요x  */
				success: function(data){
					cnt = parseInt(data.idcount);
					if(cnt == 0){
						$("#idresult").css("color", "steelblue");
						$("#idresult").html("<strong>" + id + "</strong>는 사용가능합니다.");
					}else{
						$("#idresult").css("color", "magenta");
						$("#idresult").html("<strong>" + id + "</strong>는 사용중입니다.");
					}
				}
				
			});
		}
	});
	 
	$('#zipcode').focusin(function() {
		$('#zipModal').modal();
	});
	
	$("#registerBtn").click(function() {
		if($("#id").val().trim().length == 0) {
			alert("아이디 입력!!!!");
			return;
		} else if($("#name").val().trim().length == 0) {
			alert("이름 입력!!!!");
			return;
		} else if($("#pass").val().trim().length == 0) {
			alert("비밀번호 입력!!!!");
			return;
		} else if($("#pass").val() != $("#passcheck").val()) {
			alert("비밀번호 확인!!!!");
			return;
		} else if(cnt != 0) {
			alert("아이디 중복 확인!!!!");
			return;
		} else {
			$("#memberform").attr("action", "${root}/user/register.kitri").submit();
		}
	});

});

</script>
<body>

	<div class="container" align="center">
		<div class="col-lg-6" align="center">
			<h2>회원가입</h2>
			<form id="memberform" method="post" action="">
				<input type="hidden" name="act" value="register">
				<div class="form-group" align="left">
					<label for="name">이름</label> <input type="text"
						class="form-control" id="name" name="name" placeholder="이름입력">
				</div>
				<div class="form-group" align="left">
					<label for="">아이디</label> <input type="text" class="form-control"
						id="id" name="id" placeholder="4자이상 16자 이하">
					<div id="idresult"></div>
				</div>
				<div class="form-group" align="left">
					<label for="">비밀번호</label> <input type="password"
						class="form-control" id="pass" name="pass" placeholder="">
				</div>
				<div class="form-group" align="left">
					<label for="">비밀번호재입력</label> <input type="password"
						class="form-control" id="passcheck" name="passcheck"
						placeholder="">
				</div>
				<div class="form-group" align="left">
					<label for="email">이메일</label><br>
					<div id="email" class="custom-control-inline">
						<input type="text" class="form-control" id="emailid"
							name="emailid" placeholder="" size="25"> @ <select
							class="form-control" id="emaildomain" name="emaildomain">
							<option value="naver.com">naver.com</option>
							<option value="google.com">google.com</option>
							<option value="daum.net">daum.net</option>
							<option value="nate.com">nate.com</option>
							<option value="hanmail.net">hanmail.net</option>
						</select>
					</div>
				</div>
				<div class="form-group" align="left">
					<label for="tel">전화번호</label>
					<div id="tel" class="custom-control-inline">
						<select class="form-control" id="tel1" name="tel1">
							<option value="010">010</option>
							<option value="02">02</option>
							<option value="031">031</option>
							<option value="032">032</option>
							<option value="041">041</option>
							<option value="051">051</option>
							<option value="061">061</option>
						</select> _ <input type="text" class="form-control" id="tel2" name="tel2"
							placeholder="1234"> _ <input type="text"
							class="form-control" id="tel3" name="tel3" placeholder="5678">
					</div>
				</div>
				<div class="form-group" align="left">
					<label for="">주소</label><br>
					<div id="addressdiv" class="custom-control-inline">
						<input type="text" class="form-control" id="zipcode"
							name="zipcode" placeholder="우편번호" size="7" maxlength="5"
							readonly="readonly">
						<!--<button type="button" class="btn btn-primary" onclick="javascript:">우편번호</button>-->
					</div>
					<input type="text" class="form-control" id="address" name="address"
						placeholder="" readonly="readonly"> <input type="text"
						class="form-control" id="address_detail" name="addressDetail"
						placeholder="">
				</div>
				<div class="form-group" align="center">
					<button type="button" class="btn btn-primary" id="registerBtn"
						onclick="javascript:register();">회원가입</button>
					<button type="reset" class="btn btn-warning">초기화</button>
				</div>
			</form>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/user/member/zipsearch.jsp"%>

	<%@ include file="/WEB-INF/views/template/footer.jsp"%>