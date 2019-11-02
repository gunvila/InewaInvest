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
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentInsertStockBinding
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentStockDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class StockDetailFragment : Fragment() {

    private lateinit var stockControl: StockControllerModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentStockDetailBinding>(
            inflater, R.layout.fragment_stock_detail, container, false
        )
        stockControl = ViewModelProviders.of(this).get(StockControllerModel::class.java)

        setData(binding)
        return binding.root
    }

    private fun setData(binding: FragmentStockDetailBinding) {
        var detailValue = arguments?.getString("detail")
        stockControl.allStock.observe(this, Observer { item ->
            item.map {
                if(it.nameStock == detailValue){
                    binding.txtStockNameDetail.text = it.nameStock
                    binding.txtStockNameThaiDetail.text = it.nameThai
                    binding.txtStockDetail.text = it.detail

                }
            }
        })
    }

}
