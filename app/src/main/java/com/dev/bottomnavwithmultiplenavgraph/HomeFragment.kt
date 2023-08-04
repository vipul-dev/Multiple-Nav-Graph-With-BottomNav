package com.dev.bottomnavwithmultiplenavgraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.dev.bottomnavwithmultiplenavgraph.databinding.FragmentHomeBinding

class HomeFragment : Fragment(){

    private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        binding.btnViewBalance.setOnClickListener {
            val navOption = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()

            navController.navigate(R.id.viewBalanceFragment,null,navOption)
        }

        binding.btnTransactions.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToViewTransactionsFragment()
            navController.navigate(action)
        }

        binding.btnSendMoney.visibility=View.INVISIBLE
        binding.btnSendMoney.setOnClickListener {

        }

    }

}