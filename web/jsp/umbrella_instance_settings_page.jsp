<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<%--<fmt:setLocale value="${param.lang}" />--%>
<%--<fmt:setBundle basename="admin" />--%>

<% if(request.getCharacterEncoding() == null) {
    request.setCharacterEncoding("UTF-8");
} %>

<html>
<head>
    <title>Umbrella settings</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/umbrella_instance_settings_page.css">
</head>
<body>
    <div class="title-selection">
        <div class="title-selection__header">
            <div class="title-selection__header-content_logo"></div>
            <div class="title-selection__header-content_text">Umbrella sharing</div>
        </div>
        <div class="title-selection__bar">
            <div class="title-selection__bar-services">
                <div class="bar_buttons bar_buttons__information"><a id="#infobtn">Information</a></div>
                <div class="bar_buttons bar_buttons__sharing_point-control"><a id="#sharingbtn">Sharing point settings</a></div>
                <div class="bar_buttons bar_buttons__umbrella_instance-control"><a id="#umbrellabtn">Umbrella instance settings</a></div>
            </div>
        </div>
    </div>


    <div class="body">
        <div class="left-selection__bar">
            <div class="left-selection__bar-services">
                <div class="left-bar__buttons left-bar__buttons-add_umbrella"><a href="#"></a></div>
                <div class="left-bar__buttons left-bar__buttons-delete_umbrella"><a href="#"></a></div>
                <div class="left-bar__buttons left-bar__buttons-change_umbrella_sharing_point"><a href="#"></a></div>
            </div>
        </div>
        <div class="body__information"></div>
    </div>
</body>
<script type="text/javascript" src="../js/GoToPage.js"></script>

</html>
