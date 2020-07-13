$(document).ready(function () {
    let a = $('td > a');
    for (let i = 0; i < a.length; i++) {
        console.log(a[i]);
        $("#" + (a[i].id).toString()).click(function(){
            console.log("button " + a[i].id + " was pressed");
            let data = {};
            data = {"number":$("."+ a[i].id).html()};
            console.log(data);
            $.ajax
            ({
                type: "POST",
                data: data,
                url: 'http://localhost:8080/DeleteSharingPoint',
                success:function(serverData)
                {
                    console.log("Hurey")

                },
                error: function(e)
                {
                    console.log(e)
                }
            });
        });
    }
});
