$(document).ready(function () {
    let a = $('td > a');
    for (let i = 0; i < a.length; i++) {
        console.log(a[i]);
        $("#" + (a[i].id).toString()).click(function(){
            let num = parseInt(a[i].id.replace(/\D+/g,""));
            let data = {};
            data = {"number":$(".openclose"+ num).html(), "id":a[i].id};
            $.ajax
            ({
                type: "POST",
                data: data,
                url: 'http://localhost:8080/ChangeSharingPointAvailability',
                success:function(serverData)
                {
                    console.log("Hurey");
                    location.reload()
                    // $(".openclose"+ num).html(serverData.availability);
                },
                error: function(e)
                {
                    console.log(e)
                }
            });
        });
    }
});
