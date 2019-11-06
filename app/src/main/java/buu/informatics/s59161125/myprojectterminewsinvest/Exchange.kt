package buu.informatics.s59161125.myprojectterminewsinvest

import android.os.Bundle
import android.os.Handler
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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentExchangeBinding
import buu.informatics.s59161125.myprojectterminewsinvest.service.Rates


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

    lateinit var arrayRate: ArrayList<coin>
    lateinit var exchangeone: Spinner
    lateinit var exchangetwo: Spinner
    var currencyValueOne = ""
    var currencyValueTwo: Double = 0.0

    private val viewModel: ExchangeViewModel by lazy {
        ViewModelProviders.of(this).get(ExchangeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentExchangeBinding>(
            inflater, R.layout.fragment_exchange, container, false
        )
        arrayRate = setRate()
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
                binding.txtResult.text =
                    String.format("%.2f",binding.currencyone.text.toString().toDouble() * currencyValueTwo)

            } else {
                Toast.makeText(getActivity(), "กรอกเฉพาะตัวเลขเท่านั้น", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun setSpinerOne(binding: FragmentExchangeBinding) {
        val exchangeones = arrayOf("THB")

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

    private fun setRate(): ArrayList<coin> {
        var arrayCoin: ArrayList<coin> = ArrayList()

        viewModel.properties.observe(this, Observer {
            Log.i("test","${it.get(0).USD}")

            currencyValueTwo = it.get(0).USD
            arrayCoin.add(coin("USD", it.get(0).USD))
            arrayCoin.add(coin("EUR", it.get(0).EUR))
            arrayCoin.add(coin("JPY", it.get(0).JPY))
            arrayCoin.add(coin("CHF", it.get(0).CHF))
            arrayCoin.add(coin("CNY", it.get(0).CNY))
            arrayCoin.add(coin("GBP", it.get(0).GBP))
            arrayCoin.add(coin("CAD", it.get(0).CAD))

        })

        return arrayCoin
    }

    private fun setSpinerTwo(binding: FragmentExchangeBinding) {
        val exchangetwo = arrayOf("USD", "EUR", "JPY", "CHF", "CNY", "GBP","CAD")


        var adapter = activity?.applicationContext?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                exchangetwo
            )
        }
        adapter?.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        binding.Listcurencytwo.adapter = adapter
        Handler().postDelayed({

            binding.Listcurencytwo.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View,
                        position: Int,
                        id: Long
                    ) {
                        binding.txtResult.text = ""
                        Log.i("test", "spinner ${parent.getItemAtPosition(position)}")
                        Log.i("test", "array ${arrayRate.get(position).name}")
                        if (parent.getItemAtPosition(position) == arrayRate.get(position).name) {
                            Log.i("test", "===")
                            currencyValueTwo = arrayRate.get(position).rate
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                    }
                }
        }, 1000)
    }
}

