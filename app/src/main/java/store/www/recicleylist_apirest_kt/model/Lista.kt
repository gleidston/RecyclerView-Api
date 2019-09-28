package store.www.recicleylist_apirest_kt.model


import com.google.gson.annotations.SerializedName

data class Lista(
    @SerializedName("foto")
    val foto: String,
    @SerializedName("nome")
    val nome: String,
    @SerializedName("time")
    val time: String
)