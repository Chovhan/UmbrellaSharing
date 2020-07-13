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
    <title>Change umbrella place</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../css/delete_umbrella_settings_page.css">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
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
            <div class="left-bar__buttons left-bar__buttons-add_umbrella"><a id="#addbtn"></a></div>
            <div class="left-bar__buttons left-bar__buttons-delete_umbrella"><a id="#deletebtn"></a></div>
        </div>
    </div>
    <div class="body__information">
        <table border="1" cellspacing="0" color="dimgrey">
            <tr>
                <td>Umbrella sequence number</td>
                <td>Umbrella availability</td>
                <td>Share point sequence number</td>
                <td>Share point availability</td>
                <td>County</td>
                <td>City</td>
                <td>Street</td>
                <td>House number</td>
                <td>Confirm</td>
            </tr>
            <c:forEach var="umbrella" items="${umbrellaInfo}">
                <tr>
                    <td>${umbrella.sequenceNumber}</td>
                    <td>${umbrella.availability}</td>
                    <td>${umbrella.sharePointSequenceNumber}</td>
                    <td>${umbrella.sharePointAvailability}</td>
                    <td>${umbrella.country}</td>
                    <td>${umbrella.city}</td>
                    <td>${umbrella.street}</td>
                    <td>${umbrella.houseNumber}</td>
                    <td><a class="confirm" id="confirm${umbrella.sequenceNumber}"></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
<script type="text/javascript" src="../js/DeleteUmbrella.js"></script>
<script type="text/javascript" src="../js/GoToPageUmbrella.js"></script>
</html>