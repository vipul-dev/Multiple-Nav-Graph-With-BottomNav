package com.dev.bottomnavwithmultiplenavgraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dev.bottomnavwithmultiplenavgraph.databinding.FragmentSendCashBinding

class SendCashFragment : Fragment(){

    private lateinit var binding:FragmentSendCashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSendCashBinding.inflate(inflater,container,false)

        return binding.root
    }

    private val args : SendCashFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etAmount.setText(SampleData.defaultAmount.value.toString())
        SampleData.defaultAmount.observe(viewLifecycleOwner){
            binding.etAmount.setText(it.toString())
        }

        val receiverName = args.receiverName
        val test = args.test

        binding.tvReceiver.text = "Send cash to $receiverName\n$test"

        binding.btnSend.setOnClickListener {

            if(binding.etAmount.text.toString().isEmpty()) {
                Toast.makeText(requireContext(), "Enter some amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = binding.etAmount.text.toString().toLong()
            val action = SendCashFragmentDirections
                    .actionSendCashFragmentToConfirmDialogFragment(receiverName, amount)
            findNavController().navigate(action)
        }

        binding.btnDone.setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
            findNavController().navigate(action)
        }

        binding.btnCancel.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment,true)
        }

    }

}