package br.com.downtown.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.downtown.R
import br.com.downtown.adapter.ProductAdapter
import br.com.downtown.auth.RetroFit
import br.com.downtown.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CasualFActivity : Activity() {

    private lateinit var productRecyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private val productList = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_casual_fem)


        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("jwt_token", null)


        val perfil: ImageView = findViewById(R.id.profileImage)
        perfil.setOnClickListener {
            if (token != null) {

                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            } else {

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }


        val backButton: ImageButton = findViewById(R.id.backButton)
        backButton.setOnClickListener { finish() }

        productRecyclerView = findViewById(R.id.categories_grid)
        productRecyclerView.layoutManager = GridLayoutManager(this, 2)
        productAdapter = ProductAdapter(productList)
        productRecyclerView.adapter = productAdapter

        fetchProducts()
    }

    private fun fetchProducts() {
        RetroFit.api.getProductsByCategory("CasualFeminino").enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        productList.clear()
                        productList.addAll(it)
                        productAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
