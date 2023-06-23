<?php
require("connectioncrudasrama.php");

$response = array();

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $id = $_POST["id_aturan"];
   

    $perintah = "DELETE FROM tambah_aturan_asrama WHERE id_aturan = '$id'";
    $eksekusi = mysqli_query($konek,$perintah);
    $cek      = mysqli_affected_rows($konek);
    
    if($cek > 0 ){
        $response["kode"] = 1;
        $response["pesan"] = "Data Berhasil Dihapus";
    }
    else{
        $response["kode"] = 0;
        $response["pesan"] = "Gagal Menghapus data";
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Tidak ada post data";
}

echo json_encode($response);
mysqli_close($konek);