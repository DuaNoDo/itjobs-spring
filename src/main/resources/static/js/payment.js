function maxLengthCheck(object){
   if (object.value.length > object.maxLength){
    object.value = object.value.slice(0, object.maxLength);
   }   
}

function check(form){
	if(form.card_com.value=="100"){
		  alert("카드사를 선택하세요.");
		  return false;
	}
	if(form.cardnum1.value<1000){
		  alert("카드 번호를 확인하세요.");
		  form.cardnum1.focus();
		  return false;
	}
	if(form.cardnum2.value<1000){
		  alert("카드 번호를 확인하세요.");
		  form.cardnum1.focus();
		  return false;
	}
	if(form.cardnum3.value<1000){
		  alert("카드 번호를 확인하세요.");
		  form.cardnum1.focus();
		  return false;
	}
	if(form.cardnum4.value<1000){
		  alert("카드 번호를 확인하세요.");
		  form.cardnum1.focus();
		  return false;
	}
	if(form.cardyear.value<2018){
		  alert("카드 유효기간을 확인하세요.");
		  form.cardyear.focus();
		  return false;
	}
	if(form.cardmonth.value<1 || form.cardmonth.value>12){
		  alert("카드 유효기간을 확인하세요.");
		  form.cardmonth.focus();
		  return false;
	}
	if(!form.cardpass.value || form.cardpass.value<10){
		  alert("카드 비밀번호를 확인하세요.");
		  form.cardmonth.focus();
		  return false;
	}
	setTimeout(function(){
		alert("결제에 성공했습니다.");
		form.action = "CPPE_mypage_cart_buyProc.jsp";
		form.submit();
	    window.close();
	}, 3000);
	
}