package buu.informatics.s59161125.myprojectterminewsinvest


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import buu.informatics.s59161125.myprojectterminewsinvest.database.StockDatabaseModel
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentInsertStockBinding
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentStockBinding

/**
 * A simple [Fragment] subclass.
 */
class InsertStockFragment : Fragment() {

    private lateinit var stockControl: StockControllerModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInsertStockBinding>(
            inflater, R.layout.fragment_insert_stock, container, false
        )
        stockControl = ViewModelProviders.of(this).get(StockControllerModel::class.java)

        binding.btnSave.setOnClickListener {
            onSave(binding)
        }
        return binding.root
    }

    private fun onSave(binding: FragmentInsertStockBinding) {
        if (!binding.edtName.text.isNullOrEmpty() && !binding.edtNameThai.text.isNullOrEmpty() && !binding.edtBasic.text.isNullOrEmpty()) {
            stockControl.insert(
                StockDatabaseModel(
                    binding.edtName.text.toString(),
                    binding.edtNameThai.text.toString(),
                    binding.edtBasic.text.toString()
                )
            )
            Toast.makeText(
                getActivity(), "บันทึกข้อมูลเรียบร้อย",
                Toast.LENGTH_LONG
            ).show()
            Handler().postDelayed({
                findNavController().navigate(InsertStockFragmentDirections.actionInsertStockFragmentToStockFragment())
            }, 400)
        } else {
            Toast.makeText(
                getActivity(), "กรุณากรอกข้อมูลให้ครบทุกช่อง",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
