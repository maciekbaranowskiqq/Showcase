package com.showcase.network

import com.showcase.network.api.BreweryNetwork
import com.showcase.network.api.BreweryNetworkImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
internal interface NetworkBindingModule {
    @Binds
    fun bindBreweryNetwork(breweryNetworkImpl: BreweryNetworkImpl): BreweryNetwork
}
