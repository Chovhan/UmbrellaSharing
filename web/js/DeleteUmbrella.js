$(document).ready(function () {
    let a = $('td > a');
    for (let i = 0; i < a.length; i++) {
        console.log(a[i]);
        $("#" + (a[i].id).toString()).click(function(){
            console.log("button " + a[i] + " was pressed");
            let num = parseInt(a[i].id.replace(/\D+/g,""));
            console.log(num);
            let data = {};
            data = {"number":num};
            $.ajax
            ({
                type: "POST",
                data: data,
                url: 'http://localhost:8080/DeleteUmbrella',
                success:function(serverData)
                {
                    console.log("Hurey");
                    location.reload()
                },
                error: function(e)
                {
                    console.log(e)
                }
            });
        });
    }
});
