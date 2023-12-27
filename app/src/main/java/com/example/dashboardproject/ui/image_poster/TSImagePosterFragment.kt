package com.example.dashboardproject.ui.image_poster

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboardproject.Repository.Model.Results
import com.example.dashboardproject.Utils.Status
import com.example.dashboardproject.common.TSApplication.Companion.instance
import com.example.dashboardproject.databinding.FragmentImagePosterBinding
import com.example.dashboardproject.ui.base.TSBaseFragment
import javax.inject.Inject
import javax.inject.Named

class TSImagePosterFragment : TSBaseFragment() {
    private lateinit var imagePosterBinding: FragmentImagePosterBinding
    private var trendings :MutableList<Results> = mutableListOf()
    @Inject
    @Named("Image-poster")
    lateinit var imagePosterViewModelFactory: ViewModelProvider.Factory
    private lateinit var imagePosterViewModel :TSImagePosterViewModel
    private var isEnableSearchView:Boolean = false
    private val posterAdapter by lazy {
        TSImagePosterAdapter(mContext,trendings
        ) { position, trend ->
            run {
                val resultString = convertPOJOtoJSON(trend)
                tsFragmentChannel.showDetailScreenFragment(resultString)
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        imagePosterBinding = FragmentImagePosterBinding.inflate(inflater, container, false)
        return imagePosterBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instance?.getComponent()?.inject(this)
        imagePosterViewModel =ViewModelProvider(this,imagePosterViewModelFactory)[TSImagePosterViewModel::class.java]
        imagePosterBinding.apply {
            rvImagePoster.layoutManager =
                GridLayoutManager(mContext, 2, RecyclerView.HORIZONTAL, false)
            rvImagePoster.adapter = posterAdapter
            ivSearchUserDetails.setOnClickListener {
                isEnableSearchView = !isEnableSearchView
                enableSearchView()
            }
            etSearchUserDetails.addTextChangedListener(object :TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    //"Not yet implemented"
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                   //"Not yet implemented"
                }

                override fun afterTextChanged(s: Editable?) {
                    if(etSearchUserDetails.text.length >= 4){
                        imagePosterViewModel.getSearchShows(etSearchUserDetails.text.toString())
                    }
                }
            })
        }
        imagePosterViewModel.getTrending()
        observeViewModel()
    }

    private fun FragmentImagePosterBinding.enableSearchView() {
        if (isEnableSearchView) {
            etSearchUserDetails.visibility = View.VISIBLE
        } else {
            etSearchUserDetails.visibility = View.GONE
        }
    }

    private fun observeViewModel() {
        imagePosterViewModel.trendingLiveData.observe(viewLifecycleOwner){
            when(it.status){
                Status.SUCCESS->{
                    // First we need to hide the progress bar and load the data
                    if(it.data?.results?.isNotEmpty() == true){
                        trendings.addAll(it.data.results!!)
                    }
                    posterAdapter.notifyDataSetChanged()
                }
                Status.ERROR->{
                    //here we need to hide the loader and handle the error scenario.
                    Toast.makeText(mContext,it.message,Toast.LENGTH_SHORT).show()
                }
                Status.LOADING->{
                    // Here we need to show the loader to the user.
                }else->{

                }
            }
        }
        imagePosterViewModel.searchedTrendsLiveData.observe(viewLifecycleOwner){
            when(it.status){
                Status.SUCCESS->{
                    // First we need to hide the progress bar and load the data
                    if(it.data?.results?.isNotEmpty() == true){
                        trendings.addAll(it.data.results!!)
                    }
                    posterAdapter.notifyDataSetChanged()
                }
                Status.ERROR->{
                    //here we need to hide the loader and handle the error scenario.
                    Toast.makeText(mContext,it.message,Toast.LENGTH_SHORT).show()
                }
                Status.LOADING->{
                    // Here we need to show the loader to the user.
                }else->{

            }
            }
        }
    }
}