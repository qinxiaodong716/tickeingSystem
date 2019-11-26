function nameinquire(){
    var name = $(".peoplename").val();
    $.ajax({
        url:"inquirename",
        data:{"name":name},
        success:function (data) {
            alert(data)
        }
    })
}
function phoneinquire(){
    var phone = $(".peoplephone").val();
    $.ajax({
        url:"inquirephone",
        data:{"phone":phone},
        success:function (data) {
            alert(data)
        }
    })
}
$(function(){
    $.ajax({
        url:"uname",
        success:function(data){
            $(".username").html(data);
        }
    })
})
layui.use('element', function(){
    var element = layui.element;
})
function outlogin(){
    var isDelete = confirm("您确定要退出吗？");
    if(isDelete){
        window.location.href="/hangkong/index";
    }
}