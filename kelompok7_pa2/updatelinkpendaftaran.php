<?php
require("connectioncrudasrama.php");

$response = array();

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $id_link = $_POST["id_link"];
    $link_pendaftaran = $_POST["link_pendaftaran"];
  
   

    $perintah = "UPDATE link_pendaftaran SET link_pendaftaran = '$link_pendaftaran' WHERE id_link = '$id_link'";
    $eksekusi = mysqli_query($konek,$perintah);
    $cek      = mysqli_affected_rows($konek);
    
    if($cek > 0 ){
        $response["kode"] = 1;
        $response["pesan"] = "Data Berhasil Di Update";
    }
    else{
        $response["kode"] = 0;
        $response["pesan"] = "Data Gagal Di Ubah";
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Tidak ada post data";
}

echo json_encode($response);
mysqli_close($konek);