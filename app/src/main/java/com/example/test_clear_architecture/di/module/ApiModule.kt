package com.example.test_clear_architecture.di.module

import com.example.data.remote.API
import com.example.data.remote.ApiHelper
import com.example.data.remote.ApiHelperImp
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    internal fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://api.mocki.io")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Singleton
    internal fun provideApi(retrofit: Retrofit): API {
        return retrofit.create(API::class.java)
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(apiHelperImp: ApiHelperImp): ApiHelper {
        return apiHelperImp
    }
}