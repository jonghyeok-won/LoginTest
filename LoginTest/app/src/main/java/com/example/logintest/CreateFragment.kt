package com.example.logintest

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.logintest.databinding.ActivityMainBinding
import com.example.logintest.databinding.FragmentCreateBinding
import com.example.logintest.databinding.FragmentLoginBinding
import com.example.logintest.databinding.FragmentMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import androidx.navigation.fragment.findNavController

class CreateFragment : AppCompatActivity() {
    var binding : FragmentCreateBinding ? = null


    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_create)
        auth = FirebaseAuth.getInstance()
        createBtn()
    }

    private fun createBtn() {
        binding?.btnCreate?.setOnClickListener {
            val email = binding?.emailArea?.text.toString()
            val password = binding?.passwordArea?.text.toString()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(this, "계정 생성", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "생성 실패", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}