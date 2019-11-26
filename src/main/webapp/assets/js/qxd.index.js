$(function(){
	$.ajax({
		url:"uname",
		success:function(data){
			$(".username").html(data);
		}
	})
})
function outlogin(){
	var isDelete = confirm("您确定要退出吗？");
	if(isDelete){
		window.location.href="/hangkong/outlogin";
	}
}