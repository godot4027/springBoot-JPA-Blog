let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{
			this.save();

		});
	},

	save: function(){
		// alert("user의 save함수 호출됨");
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}

		// console.log(data);
		// ajax호출시 default가 비동기 호출
		$.ajax({
			// 회원가입 수행 요청
			type: "POST",
			url: "/blog/api/user",
			data : JSON.stringify(data), // http body데이터
			contentType : "application/json; charset=utf-8", // body data가 어떤 타입인지
			dataType : "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면) => javascript 오브젝트로 변경
			
		}).done(function(resp){
			// 응답의 결과 정상
			alert("회원가입이 완료되었습니다.");
			console.log(resp);

			// location.href = "/blog";
		}).fail(function(error){
			// 응답의 결과 실패
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
	}
}

index.init();