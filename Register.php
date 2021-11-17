<?php 
    $con = mysqli_connect("localhost", "s00", "password", "s00");
    mysqli_query($con,'SET NAMES utf8');

    $userID = $_POST["user_id"];
    $userPassword = $_POST["prv_password"];
    $userAge = $_POST["prv_phonenumber"];

    $statement = mysqli_prepare($con, "INSERT INTO USER VALUES (?,?,?,?)");
    mysqli_stmt_bind_param($statement, "sssi", $user_id, $prv_password, $prv_phonenumber);
    mysqli_stmt_execute($statement);


    $response = array();
    $response["success"] = true;
 
   
    echo json_encode($response);



?>