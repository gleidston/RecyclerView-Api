package store.www.recicleylist_apirest_kt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import store.www.recicleylist_apirest_kt.model.Lista
import store.www.recicleylist_apirest_kt.model.ReqresUser

class MainActivity : AppCompatActivity() {
  private val  dataList:MutableList<Lista> = mutableListOf()
          private lateinit var  meuAdapter: MeuAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // configurando adapter
        meuAdapter= MeuAdapter(dataList)
        //configurando recycler view
        Minha_Recycler.layoutManager= LinearLayoutManager(this)
        Minha_Recycler.addItemDecoration(DividerItemDecoration(this , OrientationHelper.VERTICAL))
        Minha_Recycler.adapter=meuAdapter

        // configurando a conexao
        AndroidNetworking.initialize(this)
        AndroidNetworking.get("http://apiteste.fourtime.com/api/jogador/lista")
            .build().getAsObject(ReqresUser::class.java,object : ParsedRequestListener<ReqresUser>{


                override fun onResponse(response: ReqresUser) {


                        dataList.addAll(response.lista)

                    meuAdapter.notifyDataSetChanged()


                    }



                override fun onError(anError: ANError?) {

                }


            })
    }
}

