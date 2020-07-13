$(document).ready(function(){
    $("#confirm").click(function(){
        let manufacturing = $("#manufacturing option:selected").text().split(" - ");
        console.log(manufacturing);
        console.log($("#share-point option:selected").text());
        console.log($("availability option:selected").text());
        let data = {};
        data = {"manufacturer":manufacturing[0], "model":manufacturing[1], "sharePoint":$("#share-point option:selected").text(), "availability":$("#availability").val()};
        console.log(data);
        $.ajax
        ({
            type: "POST",
            data: data,
            url: 'http://localhost:8080/AddUmbrella',
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
});
