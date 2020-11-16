package com.showcase.network

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module(includes = [OkHttpModule::class, RetrofitModule::class, NetworkBindingModule::class])
interface NetworkingModule