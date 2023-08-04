package com.dev.bottomnavwithmultiplenavgraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.dev.bottomnavwithmultiplenavgraph.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(){

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etDefaultAmount.setText(SampleData.defaultAmount.value.toString())

        binding.btnSaveDefaultAmount.setOnClickListener {
            val defaultAmount = binding.etDefaultAmount.text.toString().toLong()
            SampleData.defaultAmount.value = defaultAmount
        }

        binding.btnAboutApp.setOnClickListener {
            val action = SettingsFragmentDirections.actionSettingsFragmentToAboutAppFragment()
            findNavController().navigate(action)
        }

    }

}