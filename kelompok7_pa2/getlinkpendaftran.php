<?php
require("connectioncrudasrama.php");

$response = array();

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $id_link = $_POST["id_link"];
   

    $perintah = "SELECT * FROM link_pendaftaran WHERE id_link = '$id_DOlahraga'";
    $eksekusi = mysqli_query($konek,$perintah);
    $cek      = mysqli_affected_rows($konek);
    
    if($cek > 0 ){
        $response["kode"] = 1;
        $response["pesan"] = "Data Berhasil Dihapus";
        $response["data"] = array();

        while($ambil = mysqli_fetch_object($eksekusi)){
            $F["id_link"] = $ambil->id_link;
            $F["link_pendaftran"] = $ambil->link_pendaftaran;
    
            array_push($response["data"], $F);
        }
    }
    else{
        $response["kode"] = 0;
        $response["pesan"] = "Data Tidak Tersedia";
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Tidak ada post data";
}

echo json_encode($response);
mysqli_close($konek);