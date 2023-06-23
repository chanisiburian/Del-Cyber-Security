<?php
require("connectioncrudasrama.php");

$response = array();

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $id = $_POST["id_aturan"];
   

    $perintah = "SELECT * FROM tambah_aturan_asrama WHERE id_aturan = '$id'";
    $eksekusi = mysqli_query($konek,$perintah);
    $cek      = mysqli_affected_rows($konek);
    
    if($cek > 0 ){
        $response["kode"] = 1;
        $response["pesan"] = "Data Berhasil Dihapus";
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
        $response["pesan"] = "Data Tidak Tersedia";
    }
}
else{
    $response["kode"] = 0;
    $response["pesan"] = "Tidak ada post data";
}

echo json_encode($response);
mysqli_close($konek);