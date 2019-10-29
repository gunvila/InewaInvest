package buu.informatics.s59161125.myprojectterminewsinvest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentAbotmeBinding

/**
 * A simple [Fragment] subclass.
 */
class abotme : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAbotmeBinding>(inflater,
            R.layout.fragment_abotme,container,false)
        return binding.root
    }



}
