package com.example.photoeditor.network

import com.example.photoeditor.database.RepositoryImpl
import com.example.photoeditor.database.SpeciesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    private const val BASE_URL = "https://api.agify.io/"

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): Apis = retrofit.create(Apis::class.java)

//    @Singleton
//    @Provides
//    fun providesRepository(apiService: Apis) = RepositoryImpl(apiService)

//    @Singleton
//    @Provides
//    fun provideServersDao(appDatabase: AppDatabase): UserDao {
//        return appDatabase.userDao()
//    }

    @Singleton
    @Provides
    fun providesRepo(apiService: Apis, speciesDao: SpeciesDao) = RepositoryImpl(apiService, speciesDao)
}