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
    <title>Information</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/information_page.css">
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
            <div class="left-bar__buttons left-bar__buttons-user_information"><a id="#userbtn"></a></div>
            <div class="left-bar__buttons left-bar__buttons-sharing-point_information"><a id="#pointbtn"></a></div>
        </div>
    </div>
    <div class="body__information">
        <table border="1" cellspacing="0">
            <tr>
                <td>First name</td>
                <td>Last name</td>
                <td>Birth date</td>
                <td>Email</td>
                <td>Phone number</td>
                <td>Umbrella id</td>
                <td>Umbrella number</td>
                <td>Share point number</td>
                <td>Country</td>
                <td>City</td>
                <td>Street</td>
                <td>House number</td>
            </tr>
            <c:forEach var="userInfo" items="${userInformationList}">
                <tr>
                    <td>${userInfo.firstName}</td>
                    <td>${userInfo.lastName}</td>
                    <td>${userInfo.userBirthDate}</td>
                    <td>${userInfo.userEmail}</td>
                    <td>${userInfo.userPhoneNumber}</td>
                    <td>${userInfo.takeUmbrellaId}</td>
                    <td>${userInfo.umbrellaSequenceNumber}</td>
                    <td>${userInfo.sharePointSequenceNumber}</td>
                    <td>${userInfo.country}</td>
                    <td>${userInfo.city}</td>
                    <td>${userInfo.street}</td>
                    <td>${userInfo.houseNumber}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

<script type="text/javascript" src="../js/GoToPageInformation.js"></script>

</html>
