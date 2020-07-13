<%--
  Created by IntelliJ IDEA.
  User: Dmytro Chovgan
  Date: 07-May-20
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <button type="button" id="#GoBtn">Go</button>
    <p id="Pid">hellooooooo</p>

</body>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        console.log("hello");
    });
    let button = document.getElementById("#GoBtn");
    button.addEventListener("click", function() {
        window.location.href = "http://localhost:8080/Information"
    });

</script>
</html>
