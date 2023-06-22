package com.learnwithsajib.addressbookretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.learnwithsajib.addressbookretrofit.api.RetrofitClient
import com.learnwithsajib.addressbookretrofit.databinding.ActivityMainBinding
import com.learnwithsajib.addressbookretrofit.models.User
import com.learnwithsajib.addressbookretrofit.ui.AddressAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {



    lateinit var adapter:AddressAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter=AddressAdapter()




      var users: Call<List<User>> = RetrofitClient.service.getAllUser()


        users.enqueue(object : Callback<List<User> >{   //Callback<list type>
            override fun onFailure(call: Call<List<User>>?, t: Throwable?) {

         Toast.makeText(applicationContext,"${t?.message}",Toast.LENGTH_SHORT).show()


            }

            override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {

                var userlist= response?.body()
adapter.submitList(userlist)




            }

        })


        binding.recyclerviewid.adapter=adapter

    }
}