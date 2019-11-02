package buu.informatics.s59161125.myprojectterminewsinvest

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import buu.informatics.s59161125.myprojectterminewsinvest.databinding.FragmentCryptoDetailBinding


class CryptoDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCryptoDetailBinding>(
            inflater, R.layout.fragment_crypto_detail, container, false
        )
        setView(binding)
        return binding.root
    }

    private fun setView(binding: FragmentCryptoDetailBinding) {
        var mapImage = setImage()
        var mapString = setString()
        var cryptoValue = arguments?.getString("crypto")
        binding.txtCryptoName.text = cryptoValue.toString()
        binding.imgCryptoDetail.setImageResource(mapImage[cryptoValue]!!)
        binding.txtCryptoDetail.text = mapString[cryptoValue].toString()
        (activity as AppCompatActivity).supportActionBar?.title = cryptoValue
    }

    private fun setImage(): HashMap<String, Int> {
        val map = HashMap<String, Int>()
        map["BTC"] = R.drawable.crypto1
        map["XRP"] = R.drawable.crypto3
        map["BCH"] = R.drawable.crypto4
        map["EOS"] = R.drawable.crypto5
        map["ETH"] = R.drawable.crypto2
        return map
    }

    private fun setString(): HashMap<String, String> {
        val map = HashMap<String, String>()
        map["BTC"] = getString(R.string.btcValue)
        map["XRP"] = getString(R.string.xrpValue)
        map["BCH"] = getString(R.string.bchValue)
        map["EOS"] = getString(R.string.eosValue)
        map["ETH"] = getString(R.string.ethValue)
        return map
    }


}
