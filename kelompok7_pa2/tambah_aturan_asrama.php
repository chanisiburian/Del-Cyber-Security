<?php
require('connectioncrudasrama.php');
$perintah = "SELECT * FROM tambah_aturan_asrama";
$eksekusi = mysqli_query($konek,$perintah);
$cek = mysqli_affected_rows($konek);

if($cek > 0){
    $response["kode"] = 1;
    $response["pesan"] = "Data Tersedia"; 
    $response["data"] = array();

    while($ambil = mysqli_fetch_object($eksekusi)){
        $F["id_aturan"] = $ambil->id_aturan;
        $F["judul"] = $ambil->judul;
        $F["deskripsi"] = $ambil->deskripsi;
        $F["poin"] = $ambil->poin;

        array_push($response["data"], $F);
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Data tidak Tersedia";
}


echo json_encode($response);
mysqli_close($konek);
