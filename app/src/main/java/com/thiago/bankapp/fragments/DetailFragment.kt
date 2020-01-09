package com.thiago.bankapp.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.thiago.bankapp.R
import com.thiago.bankapp.adapter.DetailAdapter
import com.thiago.bankapp.animator.ExpandableLayout
import com.thiago.bankapp.databinding.FragmentDetailBinding
import com.thiago.bankapp.viewmodel.DetailViewModel
import com.thiago.bankapp.viewmodel.UserViewModel

class DetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var viewModel: UserViewModel
    private lateinit var binding: FragmentDetailBinding
    private lateinit var adapter: DetailAdapter
    private lateinit var expandableLayout: ExpandableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        expandableLayout = ExpandableLayout()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentDetailBinding.inflate(inflater)

        detailViewModel = ViewModelProviders.of(activity!!).get(DetailViewModel::class.java)
        viewModel = ViewModelProviders.of(activity!!).get(UserViewModel::class.java)

        binding.lifecycleOwner = this

        binding.detailVideModel = detailViewModel
        binding.userViewModel = viewModel

        adapter = DetailAdapter()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        expandableLayout.view = binding.detailRecycler
        initDetailObserver()
        initListener()
    }

    private fun initDetailObserver(){
        detailViewModel.detailUser.observe(this, Observer {
            if(null != it){
                Log.i("test", "Detail User: " + it.get(0).title)
                adapter.projects = it
                adapter.notifyDataSetChanged()
                binding.detailRecycler.adapter = adapter
            }else{
                Log.i("test", "NOPE")
            }
        })
    }

    private fun initListener(){
        binding.accountUserExpandable.setOnClickListener{
            expandableLayout.onClick(null)
        }
    }
}
