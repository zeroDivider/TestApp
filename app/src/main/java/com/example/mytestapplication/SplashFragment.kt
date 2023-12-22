package com.example.mytestapplication

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.mytestapplication.databinding.SplashFragmentBinding


class SplashFragment : Fragment() {

    private lateinit var binding: SplashFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SplashFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireActivity().getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        val flag = sharedPreferences.getBoolean("FLAG", false)

        Handler(Looper.getMainLooper()).postDelayed({
            if (flag) {
                Navigation.findNavController(view).setGraph(R.navigation.finish_navigation)
            } else {
                Navigation.findNavController(view).setGraph(R.navigation.menu_navigation)
            }
        }, 1000)
    }
}
