package com.sdrss.githubtrendingrepoapp.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdrss.githubtrendingrepoapp.R
import com.sdrss.githubtrendingrepoapp.binding.BindingActivity
import com.sdrss.githubtrendingrepoapp.databinding.ActivityMainBinding
import com.sdrss.githubtrendingrepoapp.utils.isOnline
import com.sdrss.githubtrendingrepoapp.utils.scrollToTop
import com.sdrss.githubtrendingrepoapp.viewmodel.GithubTrendingRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * @author SDRSS
 */
class MainActivity : BindingActivity<ActivityMainBinding>() {

    override fun getLayoutResId(): Int = R.layout.activity_main

    private val adapterSearchResult: SearchResultListAdapter by inject()

    private val mViewModel: GithubTrendingRepoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpToolbar() //set toolbar

        viewModelSetUp() //set viewModel to binding variable of xml

        loadData() //loadData with checking InternetAvailability

        observeLiveData() //ObserveLiveData

        setUpRecyclerView() //set Adapter

        setUpWidgetEventListener() //Set ClickListener for Widget
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun setUpWidgetEventListener() {
        //Retry Button Listener
        retryBtn.setOnClickListener {
            loadData()
        }

        //SwipeRefreshLayout Listener
        swipeRefreshLayout.setOnRefreshListener {
            loadData()
        }
    }

    private fun setUpRecyclerView() {
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapterSearchResult
    }

    private fun viewModelSetUp() {
        binding.vm = mViewModel
    }

    private fun observeLiveData() {
        //Observe Result LiveData and submitData to listAdapter
        binding.vm?.githubTrendingRepoLiveData?.observe(this, Observer { dataList ->
            binding.vm?.isLoading?.set(false)
            (recyclerView?.layoutManager as LinearLayoutManager).scrollToTop()
            adapterSearchResult.submitList(dataList)
        })

        //Loader Data ObserveLiveData
        binding.vm?.showLoading?.observe(this, Observer { isShowingLoader ->
            if (isShowingLoader) simmerLayout.startShimmerAnimation() else simmerLayout.stopShimmerAnimation()
        })
    }

    private fun loadData() {
        if (this.isOnline()) {
            binding.vm?.isInternetAvailable?.set(true)
            binding.vm?.fetchData()
        } else {
            binding.vm?.isInternetAvailable?.set(false)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        invalidateOptionsMenu()
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.actionSortByStar) {
            binding.vm?.sortDataByStar()
        } else if (item?.itemId == R.id.actionSortByName) {
            binding.vm?.sortDataByName()
        }
        return super.onOptionsItemSelected(item)
    }
}