$(function () {
    if($(".salesId").html()==''){
        $(".find").css({"display":"none"})
    }
})
function finAllSales() {
    /*获取所有站点*/
    $.ajax({
        Type:"POST",
        url:"findAllSales",
        dataType:'json',
        success:function (data) {
            var cneirong = '<select name="branchId"><option>请选择站点</option>'
            for(var k=0;k<data.length;k++){
                cneirong+='<option value='+data[k].branchId+'>'+data[k].branchName+'</option>'
                console.log(data[k].branchName);
            }
            cneirong+='</select>'
            $(".branch").html(cneirong)
        }
    })
}
function changesales(e) {
    var phone = e
    $.ajax({
        type:"POST",
        url:"IdfindSales",
        dataType:'json',
        data:{
            "phone":phone
        },
        success:function (data) {
            console.log(data.salesName)
        }
    })
}


