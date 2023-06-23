<?php

include 'connection.php';

if($_POST){
    //data
    $username = $_POST['username'] ?? '';
    $password = $_POST['password'] ?? '';
    $nama = $_POST['nama'] ?? '';


    $response = []; //data response


    //cek username
    $userQuery = $connection->prepare("SELECT * FROM admin where username = ?");
    $userQuery->execute(array($username));
    $query = $userQuery->fetch();

    if($userQuery->rowCount() == 0){
        $response['status'] = false;
        $response['message'] = "Username Anda Salah";
    } else {
        //ambil password

        $passwordDB = $query['password'];

        if(strcmp(md5($password),$passwordDB) === 0){
            $response['status'] = true;
            $response['message'] = "Login berhasil";
            $response['data'] = [
                'user_id' => $query['id_adm'],
                'username' => $query['username'],
                'nama' => $query['nama']
 
            ];
            } else{
                $response['status'] = false;
                $response['message'] = "password anda salah";
            }
        }

        //jadikan data jadi json
        $json = json_encode($response, JSON_PRETTY_PRINT);

        echo $json;
}