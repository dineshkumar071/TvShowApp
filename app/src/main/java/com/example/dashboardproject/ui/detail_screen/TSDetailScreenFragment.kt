package com.example.dashboardproject.ui.detail_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboardproject.Repository.Model.Results
import com.example.dashboardproject.Utils.Status
import com.example.dashboardproject.databinding.FragmentDetailScreenBinding
import com.example.dashboardproject.ui.base.TSBaseFragment
import javax.inject.Inject
import javax.inject.Named

class TSDetailScreenFragment : TSBaseFragment() {

    private lateinit var detailScreenBinding: FragmentDetailScreenBinding

    @Inject
    @Named("Details-screen")
    lateinit var detailScreenViewModelFactory: TSDetailScreenViewModelFactory
    private lateinit var detailScreenViewModel: TSDetailScreenViewModel
    var trendString:String = ""
    private lateinit var trend:Results
    private var similarShows: MutableList<Results> = mutableListOf()
    private val similarShowsAdapter by lazy {
        TSSimilarShowsAdapter(mContext, similarShows
        ) { position, trend ->
            {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        trendString = arguments?.getString("amount")?:""
        trend = convertJSONtoPOJO(trendString)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailScreenBinding = FragmentDetailScreenBinding.inflate(inflater, container, false)
        return detailScreenBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailScreenViewModel = ViewModelProvider(
            this,
            detailScreenViewModelFactory
        )[TSDetailScreenViewModel::class.java]
        detailScreenBinding.apply {
            rvSimilarShow.layoutManager = LinearLayoutManager(mContext,RecyclerView.HORIZONTAL,false)
            rvSimilarShow.adapter = similarShowsAdapter
            tvBriefDescription.text = trend.overview
        }
        detailScreenViewModel.getSimilarShow()
        observeViewModel()
    }

    private fun observeViewModel() {
        detailScreenViewModel.similarShowsLiveData.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    if(it.data?.results?.isNotEmpty() == true){
                        similarShows.addAll(it.data.results!!)
                    }
                    similarShowsAdapter.notifyDataSetChanged()
                }
                Status.ERROR -> {
                    //here we need to hide the loader and handle the error scenario.
                    Toast.makeText(mContext,it.message, Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    // Here we need to show the loader to the user.
                }
                else -> {

                }
            }
        }
    }

}