package buu.informatics.s59161125.myprojectterminewsinvest


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentStockBinding

/**
 * A simple [Fragment] subclass.
 */
class StockFragment : Fragment() {

    private lateinit var stockControl: StockControllerModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentStockBinding>(
            inflater, R.layout.fragment_stock, container, false
        )
        stockControl = ViewModelProviders.of(this).get(StockControllerModel::class.java)
        setList(binding)

        binding.btnInsert.setOnClickListener {
            view?.findNavController()
                ?.navigate(StockFragmentDirections.actionStockFragmentToInsertStockFragment())
        }
        return binding.root
    }

    private fun setList(binding: FragmentStockBinding) {
        var array: ArrayList<crypto> = ArrayList()
        var count = 0
        Handler().postDelayed({
            stockControl.allStock.observe(this, Observer { item ->
                item.forEach {
                    array.add(crypto(it.nameStock));
                    count++
                }
                if (count == item.size) {
                    binding.listViewStock.adapter =
                        ListViewCryptoAdpter(activity?.applicationContext, array);
                }
            })
        }, 200)
        binding.listViewStock.setOnItemClickListener { _, _, position, _ ->
            view?.findNavController()?.navigate(
                StockFragmentDirections.actionStockFragmentToStockDetailFragment(array[position].name)
            )
        }
    }


}
