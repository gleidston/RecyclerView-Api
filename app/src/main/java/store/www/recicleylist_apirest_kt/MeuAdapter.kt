package store.www.recicleylist_apirest_kt

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*
import store.www.recicleylist_apirest_kt.model.Lista

// em mutablelist   adicionar o modulo de acordo com a classe criada
class MeuAdapter(private val dataList: MutableList<Lista>) : RecyclerView.Adapter<MyHolder>() {
    private lateinit var contex: Context
    // metodo implementantado
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        contex = parent.context
        return MyHolder(LayoutInflater.from(contex).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int = dataList.size


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = dataList[position]
        val usernometimeTextView = holder.itemView.user_nome_time
        val userAvatarImgView = holder.itemView.user_avatar
        val nomes = "Nome do Time  ${data.time}Nome do Jogador  ${data.nome}"
        usernometimeTextView.text = nomes

        Picasso.get().load(data.foto).into(userAvatarImgView)
        holder.itemView.setOnClickListener {
            Toast.makeText(contex, nomes, Toast.LENGTH_SHORT).show()
        }
    }
}

