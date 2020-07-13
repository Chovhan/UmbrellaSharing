    $(document).ready(function(){
        $("#confirm").click(function(){
            var data = {};
            data = {"country":$("#countyInput").val(), "city":$("#cityInput").val(), "street":$("#streetInput").val(), "house":$("#houseInput").val(), "availability": $("#availability").val()};
            console.log(data);
            $.ajax
            ({
                type: "POST",
                data: data,
                url: 'http://localhost:8080/AddSharingPoint',
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
