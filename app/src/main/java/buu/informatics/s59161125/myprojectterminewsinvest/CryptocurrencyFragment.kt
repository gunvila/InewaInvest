package buu.informatics.s59161125.myprojectterminewsinvest


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentCryptocurrencyBinding

/**
 * A simple [Fragment] subclass.
 */
class CryptocurrencyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCryptocurrencyBinding>(
            inflater, R.layout.fragment_cryptocurrency, container, false
        )

        setListView(binding)
        binding.btnBuy.setOnClickListener {
            openNewTabWindow("https://www.xm.com/th/",activity!!.applicationContext)
        }
        binding.btnSell.setOnClickListener {
            openNewTabWindow("https://www.xm.com/th/",activity!!.applicationContext)
        }

        return binding.root
    }

    private fun setListView(binding: FragmentCryptocurrencyBinding) {
        var array: ArrayList<crypto> = ArrayList()
        array.add(crypto("BTC"))
        array.add(crypto("XRP"))
        array.add(crypto("ETH"))
        array.add(crypto("BCH"))
        array.add(crypto("EOS"))
        binding.listViewCrypto.adapter =
            ListViewCryptoAdpter(getActivity()?.applicationContext, array)
        binding.listViewCrypto.setOnItemClickListener { _, _, position, _ ->
            view?.findNavController()?.navigate(
                CryptocurrencyFragmentDirections.actionCyptocurrencyFragmentToCryptoDetailFragment(
                    array[position].name
                )
            )
        }

    }
    private fun openNewTabWindow(urls: String, context : Context) {
        val uris = Uri.parse(urls)
        val intents = Intent(Intent.ACTION_VIEW, uris)
        val b = Bundle()
        b.putBoolean("new_window", true)
        intents.putExtras(b)
        context.startActivity(intents)
    }

}
