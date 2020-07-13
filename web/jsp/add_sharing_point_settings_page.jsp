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
    <title>Share point settings</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/add_share_point_settings_page.css">
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
            <div class="left-bar__buttons left-bar__buttons-add_sharing_point"><a id="#addpointbtn"></a></div>
            <div class="left-bar__buttons left-bar__buttons-delete_sharing_point"><a id="#deletepointbtn"></a></div>
            <div class="left-bar__buttons left-bar__buttons-close_sharing_point"><a id="#changepointbtn"></a></div>
        </div>
    </div>
    <div class="body__information">
        <form class="add-sharing-point">

            <div class="add country">
                <label for="countyInput">Country</label>
                <input name="countryInput" id="countyInput" type="text" required>
            </div>

            <div class="add city">
                <label for="cityInput">City</label>
                <input name="cityInput" id="cityInput" type="text" required>
            </div>

            <div class="add street">
                <label for="streetInput">Street</label>
                <input name="streetInput" id="streetInput" type="text" required>
            </div>

            <div class="add house-number">
                <label for="houseInput">House number</label>
                <input name="houseInput" id="houseInput" type="number" required>
            </div>

            <div class="add availability">
                <label for="availability">Availability</label>
                <select id="availability" name="availability">
                    <option>Yes</option>
                    <option>No</option>
                </select>
            </div>

            <div class="add confirm">
                <input type="button" value="Add" id="confirm">
            </div>
        </form>
    </div>
</div>

</body>
<script type="text/javascript" src="../js/GoToPageSharePoint.js"></script>
<script type="text/javascript" src="../js/AddSharePoint.js"></script>

</html>
