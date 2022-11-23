package com.nikhil.dagger

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.nikhil.dagger.data.Car
import com.nikhil.dagger.databinding.FragmentFirstBinding
import com.nikhil.dagger.di.component.DaggerPetrolCarComponent
import com.nikhil.dagger.di.component.PetrolCarComponent


import javax.inject.Inject


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    @Inject
    lateinit var car1: Car;

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        init()
    }

    private fun init() {
     /*
     //Component builder
     (activity?.application as PocApplication).apply {
            val component: PetrolCarComponent = DaggerPetrolCarComponent.builder()
                .appComponent(appComponent)
                .horsePower(150)
                .engineCapcity(2000)
                .build()
            component.inject(this@FirstFragment)
            car1.drive();
        }*/

    //Component Factory
    (activity?.application as PocApplication).apply {
           val component: PetrolCarComponent = DaggerPetrolCarComponent
               .factory()
               .create(appComponent,150,2000)

           component.inject(this@FirstFragment)
           car1.drive();
       }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}