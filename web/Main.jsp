<%-- 
    Document   : Main
    Created on : 10-10-2015, 19:52:50
    Author     : X
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>   
    </head>
    
        <body>
        
        <script>


            $(document).ready(function () {

                $("#showButton").click(function () {

                    $.ajax({
                        url: "http://localhost:8080/CA2NewVersion/api/rest",
                        type: "GET",
                        dataType: "json"

                    }).done(function (dateFromServer) {

                        $("#myPersonList").empty();
                        for (var i = 0; i < dateFromServer.length; i++) {

                            $("#myPersonList").append("<li>" + "Person id: " + dateFromServer[i].id + " Person name: " + dateFromServer[i].firstName + "</li>");
                        }


                    }).fail(function () {
                        alert("Fejl");
                    });
                });

                $("#deletePersonButton").click(function () {

                    $.ajax({
                        url: "http://localhost:8080/CA2NewVersion/api/rest/delete" + $("#inputDeleteId").val(),
                        type: "DELETE",
                        dataType: "json"

                    }).done(function (dateFromServer) {

                        $("#showButton").click();
                    }).fail(function () {
                        alert("An Error has accured, u cannot delete that person, with the given Id!");
                    });
                });

                $("#createPersonButton").click(function () {

                    var firstNames = $("#firstNameInput").val();
                    var lastNames = $("#lastNameInput").val();
                    var emails = $("#emailNameInput").val();
                    var streets = $("#streetNameInput").val();
                    var zipCodes = $("#zipCodeNameInput").val();
                    var citys = $("#cityInput").val();

                    var person = {"firstName": firstNames, "lastName": lastNames, "email": emails, "street": streets, "zipCode": zipCodes, "city": citys};

                    $.ajax({
                        type: "POST",
                        contentType: "application/json",
                        data: JSON.stringify(person),
                        url: "http://localhost:8080/CA2NewVersion/api/rest/add"
                    });
                });
                
                $("#editPersonButton").click(function () {

                    var firstNames = $("#firstNameInput").val();
                    var lastNames = $("#lastNameInput").val();
                    var emails = $("#emailNameInput").val();
                    var streets = $("#streetNameInput").val();
                    var zipCodes = $("#zipCodeNameInput").val();
                    var citys = $("#cityInput").val();

                    var person = {"firstName": firstNames, "lastName": lastNames, "email": emails, "street": streets, "zipCode": zipCodes, "city": citys};

                    $.ajax({
                        type: "PUT",
                        contentType: "application/json",
                        data: JSON.stringify(person),
                        url: "http://localhost:8080/CA2NewVersion/api/rest/edit/" + $("#id").val()
                    });
                });

                $("#getByIdButton").click(function () {

                    $.ajax({
                        url: "http://localhost:8080/CA2NewVersion/api/rest/" + $("#getByid").val(),
                        type: "GET",
                        dataType: "json"
                    }).done(function (dateFromServer) {
                        $("#id").val(dateFromServer.id);
                        $("#firstNameInput").val(dateFromServer.firstName);
                        $("#lastNameInput").val(dateFromServer.lastName);
                        $("#emailNameInput").val(dateFromServer.email);
                        $("#streetNameInput").val(dateFromServer.street);
                        $("#zipCodeNameInput").val(dateFromServer.zipCode);
                        $("#cityInput").val(dateFromServer.city);


                    }).fail(function () {
                        alert("An Error has accured, No person with that ID!");
                    });

                });


            });



        </script>
        
        <div class="container">
            
            <div class="jumbotron">
                <h1>CA2</h1>
                <div id="author"> Iman Husseini</div>
                
            </div>
        
            <div class="row">
                
                <div class="col-sm-10">
                    
                    <ul id="myPersonList" >
                    </ul> <br/>
                    <button id="showButton">Show all persons</button> <br/>
                    
                </div>
                
                </div>
        
            <hr>
            
            <div class="row">
                <div class="col-sm-10">
                    <input id ="inputDeleteId" type="text" placeholder="Input person id to delete">
                    <button id="deletePersonButton">Delete person by id</button> <br/>
                    <br>
                </div>
            </div>
            
            
            <div class="row">
                <div class="col-sm-10">
                    <br/>
                    <input id ="getByid" type="text" placeholder="Input Id to edit ">
                    <button id="getByIdButton">Get Person By Id</button> <br/>

                </div>
            </div>
        
        
        
        
        
        <br/>

        <hr>
        <form method="POST">
            <input id ="id" type="text" placeholder="ID " size="10">

            <input id ="firstNameInput" type="text" placeholder="FirstName ">

            <input id ="lastNameInput" type="text" placeholder="LastName ">

            <input id ="emailNameInput" type="text" placeholder="Email ">

            <input id ="streetNameInput" type="text" placeholder="Street ">

            <input id ="zipCodeNameInput" type="text" placeholder="ZipCode" size="15">

            <input id ="cityInput" type="text" placeholder="City">

            <button id="createPersonButton">Create Person</button> <br/><br>

            <button id="editPersonButton">Edit Person</button> <br/>
        </form>

        <br><br>
        
        <h3>DOCUMENTATION BELOW</h3>
        <a href="DocumentationPage.html">Documentation</a>
        
        
            
        </div>
        
    </body>
    
</html>
