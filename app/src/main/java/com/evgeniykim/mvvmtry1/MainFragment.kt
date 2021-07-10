package com.evgeniykim.mvvmtry1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.evgeniykim.mvvmtry1.databinding.FragmentMainBinding
import com.evgeniykim.mvvmtry1.model.MainViewModel

class MainFragment : Fragment() {

    // View Binding
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    // Create a viewModel
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListener()
        fragmentTextUpdateObserver()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupClickListener() {
        binding.fragmentButton.setOnClickListener { viewModel.getUpdatedText() }
    }

    private fun fragmentTextUpdateObserver() {
        viewModel.uiTextLiveData.observe(viewLifecycleOwner, Observer { updatedText ->
            binding.fragmentTextView.text = updatedText
        })
    }



}