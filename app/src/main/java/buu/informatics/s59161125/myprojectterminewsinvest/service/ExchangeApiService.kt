package buu.informatics.s59161125.myprojectterminewsinvest.service

import buu.informatics.s59161125.myprojectterminewsinvest.Exchange
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.exchangeratesapi.io/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()


interface ExchangeApiService {
    @GET("latest?base=THB")
    fun getProperties():
            Deferred<ExchangeProperty>
}



object ExchangeApi {
    val retrofitService : ExchangeApiService by lazy {
        retrofit.create(ExchangeApiService::class.java) }

}
