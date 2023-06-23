<?php

include 'connection.php';

if($_POST){
    //data
    $username = $_POST['username'] ?? '';
    $nim = $_POST['nim'] ?? '';
    $password = $_POST['password'] ?? '';
    $prodi = $_POST['prodi'] ?? '';

    $response = []; //data response


    //cek username
    $userQuery = $connection->prepare("SELECT * FROM mahasiswa where username = ?");
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
                'user_id' => $query['id'],
                'nim' => $query['nim'],
                'username' => $query['username'],
                'prodi' => $query['prodi']
 
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