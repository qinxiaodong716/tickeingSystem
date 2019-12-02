$(function () {
    $.ajax({
        url:"findAllAirplane",
        dataType:'json',
        success:function (e) {
            var cneirong = '<select name="airplane"><option>请选择机型</option>'
            for(var k=0;k<e.length;k++){
                cneirong+='<option value='+e[k].model+'>'+e[k].model+'</option>'
            }
            cneirong+='</select>'
            $(".airplane").html(cneirong)
        }
    })
    $.ajax({
        url:"findAllAirport",
        dataType:'json',
        success:function (e) {
            var cneirong = '<select name="fromCity"><option>请选择出发地机场</option>'
            for(var k=0;k<e.length;k++){
                cneirong+='<option value='+e[k].airportCode+'>'+e[k].airportName+'</option>'
            }
            cneirong+='</select>'
            $(".formcity").html(cneirong)
        }
    })
    $.ajax({
        url:"findAllAirport",
        dataType:'json',
        success:function (e) {
            var cneirong = '<select name="toCity"><option>请选择目的地机场</option>'
            for(var k=0;k<e.length;k++){
                cneirong+='<option value='+e[k].airportCode+'>'+e[k].airportName+'</option>'
            }
            cneirong+='</select>'
            $(".tocity").html(cneirong)
        }
    })

    if($(".findflightNumber").html()==''){
        $(".find").css({"display":"none"})
    }
})