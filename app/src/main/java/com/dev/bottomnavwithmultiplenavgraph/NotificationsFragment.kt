package com.dev.bottomnavwithmultiplenavgraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.dev.bottomnavwithmultiplenavgraph.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment(){

    private lateinit var binding:FragmentNotificationsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationsBinding.inflate(inflater,container,false)


        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lvNotifications.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,getNotifications())

    }
    private fun getNotifications():List<String>{
        val notifications = mutableListOf<String>()

        for(i in 1..20){
            notifications.add("Notification # $i")
        }
        return notifications
    }
}