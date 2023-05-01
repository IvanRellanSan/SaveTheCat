package com.itbproject.savethecat.ui.viewmodels

import com.itbproject.savethecat.coroutines.AppDispatchers
import com.itbproject.savethecat.data.models.BreedDto
import com.itbproject.savethecat.data.models.WeightDto
import com.itbproject.savethecat.data.network.CatApiService
import com.itbproject.savethecat.ui.models.DetailUiModel
import com.itbproject.savethecat.ui.models.mapper.BreedDtoToDetailUiState
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.mockito.kotlin.doSuspendableAnswer
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.coroutines.ContinuationInterceptor

class DetailViewmodelTest{
    @get:Rule
    val detailCourotineRule = DetailCourotineRule()

    private val catApiService = mock<CatApiService>()

    private lateinit var viewModel: DetailViewmodel

    private val breedDto = BreedDto(
        adaptability = 0,
        affection_level = 0,
        alt_names = "",
        cfa_url = "",
        child_friendly = 0,
        cat_friendly = 0,
        bidability = 0,
        country_code = "",
        country_codes = "",
        description = "",
        dog_friendly = 0,
        energy_level = 0,
        experimental = 0,
        grooming = 0,
        hairless = 0,
        health_issues = 0,
        hypoallergenic = 0,
        id = "avecrem",
        image = null,
        indoor = 0,
        intelligence = 0,
        lap = 0,
        life_span = "",
        name = "",
        natural = 0,
        origin = "",
        rare = 0,
        reference_image_id = "",
        rex = 0,
        shedding_level = 0,
        short_legs = 0,
        social_needs = 0,
        stranger_friendly = 0,
        suppressed_tail = 0,
        temperament = "",
        vcahospitals_url = "",
        vetstreet_url = "",
        vocalisation = 0,
        weight = WeightDto(
            imperial = "",
            metric = ""
        ),
        wikipedia_url = ""
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = AppDispatchers(
        IO = TestCoroutineDispatcher()
    )

    @Before
    fun setUp(){
        viewModel = DetailViewmodel(
            apiService = catApiService,
            appDispatchers = testDispatcher
        )
    }

    @Test
    fun loadingStateWorks() = runBlocking {
        whenever(catApiService.getBreed("avecrem")).doSuspendableAnswer {
            withContext(Dispatchers.IO) { delay(5000) }
            breedDto
        }
        viewModel.loadBreed("avecrem")
        Assert.assertEquals(DetailState.LOADING, viewModel.detailState.value)
    }

    @Test
    fun sucessStateWorks() = runBlocking {
        whenever(catApiService.getBreed("avecrem")).thenReturn(
            breedDto
        )
        whenever(catApiService.getImages("avecrem", 15)).thenReturn(
            emptyList()
        )

        viewModel.loadBreed("avecrem")
        Assert.assertEquals(DetailState.SUCCESS(BreedDtoToDetailUiState().map(breedDto, emptyList())), viewModel.detailState.value)
    }

    @Test
    fun failureStateWorks() = runBlocking {
        whenever(catApiService.getBreed("avecrem")).thenThrow(RuntimeException("Error"))
        viewModel.loadBreed("avecrem")
        Assert.assertEquals(DetailState.FAILURE("Error"), viewModel.detailState.value)
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
class DetailCourotineRule : TestWatcher(),
    TestCoroutineScope by TestCoroutineScope() {
    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(
            this.coroutineContext[ContinuationInterceptor] as CoroutineDispatcher
        )
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}
