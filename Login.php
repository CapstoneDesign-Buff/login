<?php
    $con = mysqli_connect("localhost", "s00", "password", "s00");
    mysqli_query($con,'SET NAMES utf8');

    $userID = $_POST["user_id"];
    $userPassword = $_POST["prv_password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM USER WHERE user_id = ? AND prv_password = ?");
    mysqli_stmt_bind_param($statement, "ss", $user_id, $prv_password);
    mysqli_stmt_execute($statement);


    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $user_id, $prv_password, $prv_phonenumber);

    $response = array();
    $response["success"] = false;
 
    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
        $response["user_id"] = $user_id;
        $response["prv_password"] = $prv_password;
        $response["prv_phonenumber"] = $prv_phonenumber;       
    }

    echo json_encode($response);



?>