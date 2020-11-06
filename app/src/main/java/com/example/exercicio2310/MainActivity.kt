package com.example.exercicio2310

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.exercicio2310.R.layout.activity_main
import com.google.android.material.tabs.TabLayout

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),TabLayout.OnTabSelectedListener {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        supportActionBar?.title = "Cadastro"
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        initComponents()
        callFragment(NaoSocioFragment())

    }

    private fun initComponents() {
        tabLayout = findViewById(R.id.tabGeral)
        tabLayout.addOnTabSelectedListener(this)
    }

    private fun callFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container,fragment)
        ft.commit()
    }

    override fun onTabReselected(tab: TabLayout.Tab?) { /**usar **/

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) { /**usar dps**/

    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
       when(tab?.position){
           0 -> {
               callFragment(NaoSocioFragment())
           }
           1 -> {
               callFragment(SocioFragment())
           }
       }
    }
}