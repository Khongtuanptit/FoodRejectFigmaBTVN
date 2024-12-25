package com.eagletech.foodrejectfigmabtvn.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eagletech.foodrejectfigmabtvn.R
import com.eagletech.foodrejectfigmabtvn.adapter.DetailFoodItemAdapter
import com.eagletech.foodrejectfigmabtvn.model.DetailFoodItem
import com.eagletech.foodrejectfigmabtvn.model.FoodItem

class DetailCategoryActivity : AppCompatActivity() {
    lateinit var rc_detail_category: RecyclerView
    lateinit var back: ImageView
    lateinit var title_food: TextView
    lateinit var recipe_count: TextView
    lateinit var searchEditText: EditText

    private lateinit var fullFoodList: List<DetailFoodItem>
    private lateinit var detailFoodItemAdapter: DetailFoodItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_category)

        rc_detail_category = findViewById(R.id.rc_detail_category)
        back = findViewById(R.id.back)
        title_food = findViewById(R.id.title_food)
        recipe_count = findViewById(R.id.recipe_count)
        searchEditText = findViewById(R.id.searchEditText)

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // lọc lại danh sáhc ở đây
                filterList(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        val foodItem = intent.getSerializableExtra("foodItem") as FoodItem

        title_food.text = foodItem.title
        recipe_count.text = "(${foodItem.recipeCount})"

        back.setOnClickListener {
            finish()
        }

        fullFoodList = listOf(
            DetailFoodItem(
                R.drawable.img_recipes_of_week,
                "Black Karaage with Curry Bento",
                "This Japanese modern izakaya dish features crispy black karaage..",
                isLike = true
            ),
            DetailFoodItem(
                R.drawable.img_recipes_of_week,
                "Salmon Sashimi Platter",
                "Fresh salmon sashimi served with soy sauce and wasabi..",
                isLike = false
            ),
            DetailFoodItem(
                R.drawable.img_recipes_of_week,
                "Salmon Sashimi Platter",
                "Fresh salmon sashimi served with soy sauce and wasabi..",
                isLike = true
            ),
            DetailFoodItem(
                R.drawable.img_recipes_of_week,
                "Salmon Sashimi Platter",
                "Fresh salmon sashimi served with soy sauce and wasabi..",
                isLike = false
            ),
            DetailFoodItem(
                R.drawable.img_recipes_of_week,
                "Salmon Sashimi Platter",
                "Fresh salmon sashimi served with soy sauce and wasabi..",
                isLike = false
            ),
            DetailFoodItem(
                R.drawable.img_recipes_of_week,
                "Salmon Sashimi Platter",
                "Fresh salmon sashimi served with soy sauce and wasabi..",
                isLike = true
            ),
            DetailFoodItem(
                R.drawable.img_recipes_of_week,
                "Salmon Sashimi Platter",
                "Fresh salmon sashimi served with soy sauce and wasabi..",
                isLike = false
            ),
            DetailFoodItem(
                R.drawable.img_recipes_of_week,
                "Salmon Sashimi Platter",
                "Fresh salmon sashimi served with soy sauce and wasabi..",
                isLike = false
            ),

            DetailFoodItem(
                R.drawable.img_recipes_of_week,
                "Matcha Cheesecake",
                "A delicious matcha-flavored cheesecake with a crispy crust..",
                isLike = false
            )
        )

        detailFoodItemAdapter = DetailFoodItemAdapter(fullFoodList, { detailFoodItem ->
            // xử lý khi click vào từng item
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("detailFoodItem", detailFoodItem)
            startActivity(intent)
            Toast.makeText(this, "${detailFoodItem.title}", Toast.LENGTH_SHORT).show()
        }, { detailFoodItem ->
            Toast.makeText(
                this,
                if (detailFoodItem.isLike) "Like!" else "Unlike!",
                Toast.LENGTH_SHORT
            )
                .show()
        })

        rc_detail_category.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )

        rc_detail_category.adapter = detailFoodItemAdapter

    }

    // tomko
    private fun filterList(query: String) {
        val filteredList = fullFoodList.filter { item ->
            item.title.contains(query, ignoreCase = true) || item.description.contains(
                query,
                ignoreCase = true
            )
        }
        detailFoodItemAdapter.updateData(filteredList)

    }
}