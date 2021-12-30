package com.example.sleepplan.sleepTracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.example.sleepplan.R
import com.example.sleepplan.database.SleepDatabase
import com.example.sleepplan.databinding.FragmentSleepTrackerBinding
import kotlinx.coroutines.InternalCoroutinesApi


class SleepTrackerFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding =DataBindingUtil.inflate<FragmentSleepTrackerBinding>(inflater,R.layout.fragment_sleep_tracker,container,false)

        val application = requireNotNull(this.activity).application
        val dataSource=SleepDatabase.getInstance(application).sleepDatabaseDao
        val viewModelFactory=SleepTrackerViewModelFactory(dataSource,application)
        val sleepTrackerViewModel=
            ViewModelProviders.of(this,viewModelFactory).get(SleepTrackerViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.sleepTrackerViewModel=sleepTrackerViewModel
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SleepTrackerFragment().apply {

            }
    }
}