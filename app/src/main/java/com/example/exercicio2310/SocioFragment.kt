package com.example.exercicio2310

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.exercicio2310.model.Socio
import kotlinx.android.synthetic.main.fragment_nao_socio.*
import kotlinx.android.synthetic.main.fragment_socio.*


class SocioFragment : Fragment() {
   private lateinit var viewmodel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_socio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewmodel = ViewModelProvider(it).get(MainViewModel::class.java)


            viewmodel.socioAtualizado.observe(it, Observer {
                activity?.findViewById<TextView>(R.id.nomeSocio)?.text =
                    "${it.nome}"
            })

        }
    }
}

