<?php

include 'connection.php';

if($_POST){

    $nim = filter_input(INPUT_POST,'nim', FILTER_SANITIZE_STRING);
    $username = filter_input(INPUT_POST,'username', FILTER_SANITIZE_STRING);
    $password = filter_input(INPUT_POST,'password', FILTER_SANITIZE_STRING);
    $prody = filter_input(INPUT_POST,'prodi', FILTER_SANITIZE_STRING);
    $angkatan = filter_input(INPUT_POST,'angkatan', FILTER_SANITIZE_STRING);

    $response = [];

    $userQuery = $connection->prepare("SELECT * FROM mahasiswa where username = ?");
    $userQuery->execute(array($username));
    
    //cek username
    if($userQuery->rowCount() != 0){
        $response['status'] = false;
        $response['message'] = "akun sudah digunakan";
    } else{
        $insertAccount ='INSERT INTO mahasiswa (nim,username,password,prodi,angkatan) values (:nim, :username,:password,:prodi,:angkatan)';
        $statement = $connection->prepare($insertAccount);

        try{
            $statement->execute([
                ':nim' => $nim,
                ':username' => $username,
                ':password' => md5($password),
                ':prodi' => $prody,
                'angkatan' => $angkatan
            ]);

            //response
            $response['status'] = true;
            $response['message'] = "akun berhasil terdaftar";
            $response['data'] = [
                'nim' => $nim,
                'username' => $username,
                'password' => $password,
                'prodi' => $prody,
                'angkatan' => $angkatan
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