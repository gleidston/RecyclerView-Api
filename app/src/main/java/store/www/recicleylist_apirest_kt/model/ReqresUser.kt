package store.www.recicleylist_apirest_kt.model


import com.google.gson.annotations.SerializedName

data class ReqresUser(
    @SerializedName("lista")
    val lista: List<Lista>,
    @SerializedName("sucesso")
    val sucesso: Boolean
)