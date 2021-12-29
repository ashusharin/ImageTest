package com.shusharin.testcaseimage.ui.mainscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.testcaseimage.R
import com.shusharin.testcaseimage.databinding.MainFragmentBinding
import com.shusharin.testcaseimage.di.App
import com.shusharin.testcaseimage.ui.detailScreen.DetailFragment
import com.shusharin.testcaseimage.ui.mainscreen.recycler.RVAdapter
import com.shusharin.testcaseimage.utils.ViewModelFactory
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }
    private val appComponent by lazy {
        (activity?.application as App).appComponent
    }
    private lateinit var adapter: RVAdapter

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupRecyclerView()
        setData()
        return root

    }

    private fun setData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.listImage.onEach {
                    adapter.imageList = it
                }.launchIn(this)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        adapter = RVAdapter()
        binding.rv.adapter = adapter
        rvListener()
    }

    fun rvListener(){
        binding.rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    viewModel.updateList()
                }
            }
        })

        adapter.onImageItemClickListener = {
            val argument = Bundle().apply {
                putSerializable("img", it)
            }
            openDetailFrag(argument)
        }
    }

    private fun openDetailFrag(argument: Bundle) {
        val fragment: Fragment = DetailFragment()
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        fragment.arguments = argument
        transaction?.replace(R.id.fragment_container, fragment)?.addToBackStack("det")?.commit()

    }
}