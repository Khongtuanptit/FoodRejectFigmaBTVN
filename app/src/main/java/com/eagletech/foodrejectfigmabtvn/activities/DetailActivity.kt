package com.eagletech.foodrejectfigmabtvn.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.eagletech.foodrejectfigmabtvn.R
import com.eagletech.foodrejectfigmabtvn.adapter.BuocAdapter
import com.eagletech.foodrejectfigmabtvn.adapter.CongThucAdapter
import com.eagletech.foodrejectfigmabtvn.adapter.ImageAdapter
import com.eagletech.foodrejectfigmabtvn.model.Buoc
import com.eagletech.foodrejectfigmabtvn.model.CongThuc
import com.eagletech.foodrejectfigmabtvn.model.DetailFoodItem
import com.eagletech.foodrejectfigmabtvn.model.ImageDetail
import me.relex.circleindicator.CircleIndicator3

class DetailActivity : AppCompatActivity() {

    // Xử lý cho viewpager image
    lateinit var viewpager_image_detail: ViewPager2
    lateinit var indicator: CircleIndicator3

    // Xử lý cho toolbar
    lateinit var title_food_detail: TextView
    lateinit var back_detail: ImageView

    // Xử lý cho recycleView thứ nhất(tức là danh sách công thức)
    lateinit var recycle_cong_thuc: RecyclerView

    // Xử lý cho recycleView thứ hai(tức là danh sách cách làm)
    lateinit var name_recipe_detail: TextView
    lateinit var recycle_cach_lam: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        // Dữ liệu detailFoodItem được gửi từ màn DetaiCategory
        val detailFoodItem = intent.getSerializableExtra("detailFoodItem") as DetailFoodItem

        // Xử lý cho viewpager image
        viewpager_image_detail = findViewById(R.id.viewpager_image_detail)
        indicator = findViewById(R.id.indicator)

        // Xử lý cho toolbar
        title_food_detail = findViewById(R.id.title_food_detail)
        back_detail = findViewById(R.id.back_detail)

        this.back_detail.setOnClickListener {
            finish()
        }
        title_food_detail.text = detailFoodItem.title


        // Xử lý cho thằng recycleView thứ nhất(tức là danh sách công thức)
        recycle_cong_thuc = findViewById(R.id.recycle_cong_thuc)
        val listCongThuc = listOf(
            CongThuc("1 cup flour", R.drawable.ic_ct),
            CongThuc("2 large eggs", R.drawable.ic_ct),
            CongThuc("1/2 octopus", R.drawable.ic_ct),
            CongThuc("1/2 tsp salt", R.drawable.ic_ct),
            CongThuc("1/4 tsp sugar", R.drawable.ic_ct),
            CongThuc("1/4 onions", R.drawable.ic_ct),
            CongThuc("1 cup flour", R.drawable.ic_ct),
            CongThuc("1 cup flour", R.drawable.ic_ct),
            CongThuc("1 cup flour", R.drawable.ic_ct)
        )

        val congThucAdapter = CongThucAdapter(listCongThuc)
        recycle_cong_thuc.layoutManager = GridLayoutManager(this, 2)
        recycle_cong_thuc.adapter = congThucAdapter


        // Xử lý cho recycleView thứ hai(tức là danh sách cách làm)
        name_recipe_detail = findViewById(R.id.name_recipe_detail)
        recycle_cach_lam = findViewById(R.id.recycle_cach_lam)

        name_recipe_detail.text = detailFoodItem.title

        val listCachLam = listOf(
            Buoc(1, "In a large bowl, whisk together the flour, baking powder, salt, and sugar"),
            Buoc(2, "In a separate bowl, whisk together the dashi and eggs."),
            Buoc(3, "Add the egg mixture to the flour mixture and whisk until smooth."),
            Buoc(4, "Stir in the octopus and green onions."),
            Buoc(5, "In a large bowl, whisk together the flour, baking powder, salt, and sugar"),
            Buoc(6, "In a large bowl, whisk together the flour, baking powder, salt, and sugar"),
            Buoc(7, "In a large bowl, whisk together the flour, baking powder, salt, and sugar"),
            Buoc(8, "In a large bowl, whisk together the flour, baking powder, salt, and sugar"),
        )

        val buocAdapter = BuocAdapter(listCachLam)
        recycle_cach_lam.layoutManager = LinearLayoutManager(this)
        recycle_cach_lam.adapter = buocAdapter


        val listImage = listOf(
            ImageDetail(detailFoodItem.imageUrl),
            ImageDetail(R.drawable.img_2)
        )

        val imageAdapter = ImageAdapter(listImage)
        viewpager_image_detail.adapter = imageAdapter

        indicator.setViewPager(viewpager_image_detail)
    }
}