package com.fikri.footballapp.model;

import com.fikri.footballapp.R;

import java.util.ArrayList;

public class FootballData {
    private static String[] footballNames ={
            "Persib Bandung",
            "Persija Jakarta",
            "Persebaya Surabaya",
            "Arema Malang",
            "Madura United",
            "Sriwijaya FC",
            "Persipura FC",
            "Persela Lamongan",
            "PSM Makassar",
            "Mitra Kukar FC"
    };

    private static String[] footballDetails = {
            "Persib Bandung (Persatuan Sepak Bola Indonesia Bandung) adalah klub sepak bola Indonesia yang berdiri pada 14 Maret 1933, berbasis di Bandung, Jawa Barat. Persib saat ini bermain di Liga 1 Indonesia. Julukan mereka adalah Maung Bandung dan Pangeran Biru",
            "Persija (singkatan dari Persatuan Sepak Bola Indonesia Jakarta) adalah klub sepak bola Indonesia yang berbasis di Jakarta. Persija didirikan pada 28 November 1928, tepat sebulan setelah Sumpah Pemuda. Persija saat ini berlaga di Liga 1. Persija merupakan salah satu klub sepakbola paling sukses di sejarah sepakbola Indonesia dengan torehan 2 kali juara liga domestik dan 9 kali juara turnamen perserikatan hingga sejauh ini.",
            "Persebaya Surabaya yang sempat mengubah namanya menjadi Persebaya 1927,[3] adalah sebuah klub Sepak bola profesional di Indonesia yang berbasis di Surabaya yang berdiri pada 18 Juni 1927 dengan nama asalnya adalah Soerabajasche Indische Voetbal Bond (SIVB) dan sudah malang melintang dikancah sepak bola Indonesia. Sempat di bekukan oleh PSSI dan disahkan kembali oleh PSSI sebagai anggota di Kongres Tahunan PSSI Bandung pada tanggal 8 Januari 2017.",
            "Arema FC (dahulu bernama Arema Cronus) , atau biasa disebut dan dikenal sebagai Arema Malang, adalah sebuah klub sepak bola profesional yang berasal dari Malang, Jawa Timur, Indonesia. Arema didirikan pada tanggal 11 Agustus 1987, Arema mempunyai julukan \"Singo Edan\". Dalam Liga 1, Arema bermarkas di Stadion Kanjuruhan, Kabupaten Malang dan Stadion Gajayana, Kota Malang. Arema adalah tim sekota dari Persema Malang, Persekam Metro, dan Malang United.",
            "Madura United FC merupakan klub sepak bola asal Indonesia yang berbasis di Pamekasan, Madura. Klub ini sebelumnya bernama Pelita Bandung Raya yang pada waktu itu berlaga di Liga Super Indonesia. Pemilik Pelita Bandung Raya, Ari D. Sutedi akhirnya menjual klubnya ke Achsanul Qosasi, dan kemudian bertransformasi menjadi Madura United FC. Kini, Madura United menjelma menjadi salah satu klub terkuat di liga utama Indonesia.",
            "Sriwijaya Football Club (disingkat Sriwijaya FC) adalah sebuah klub sepak bola Indonesia yang bermarkas di Palembang. Tim berjuluk Laskar Wong Kito ini merupakan tim yang dimiliki oleh PT Sriwijaya Optimis Mandiri (PT SOM) setelah terjadi penjualan opsi kepemilikan dari Pemerintah Provinsi Sumatra Selatan",
            "Persatuan Sepak bola Indonesia Jayapura (disingkat Persipura Jayapura) adalah sebuah klub sepak bola Indonesia yang bermarkas di Jayapura, Papua. Prestasi tertingginya hingga kini adalah menjadi empat kali juara Liga Indonesia dari tahun 2005 hingga 2013",
            "Persatuan Sepak Bola Lamongan (biasa disingkat: Persela) dan mempunyai julukan Laskar Joko Tingkir adalah sebuah klub sepak bola Indonesia yang bermarkas di Lamongan, Jawa Timur. Persela dikelola oleh PT. Persela Jaya.",
            "Persatuan Sepak bola Makassar (disingkat PSM Makassar) adalah sebuah tim sepak bola Indonesia yang berbasis di Makassar, Sulawesi Selatan, Indonesia, yang dikenal pasukan Ramang atau Juku Eja. PSM Makassar saat ini bermain di Shopee Liga 1, setelah sebelumnya pernah bermain di Liga Primer Indonesia",
            "Mitra Kutai Kartanegara (disingkat: Mitra Kukar) adalah sebuah klub sepak bola Indonesia yang bermarkas di Kabupaten Kutai Kartanegara, Kalimantan Timur. Klub ini memiliki julukan sebagai Barisan Kuat dan Kekar dan Naga Mekes, sementara kelompok pendukungnya bernama Mitman (Mitra Mania). Seluruh pertandingan kandang Mitra Kukar dimainkan di Stadion Madya Aji Imbut, Tenggarong Seberang"
    };

    private static String[] coachNames = {
            "Robert Rene Alberts",
            "Sergio Farias",
            "Aji Santoso",
            "Mario Gomez",
            "Rahmad Darmawan",
            "Budiardjo Thalib",
            "Jacksen Tiago",
            "Nil Maizar",
            "Bojan Hodak",
            "Jafri Sastra"
    };

    private static int[] footbalImages = {
            R.drawable.persib,
            R.drawable.persija,
            R.drawable.persebaya,
            R.drawable.arema,
            R.drawable.maduraunited,
            R.drawable.sriwijaya,
            R.drawable.persipura,
            R.drawable.persela,
            R.drawable.psm,
            R.drawable.mitrakukar
    };

    public static ArrayList<Football> getListData(){
        ArrayList<Football>list = new ArrayList<>();
        for(int i=0;i < footballNames.length ; i++){
            Football fb = new Football();
            fb.setName(footballNames[i]);
            fb.setAbout(footballDetails[i]);
            fb.setCoach(coachNames[i]);
            fb.setPhoto(footbalImages[i]);
            list.add(fb);
        }
        return list;
    }
}
