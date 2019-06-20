<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<script type="text/javascript">
$(function() {
	
	/* 엔터쳤을때도 이벤트 넣어주기(버튼과 같은 이벤트 발생 - trigger) */
	$("#doro").keyup(function(e) {
		var doro = $("#doro").val;
		if (e.keyCode == 13 && doro.length > 0) {
			$("#searchBtn").trigger("click");
		}
	});
	
	$("#searchBtn").click(function(){
		$.ajax({
			type: "GET",
			url: "${root}/user/zipsearch.kitri",
			dataType: "json",
			data: {"doro" : $("#doro").val()}, /* 넘어오는 파라미터의 이름하고 컨트롤러 변수 이름하고 같으면 설정필요x  */
			success: function(data){
				var list = data.ziplist; /* json의 배열을 받아옴 */
				var len = list.length;	
				var view = "";
				for (var i = 0; i < len; i++) {
					var address = list[i].sido + " " + list[i].gugun + " " + list[i].upmyon + " " + list[i].doro + " " + list[i].buildingNumber + " " + list[i].sigugunBuildingName;
					view += '<tr>\n';
					view += '	<td>' + list[i].zipcode + '</td>\n';
					view += '	<td align="left">';
					view += '<a href="javascript:selectZip(\'' + list[i].zipcode + '\', \'' + address + '\');">';
					view += address;
					view += '</a>';
					view += '	</td>\n';
					view += '</tr>\n';
				}
				$("#zip_codeList").empty().append(view);
			}
		});
	});
});

function selectZip(z, a){

	$("#zipcode").val(z);
	$("#address").val(a);
	
	$("#zipModal").modal("hide");
	$("#doro").val('');
	$("#zip_codeList").empty();
}



</script>

<div id="zipModal" class="modal fade" role="dialog">
	<h5 class="modal-title" id="myModalLabel">우편번호검색</h5>
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>    
            <div class="modal-body text-center">
            
            		<div align="center">
            			<label>도로명 주소검색</label>
            		</div>
					<div class="input-group" align="left">
						<input type="text" class="form-control" id="doro" name="doro" placeholder="검색 할 도로명 입력(예: 구로디지털로, 여수울로)">
						<span class="input-group-btn">
						<input type="button" class="btn btn-warning" value="검색" id="searchBtn">
						</span>
					</div>
              
                <div style="width:100%; height:200px; overflow:auto">
                	<table class = "table text-center">
                		<thead>
                		<tr>
                			<th style="width:150px;">우편번호</th>
                			<th style="width:600px;">주소</th>
                		</tr>
                		</thead>
                		<tbody id="zip_codeList"></tbody>
                	</table>
                </div>
            </div>
        </div>
    </div>
</div>



