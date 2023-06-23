<?php
$connection = null;

try{
    //Config
    $host = "localhost";
    $username = "root";
    $password = "";
    $dbname = "kelompok7_pa2";

    //connect
    $database = "mysql:dbname=$dbname;host=$host";
    $connection = new PDO($database, $username, $password);
    $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // if($connection){
    //     echo "Koneksi berhasil";
    // }
    // else{
    //     echo "gagal";
    // }

} catch (PDOexeption $e){
    echo "Error ! " . $e->getMessage();
    die;
}

?>