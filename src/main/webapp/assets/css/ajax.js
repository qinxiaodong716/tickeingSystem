function ajax(J){
	
	if(!J.url){
		console.error("url不能为空")
		return;
	}
	
	var url =J.url;
	var newData = "";
	
	if(typeof J.data == "object"){
		
		for(var i in J.data){
			newData += i + "=" + J.data[i] + "&";
		}
	}
	console.log(J.data);
	console.log(newData);
	
	var data = newData.slice(0,-1)
	console.log(data)
	
	var type = J.type || "get";
	var dataType = J.dataType || "text";
	
	var successfn = J.success;
	
	var ajax = new XMLHttpRequest();
	ajax.onreadystatechange = function(){
		
		if(ajax.readyState == 4){
			
			if(ajax.status == 200){
				var data1 = ajax.response;
				successfn(data1);
			}
		}
	}
	ajax.open(type,url+"?"+data);
	ajax.responseType = dataType;
	ajax.setRequestHeader("content-type",  "application/x-www-form-urlencoded");
	ajax.send();
	
}