package buu.informatics.s59161125.myprojectterminewsinvest

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentLoginmainBinding
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentMainmenuBinding
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_loginmain.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Mainmenu.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Mainmenu.newInstance] factory method to
 * create an instance of this fragment.
 */
class Mainmenu : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMainmenuBinding>(
            inflater, R.layout.fragment_mainmenu, container, false
        )
       binding.btn1.setOnClickListener {
           findNavController().navigate(R.id.action_mainmenu_to_tagetinvest)

       }
/*       binding.btn2.setOnClickListener {
           findNavController().navigate()
       } */

        binding.btn4.setOnClickListener {
            findNavController().navigate(R.id.action_mainmenu_to_exchange)

        }


        return binding.root
    }



}

