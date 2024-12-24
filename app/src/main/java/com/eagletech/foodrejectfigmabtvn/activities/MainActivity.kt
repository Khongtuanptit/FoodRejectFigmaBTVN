package com.eagletech.foodrejectfigmabtvn.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.eagletech.foodrejectfigmabtvn.R
import com.eagletech.foodrejectfigmabtvn.adapter.ImagePagerAdapter
import com.eagletech.foodrejectfigmabtvn.adapter.RecipeAdapter
import com.eagletech.foodrejectfigmabtvn.model.FoodItem
import com.eagletech.foodrejectfigmabtvn.model.RecipeItem

class MainActivity : AppCompatActivity() {
    lateinit var viewpager_image_slide: ViewPager2
    lateinit var rc_recipe_of_week: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        viewpager_image_slide = findViewById(R.id.viewpager_image_slide)
        rc_recipe_of_week = findViewById(R.id.rc_recipe_of_week)


        val imageListHome = listOf(
            FoodItem(R.drawable.img_demo_food, "Japanese Food", 64),
            FoodItem(R.drawable.img_demo_food, "Italian Cuisine", 45),
            FoodItem(R.drawable.img_demo_food, "Mexican Tacos", 30),
            FoodItem(R.drawable.img_demo_food, "Mexican Tacos 2", 30),
            FoodItem(R.drawable.img_demo_food, "Mexican Tacos 3", 30),
        )

        val adapterImageListHome = ImagePagerAdapter(imageListHome) { foodItem ->
            Toast.makeText(this, "${foodItem.title}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DetailCategoryActivity::class.java)
            intent.putExtra("foodItem", foodItem)
            startActivity(intent)
        }

        viewpager_image_slide.adapter = adapterImageListHome
        viewpager_image_slide.setCurrentItem(1, false)

        val recipes = listOf(
            RecipeItem(R.drawable.img_recipes_of_week, "Seafood Udon", false),
            RecipeItem(R.drawable.img_recipes_of_week, "Spicy Ramen", true),
            RecipeItem(R.drawable.img_recipes_of_week, "Spicy Ramen 2", false),
            RecipeItem(R.drawable.img_recipes_of_week, "Spicy Ramen 3", true),
            RecipeItem(R.drawable.img_recipes_of_week, "Spicy Ramen 4", false),
            RecipeItem(R.drawable.img_recipes_of_week, "Sushi Rolls", false)
        )


        val adapterRecipeItem = RecipeAdapter(recipes, { recipes ->
            Toast.makeText(this, "${recipes.title} click", Toast.LENGTH_SHORT).show()
        }, { recipes ->
            Toast.makeText(this, if (recipes.isLike) "Like!" else "Unlike!", Toast.LENGTH_SHORT)
                .show()
        })


        rc_recipe_of_week.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false
        )
        rc_recipe_of_week.adapter = adapterRecipeItem

    }
}