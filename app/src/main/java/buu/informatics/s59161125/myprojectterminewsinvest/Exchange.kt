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
import android.widget.Toast
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
    var currencyValueOne = ""
    var currencyValueTwo = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentExchangeBinding>(
            inflater, R.layout.fragment_exchange, container, false
        )
        exchangeone = binding.Listcurrencyone as Spinner
        exchangetwo = binding.Listcurencytwo as Spinner

        setSpinerOne(binding)
        setSpinerTwo(binding)
        setCalculate(binding)

        return binding.root
    }

    private fun setCalculate(binding: FragmentExchangeBinding) {
        binding.calbtn.setOnClickListener {
            if (binding.currencyone.text.toString().matches("-?\\d+(\\.\\d+)?".toRegex())) {
                if (currencyValueOne == "USD") {
                    if (currencyValueTwo == "THB") {
                        binding.txtResult.text =
                            (binding.currencyone.text.toString().toDouble() * 30.25).toString()
                    } else {
                        binding.txtResult.text = binding.currencyone.text.toString()
                    }
                } else {
                    if (currencyValueTwo == "USD") {
                        binding.txtResult.text =
                            (binding.currencyone.text.toString().toDouble() / 30.25).toString()
                    } else {
                        binding.txtResult.text = binding.currencyone.text.toString()
                    }
                }
            } else {
                Toast.makeText(getActivity(), "กรอกเฉพาะตัวเลขเท่านั้น", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun setSpinerOne(binding: FragmentExchangeBinding) {
        val exchangeones = arrayOf("USD", "THB")

        var adapter = activity?.applicationContext?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                exchangeones
            )

        }
        adapter?.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.Listcurrencyone.adapter = adapter

        binding.Listcurrencyone.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    currencyValueOne = parent.getItemAtPosition(position).toString()
                    Log.i("test", parent.getItemAtPosition(position).toString())
                    //"Spinner selected : ${parent.getItemAtPosition(position).toString()}"
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Another interface callback
                }
            }
    }

    private fun setSpinerTwo(binding: FragmentExchangeBinding) {
        val exchangetwos = arrayOf("THB", "USD")

        var adapter = activity?.applicationContext?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                exchangetwos
            )
        }
        adapter?.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.Listcurencytwo.adapter = adapter

        binding.Listcurencytwo.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    currencyValueTwo = parent.getItemAtPosition(position).toString()
                    Log.i("test", parent.getItemAtPosition(position).toString())
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
    }
}

