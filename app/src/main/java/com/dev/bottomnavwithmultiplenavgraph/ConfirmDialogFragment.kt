package com.dev.bottomnavwithmultiplenavgraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.dev.bottomnavwithmultiplenavgraph.databinding.FragmentConfirmDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ConfirmDialogFragment : BottomSheetDialogFragment(){

    private lateinit var binding:FragmentConfirmDialogBinding
    private val args:ConfirmDialogFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentConfirmDialogBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receiverName = args.receiverName
        val amount = args.amount

        binding.tvMessage.text = "Do you want to send ₨$amount to $receiverName?"

        binding.btnYes.setOnClickListener {
            Toast.makeText(requireContext(), "$amount has been sent to $receiverName", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        binding.btnNo.setOnClickListener {
            dismiss()
        }

    }

}