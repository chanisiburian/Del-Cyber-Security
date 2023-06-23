<?php
require('connectioncrudasrama.php');
$perintah = "SELECT * FROM link_pendaftaran";
$eksekusi = mysqli_query($konek,$perintah);
$cek = mysqli_affected_rows($konek);

if($cek > 0){
    $response["kode"] = 1;
    $response["pesan"] = "Data Tersedia"; 
    $response["data"] = array();

    while($ambil = mysqli_fetch_object($eksekusi)){
        $F["id_DOlahraga"] = $ambil->id_DOlahraga;
        $F["link_pendaftran"] = $ambil->link_pendaftaran;
  

        array_push($response["data"], $F);
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Data tidak Tersedia";
}


echo json_encode($response);
mysqli_close($konek);
