package com.ulisesdiaz.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class SecondSegundo : AppCompatActivity() {

    var toolbar:Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segundo)
        toolbar = findViewById(R.id.toolbarActividadDos)

        toolbar?.setTitle(R.string.toolbar_segunda_actividad)
        setSupportActionBar(toolbar)

        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    /**
     * Inicializa el contenido del meni de opciones de la Actividad, es decir  que infla los elementos
     * que se creron en el archivo menu.xml para manipularlos mediante codigo Kotli
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_segundo, menu)
        return super.onCreateOptionsMenu(menu)
    }

    /**
     * Se activa siempre que se selecciona un elemento del menu de opciones
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.menu_upload -> {
                Toast.makeText(this, "Elemento Para cargar", Toast.LENGTH_SHORT).show()
                return true
            }
            else ->( return super.onOptionsItemSelected(item))
        }
    }
}