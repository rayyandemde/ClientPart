package com.android3.siegertpclient.ui.dummyretrofit

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android3.siegertpclient.databinding.ActivityTestRetrofitBinding
import com.android3.siegertpclient.ui.dummyretrofit.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.await


class TestRetrofitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestRetrofitBinding
    private lateinit var repository: Repository
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var userId: String

    var textPost: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestRetrofitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        userId = sharedPreferences.getString("userId", null) as String

        repository = Repository()

        //createUser()

        binding.buttonCreateUser.setOnClickListener {
            createUser()
        }

        binding.buttonCheckResponse.setOnClickListener {

        }


    }

    private fun createUser() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = repository
                    .createNewUser("test28feb", "test28surname",
                        "test28forename", userId ,  sharedPreferences
                            .getString("token", null) as String)
                if(response.isSuccessful) {
                    val data = response.body()!!
                    withContext(Dispatchers.Main) {
                        binding.tvThePost.text = "The new user are :: ".plus(data.toString())
                        Toast.makeText(this@TestRetrofitActivity, "User has been created", Toast.LENGTH_LONG).show()
                    }
                }
            }catch (e: Exception){
                withContext(Dispatchers.Main) {
                    Log.e("TooLong", e.toString())
                    Toast.makeText(this@TestRetrofitActivity, e.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}