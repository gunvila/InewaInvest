package buu.informatics.s59161125.myprojectterminewsinvest

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentTagetinvestBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Tagetinvest.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Tagetinvest.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tagetinvest : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTagetinvestBinding>(
            inflater, R.layout.fragment_tagetinvest, container, false
        )
        return binding.root
    }
}
