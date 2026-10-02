package com.example.keychainapp.ui.theme

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.keychainapp.R

class MediaFragment : Fragment(R.layout.fragment_media) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnTambahFoto = view.findViewById<ImageButton>(R.id.btnTambahFoto)
        val btnTambahVideoGif = view.findViewById<ImageButton>(R.id.btnTambahVideoGif)

        // Logika pas tombol [+] kategori Foto dipencet
        btnTambahFoto.setOnClickListener {
            Toast.makeText(requireContext(), "Buka Galeri Foto...", Toast.LENGTH_SHORT).show()
            // Kodingan buka galeri foto masuk sini nanti
        }

        // Logika pas tombol [+] kategori Video/GIF dipencet
        btnTambahVideoGif.setOnClickListener {
            Toast.makeText(requireContext(), "Buka Galeri Video/GIF...", Toast.LENGTH_SHORT).show()
            // Kodingan buka galeri video masuk sini nanti
        }
    }
}