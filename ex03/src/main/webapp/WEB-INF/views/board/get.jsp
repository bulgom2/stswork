<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
		
			<div class="panel-heading">Board Read Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				
				<div class="form-group">
		          <label>Bno</label> <input class="form-control" name='bno'
		            value='<c:out value="${board.bno }"/>' readonly="readonly">
		        </div>
						
				<div class="form-group">
		          <label>Title</label> <input class="form-control" name='title'
		            value='<c:out value="${board.title }"/>' readonly="readonly">
		        </div>
				
				<div class="form-group">
		          <label>Text area</label>
		          <textarea class="form-control" rows="3" name='content'
		            readonly="readonly"><c:out value="${board.content}" /></textarea>
		        </div>
				
				<div class="form-group">
					<label>Writer</label> <input class="form-control" name='writer'
					  value='<c:out value="${board.writer}"/>' readonly="readonly" >
				</div>
				
				<button data-oper='modify' class="btn btn-default"
					onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">Modify</button>
				<button data-oper='list' class="btn btn-default"
					onclick="location.href='/board/list'">List</button>
					
				<form id='operForm' action="/board/modify" method="get">
					<input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
					<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
  					<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
  					<input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
  					<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>
				</form>
							
			</div>		
			<!--  end panel-body -->
		</div>
		<!--  end panel-body -->
	</div>
	<!--  end panel -->
</div>
<!--  /.row -->


<!-- 
<script type="text/javascript">
	$(document).ready(function() {
		
		console.log(replyService);
	});
	
	console.log("==================");
	console.log("JS TEST");
	
	var bnoValue = '<c:out value="${board.bno}"/>';

	// for replyService add test
	replyService.add(
		{reply:"JS Test", replyer:"tester", bno:bnoValue},
		function(result){
			alert("RESULT: " + result);
		});

	replyService.getList(
		{bno:bnoValue, page:1},
		function(list){
			for (var i=0, len=list.length||0; i<len; i++) {
				console.log(list[i]);
			}
		});
	
	replyService.remove(17, function(count) {
		console.log(count);
		
		if (count === "success") {
			alert("REMOVED");
		}
	}, function(err) {
		alert('ERROR...');
	});

	replyService.update({
		rno : 3,
		bno : bnoValue,
		reply : "Modified Reply...."
	}, function(result) {
		alert("수정 완료...");
	});

	function get(rno, callback, error) {
		
		$.get("/replies/" + rno + ".json", function(result) {
			
			if (callback) {
				callback(reslut);
			}
		}).fail(function(xhr, status, err) {
			if (error) {
				error();
			}
		});
	}

	return {
		add : add,
		getList : getList,
		remove : remove,
		update : update,
		get : get
	};
})();

</script>

 -->

<script type="text/javascript" src="/resources/js/reply.js"></script>

<script>
console.log("==================");
console.log("JS TEST");

var bnoValue = '<c:out value="${board.bno}"/>';

//for replyService add test
replyService.add(
	{reply:"JS Test", replyer:"tester", bno:bnoValue},
	function(result){
		alert("RESULT: " + result);
	}
);

// reply List Test
replyService.getList({bno:bnoValue, page:1}, function(list) {
    for(var i = 0, len = list.length || 0; i < len; i++){
       console.log(list[i]);
    }
 });
 
 // 댓글 삭제 테스트
replyService.remove(2, function(count) {
    console.log(count);
    
    if(count === "success") {
       alert("REMOVED");
    }
 }, function(err) {
    alert('ERROR...');
 });
 
 // 댓글 수정
replyService.update({
	rno : 3,
	bno : bnoValue,
	reply : "modified Reply...."
}, function(result) {
	alert("수정 완료...");
	}
);

 // 댓글 번호 전달
replyService.get(10, function(data){
	console.log(data);
})

</script>

<script type="text/javascript">
$(document).ready(function() {
	var operForm = $("#operForm");
	
	$("button[data-oper='modify']").on("click", function(e){
		operForm.attr("action","/board/modify").submit();
	});
	
	$("button[data-oper='list']").on("click", function(e){
		operForm.find("#bno").remove();
		operForm.attr("action","/board/list")
		operForm.submit();
	});
})
</script>

<%@include file="../includes/footer.jsp" %>