<?php
require("connectioncrudasrama.php");

$response = array();

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $link_pendaftaran = $_POST["link_pendaftaran"];
    
    $perintah = "INSERT INTO link_pendaftaran (link_pendaftaran) VALUES ('$link_pendaftaran')";
    $eksekusi = mysqli_query($konek,$perintah);
    $cek      = mysqli_affected_rows($konek);
    
    if($cek > 0 ){
        $response["kode"] = 1;
        $response["pesan"] = "Simpan Data Berhasil";
    }
    else{
        $response["kode"] = 0;
        $response["pesan"] = "Gagal menyimpan data";
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Tidak ada post data";
}

echo json_encode($response);
mysqli_close($konek);