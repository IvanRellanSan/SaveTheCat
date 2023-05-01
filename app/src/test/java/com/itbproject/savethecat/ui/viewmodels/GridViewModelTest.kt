package com.itbproject.savethecat.ui.viewmodels

import com.itbproject.savethecat.coroutines.AppDispatchers
import com.itbproject.savethecat.data.network.CatApiService
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
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

class GridViewModelTest {

    @get:Rule
    val mainCourotineRule = GridCourotineRule()

    private val catApiService = mock<CatApiService>()

    private lateinit var viewModel: GridViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = AppDispatchers(
        IO = TestCoroutineDispatcher()
    )

    @Before
    fun setUp(){
        viewModel = GridViewModel(
            apiService = catApiService,
            appDispatchers = testDispatcher
        )
    }

    @Test
    fun loadingStateWorks() = runBlocking {
        whenever(catApiService.getBreeds()).doSuspendableAnswer {
            withContext(Dispatchers.IO) { delay(5000) }
            emptyList()
        }
        viewModel = GridViewModel(
            apiService = catApiService,
            appDispatchers = testDispatcher
        )
        Assert.assertEquals(GridState.LOADING, viewModel.gridState.value)
    }

    @Test
    fun sucessStateWorks() = runBlocking {
        whenever(catApiService.getBreeds()).thenReturn(emptyList())
        viewModel = GridViewModel(
            apiService = catApiService,
            appDispatchers = testDispatcher
        )
        Assert.assertEquals(GridState.SUCCESS(emptyList()), viewModel.gridState.value)
    }

    @Test
    fun failureStateWorks() = runBlocking {
        whenever(catApiService.getBreeds()).thenThrow(RuntimeException("Error"))
        viewModel = GridViewModel(
            apiService = catApiService,
            appDispatchers = testDispatcher
        )
        Assert.assertEquals(GridState.FAILURE("Error"), viewModel.gridState.value)
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
class GridCourotineRule : TestWatcher(),
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
