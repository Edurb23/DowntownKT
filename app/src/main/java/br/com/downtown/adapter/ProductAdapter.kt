package br.com.downtown.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.downtown.R
import br.com.downtown.model.Product
import com.squareup.picasso.Picasso
import android.util.Base64
import android.graphics.BitmapFactory
import android.util.Log

class ProductAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productImage: ImageView = view.findViewById(R.id.productImage)
        val productName: TextView = view.findViewById(R.id.productName)
        val productPrice: TextView = view.findViewById(R.id.productPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.productName.text = product.nomeProduto
        holder.productPrice.text = "R$ ${product.preco}"

        try {

            val base64String = if (product.imagem.startsWith("data:image")) {
                product.imagem.substringAfter("base64,")
            } else {
                product.imagem
            }

            val imageBytes = Base64.decode(base64String, Base64.DEFAULT)
            val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            holder.productImage.setImageBitmap(decodedImage)


            Log.d("ProductAdapter", "Produto: ${product.nomeProduto}, Imagem Base64 (início): ${base64String.take(30)}...")
        } catch (e: IllegalArgumentException) {
            Log.e("ProductAdapter", "Erro ao decodificar imagem para o produto ${product.nomeProduto}: ${e.message}")
        } catch (e: Exception) {
            Log.e("ProductAdapter", "Erro desconhecido ao decodificar imagem para o produto ${product.nomeProduto}: ${e.message}")
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
