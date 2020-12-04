package com.ulisesdiaz.toolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.ShareActionProvider
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat

class MainActivity : AppCompatActivity() {

    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnPrincipal = findViewById<Button>(R.id.btnPricipal)
        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        btnPrincipal.setOnClickListener {
            var intent = Intent(this, SecondSegundo::class.java)
            startActivity(intent)
        }
    }

    /**
     * Inicializa el contenido del meni de opciones de la Actividad, es decir  que infla los elementos
     * que se creron en el archivo menu.xml para manipularlos mediante codigo Kotli
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val itemBusqueda = menu?.findItem(R.id.menu_search)
        val itemCompartir = menu?.findItem(R.id.menu_share)
        var vistaBusqueda = itemBusqueda?.actionView as SearchView
        val shareActionProvider = MenuItemCompat.getActionProvider(itemCompartir) as ShareActionProvider
        compartirItem(shareActionProvider)

        vistaBusqueda.queryHint = "Escribre tu nombre..."
        vistaBusqueda.setOnQueryTextFocusChangeListener { v, hasFocus ->
            Log.d("LISTENERFOCUS", hasFocus.toString())
        }
        vistaBusqueda.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("OnQueryTextSubmit", query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("OnQueryTextChange", newText!!)
                return true
            }

        })
        return super.onCreateOptionsMenu(menu)
    }

    /**
     * Se activa siempre que se selecciona un elemento del menu de opciones
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.menu_favorite -> {
                Toast.makeText(this, "Elemento añadido como favorito", Toast.LENGTH_SHORT).show()
                return true
            }
            else ->( return super.onOptionsItemSelected(item))
        }
    }

    /**
     * Por medio de una accion se activa un menu del sistema Android que tiene un listado,
     * de las aplicaciones en la cual puedes compartirle información
     */
    private fun  compartirItem(shareActionProvider: ShareActionProvider){
        if (shareActionProvider != null){
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Este es un mensaje compartido")
            shareActionProvider.setShareIntent(intent)
        }
    }

}