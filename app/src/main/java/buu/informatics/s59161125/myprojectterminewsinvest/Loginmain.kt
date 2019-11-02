package buu.informatics.s59161125.myprojectterminewsinvest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentLoginmainBinding
import kotlinx.android.synthetic.main.fragment_loginmain.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Loginmain.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Loginmain.newInstance] factory method to
 * create an instance of this fragment.
 */
class Loginmain : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentLoginmainBinding>(
            inflater, R.layout.fragment_loginmain, container, false
        )

        binding.submit.setOnClickListener { view: View ->
            var user = use.text.toString()
            var pass = pass.text.toString()
            if (user == "admin" && pass == "12345678") {
                Log.d("true", "12345")
                view.findNavController()
                    .navigate(LoginmainDirections.actionLoginmainToMainmenu("pass"))
                (activity as AppCompatActivity).supportActionBar?.show()
            } else {
                Toast.makeText(
                    getActivity(), "รหัสผ่านผิดกรุณา ล็อคอินใหม่",
                    Toast.LENGTH_LONG
                ).show()
            }

        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
    }


}
