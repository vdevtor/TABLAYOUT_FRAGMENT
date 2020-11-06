package com.example.exercicio2310

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.exercicio2310.model.MaskWatcher
import com.example.exercicio2310.model.Socio
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_nao_socio.*


class NaoSocioFragment : Fragment() {
    private lateinit var tilNome: TextInputLayout
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilTelefone: TextInputLayout
    private lateinit var tilSenha: TextInputLayout
    private lateinit var tilconfSenha: TextInputLayout
    private lateinit var tilButton: Button

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nao_socio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
        setObservable()

    }

    private fun setObservable() {
        tilButton.setOnClickListener {
            var taTudoCerto = true
            val nome = tilNome.editText?.text.toString()
            val email = tilEmail.editText?.text.toString()
            val telefone = tilTelefone.editText?.text.toString()
            val senha = tilSenha.editText?.text.toString()
            val confirmaSenha = tilconfSenha.editText?.text.toString()

            if (nome.isBlank()) {
                tilNome.error = getString(
                    R.string.campo_obrigatorio,
                    getString(R.string.name_completo)
                )
                taTudoCerto = false
            } else {
                tilNome.isErrorEnabled = false
            }


            if (email.isBlank()) {
                tilEmail.error = getString(
                    R.string.campo_obrigatorio,
                    getString(R.string.e_mail)
                )
                taTudoCerto = false
            } else {
                tilEmail.isErrorEnabled = false
            }
            if (telefone.isBlank()) {
                tilTelefone.error = getString(
                    R.string.campo_obrigatorio,
                    getString(R.string.contato_telefone)
                )
                taTudoCerto = false
            } else {

                tilTelefone.isErrorEnabled = false
            }
            if (senha.isBlank()) {
                tilSenha.error = getString(
                    R.string.campo_obrigatorio,
                    getString(R.string.senha)
                )
                taTudoCerto = false
            } else {
                tilSenha.isErrorEnabled = false
            }
            if (confirmaSenha.isBlank()) {
                tilconfSenha.error = getString(
                    R.string.campo_obrigatorio,
                    getString(R.string.confirmar_senha)
                )
                taTudoCerto = false
            } else {
                tilconfSenha.isErrorEnabled = false
            }

            if (taTudoCerto) {
                viewModel.setNovoSocio(
                    Socio(
                        nome = nome,
                        email = email,
                        telefone = telefone
                    )
                )

            }


        }
    }

    private fun password(): Boolean {
        val senha = tilSenha.editText?.text.toString()
       val confirmaSenha = tilconfSenha.editText?.text.toString()
        var confere = false
        if (senha == confirmaSenha) {
            confere = true

        }
        return confere
    }

    private fun initComponents() {
        activity?.let {
            viewModel = ViewModelProvider(it).get(MainViewModel::class.java)

            tTelefone.addTextChangedListener(MaskWatcher.MaskWatcher(tTelefone,"(##) #####-####"))
            tilNome = it.findViewById(R.id.tilName)
            tilEmail = it.findViewById(R.id.tilEmail)
            tilTelefone = it.findViewById(R.id.tilTelefone)
            tilSenha = it.findViewById(R.id.tilSenha)
            tilconfSenha = it.findViewById(R.id.tilConfirmaSenha)
            tilButton = it.findViewById(R.id.cadastra_Button)
        }
    }

}
