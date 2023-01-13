


function closeTost1(){
	toast1.style="display:none;"
}
function closeTost2(){
	toast2.style="display:none;"
}
function closeTost3(){
	toast3.style="display:none;"
}


	var status=document.getElementById("status").value;

if(status=="success"){

		toast1.style="display:grid;"

}
if(status=="failedBOFExisitingUser"){

		toast2.style="display:grid;"

}
if(status=="failedBOFpassNOmatched"){

		toast3.style="display:grid;"

}