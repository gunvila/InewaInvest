package buu.informatics.s59161125.myprojectterminewsinvest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentExchangeBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Exchange.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Exchange.newInstance] factory method to
 * create an instance of this fragment.
 */
class Exchange : Fragment() {

    lateinit var exchangeone: Spinner
    lateinit var exchangetwo: Spinner


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentExchangeBinding>(
            inflater, R.layout.fragment_exchange, container, false
        )
        exchangeone = binding.Listcurrencyone as Spinner
        exchangetwo = binding.Listcurencytwo as Spinner

        val exchangeones = arrayOf("USD","EUR","JPY","AUD","CNY","THB","CAD")
        val exchangetwos = arrayOf("JPY", "THB")

        var adapter = activity?.applicationContext?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                exchangeones
            )

        }
        adapter?.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.Listcurrencyone.adapter = adapter

        // Finally, data bind the spinner object with dapter
        binding.Listcurrencyone.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    // Display the selected item text on text view
                    Log.i("test", parent.getItemAtPosition(position).toString())
                    //"Spinner selected : ${parent.getItemAtPosition(position).toString()}"
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Another interface callback
                }
            }


        return binding.root
    }
}

