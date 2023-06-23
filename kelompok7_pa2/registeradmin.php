<?php

include 'connection.php';

if($_POST){

    $username = filter_input(INPUT_POST,'username', FILTER_SANITIZE_STRING);
    $password = filter_input(INPUT_POST,'password', FILTER_SANITIZE_STRING);
    $nama = filter_input(INPUT_POST,'nama', FILTER_SANITIZE_STRING);

    $response = [];

    $userQuery = $connection->prepare("SELECT * FROM admin where username = ?");
    $userQuery->execute(array($username));
    
    //cek username
    if($userQuery->rowCount() != 0){
        $response['status'] = false;
        $response['message'] = "akun sudah digunakan";
    } else{
        $insertAccount ='INSERT INTO admin (username,password,nama) values (:username,:password,:nama)';
        $statement = $connection->prepare($insertAccount);

        try{
            $statement->execute([
   
                ':username' => $username,
                ':password' => md5($password),
                ':nama' => $nama
            ]);

            //response
            $response['status'] = true;
            $response['message'] = "akun berhasil terdaftar";
            $response['data'] = [
                'username' => $username,
                'password' => $password,
                'nama' => $nama
            ];
        } catch(Exception $e)
        {
            die($e->getMessage());
        }
    }
    //json
    $json = json_encode($response, JSON_PRETTY_PRINT);

    echo $json;
}