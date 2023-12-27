package com.example.dashboardproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.dashboardproject.Repository.Model.Results
import com.example.dashboardproject.common.TSFragmentChannel
import com.example.dashboardproject.databinding.ActivityMainBinding
import com.example.dashboardproject.ui.base.TSBaseFragment

class MainActivity : AppCompatActivity(),TSFragmentChannel{
    private lateinit var navController: NavController
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fc_home_container) as NavHostFragment
        navController = navHostFragment.navController
        TSBaseFragment.setFragmentChannel(this)
    }

    override fun showImagePosterFragment() {
        runOnUiThread{
            navController.navigate(R.id.ts_image_poster_fragment)
        }
    }

    override fun showDetailScreenFragment(result: String) {
        runOnUiThread {
            val bundle = bundleOf("trend" to result)
            navController.navigate(R.id.ts_detail_screen_fragment,bundle)
        }
    }
}