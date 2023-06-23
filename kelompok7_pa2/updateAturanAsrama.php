<?php
require("connectioncrudasrama.php");

$response = array();

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $id = $_POST["id_aturan"];
    $judul = $_POST["judul"];
    $deskripsi = $_POST["deskripsi"];
    $poin = $_POST["poin"];
   

    $perintah = "UPDATE tambah_aturan_asrama SET judul = '$judul',deskripsi = '$deskripsi',poin = '$poin' WHERE id_aturan = '$id'";
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