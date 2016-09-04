package io.github.rohmanhakim.museumapp.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rohmanhakim <rohmanhakim@live.com> on 9/4/16 14:20.
 */
public class Data {
    @SerializedName("museum_id")
    public String museumId;

    @SerializedName("kode_pengelolaan")
    public String kodePengelolaan;

    @SerializedName("nama")
    public String nama;

    @SerializedName("sdm")
    public String sdm;

    @SerializedName("alamat_jalan")
    public String alamatJalan;

    @SerializedName("desa_kelurahan")
    public String desaKelurahan;

    @SerializedName("kecamatan")
    public String kecamatan;

    @SerializedName("kabupaten_kota")
    public String kabupatenKota;

    @SerializedName("propinsi")
    public String propinsi;

    @SerializedName("lintang")
    public String lintang;

    @SerializedName("bujur")
    public String bujur;

    @SerializedName("koleksi")
    public String koleksi;

    @SerializedName("sumber_dana")
    public String sumberDana;

    @SerializedName("pengelola")
    public String pengelola;

    @SerializedName("tipe")
    public String tipe;

    @SerializedName("standar")
    public String standar;

    @SerializedName("tahun_berdiri")
    public String tahunBerdiri;

    @SerializedName("bangunan")
    public String bangunan;

    @SerializedName("luas_tanah")
    public String luasTanah;

    @SerializedName("status_kepemilikan")
    public String statusKepemilikan;
}
