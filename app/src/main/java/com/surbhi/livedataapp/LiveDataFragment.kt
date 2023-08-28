package com.surbhi.livedataapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.surbhi.livedataapp.databinding.FragmentLiveDataBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LiveDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LiveDataFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mainActivity: MainActivity
    lateinit var binding : FragmentLiveDataBinding
    lateinit var liveDataClass: LiveDataClass

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivity = activity as MainActivity
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLiveDataBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        liveDataClass = ViewModelProvider(mainActivity)[LiveDataClass::class.java]
        liveDataClass.color.observe(mainActivity){
            System.out.print("in observe method $it")
            when(it){
                1 -> binding.llBg.setBackgroundColor(ContextCompat.getColor(mainActivity,R.color.red))
                2 -> binding.llBg.setBackgroundColor(ContextCompat.getColor(mainActivity,R.color.blue))
                3 -> binding.llBg.setBackgroundColor(ContextCompat.getColor(mainActivity,R.color.green))
            }
            liveDataClass.number.observe(mainActivity){
                binding.tvNumber.text = it.toString()
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LiveDataFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LiveDataFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}